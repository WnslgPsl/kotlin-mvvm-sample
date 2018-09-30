package jjuni.kotlin.mvvmsample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.databinding.MainPhotoItemBinding
import jjuni.kotlin.mvvmsample.util.CustomRecyclerViewHolder
import jjuni.kotlin.mvvmsample.util.OnItemClickListener
import jjuni.kotlin.mvvmsample.util.UserDiffCallback

/**
 * Created by Jo on 2018. 9. 29.
 */

class MainRecyclerAdapter : RecyclerView.Adapter<CustomRecyclerViewHolder<ArrayList<Photo>>>(){

    private var items = arrayListOf<Photo>()

    override fun getItemCount(): Int {
        return if(items != null) items.size else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerViewHolder<ArrayList<Photo>> {
        val binding: MainPhotoItemBinding = MainPhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainPhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomRecyclerViewHolder<ArrayList<Photo>>, position: Int) {
        holder.bind(items, position)
    }

    fun loadItem(items: ArrayList<Photo>): Unit{

        val diffCallback: UserDiffCallback = UserDiffCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(items)

        diffResult.dispatchUpdatesTo(this)
    }

}