package com.example.composeplayground.presentation.timeline

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.presentation.post.PostItem

@Composable
fun TimelineScreen(
    timelineViewModel: TimelineViewModel = viewModel()
) {
    // We initialize the state with at least one initialPost to make it work, but in real apps, we
    // should handle this situation in a better way.
    val timelineScreenState: TimelineScreenState by timelineViewModel.timelineScreenState.observeAsState(
        initial = TimelineScreenState(listOf(initialPosts.first()))
    )

    Surface(color = MaterialTheme.colors.background) {
        PostItem(post = timelineScreenState.listOfPosts.first())
    }
}
