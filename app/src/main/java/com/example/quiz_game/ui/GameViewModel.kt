package com.example.quiz_game.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.quiz_game.data.MAX_Questions
import com.example.quiz_game.data.SCORE_INCREASE
import com.example.quiz_game.data.allAnswer
import com.example.quiz_game.data.allQuestion
import com.example.quiz_game.data.trueAnswer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    // Game UI state
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    // Set of words used in the game
    private var usedQuestion: MutableSet<String> = mutableSetOf()
    private lateinit var currentQuestion: String

    init {
        resetGame()
    }
    fun resetGame() {
        usedQuestion.clear()
        _uiState.value = GameUiState(currentScrambledQuestion = pickRandomQuestion())
    }

    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /*
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkAns() {
        val currentQuestionIndex = allQuestion.indexOf(_uiState.value.currentScrambledQuestion)
        val correctAnswers = trueAnswer[currentQuestionIndex]

        if (userGuess in correctAnswers) {
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
            _uiState.update { currentState ->
                currentState.copy(isWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedQuestion.size == MAX_Questions){
            _uiState.update { currentState ->
                currentState.copy(
                    isWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isWrong = false,
                    currentScrambledQuestion = pickRandomQuestion(),
                    currentQuestionCount = currentState.currentQuestionCount.inc(),
                    score = updatedScore
                )
            }
        }
    }


    private fun pickRandomQuestion(): String {
        var randomQuestion = allQuestion.random()
        while (usedQuestion.contains(randomQuestion)) {
            randomQuestion = allQuestion.random()
        }
        usedQuestion.add(randomQuestion)
        val index = allQuestion.indexOf(randomQuestion)
        return randomQuestion
    }

}