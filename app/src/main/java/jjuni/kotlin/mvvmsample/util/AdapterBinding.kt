package jjuni.kotlin.mvvmsample.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.ui.adapter.MainRecyclerAdapter

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