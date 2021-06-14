package com.example.composeplayground.presentation.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.domain.Post
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
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    onClick = { timelineViewModel.cleanPosts() }) {
                    Text(text = "Clean")
                }
                Button(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f),
                    onClick = { timelineViewModel.fillPosts() }) {
                    Text(text = "Fill")
                }
            }

            if (timelineScreenState.listOfPosts.isEmpty()) {
                TimelineEmpty()
            } else {
                TimelineList(listOfPosts = timelineScreenState.listOfPosts)
            }
        }
    }
}

@Composable
fun TimelineEmpty() {
    Text("Empty list")
}

@Composable
fun TimelineList(listOfPosts: List<Post>) {
    LazyColumn {
        items(listOfPosts) { post ->
            PostItem(post = post)
        }
    }
}
