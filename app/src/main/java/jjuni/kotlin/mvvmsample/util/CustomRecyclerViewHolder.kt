package jjuni.kotlin.mvvmsample.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Jo on 2018. 9. 29.
 */

abstract class CustomRecyclerViewHolder<T> (itemView: View): RecyclerView.ViewHolder(itemView){

    abstract fun bind(item: T, position: Int)
}