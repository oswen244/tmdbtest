package com.example.tmdbtest

import android.os.Handler
import com.example.tmdbtest.data.Movie

class RepoModel {

    fun getMovies(onRepositoryReadyCallBack: OnRepositoryCallBack){
        var arrayList = ArrayList<Movie>()

        arrayList.add(Movie(335983, "Venom", "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg", "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg", "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego “Venom” to save his life.", "2018-10-03", 1484))

        Handler().postDelayed({ onRepositoryReadyCallBack.onDataReady(arrayList) }, 2000)
    }
}

interface OnDataReadyCallBack{
    fun onDataReady(data: String)
}

interface OnRepositoryCallBack{
    fun onDataReady(data: ArrayList<Movie>)
}