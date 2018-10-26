package com.example.tmdbtest.data.repositories

import com.example.tmdbtest.data.models.Movie

class MovieRemoteRepository {

    fun getMovies(onRepositoryCallBack: OnRepoRemoteReadyCallback){

    }

}

interface OnRepoRemoteReadyCallback {
    fun onDataReady(data: ArrayList<Movie>)
}
