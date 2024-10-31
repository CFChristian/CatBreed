package com.example.catlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCatAdapter(private val listCat: ArrayList<Cat>) : RecyclerView.Adapter<ListCatAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_cats, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listCat.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cat = listCat[position]
        holder.catPhoto.setImageResource(cat.photo)
        holder.tvBreed.text = cat.breed
        holder.tvDescription.text = cat.description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailScreen::class.java)
            intent.putExtra("cat_data", cat)
            context.startActivity(intent)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catPhoto: ImageView = itemView.findViewById(R.id.img_cat)
        val tvBreed: TextView = itemView.findViewById(R.id.tv_cat_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_cat_description)
    }
}
