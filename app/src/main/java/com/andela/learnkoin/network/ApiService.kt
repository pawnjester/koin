package com.andela.learnkoin.network

import com.andela.learnkoin.model.ApiResponse
import com.andela.learnkoin.model.ResultsItem
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
    }

    @GET("food.json")
    fun getFood(): Observable<ApiResponse<List<ResultsItem>>>
}