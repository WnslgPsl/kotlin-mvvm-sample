package jjuni.kotlin.mvvmsample.data

import io.reactivex.Single

/**
 * Created by Jo on 2018. 9. 29.
 */

interface MainDataSource {

    fun getSearchPhotos(format: String, nojsoncallback: String, method: String, searchKeyword: String, flickrKey: String, requestPage: Int,
                        requestPerPage: Int): Single<PhotoResponse>
}