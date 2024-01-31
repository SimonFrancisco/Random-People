package com.example.random_land

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.random_land.listoverview.PeopleApiStatus
import com.example.random_land.listoverview.PeopleListAdapter
import com.example.random_land.network.PeopleRandom


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl.let {
        val imgUri = it?.toUri()?.buildUpon()?.scheme("https")?.build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("peopleApiStatus")
fun bindStatus(statusImageView: ImageView, status: PeopleApiStatus) {
    when (status) {
        PeopleApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        PeopleApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }

        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}

/***
 * No need for now
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PeopleRandom>?) {
    val adapter = recyclerView.adapter as PeopleListAdapter
    adapter.submitList(data)
}