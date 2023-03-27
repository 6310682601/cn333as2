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
import java.lang.Math.random
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


class GameViewModel : ViewModel() {
    // Game UI state
//    private val Question = Question()
//    var currentQuestionIndex = Question.question.shuffled()
//    var index = Random.nextInt(0,9)
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    // Set of words used in the game
    private var usedQuestion: MutableSet<Int> = mutableSetOf()
    private lateinit var currentQuestion: String

    init {
        resetGame()
    }
    fun resetGame() {
        usedQuestion.clear()
//        _uiState.value = GameUiState(currentScrambledQuestion = pickRandomQuestion())
    }

    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }

    /*
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkAns() {

//        val correctAnswers = trueAnswer[currentQuestionIndex]

        if (userGuess in trueAnswer) {
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
//                    currentScrambledQuestion = pickRandomQuestion(),
                    currentQuestionCount = currentState.currentQuestionCount.inc(),
                    score = updatedScore
                )
            }
        }
    }


//    fun pickRandomQuestion(): Pair<String, List<String>> {
//        var randomQuestion = allQuestion.random()
//        while (usedQuestion.contains(randomQuestion)) {
//            randomQuestion = allQuestion.random()
//        }
//        usedQuestion.add(randomQuestion)
//        val index = allQuestion.indexOf(randomQuestion)
//        val answers = allAnswer[index]
//        return Pair(randomQuestion, answers)
//    }
    fun pickRandomQuestion(): List<String> {
        var index = Random.nextInt(0,9)
//        if (index in usedQuestion){
//            index = Random.nextInt(0,9)
//            pickRandomQuestion()
//        }
//        else{
//            usedQuestion.add(index)
//        }

        var randomQuestion = allQuestion[index]
        val answers = allAnswer[index].shuffled()
        val ans1 = answers[0]
        val ans2 = answers[1]
        val ans3 = answers[2]
        val ans4 = answers[3]
        val output = listOf(randomQuestion, ans1, ans2, ans3, ans4)

        return output
    }

}