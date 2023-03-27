package com.example.quiz_game.data

const val MAX_Questions = 10
const val SCORE_INCREASE = 20
//class Question(
//    val question: String,
//    val choice: List<String>,
//    val answer: String
//)
//
//val questions = listOf (
//    Question(
//        "What can you catch but not throw?",
//        listOf("a cold","a ball","a bird","a bouquet"),
//        "a cold"
//    ),
//
//    Question(
//        "What has a face and two hands but no arms?",
//        listOf("a clock","a mirror","a playing card","a radio"),
//        "a clock",
//    ),
//
//    Question(
//        "What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?",
//        listOf("a river","a nose","a tree","a wolf"),
//        "a river"
//    ),
//
//    Question(
//        "What has a neck but no head?",
//        listOf("a bottle","a comet","a flower","a snake"),
//        "a bottle"
//    ),
//
//    Question(
//        "What has teeth but cannot bite?",
//        listOf("a comb","a bee","a puppy","a toothpick"),
//        "a comb"
//    ),
//
//    Question(
//        "What is it that you must keep after giving it to someone?",
//        listOf("your word","your pen","your money","your time"),
//        "your word"
//    ),
//
//    Question(
//        "What is as light as a feather, but even the strongest man cannot hold it for much more than a minute?",
//        listOf("breath","air","fire","light"),
//        "breath"
//    ),
//
//    Question(
//        "They come out at night without being called and are lost in the day without being stolen. What are they?",
//        listOf("stars","cockroaches","nightmares","robbers"),
//        "stars"
//    ),
//
//    Question(
//        "What has been around for millions of years but is no more than a month old?",
//        listOf("the moon","the sun","the universe","the wind"),
//        "the moon"
//    ),
//
//    Question(
//        "No sooner spoken than broken. What is it?",
//        listOf("silence","friendship","glass","news"),
//        "silence"
//    )
//)
//
val allQuestion = listOf(
    "What can you catch but not throw?",
    "What has a face and two hands but no arms?",
    "What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?",
    "What has a neck but no head?",
    "What has teeth but cannot bite?",
    "What is it that you must keep after giving it to someone?",
    "What is as light as a feather, but even the strongest man cannot hold it for much more than a minute?",
    "They come out at night without being called and are lost in the day without being stolen. What are they?",
    "What has been around for millions of years but is no more than a month old?",
    "No sooner spoken than broken. What is it?"
)

val allAnswer = listOf(
    listOf("a cold","a ball","a bird","a bouquet"),
    listOf("a clock","a mirror","a playing card","a radio"),
    listOf("a river","a nose","a tree","a wolf"),
    listOf("a bottle","a comet","a flower","a snake"),
    listOf("a comb","a bee","a puppy","a toothpick"),
    listOf("your word","your pen","your money","your time"),
    listOf("breath","air","fire","light"),
    listOf("stars","cockroaches","nightmares","robbers"),
    listOf("the moon","the sun","the universe","the wind"),
    listOf("silence","friendship","glass","news"),
)

val trueAnswer = listOf(
    "a cold",
    "a clock",
    "a river",
    "a bottle",
    "a comb",
    "your word",
    "breath",
    "stars",
    "the moon",
    "silence"
)
