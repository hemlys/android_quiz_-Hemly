package com.sample.demo.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.myapplication.R
import com.sample.demo.myapplication.bean.UsersList
import kotlinx.android.synthetic.main.animal_list_item.view.*


class UsersListAdapter(val partItemList: List<UsersList>, val clickListener: (UsersList) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.animal_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(partItemList[position], clickListener)
    }

    override fun getItemCount() = partItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: UsersList, clickListener: (UsersList) -> Unit) {
            Glide
                .with(itemView.avatar_image_view)
                .load(part.avatar_url)
                .centerCrop()
                .into(itemView.avatar_image_view);
            itemView.login_text_view.text = part.login
            itemView.setOnClickListener { clickListener(part) }
        }
    }
}