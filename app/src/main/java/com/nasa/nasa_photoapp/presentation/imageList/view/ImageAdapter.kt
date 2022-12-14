package com.nasa.nasa_photoapp.presentation.imageList.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nasa.nasa_photoapp.R
import com.nasa.nasa_photoapp.core.getProgressDrawable
import com.nasa.nasa_photoapp.core.loadImage
import com.nasa.nasa_photoapp.domain.model.Image

/**
 * Created by Anitha Jasmine G on 18/08/22.
 */
class ImageAdapter(val context: Context, val items: MutableList<Image>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_image_layout,
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
        holder.tvTitle.text = item.title
        holder.ivImage.loadImage(item.url, getProgressDrawable(context))
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvTitle = itemView.findViewById(R.id.idTVNasa) as TextView
        val ivImage = itemView.findViewById(R.id.idIVNasa) as ImageView


    }
}