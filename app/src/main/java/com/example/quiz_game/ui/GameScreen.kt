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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz_game.data.allAnswer
import com.example.quiz_game.ui.theme.Quiz_GameTheme

@Composable
fun GameScreen(
//    modifier: Modifier = Modifier,
//    gameViewModel: GameViewModel = viewModel()
) {
//    val gameUiState by gameViewModel.uiState.collectAsState()

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
                text = "0 out of 10",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(150.dp))
            Text(
                text = "Score: 0",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(200.dp))
        Text(
            text = "QUIZ",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = allAnswer[0][0],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = allAnswer[0][1],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = allAnswer[0][2],
                fontSize = 20.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = allAnswer[0][3],
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(45.dp))

        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "NEXT",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = { /*TODO*/ }) {
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