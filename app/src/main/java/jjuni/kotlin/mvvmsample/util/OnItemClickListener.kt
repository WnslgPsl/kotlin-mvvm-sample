package jjuni.kotlin.mvvmsample.util

/**
 * Created by Jo on 2018. 9. 29.
 */

interface OnItemClickListener<T> {

    fun onItemClicked(t: T)
}