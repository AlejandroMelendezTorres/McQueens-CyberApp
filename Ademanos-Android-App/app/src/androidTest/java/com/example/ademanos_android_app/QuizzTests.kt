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
                .onAllNodesWithText("Quizzes", ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText("QUIZZ HOGAR", ignoreCase = true).assertIsDisplayed()

    }

    @Test
    fun quizzScreenNavigation(){
        goToQuizzScreen()
        restartState()
    }

    @Test
    fun correctVideoDisplays(){
        goToQuizzScreen()
        composeTestRule.onNodeWithTag("https://storage.googleapis.com/ademanos-f242e.appspot.com/LSM_Hogar_Web/Gas_Web.m4v").performClick()
        restartState()
    }

    @Test
    fun clickOnWrongOption(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText("VENTANA", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("RESPUESTA INCORRECTA", ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun clickOnCorrectOption(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText("GAS", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("RESPUESTA CORRECTA", ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun goToNextLevel(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText("GAS", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("RESPUESTA CORRECTA", ignoreCase = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("IMPRESORA", ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    @Test
    fun completeQuizz(){
        goToQuizzScreen()
        composeTestRule.onNodeWithText("GAS", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("FOCO", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("CAJA", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("VASO", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("CUCHARA", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("IMPRESORA", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("Continuar", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("MESA", ignoreCase = true).performClick()

        composeTestRule.onNodeWithText("Quizzes", ignoreCase = true).assertIsDisplayed()
        restartState()
    }

    fun goToQuizzScreen(){
        // Start the app
        composeTestRule.setContent {
            AdemanosApp()
        }

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText("Diccionario", ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithTag("Quiz Tab").performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText("Quizzes", ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
        composeTestRule.onNodeWithText("QUIZZ HOGAR", ignoreCase = true).performClick()

        composeTestRule.waitUntil(timeout){
            composeTestRule
                .onAllNodesWithText("Indica la opción correcta", ignoreCase = true)
                .fetchSemanticsNodes().size == 1
        }
    }

    fun restartState(){
        // Start the app
        composeTestRule.onNodeWithTag("Dictionary Tab").performClick()
    }

}