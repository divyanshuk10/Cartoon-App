package com.divyanshu.assignmentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.divyanshu.assignmentapp.databinding.CartoonItemBinding
import com.divyanshu.assignmentapp.ui.CartoonDetailsFragmentDirections
import com.divyanshu.assignmentapp.ui.CartoonsFragmentDirections
import com.divyanshu.model.CartoonData

class CartoonAdapter :
    PagingDataAdapter<CartoonData, CartoonAdapter.MyViewHolder>(diffCallback = diffCallback) {


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CartoonData>() {
            override fun areItemsTheSame(oldItem: CartoonData, newItem: CartoonData): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: CartoonData, newItem: CartoonData): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class MyViewHolder(val binding: CartoonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        println(item?.image)
        holder.binding.apply {
            txtCartoon.text = item?.name
            val imageLink = "${item?.image}"
            imgCartoon.load(imageLink) {
                crossfade(true)
                crossfade(500)
            }
        }

        holder.itemView.setOnClickListener {
            val direction =
                CartoonsFragmentDirections.actionFirstFragmentToSecondFragment(item)
            it.findNavController().navigate(direction)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CartoonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}