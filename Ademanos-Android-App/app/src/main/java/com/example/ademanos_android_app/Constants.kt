package com.example.ademanos_android_app

import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.models.Quiz

const val TEST_IMAGE= "https://firebasestorage.googleapis.com/v0/b/ademanos-f242e.appspot.com/o/a.JPG?alt=media&token=9c50e555-f38d-421c-89e8-2ef35fd7aeb4"
const val TEST_VIDEO="https://firebasestorage.googleapis.com/v0/b/ademanos-f242e.appspot.com/o/Amarillo_Web.m4v?alt=media&token=0637ad5b-f422-47a3-8682-acf8b0475483"

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