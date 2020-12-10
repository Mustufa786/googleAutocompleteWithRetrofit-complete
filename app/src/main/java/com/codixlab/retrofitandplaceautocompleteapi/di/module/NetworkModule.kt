package com.codixlab.retrofitandplaceautocompleteapi.di.module

import com.codixlab.retrofitandplaceautocompleteapi.retrofit.APIHostUrls
import com.codixlab.retrofitandplaceautocompleteapi.utils.RemoteConstant
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofitInstance(
        client: OkHttpClient,
        coroutineCallAdapterFactory: CoroutineCallAdapterFactory,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RemoteConstant.REMOTE_URL)
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIClient(retrofit: Retrofit): APIHostUrls {
        return retrofit.create(APIHostUrls::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun getCoroutineCallAdapter(): CoroutineCallAdapterFactory {
        return CoroutineCallAdapterFactory.invoke()
    }

}