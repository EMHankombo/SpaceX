package com.example.android.spacex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.spacex.R
import com.example.android.spacex.databinding.LaunchItemBinding
import com.example.android.spacex.network.model.Launch
import com.example.android.spacex.utils.Utilities

class SpaceXAdapter(private val launches: List<Launch>) :
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
            with(itemBinding) {
                tvMission.text = launch.name
                tvDateTime.text = Utilities.getDateOnly(launch.date_utc)
                tvRocket.text = launch.rocket
                if (launch.success) {
                    imgLaunchSuccess.setImageResource(R.drawable.ic_baseline_check_24)
                } else {
                    imgLaunchSuccess.setImageResource(
                        R.drawable.ic_baseline_clear_24
                    )
                }
                Glide.with(itemBinding.root).load(launch.links.patch.large).into(imgPatch)

            }

        }

    }
}