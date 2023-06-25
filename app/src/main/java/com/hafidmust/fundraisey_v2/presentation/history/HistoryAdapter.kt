package com.hafidmust.fundraisey_v2.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.ContentItem
import com.hafidmust.fundraisey_v2.databinding.ItemHistoryBinding

class HistoryAdapter(private val listHistory: List<ContentItem>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private var itemClickListener : ItemClickListener? = null
    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }


    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ContentItem) {
            binding.tvNominal.text = data.amount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int = listHistory.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(listHistory[position])
        holder.itemView.setOnClickListener {
            listHistory[holder.adapterPosition].id?.let { it1 -> itemClickListener?.onItemClick(it1) }
        }
    }

    interface ItemClickListener {
        fun onItemClick(id : Int)
    }
}