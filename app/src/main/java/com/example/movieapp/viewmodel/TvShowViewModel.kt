package com.example.movieapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.TvShowItem
import com.example.movieapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: Repository) : ViewModel() {


    private val _responseTvShow = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
        get() = _responseTvShow

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let {
            if (it.isSuccessful) {
                _responseTvShow.postValue(it.body())
            } else {
                Log.d("tag", "getAllTvShow error: ${it.code()}")
            }
        }
    }
}