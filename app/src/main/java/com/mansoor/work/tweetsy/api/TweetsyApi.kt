package com.mansoor.work.tweetsy.api

import com.mansoor.work.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("/v3/b/650de52c54105e766fb84a62?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<ArrayList<TweetListItem>>

    @GET("/v3/b/650de52c54105e766fb84a62?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<ArrayList<String>>
}