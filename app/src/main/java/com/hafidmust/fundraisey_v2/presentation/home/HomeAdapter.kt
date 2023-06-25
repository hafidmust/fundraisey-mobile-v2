package com.hafidmust.fundraisey_v2.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hafidmust.fundraisey_v2.R
import com.hafidmust.fundraisey_v2.data.source.remote.retrofit.response.DataItem

class HomeAdapter(private val listLoan : List<DataItem>) : RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(id : Int)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageStartup = itemView.findViewById<ImageView>(R.id.iv_startup)
        private val tvStartup = itemView.findViewById<TextView>(R.id.tv_startup)
        private val tvProject = itemView.findViewById<TextView>(R.id.tv_project)
        private val tvAmount = itemView.findViewById<TextView>(R.id.tv_amount)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tv_desc)
        private val pbMilestone = itemView.findViewById<ProgressBar>(R.id.pb_milestone)
        private val tvCollected = itemView.findViewById<TextView>(R.id.tv_collected)
        private val tvRemaining = itemView.findViewById<TextView>(R.id.tv_remaining_day)

        fun bindData(data : DataItem){
            tvStartup.text = data.startup.name
            tvProject.text = data.name
            tvDescription.text = data.description

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_startup, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listLoan.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindData(listLoan[position])

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listLoan[holder.adapterPosition].id)
        }
    }
}