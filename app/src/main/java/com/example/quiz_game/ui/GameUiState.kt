package com.example.quiz_game.ui

data class GameUiState(
    val currentScrambledQuestion: String = "",
    val currentQuestionCount: Int = 1,
    val score: Int = 0,
    val isWrong: Boolean = false,
    val isGameOver: Boolean = false
)

