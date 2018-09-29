package jjuni.kotlin.mvvmsample.data

import io.reactivex.Single
import jjuni.kotlin.mvvmsample.data.remote.RemoteDataSource

/**
 * Created by Jo on 2018. 9. 29.
 */

class MainRepository : MainDataSource{

    private val remoteDataSource by lazy {
        RemoteDataSource()
    }

    override fun getSearchPhotos(format: String, nojsoncallback: String, method: String, searchKeyword: String, flickrKey: String, requestPage: Int, requestPerPage: Int): Single<PhotoResponse> {
        return remoteDataSource.getSearchPhotos(format, nojsoncallback, method, searchKeyword, flickrKey, requestPage, requestPerPage)
    }
}