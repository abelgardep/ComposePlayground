package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.presentation.timeline.TimelineScreen
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposePlaygroundTheme {
                TimelineScreen(initialPosts)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimelineScreenPreview() {
    ComposePlaygroundTheme {
        TimelineScreen(initialPosts)
    }
}
