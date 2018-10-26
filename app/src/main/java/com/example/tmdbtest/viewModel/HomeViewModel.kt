package com.example.tmdbtest.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.tmdbtest.data.models.Movie
import com.example.tmdbtest.data.repositories.MovieRepository
import com.example.tmdbtest.data.repositories.OnRepositoryReadyCallback
import com.example.tmdbtest.utils.NetManager

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    var repoModel: MovieRepository = MovieRepository(NetManager(getApplication()))

    var text = ObservableField("")

    var isLoading = ObservableField(false)

    var movies = MutableLiveData<ArrayList<Movie>>()

    fun loadMovies(){
        isLoading.set(true)
        repoModel.getMovies(object: OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Movie>) {
                isLoading.set(false)
                movies.value = data
            }
        })
    }
}