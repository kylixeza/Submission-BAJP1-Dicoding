package com.kylix.submissionbajp1

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.kylix.submissionbajp1.ui.activities.MainActivity
import com.kylix.submissionbajp1.utils.Dummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val moviesData = Dummy.getMovie()
    private val tvShowsData = Dummy.getTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie(){
        onView(withId(R.id.rv_movie)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(moviesData.size))
        }
    }

    @Test
    fun loadMovieDetail(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(moviesData[0].title)))
        }
        onView(withId(R.id.tv_release)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(moviesData[0].release)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(moviesData[0].genre)))
        }
        onView(withId(R.id.tv_duration)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(moviesData[0].duration)))
        }
        onView(withId(R.id.tv_score)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(moviesData[0].score)))
        }
        onView(withId(R.id.collapseToolbar)).perform(click())
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvShow)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowsData.size))
        }
    }

    @Test
    fun loadTvShowDetail(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(tvShowsData[0].title)))
        }
        onView(withId(R.id.tv_release)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(tvShowsData[0].release)))
        }
        onView(withId(R.id.tv_genre)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(tvShowsData[0].genre)))
        }
        onView(withId(R.id.tv_duration)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(tvShowsData[0].duration)))
        }
        onView(withId(R.id.tv_score)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(tvShowsData[0].score)))
        }
        onView(withId(R.id.collapseToolbar)).perform(click())
    }
}