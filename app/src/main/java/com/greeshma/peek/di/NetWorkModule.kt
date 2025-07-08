package com.greeshma.peek.di

import android.content.Context
import com.greeshma.peek.PeekApp
import com.greeshma.peek.data.web.PeekApi
import com.greeshma.peek.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): PeekApp {
        return context as PeekApp
    }
    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }
    @Provides
    @Singleton
    fun providePeekApi(retrofit: Retrofit): PeekApi {
        return retrofit.create(PeekApi::class.java)
    }

}