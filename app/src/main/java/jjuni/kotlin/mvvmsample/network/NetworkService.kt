package jjuni.kotlin.mvvmsample.network

import io.reactivex.Single
import jjuni.kotlin.mvvmsample.data.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jo on 2018. 9. 29.
 */

interface NetworkService {

    @GET("rest")
    fun getFlickrSearch(
            @Query("format") format: String,
            @Query("nojsoncallback") nojsoncallback: String,
            @Query("method") method: String,
            @Query("api_key") api_key: String,
            @Query("text") text: String,
            @Query("page") page: Int,
            @Query("per_page") per_page: Int
    ): Single<PhotoResponse>
}