package com.example.composeplayground.presentation.timeline

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.composeplayground.domain.Post
import com.example.composeplayground.presentation.post.PostItem

@Composable
fun TimelineScreen(
    listOfPosts: List<Post>
) {
    Surface(color = MaterialTheme.colors.background) {
        PostItem(post = listOfPosts[0])
    }
}
