package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.presentation.timeline.TimelineScreen
import com.example.composeplayground.presentation.timeline.TimelineViewModel
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: TimelineViewModel by viewModels()

        setContent {
            ComposePlaygroundTheme {
                TimelineScreen(viewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimelineScreenPreview() {
    ComposePlaygroundTheme {
        TimelineScreen()
    }
}
