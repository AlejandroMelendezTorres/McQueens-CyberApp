package com.example.ademanos_android_app

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.ademanos_android_app.cardGrid.QuizzScreen
import org.junit.Rule
import org.junit.Test

class QuizzTests {

    private var timeout=15000L

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun quizzScreenLoads() {
        // Start the app
        composeTestRule.setContent {
            QuizzScreen()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.quizz_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quizz), ignoreCase = true).assertIsDisplayed()

    }

    @Test
    fun quizzScreenNavigation(){
        goToQuizzScreen()
        restartState()
    }

    @Test
    fun correctVideoDisplays(){
        goToQuizzScreen()
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.test_quiz_media_tag)).performClick()
        restartState()
    }

    @Test
    fun clickOnWrongOption(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_incorrect_answer), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.incorrect_quiz_answer_message), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun clickOnCorrectOption(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText("GAS", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.correct_quiz_answer_message), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun goToNextLevel(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_1), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.correct_quiz_answer_message), ignoreCase = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_2), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun completeQuizz(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_1), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_2), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_3), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_4), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_5), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_6), ignoreCase = true).performClick()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.continue_quiz_button), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_quiz_correct_answer_7), ignoreCase = true).performClick()

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.quizz_title), ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    fun goToQuizzScreen(){
        // Start the app
        composeTestRule.setContent {
            AdemanosApp()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.dictionary_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
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
    }

    fun restartState(){
        // Start the app
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.dictionary_tab_test_id)).performClick()
    }

}