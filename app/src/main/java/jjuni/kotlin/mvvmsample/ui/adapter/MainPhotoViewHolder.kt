package jjuni.kotlin.mvvmsample.ui.adapter

import jjuni.kotlin.mvvmsample.data.Photo
import jjuni.kotlin.mvvmsample.databinding.MainPhotoItemBinding
import jjuni.kotlin.mvvmsample.util.CustomRecyclerViewHolder
import jjuni.kotlin.mvvmsample.util.GlideApp
import kotlinx.android.synthetic.main.main_photo_item.view.*
import java.util.ArrayList

/**
 * Created by Jo on 2018. 9. 29.
 */

class MainPhotoViewHolder(private val binding: MainPhotoItemBinding) : CustomRecyclerViewHolder<ArrayList<Photo>>(binding.root) {

    override fun bind(item: ArrayList<Photo>, position: Int) {
        itemView.run {
            GlideApp.with(this.context)
                    .load(item.get(position).getPhotoURL())
                    .centerCrop()
                    .into(iv_main_photo_item)
        }
    }

}