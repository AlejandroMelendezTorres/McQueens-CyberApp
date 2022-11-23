package com.example.ademanos_android_app

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class StatsTests {

    private var timeout=15000L
    private var loggedIn = false

    private var consultedWords = 0
    private var completedLevels = 0

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun statsDoDisplay() {
        goToStatsScreen()
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.profile_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText("niveles", ignoreCase = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("palabras", ignoreCase = true).assertIsDisplayed()
        logOut()
        restartState()
    }

    @Test
    fun statsChangeAfterConsultingWord() {
        goToStatsScreen()
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.profile_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        val node=composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.tag_words_consulted)).assertIsDisplayed()
        val semanticsNode = node.fetchSemanticsNode()

        for ((key, value) in semanticsNode.config) {
            if (key.name == "Text") {
                val values=listOf(value as List<*>)
                consultedWords = values.first().first().toString().toInt()
            }
        }

        consultAWord()

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.profile_tab_test_id)).performClick()
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(consultedWords.toString(), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        logOut()
        restartState()
    }

    @Test
    fun statsChangeAfterCompletingLevel() {
        goToStatsScreen()
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.profile_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        val node=composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.tag_levels_completed)).assertIsDisplayed()
        val semanticsNode = node.fetchSemanticsNode()

        for ((key, value) in semanticsNode.config) {
            if (key.name == "Text") {
                val values=listOf(value as List<*>)
                completedLevels = values.first().first().toString().toInt()
            }
        }

        completeALevel()

        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.profile_tab_test_id)).performClick()
        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(completedLevels.toString(), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        logOut()
        restartState()
    }

    fun restartState(){
        // Start the app
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.dictionary_tab_test_id)).performClick()
    }

    fun goToStatsScreen(){
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
        if (!loggedIn){
            logIn(composeTestRule.activity.getString(R.string.correct_test_email),composeTestRule.activity.getString(R.string.correct_test_password))
        }

    }

    fun logIn(email:String, password:String){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.email_field_label), ignoreCase = true).performClick().performTextInput(email)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.password_field_label), ignoreCase = true).performClick().performTextInput(password)
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.login_button_label), ignoreCase = true).performClick()
        loggedIn = true
    }

    fun logOut(){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.logout_button_label), ignoreCase = true).performClick()
        loggedIn = false
    }

    fun consultAWord(){
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.dictionary_tab_test_id)).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_category), ignoreCase = true).performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.test_word), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_word), ignoreCase = true).performClick()

        consultedWords++
    }

    fun completeALevel(){
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.quiz_tab_test_id)).performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.quizz_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quizz), ignoreCase = true).performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.test_quiz_prompt), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_1), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.correct_quiz_answer_message), ignoreCase = true).assertIsDisplayed()

        completedLevels++
    }

}