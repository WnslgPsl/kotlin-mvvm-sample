package jjuni.kotlin.mvvmsample.util

import androidx.databinding.Observable
import io.reactivex.disposables.Disposables

/**
 * Created by Jo on 2018. 9. 30.
 */

fun Int.ApiException(): Exception {

    val errorMsg = when (this) {
        1 -> "1번 오류"
        2 -> "2번 오류"
        3 -> "검색어 누락"
        else -> {
            "알수없는 에러"
        }
    }
    return Exception(errorMsg)
}

fun <T : Observable> T.addOnPropertyChanged(callback: (T) -> Unit) =
        object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: Observable?, i: Int) =
                    callback(observable as T)
        }.also { addOnPropertyChangedCallback(it) }