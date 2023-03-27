package com.example.quiz_game.ui

import com.example.quiz_game.data.Question

data class GameUiState(
    val currentQuestion: Question,
    val choice: List<String>,
    val score: Int,
    val quizIndex: Int,
    val isGameFinished: Boolean,
)
