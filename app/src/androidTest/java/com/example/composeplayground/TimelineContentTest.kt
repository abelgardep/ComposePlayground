package com.example.composeplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.domain.Post
import com.example.composeplayground.presentation.timeline.TimelineContent
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import org.junit.Rule
import org.junit.Test


class TimelineContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun assert_empty_list_screen_is_displayed() {
        var viewState by mutableStateOf(listOf<Post>())

        composeTestRule.setContent {
            ComposePlaygroundTheme {
                TimelineContent(listOfPosts = viewState, {}, {})
            }
        }

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertIsDisplayed()
            .assertTextEquals("Empty list")

        viewState = listOf(initialPosts.first())

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertDoesNotExist()
    }
}
