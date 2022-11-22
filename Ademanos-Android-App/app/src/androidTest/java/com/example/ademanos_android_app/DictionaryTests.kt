package com.example.ademanos_android_app

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.ademanos_android_app.cardGrid.DictionaryScreen
import org.junit.Rule
import org.junit.Test

class DictionaryTests {

    private var timeout=15000L

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun dictionaryScreenLoads() {
        // Start the app
        composeTestRule.setContent {
            DictionaryScreen()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.dictionary_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_category), ignoreCase = true).assertIsDisplayed()

    }

    @Test
    fun dictionaryScreenNavigation(){
        goToCategoryScreen()
        restartState()
    }

    @Test
    fun correctVideoDisplays(){
        goToCategoryScreen()
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_word), ignoreCase = true).performClick()
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.test_word_media_tag)).assertIsDisplayed()
        restartState()
    }

    fun goToCategoryScreen(){
        // Start the app
        composeTestRule.setContent {
            AdemanosApp()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.dictionary_title), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.test_category), ignoreCase = true).performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText(composeTestRule.activity.getString(R.string.test_word), ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

    }

    fun restartState(){
        // Start the app
        composeTestRule.onNodeWithTag(composeTestRule.activity.getString(R.string.dictionary_tab_test_id)).performClick()
    }

}