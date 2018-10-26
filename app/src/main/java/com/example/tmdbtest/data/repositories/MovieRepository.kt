package com.example.tmdbtest.data.repositories

import com.example.tmdbtest.data.models.Movie
import com.example.tmdbtest.utils.NetManager

class MovieRepository(val netManager: NetManager) {

    val localDataSource = MovieLocalRepository()
    val remoteDataSource = MovieRemoteRepository()

    fun getMovies(onRepositoryReadyCallback: OnRepositoryReadyCallback){

        netManager.isConnectedToInternet?.let {
            if (it){
                remoteDataSource.getMovies(object: OnRepoRemoteReadyCallback{
                    override fun onDataReady(data: ArrayList<Movie>) {
                        localDataSource.saveMovies(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    }

                })
            }else{
                localDataSource.getMovies(object: OnRepoLocalReadyCallBack{
                    override fun onLocalDataReady(data: ArrayList<Movie>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }

                })
            }
        }

    }
}

interface OnRepositoryReadyCallback{
    fun onDataReady(data: ArrayList<Movie>)
}