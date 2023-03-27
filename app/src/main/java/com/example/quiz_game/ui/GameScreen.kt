package com.example.quiz_game.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.quiz_game.ui.theme.Quiz_GameTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz_game.data.questions

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel = viewModel(),
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    val question = gameUiState.currentQuestion.toString()
    val choice = gameUiState.choice
    val score = gameUiState.score
    val count = gameUiState.quizIndex

    Column(
        Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF4A148C))
        ) {
            Text(
                text = "Quiz Game",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Text(
                text = "$count out of 10",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(150.dp))
            Text(
                text = "Score: $score",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(25.dp),
            text = question,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {gameViewModel.checkAnswer(choice[0])},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[0],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {gameViewModel.checkAnswer(choice[1])},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[1],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {gameViewModel.checkAnswer(choice[2])},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[2],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {gameViewModel.checkAnswer(choice[3])},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = choice[3],
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(45.dp))

        Row() {
            Button(onClick = {gameViewModel.getQuestion()}) {
                Text(
                    text = "NEXT",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = {gameViewModel.reset()}) {
                Text(
                    text = "RESET",
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Quiz_GameTheme {

    }
}