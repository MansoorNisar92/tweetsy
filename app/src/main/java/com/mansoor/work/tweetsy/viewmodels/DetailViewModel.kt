package com.mansoor.work.tweetsy.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mansoor.work.tweetsy.models.TweetListItem
import com.mansoor.work.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets


    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "life"
            repository.getTweetList(category)
        }
    }
}