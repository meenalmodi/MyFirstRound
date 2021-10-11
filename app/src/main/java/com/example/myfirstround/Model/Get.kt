package com.example.myfirstround.Model

data class Get(
    val items: List<Item>
    )

data class Item(
    val is_answered : Boolean,
    val accepted_answer_id : Int,
    val answer_count : Int,
    val title : String
)