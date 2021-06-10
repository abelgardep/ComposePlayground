package com.example.composeplayground.data

import com.example.composeplayground.R
import com.example.composeplayground.domain.Post
import com.example.composeplayground.domain.User


val users = listOf(
    User(
        name = "Juan",
        avatarId = R.drawable.avatar1
    ),
    User(
        name = "Paco",
        avatarId = R.drawable.avatar2
    ),
    User(
        name = "Carla",
        avatarId = R.drawable.avatar3
    ),
    User(
        name = "Sonia",
        avatarId = R.drawable.avatar4
    ),
    User(
        name = "Carlos",
        avatarId = R.drawable.avatar5
    ),
)

val initialPosts = listOf(
    Post(
        id = 1,
        postImageId = R.drawable.post1,
        author = users[2],
        likedBy = listOf()
    ),
    Post(
        id = 1,
        postImageId = R.drawable.post2,
        author = users[3],
        likedBy = listOf(users[1], users[2])
    ),
    Post(
        id = 1,
        postImageId = R.drawable.post3,
        author = users[4],
        likedBy = listOf(users[3])
    ),
    Post(
        id = 1,
        postImageId = R.drawable.post4,
        author = users[1],
        likedBy = listOf(users[4])
    ),
    Post(
        id = 1,
        postImageId = R.drawable.post5,
        author = users[0],
        likedBy = listOf()
    ),
)
