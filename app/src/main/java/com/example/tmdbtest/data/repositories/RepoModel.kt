package com.example.tmdbtest.data.repositories

import android.os.Handler
import com.example.tmdbtest.data.models.Movie

class RepoModel {

}

interface OnRepositoryCallBack{
    fun onDataReady(data: ArrayList<Movie>)
}