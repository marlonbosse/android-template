package com.ankerapps.template.ui.counter

import androidx.preference.PreferenceManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.tfcporciuncula.flow.FlowSharedPreferences
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import com.ankerapps.template.AppModule
import com.ankerapps.template.R
import com.ankerapps.template.data.CounterRepository
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(AppModule::class)
@RunWith(AndroidJUnit4::class)
class CounterActivityTest {

    @BindValue @JvmField val flowSharedPreferences : FlowSharedPreferences = let {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(
            getInstrumentation().targetContext)
        sharedPreferences.edit().clear().commit()
        val flowSharedPreferences =  FlowSharedPreferences(sharedPreferences)

        runBlocking {
            flowSharedPreferences.getInt(CounterRepository.COUNTER_KEY, defaultValue = 1).setAndCommit(1)
        }
        flowSharedPreferences
    }

    var hiltRule = HiltAndroidRule(this)
    val intentTestRule = ActivityScenarioRule<CounterActivity>(CounterActivity::class.java)

    @get:Rule
    var rules = RuleChain.outerRule(hiltRule)
        .around(intentTestRule)

    @Test
    fun testIncrementButtons() {
        onView(withId(R.id.fabIncrement)).perform(click())
        onView(withId(R.id.counterText)).check(matches(withText("2")))
    }

    @Test
    fun testDecrementButtons() {
        onView(withId(R.id.fabDecrement)).perform(click())
        onView(withId(R.id.counterText)).check(matches(withText("0")))
    }

}
