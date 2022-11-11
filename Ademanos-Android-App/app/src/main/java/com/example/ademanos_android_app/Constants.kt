package com.example.ademanos_android_app

import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.models.Quiz
import com.example.ademanos_android_app.models.Stats
import com.example.ademanos_android_app.models.Word
import com.example.ademanos_android_app.wordView.WordView

const val TEST_IMAGE= "https://storage.googleapis.com/ademanos-f242e.appspot.com/LSM_Abecedario_Web/m.JPG"
const val TEST_VIDEO="https://storage.googleapis.com/ademanos-f242e.appspot.com/LSM_Lugares_Web/Tienda_Web.m4v"

val TEST_QUESTION_0 = Question(
    "test",
    TEST_VIDEO,
    "¿Qué numero es este 0?",
    arrayOf("1","2","3","4"),
    0
)
val TEST_QUESTION_1 = Question(
    "test",
    TEST_IMAGE,
    "¿Qué numero es este 1?",
    arrayOf("1","2","3","4"),
    1
)
val TEST_QUESTION_2 = Question(
    "test",
    TEST_VIDEO,
    "¿Qué numero es este 2?",
    arrayOf("1","2","3","4"),
    2
)
val TEST_QUIZ = Quiz(
    "test",
    "Quiz de prueba",
    "Esta es una prueba",
    arrayOf(TEST_QUESTION_0,TEST_QUESTION_1,TEST_QUESTION_2)
)

val STATS_TEMP = Stats(
    11,
    4,
    6
)

val TEST_WORD = Word("test","Uno","El numero uno", TEST_IMAGE)
