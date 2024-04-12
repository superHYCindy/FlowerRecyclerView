package com.example.recyclerview.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.data.Flower
import com.example.recyclerview.databinding.FlowerItemBinding

class FlowersAdapter(private val onClick: (Flower) -> Unit) :
    RecyclerView.Adapter<FlowersAdapter.FlowerViewHolder>() {

    var flowerList = listOf<Flower>()

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
    class FlowerViewHolder(private var binding: FlowerItemBinding, val onClick: (Flower) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentFlower: Flower? = null

        init {
            itemView.setOnClickListener {
                currentFlower?.let {
                    onClick(it)
                }
            }
        }

        /* Bind flower name and image. */
        fun bind(flower: Flower) {
            currentFlower = flower

            binding.flowerText.text = flower.name
            binding.flowerImage.setImageResource(flower.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(FlowerItemBinding.bind(view), onClick)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flowerList[position])
    }
}
