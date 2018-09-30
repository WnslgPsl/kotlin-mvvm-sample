package jjuni.kotlin.mvvmsample.util

import androidx.recyclerview.widget.DiffUtil
import jjuni.kotlin.mvvmsample.data.Photo

/**
 * Created by Jo on 2018. 9. 29.
 */

class UserDiffCallback(private val oldUserList:ArrayList<Photo>,
                       private val newUserList:ArrayList<Photo>) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldUserList.size
    }

    override fun getNewListSize(): Int {
        return newUserList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUserList[oldItemPosition] === newUserList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUserList[oldItemPosition].id == newUserList[newItemPosition].id
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}