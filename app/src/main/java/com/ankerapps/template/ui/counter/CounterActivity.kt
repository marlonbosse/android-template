package com.ankerapps.template.ui.counter

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import com.ankerapps.template.R
import com.ankerapps.template.databinding.ActivityCounterBinding
import com.ankerapps.template.ui.BaseActivity
import com.ankerapps.template.ui.custom.BottomAppBarCutCornersTopEdge

@AndroidEntryPoint
class CounterActivity : BaseActivity() {

    private lateinit var binding: ActivityCounterBinding
    private lateinit var viewModel : CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabIncrement.setOnClickListener { viewModel.incrementClick() }
        binding.fabDecrement.setOnClickListener { viewModel.decrementClick() }

        viewModel.counter.observe(this, {
            binding.counterText.setText(it.toString())
        })
        viewModel.errors.observe(this, {
            showErrorSnackBar()
        })

        setupBottomAppBarCutCornersBackground()
    }


    private fun showErrorSnackBar() {
        Snackbar.make(binding.coordinatorLayout, R.string.error_message, Snackbar.LENGTH_SHORT).show()
    }

    private fun setupBottomAppBarCutCornersBackground() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            binding.bottomAppBar.fabCradleMargin,
            binding.bottomAppBar.fabCradleRoundedCornerRadius,
            binding.bottomAppBar.cradleVerticalOffset
        )
        val background = binding.bottomAppBar.background as MaterialShapeDrawable
        background.shapeAppearanceModel = background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
        background.invalidateSelf()
    }

}
