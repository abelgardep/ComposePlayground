package com.example.composeplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.domain.Post
import com.example.composeplayground.presentation.timeline.TimelineContent
import com.example.composeplayground.presentation.timeline.TimelineScreen
import com.example.composeplayground.presentation.timeline.TimelineViewModel
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import org.junit.Rule
import org.junit.Test


class TimelineContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun assert_empty_list_screen_is_displayed_timeline_content() {
        var viewState by mutableStateOf(listOf<Post>())

        composeTestRule.setContent {
            ComposePlaygroundTheme {
                TimelineContent(
                    listOfPosts = viewState,
                    onClickFill = {
                        viewState = listOf(initialPosts.first())
                    }, onClickClean = {
                        viewState = listOf()
                    })
            }
        }

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertIsDisplayed()
            .assertTextEquals("Empty list")

        composeTestRule
            .onNodeWithTag(TEST_TAG_FILL_BUTTON)
            .performClick()

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag(TEST_TAG_CLEAN_BUTTON)
            .performClick()

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertIsDisplayed()
            .assertTextEquals("Empty list")
    }


    @Test
    fun assert_empty_list_screen_is_displayed_timeline_screen() {
        composeTestRule.setContent {
            ComposePlaygroundTheme {
                TimelineScreen(
                    TimelineViewModel()
                )
            }
        }
        composeTestRule
            .onNodeWithTag(TEST_TAG_FILL_BUTTON)
            .performClick()

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag(TEST_TAG_CLEAN_BUTTON)
            .performClick()

        composeTestRule
            .onNodeWithTag(TEST_TAG_EMPTY_LIST)
            .assertIsDisplayed()
            .assertTextEquals("Empty list")
    }
}
