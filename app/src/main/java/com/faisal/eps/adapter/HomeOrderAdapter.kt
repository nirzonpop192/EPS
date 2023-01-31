package com.faisal.eps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.faisal.eps.R
import com.faisal.eps.data.OrderResponseItem
import com.faisal.eps.databinding.RowItemRepoBinding
import com.faisal.eps.util.DateFormatManager

class HomeOrderAdapter (private var list : List<OrderResponseItem>
): RecyclerView.Adapter<HomeOrderAdapter.ViewHolder>() {

    class ViewHolder(binding: RowItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
//        val moviePoster : ImageView = binding.ivMovie
        val orderId : TextView = binding.tvOrder
        val price : TextView = binding.tvPrice
        val deliveryDate : TextView = binding.tvDate
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
        holder.orderId.text="Order Id # ${list.get(position).bookingID.toString()}"
        holder.price.text="ট ${list.get(position).totalValue.toString()}"
        holder.deliveryDate.text=DateFormatManager.formatDateTime(list.get(position).cd)


    }

    fun updateData(list: List<OrderResponseItem>) {
        this.list = list
        notifyDataSetChanged()
    }


}