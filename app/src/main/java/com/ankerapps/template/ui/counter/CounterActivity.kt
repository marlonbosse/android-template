package com.ankerapps.template.ui.counter

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import com.ankerapps.template.R
import com.ankerapps.template.ui.BaseActivity
import com.ankerapps.template.ui.custom.BottomAppBarCutCornersTopEdge
import kotlinx.android.synthetic.main.activity_counter.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CounterActivity : BaseActivity() {

    private lateinit var viewModel : CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        setContentView(R.layout.activity_counter)

        fabIncrement.setOnClickListener { viewModel.incrementClick() }
        fabDecrement.setOnClickListener { viewModel.decrementClick() }

        viewModel.counter.observe(this, {
            counterText.setText(it.toString())
        })
        viewModel.errors.observe(this, {
            showErrorSnackBar()
        })

        setupBottomAppBarCutCornersBackground()
    }


    private fun showErrorSnackBar() {
        Snackbar.make(coordinatorLayout, R.string.error_message, Snackbar.LENGTH_SHORT).show()
    }

    private fun setupBottomAppBarCutCornersBackground() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            bottomAppBar.fabCradleMargin,
            bottomAppBar.fabCradleRoundedCornerRadius,
            bottomAppBar.cradleVerticalOffset
        )
        val background = bottomAppBar.background as MaterialShapeDrawable
        background.shapeAppearanceModel = background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
        background.invalidateSelf()
    }

}
