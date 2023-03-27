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
//    var index = (0..9).random()
//    fun pickRandomQuestion(): List<String> {
//
//        var randomQuestion = allQuestion[index]
//        val answers = allAnswer[index]
//        var out = listOf(answers[0], answers[1], answers[2], answers[3])
//        out.shuffled()
//        return listOf(randomQuestion, out[0], out[1], out[2], out[3])
//    }

    fun pickRandomQuestion(): List<String> {
        // Pick a random index for the question
        val randomIndex = (0 until 9).random()

        // Get the corresponding question and answer list
        val question = allQuestion[randomIndex]
        val answers = allAnswer[randomIndex]

        // Shuffle the answers
        val shuffledAnswers = answers.shuffled()
        val questionAndAnswers = mutableListOf<String>()
        questionAndAnswers.add(question)
        questionAndAnswers.addAll(shuffledAnswers)

        // Return the list of question and shuffled answers
        return questionAndAnswers
    }
}