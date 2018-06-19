package com.everis.mvpkotlin

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import com.everis.mvpkotlin.listEmployees.view.ListEmployeesActivity
import com.everis.mvpkotlin.listEmployees.view.ListEmployeesView
import com.everis.mvpkotlin.login.view.LoginActivity
import org.junit.Rule
import org.junit.Test

class LoginViewTest {


    @get:Rule
    val mActivityTestRule = IntentsTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun testErrorEmptyLogin() {
        onView(withId(R.id.buttonRegister)).perform(click())
        onView(withText(R.string.error_empty_login)).check(matches(isDisplayed()))
    }

    @Test
    fun testErrorEmptyUser() {
        onView(withId(R.id.passwordLoginEditText)).perform(replaceText("Testing"), closeSoftKeyboard())
        onView(withId(R.id.buttonRegister)).perform(click())
        onView(withText(R.string.error_empty_user)).check(matches(isDisplayed()))
    }

    @Test
    fun testErrorEmptyPassword() {
        onView(withId(R.id.userLoginEditText)).perform(replaceText("Testing"), closeSoftKeyboard())
        onView(withId(R.id.buttonRegister)).perform(click())
        onView(withText(R.string.error_empty_password)).check(matches(isDisplayed()))
    }

    @Test
    fun testErrorLogin() {
        onView(withId(R.id.userLoginEditText)).perform(replaceText("Testing"), closeSoftKeyboard())
        onView(withId(R.id.passwordLoginEditText)).perform(replaceText("Testing"), closeSoftKeyboard())
        onView(withId(R.id.buttonRegister)).perform(click())
        onView(withText(R.string.error_incorrect_login)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginOK() {
        onView(withId(R.id.userLoginEditText)).perform(replaceText("TallerMVP"), closeSoftKeyboard())
        onView(withId(R.id.passwordLoginEditText)).perform(replaceText("123456"), closeSoftKeyboard())
        onView(withId(R.id.buttonRegister)).perform(click())
        intended(hasComponent(ListEmployeesActivity::class.java!!.name))
    }
}