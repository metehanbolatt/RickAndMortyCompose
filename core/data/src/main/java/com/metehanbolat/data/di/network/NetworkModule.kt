package com.metehanbolat.data.di.network

import com.metehanbolat.data.api.RickAndMortyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @ViewModelScoped
    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

    @ViewModelScoped
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @ViewModelScoped
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @ViewModelScoped
    @Provides
    fun provideRickAndMortyApiService(
        retrofit: Retrofit
    ): RickAndMortyApi = retrofit.create(RickAndMortyApi::class.java)
}
