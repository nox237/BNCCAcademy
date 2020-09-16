package com.example.bnccacademy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HotlineAdapter(private val lookUpList: MutableList<HotlineData>): RecyclerView.Adapter<HotlineViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotlineViewHolder {
        return HotlineViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_hotline,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HotlineViewHolder, position: Int) {
        holder.bind(lookUpList[position])
    }

    override fun getItemCount(): Int {
        return lookUpList.size
    }

    fun updateData(newList: List<HotlineData>) {
        lookUpList.clear()
        lookUpList.addAll(newList)

        notifyDataSetChanged()
    }
}