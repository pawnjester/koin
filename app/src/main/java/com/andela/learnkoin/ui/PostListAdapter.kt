package com.andela.learnkoin.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.andela.learnkoin.R
import com.andela.learnkoin.databinding.SingleLayoutPostBinding
import com.andela.learnkoin.model.Post

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private val posts = mutableListOf<Post>()

    fun updateList(items: List<Post>) {
        posts.clear()
        posts.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil
                .inflate<SingleLayoutPostBinding>(inflater,
                        R.layout.single_layout_post, parent, false)

        return ViewHolder(binding!!)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = posts[position]
        holder.bind(items)
    }

    inner class ViewHolder(val binding: SingleLayoutPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}