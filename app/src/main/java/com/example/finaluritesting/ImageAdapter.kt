package com.example.finaluritesting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluritesting.dataclasses.Image

class ImageAdapter(
    private val context: Context,
    private val images: List<Image>,
    private val listener: (Image) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageSrc = view.findViewById<ImageView>(R.id._image)
        private val title = view.findViewById<TextView>(R.id._title)
        fun bindView(image: Image, listener: (Image) -> Unit) {
            imageSrc.setImageResource(image.imageSrc)
            title.text = image.imageTitle
            itemView.setOnClickListener { listener(image) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false))

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position], listener)
    }
}