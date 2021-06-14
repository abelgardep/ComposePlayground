package com.example.composeplayground.presentation.timeline

import androidx.compose.runtime.Immutable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.composeplayground.data.initialPosts
import com.example.composeplayground.domain.Post

class TimelineViewModel : ViewModel() {

    private val _timeLineScreenState = MediatorLiveData<TimelineScreenState>()
    val timelineScreenState: LiveData<TimelineScreenState> = _timeLineScreenState

    init {
        _timeLineScreenState.postValue(TimelineScreenState(initialPosts))
    }

    fun fillPosts() {
        _timeLineScreenState.postValue(TimelineScreenState(initialPosts))
    }

    fun cleanPosts() {
        _timeLineScreenState.postValue(TimelineScreenState(listOf()))
    }
}

@Immutable
data class TimelineScreenState(
    val listOfPosts: List<Post>
)
