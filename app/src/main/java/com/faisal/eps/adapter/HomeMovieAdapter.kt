package com.faisal.eps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.faisal.eps.R
import com.faisal.eps.data.OrderResponseItem
import com.faisal.eps.databinding.RowItemRepoBinding

class HomeMovieAdapter (private var list : List<OrderResponseItem>
                        ,private val mListener: OnItemClickListener?
): RecyclerView.Adapter<HomeMovieAdapter.ViewHolder>() {

    class ViewHolder(binding: RowItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
//        val moviePoster : ImageView = binding.ivMovie
//        val movieTitle : TextView = binding.tvMovieTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  binding: RowItemRepoBinding= DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_item_repo,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide.with(holder.moviePoster).load(list.get(position).Poster).into(holder.moviePoster)
//        holder.movieTitle.text=list.get(position).Title.toString()

        holder.itemView.setOnClickListener {
            mListener?.onItemClick(position)
        }
    }

    fun updateData(list: List<OrderResponseItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick( position: Int)
    }
}