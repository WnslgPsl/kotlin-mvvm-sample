package jjuni.kotlin.mvvmsample.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import jjuni.kotlin.mvvmsample.data.Photo

/**
 * Created by Jo on 2018. 10. 2.
 */
 
class ItemViewModel(val context:Context, val item: Photo) {

    public fun getTitle(title:String) {
        Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
    }

}