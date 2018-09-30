package jjuni.kotlin.mvvmsample.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.schedulers.Schedulers
import jjuni.kotlin.mvvmsample.BuildConfig
import jjuni.kotlin.mvvmsample.data.MainRepository
import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.data.PhotoResponse
import jjuni.kotlin.mvvmsample.ui.base.BaseViewModel
import jjuni.kotlin.mvvmsample.util.ApiException

/**
 * Created by Jo on 2018. 8. 1.
 */

class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    private val progress =  ObservableField<Boolean>()
    val error = ObservableField<String>()
    val photoItems = ObservableArrayList<Photo>()




    fun getSearchPhotos() {
        progress.set(true)
        compositeDisposable.add(repository.getSearchPhotos("json", "1",
                "flickr.photos.search", "love", BuildConfig.FLICKR_API_KEY, 1,
                200)
                .filter { items ->
                    if (items.stat == "ok") {
                        return@filter true
                    } else {
                        throw items.code.ApiException()
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableMaybeObserver<PhotoResponse>() {
                    override fun onComplete() {
                    }

                    override fun onSuccess(items: PhotoResponse) {
                        progress.set(false)
                        photoItems.addAll(items.photos.photo)
                    }

                    override fun onError(e: Throwable) {
                        progress.set(false)
                        error.set(e.message)
                    }

                })
        )
    }
}