package com.yelow.roomdatabase.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yelow.roomdatabase.R
import com.yelow.roomdatabase.data.Friend
import com.yelow.roomdatabase.databinding.ItemFriendBinding

class FriendAdapter(private val items: List<Friend>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(val viewDataBinding: ItemFriendBinding): RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(friend: Friend?) {
            viewDataBinding.friend = friend
            viewDataBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {

        val binding: ItemFriendBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_friend,  parent, false)

        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}