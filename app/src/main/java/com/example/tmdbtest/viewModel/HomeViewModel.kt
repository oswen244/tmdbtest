package com.example.tmdbtest.viewModel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.tmdbtest.OnDataReadyCallBack
import com.example.tmdbtest.OnRepositoryCallBack
import com.example.tmdbtest.RepoModel
import com.example.tmdbtest.data.Movie

class HomeViewModel: ViewModel() {
    var repoModel: RepoModel = RepoModel()
    var text = ObservableField<String>()
    var isLoading = ObservableField<Boolean>()

    var movies = ArrayList<Movie>()

    /*fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallBack {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }*/

    fun loadMovies(){
        isLoading.set(true)
        repoModel.getMovies(object: OnRepositoryCallBack {
            override fun onDataReady(data: ArrayList<Movie>) {
                isLoading.set(false)
                movies = data
            }
        })
    }
}