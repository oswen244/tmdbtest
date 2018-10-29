package com.example.tmdbtest.data.repositories

import com.example.tmdbtest.data.models.Movie
import com.example.tmdbtest.data.networking.APIController
import com.example.tmdbtest.data.networking.ServiceVolley
import com.example.tmdbtest.utils.Contants
import org.json.JSONArray
import org.json.JSONObject

class MovieRemoteRepository {

    private val service = ServiceVolley()
    private val apiController = APIController(service)

    fun getMovies(onRepoRemoteReadyCallback: OnRepoRemoteReadyCallback){

        apiController.get(Contants.GETPOPULARS, Contants.APIKEY){   result ->

            if(result != null){
                val movies: JSONArray = result.getJSONArray("results")
                val arrayResult: ArrayList<Movie> = ArrayList()
                var temp: JSONObject

                for (i in 0 until movies.length()){
                    temp = movies.getJSONObject(i)
                    arrayResult.add(
                        Movie(
                            temp.getInt("id"),
                            temp.getString("original_title"),
                            temp.getString("poster_path"),
                            temp.getString("backdrop_path"),
                            temp.getString("overview"),
                            temp.getString("release_date"),
                            temp.getInt("vote_count")
                        )
                    )
                }

                onRepoRemoteReadyCallback.onDataReady(arrayResult)
            }
        }
    }

}

interface OnRepoRemoteReadyCallback {
    fun onDataReady(data: ArrayList<Movie>)
}
