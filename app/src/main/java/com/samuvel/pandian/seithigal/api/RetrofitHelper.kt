package com.samuvel.pandian.seithigal.api

import com.samuvel.pandian.seithigal.entities.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RetrofitHelper(private var listener: RetrofitHelperListener) {
    private val BASE_URL: String = "https://newsapi.org/v2/"

    fun getHotNews() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(NewsApiService::class.java)
        service.getHotNews().enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                listener.onHotNewsFetchFailure()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    listener.onHotNewsFetchSuccess(response.body()!!)
                } else {
                    listener.onHotNewsFetchFailure()
                }
            }
        })
    }


    interface NewsApiService {
        @GET("top-headlines?country=in&apiKey=02542736fc02452da34960157413c42c")
        fun getHotNews(): Call<News>
    }

    interface RetrofitHelperListener {
        fun onHotNewsFetchSuccess(result: News)
        fun onHotNewsFetchFailure()
    }
}