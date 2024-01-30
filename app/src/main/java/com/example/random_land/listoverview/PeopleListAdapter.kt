package com.example.random_land.listoverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.random_land.databinding.PeopleListBinding
import com.example.random_land.network.PeopleRandom

/***
 * We are not using this for now
 */
class PeopleListAdapter:ListAdapter<PeopleRandom,PeopleListAdapter.PeopleRandomViewHolder>(DiffCallBack) {
    companion object DiffCallBack:DiffUtil.ItemCallback<PeopleRandom>() {
        override fun areItemsTheSame(oldItem: PeopleRandom, newItem: PeopleRandom): Boolean {
                return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PeopleRandom, newItem: PeopleRandom): Boolean {
            return oldItem.results == newItem.results
        }

    }

    class PeopleRandomViewHolder(private var binding:PeopleListBinding):RecyclerView.ViewHolder(binding.root) {
            fun binding(peopleRandom: PeopleRandom){
                binding.people = peopleRandom
                binding.executePendingBindings()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleRandomViewHolder {
        return PeopleRandomViewHolder(PeopleListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PeopleRandomViewHolder, position: Int) {
        val peopleRandom = getItem(position)
        holder.binding(peopleRandom)
    }

}