package com.example.ademanos_android_app

import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.models.Quiz
import com.example.ademanos_android_app.models.Word

const val TEST_IMAGE= "https://storage.googleapis.com/ademanos-f242e.appspot.com/LSM_Abecedario_Web/m.JPG"
const val TEST_VIDEO="https://storage.googleapis.com/ademanos-f242e.appspot.com/LSM_Lugares_Web/Tienda_Web.m4v"

val TEST_QUESTION_0 = Question(
    "test",
    TEST_VIDEO,
    "¿Qué numero es este 0?",
    listOf("1","2","3","4"),
    0
)
val TEST_QUESTION_1 = Question(
    "test",
    TEST_IMAGE,
    "¿Qué numero es este 1?",
    listOf("1","2","3","4"),
    1
)
val TEST_QUESTION_2 = Question(
    "test",
    TEST_VIDEO,
    "¿Qué numero es este 2?",
    listOf("1","2","3","4"),
    2
)
val TEST_QUIZ = Quiz(
    "test",
    "test",
    "Quiz de prueba",
    "Quiz de prueba",
    listOf(TEST_QUESTION_0,TEST_QUESTION_1,TEST_QUESTION_2)
)

val TEST_WORD = Word("test","Uno","El numero uno", TEST_IMAGE)

const val DICTIONARY_TAB = 0
const val QUIZ_TAB = 1
const val PROFILE_TAB = 2
const val CATEGORY_TAB = 3
const val WORD_TAB = 4
const val LEVEL_TAB = 5