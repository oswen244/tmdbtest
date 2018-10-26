package com.example.tmdbtest.data.repositories

import android.os.Handler
import com.example.tmdbtest.data.models.Movie

class MovieLocalRepository {
    fun getMovies(onRepositoryReadyCallBack: OnRepoLocalReadyCallBack){
        var arrayList = ArrayList<Movie>()

        arrayList.add(
            Movie(
                335983,
                "Venom",
                "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
                "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg",
                "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego “Venom” to save his life.",
                "2018-10-03",
                1484
            )
        )

        Handler().postDelayed({ onRepositoryReadyCallBack.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveMovies(arrayList: ArrayList<Movie>){

    }

}

interface OnRepoLocalReadyCallBack{
    fun onLocalDataReady(data: ArrayList<Movie>)
}