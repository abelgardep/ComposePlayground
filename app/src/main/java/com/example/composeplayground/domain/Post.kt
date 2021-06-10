package com.example.composeplayground.domain


data class Post(
    val id: Int,
    val author: User,
    val authorImage: Int,
    val likedBy: List<User>
)
