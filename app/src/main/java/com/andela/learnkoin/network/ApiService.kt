package com.andela.learnkoin.network

import com.andela.learnkoin.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}