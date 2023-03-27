package com.example.quiz_game.ui

import androidx.lifecycle.ViewModel
import com.example.quiz_game.data.Question
import com.example.quiz_game.data.questions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class GameViewModel : ViewModel() {
    // Game UI state
//    private val Question = Question()
//    var currentQuestionIndex = Question.question.shuffled()
//    var index = Random.nextInt(0,9)
    var question = questions.shuffled()
    var score = 0
    var quizIndex = 0

    private val _uiState = MutableStateFlow(GameUiState(
        currentQuestion = question[quizIndex],
        choice = question[quizIndex].choice.shuffled(),
        score = 0,
        quizIndex = 0
    ))

    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()


    fun getQuestion() {
        if (quizIndex < 9) {
            quizIndex += 1
        }
        val currentQuestion = question[quizIndex]
        val choice = currentQuestion.choice.shuffled()
        val newState = GameUiState(currentQuestion = currentQuestion, choice = choice, score = score, quizIndex = quizIndex)
        _uiState.value = newState
    }

    fun checkAnswer(input: String) {
        if (input == question[quizIndex].answer) {
            score += 1
        }
    }

    fun reset() {
        score = 0
        quizIndex = 0
    }

}