package com.example.android.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.spacex.databinding.LaunchItemBinding
import com.example.android.spacex.network.model.Launch

class SpaceXAdapter(private val launches: MutableList<Launch>) :
    RecyclerView.Adapter<SpaceXAdapter.SpaceXViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        val binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpaceXViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        holder.binding(launches[position])
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    class SpaceXViewHolder(private val itemBinding: LaunchItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun binding(launch: Launch) {

        }

    }
}