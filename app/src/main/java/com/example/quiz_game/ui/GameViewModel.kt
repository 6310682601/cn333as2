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
<<<<<<< HEAD
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
=======
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

>>>>>>> 7973f684a1e7425c6eaeec49a25b5e23eb8f99c6
