package com.example.composeplayground.domain


data class Post(
    val id: Int,
    val author: User,
    val postImageId: Int,
    val likedBy: List<User>
)
