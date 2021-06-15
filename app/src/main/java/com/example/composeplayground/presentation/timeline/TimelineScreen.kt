package com.example.composeplayground.presentation.timeline

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.R
import com.example.composeplayground.TEST_TAG_CLEAN_BUTTON
import com.example.composeplayground.TEST_TAG_EMPTY_LIST
import com.example.composeplayground.TEST_TAG_FILL_BUTTON
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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row { Text(stringResource(id = R.string.app_name)) } },
                navigationIcon = null,
                actions = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(imageVector = (Icons.Default.Search), contentDescription = null)
                        }
                    )
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* TODO */ },
                text = { Text("Add a new post") },
                icon = { Icon(imageVector = Icons.Outlined.Add, contentDescription = null) })
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        TimelineContent(
            listOfPosts = timelineScreenState.listOfPosts,
            onClickFill = { timelineViewModel.fillPosts() },
            onClickClean = { timelineViewModel.cleanPosts() }
        )
    }
}

@Composable
fun TimelineContent(
    listOfPosts: List<Post>,
    onClickFill: () -> Unit,
    onClickClean: () -> Unit
) {
    Column {
        CleanAndFillButtons(
            onClickClean = { onClickClean() },
            onClickFill = { onClickFill() }
        )

        if (listOfPosts.isEmpty()) {
            TimelineEmpty()
        } else {
            TimelineList(listOfPosts = listOfPosts)
        }
    }
}

@Composable
fun CleanAndFillButtons(
    onClickFill: () -> Unit,
    onClickClean: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            modifier = Modifier
                .testTag(TEST_TAG_CLEAN_BUTTON)
                .padding(16.dp)
                .weight(1f),
            onClick = { onClickClean() }) {
            Text(text = "Clean")
        }
        Button(
            modifier = Modifier
                .testTag(TEST_TAG_FILL_BUTTON)
                .padding(16.dp)
                .weight(1f),
            onClick = { onClickFill() }) {
            Text(text = "Fill")
        }
    }
}

@Composable
fun TimelineEmpty() {
    Text(text = "Empty list", modifier = Modifier.testTag(TEST_TAG_EMPTY_LIST))
}

@Composable
fun TimelineList(listOfPosts: List<Post>) {
    LazyColumn {
        items(listOfPosts) { post ->
            PostItem(post = post)
        }
    }
}
