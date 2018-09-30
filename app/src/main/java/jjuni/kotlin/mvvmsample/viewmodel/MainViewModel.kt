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

//    val progress =  ObservableField<Boolean>()
//    val error = ObservableField<String>()
//    val photoItems = ObservableArrayList<Photo>()

    private val _progress =  MutableLiveData<Boolean>()
    private val _error = MutableLiveData<String>()
    private val _photoItems = MutableLiveData<ArrayList<Photo>>()

    val progress:  LiveData<Boolean> get() = _progress
    val error: LiveData<String> get() = _error
    val photoItems: LiveData<ArrayList<Photo>> get() = _photoItems

    fun getSearchPhotos() {
        _progress.value = true
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
                        _progress.value = false
                        _photoItems.value = items.photos.photo
//                        photoItems.addAll(items.photos.photo)
                    }

                    override fun onError(e: Throwable) {
                        _progress.value = false
                        _error.value = e.message
                    }

                })
        )
    }
}