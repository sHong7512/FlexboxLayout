package com.shong.flexboxlayout

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shong.flexboxlayout.databinding.ItemContentBinding

class FlexboxAdapter @JvmOverloads constructor(
    private var nameList: MutableList<String> = mutableListOf()
) : RecyclerView.Adapter<FlexboxAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.nameTextView.text = nameList[position]

            binding.closeImageButton.setOnClickListener {
                nameList.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = nameList.size

    @SuppressLint("NotifyDataSetChanged")
    internal fun addList(name: String) {
        this.nameList.add(name)
        notifyDataSetChanged()
    }
}