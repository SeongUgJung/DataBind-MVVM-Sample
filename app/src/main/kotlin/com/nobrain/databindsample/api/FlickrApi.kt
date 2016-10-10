package com.nobrain.databindsample.api

import com.nobrain.databindsample.BuildConfig
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


class FlickrApi @Inject internal constructor(private val retrofit: Retrofit) {

    fun getRecentPhoto(page: Int, perPage: Int): Observable<RecentPhoto> {
        return retrofit.create(Api::class.java).getRecentPhoto(page, perPage)
    }

    internal interface Api {
        @GET("?format=json&nojsoncallback=1&method=flickr.interestingness.getList&api_key=" + BuildConfig.FLICKER_API_KEY)
        fun getRecentPhoto(@Query("page") page: Int, @Query("per_page") perPage: Int): Observable<RecentPhoto>
    }
}