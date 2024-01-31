package com.example.random_land.listoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.random_land.R
import com.example.random_land.network.Results

class PeopleAdapterTry : RecyclerView.Adapter<PeopleAdapterTry.MyViewHolder>() {
    private var peopleList = emptyList<Results>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val peopleImage: ImageView = itemView.findViewById(R.id.people_image)
        val peopleName: TextView = itemView.findViewById(R.id.name_Surname)
        val peopleAddress: TextView = itemView.findViewById(R.id.address)
        val peopleNumber: TextView = itemView.findViewById(R.id.number)
        val peopleLayout: RelativeLayout = itemView.findViewById(R.id.peopleTouch)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.people_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPerson = peopleList[position]
        val currentImage: String? = currentPerson.picture?.large
        // For some reason glide was giving me errors related with setTag(),
        // I have no tags in ImageView, that's why I set it to "null"
        holder.peopleImage.tag = null

        /***
         * Here I am getting images from our Api by using glide,
         * I tried doing it with BindingAdapters but that quite didn't as
         * I have have to access list and run through it. This is the new approach
         */
        currentImage?.let {
            val imgUri = it.toUri().buildUpon()?.scheme("https")?.build()
            Glide.with(holder.peopleImage.context)
                .load(imgUri)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image)
                )
                .into(holder.peopleImage)
        }
        holder.peopleName.text =
            "ФИО: ${currentPerson.name?.title} ${currentPerson.name?.first} ${currentPerson.name?.last}"
        holder.peopleAddress.text =
            "Адрес: ${currentPerson.location?.street?.name},${currentPerson.location?.street?.number}"
        holder.peopleNumber.text = "Номер: ${currentPerson.phone}"

        holder.peopleLayout.setOnClickListener {
            val action = ListOverviewDirections.actionListOverviewToPeopleDetail(currentPerson)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    fun setData(people: List<Results>) {
        this.peopleList = people
        notifyDataSetChanged()
    }
}