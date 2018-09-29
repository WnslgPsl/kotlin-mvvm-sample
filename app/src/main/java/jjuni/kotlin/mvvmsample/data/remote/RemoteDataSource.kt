package jjuni.kotlin.mvvmsample.data.remote

import io.reactivex.Single
import jjuni.kotlin.mvvmsample.data.MainDataSource
import jjuni.kotlin.mvvmsample.data.PhotoResponse
import jjuni.kotlin.mvvmsample.network.createRetrofit

/**
 * Created by Jo on 2018. 9. 29.
 */

class RemoteDataSource : MainDataSource {

    override fun getSearchPhotos(format: String, nojsoncallback: String, method: String, searchKeyword: String,
                                 flickrKey: String, requestPage: Int, requestPerPage: Int): Single<PhotoResponse> {

        return createRetrofit().getFlickrSearch(format, nojsoncallback,
                method, flickrKey, searchKeyword, requestPage, requestPerPage)
    }
}