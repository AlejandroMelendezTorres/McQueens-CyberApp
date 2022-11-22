package com.example.ademanos_android_app

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.ademanos_android_app.loginScreen.LoginScreen
import org.junit.Rule
import org.junit.Test

class LoginTests {

    private var timeout=15000L

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun loginScreenLoads() {
        // Start the app
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.app_title), ignoreCase = true).assertIsDisplayed()

    }

    @Test
    fun loginScreenNavigation(){
        goToLoginScreen()
        restartState()
    }

    @Test
    fun correctLogin(){
        goToLoginScreen()
        logIn(composeTestRule.activity.getString(R.string.correct_test_email),composeTestRule.activity.getString(R.string.correct_test_password))
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.profile_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.correct_test_email), ignoreCase = true).assertIsDisplayed()
        logOut()
        restartState()
    }

    @Test
    fun incorrectLogin(){
        goToLoginScreen()
        //Invalid email format
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email_field_label), ignoreCase = true).performClick().performTextInput(composeTestRule.activity.getString(R.string.invalid_email_format))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email_supporting_text), ignoreCase = true).assertIsDisplayed()
        //Invalid password length
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.password_field_label), ignoreCase = true).performClick().performTextInput(composeTestRule.activity.getString(R.string.invalid_password_length))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.password_supporting_text), ignoreCase = true).assertIsDisplayed()
        //Non existent credentials
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email_field_label), ignoreCase = true).performClick().performTextInput("")
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.password_field_label), ignoreCase = true).performClick().performTextInput("")
        logIn(composeTestRule.activity.getString(R.string.incorrect_test_email),composeTestRule.activity.getString(R.string.incorrect_test_password))
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.incorrect_login_message), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun correctLogout(){
        goToLoginScreen()
        logIn(composeTestRule.activity.getString(R.string.correct_test_email),composeTestRule.activity.getString(R.string.correct_test_password))
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.profile_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.correct_test_email), ignoreCase = true).assertIsDisplayed()
        logOut()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.app_title), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    fun goToLoginScreen(){
        // Start the app
        composeTestRule.setContent {
            AdemanosApp()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.dictionary_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.profile_tab_test_id)).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.app_title), ignoreCase = true).assertIsDisplayed()

    }

    fun restartState(){
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.dictionary_tab_test_id)).performClick()
    }

    fun logOut(){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.logout_button_label), ignoreCase = true).performClick()
    }

    fun logIn(email:String, password:String){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email_field_label), ignoreCase = true).performClick().performTextInput(email)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.password_field_label), ignoreCase = true).performClick().performTextInput(password)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.login_button_label), ignoreCase = true).performClick()
    }

}