package com.mansoor.work.tweetsy.di

import com.mansoor.work.tweetsy.api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetroFit() = Retrofit.Builder()
        .baseUrl("https://api.jsonbin.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Singleton
    @Provides
    fun providesTweetsyAPI(retrofit: Retrofit): TweetsyApi {
        return retrofit.create(TweetsyApi::class.java)
    }
}