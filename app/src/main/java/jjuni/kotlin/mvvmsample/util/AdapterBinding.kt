package jjuni.kotlin.mvvmsample.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.ui.adapter.MainRecyclerAdapter
import kotlinx.android.synthetic.main.main_photo_item.view.*

/**
 * Created by Jo on 2018. 9. 29.
 */

@BindingAdapter("bind:item")
fun bindItem(recyclerView: RecyclerView, olduser: ArrayList<Photo>?) {
    val adapter: MainRecyclerAdapter = recyclerView.adapter as MainRecyclerAdapter
    olduser?.let {
        adapter.loadItem(it)
    }
}

@BindingAdapter("bind:image")
fun bindImage(view:View, url:String) {
    view.run {
        GlideApp.with(this.context)
                .load(url)
                .centerCrop()
                .into(iv_main_photo_item)
    }
}