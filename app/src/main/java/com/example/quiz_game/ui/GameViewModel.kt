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


    fun getQuestion(): Question {
        if (quizIndex != 9) {
            quizIndex += 1
            return question[quizIndex]
        } else {
            return question[quizIndex]
        }

    }

    fun checkAnswer( input: String) {
        if (input == question[quizIndex].answer) {
            score += 1
        } else {
            score += 0
        }
    }

    fun reset() {
        score = 0
        quizIndex = 0
    }

}

