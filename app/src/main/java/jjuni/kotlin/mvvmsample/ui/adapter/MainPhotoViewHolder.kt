package jjuni.kotlin.mvvmsample.ui.adapter

import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.databinding.MainPhotoItemBinding
import jjuni.kotlin.mvvmsample.util.CustomRecyclerViewHolder
import jjuni.kotlin.mvvmsample.util.OnItemClickListener
import java.util.ArrayList

/**
 * Created by Jo on 2018. 9. 29.
 */

class MainPhotoViewHolder(private val binding: MainPhotoItemBinding, private val onItemClickListener: OnItemClickListener<Photo>) : CustomRecyclerViewHolder<ArrayList<Photo>>(binding.root) {

    override fun bind(item: ArrayList<Photo>, position: Int) {
        binding.item = item.get(position)
        binding.listener = onItemClickListener
    }

}