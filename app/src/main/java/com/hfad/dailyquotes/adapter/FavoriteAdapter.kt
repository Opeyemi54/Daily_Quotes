package com.hfad.dailyquotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hfad.dailyquotes.R
import com.hfad.dailyquotes.model.Quotedataclass

class FavoriteAdapter(private var context: Context, private val onClickListener: (quote: Quotedataclass) -> Unit)
    : ListAdapter<Quotedataclass, FavoriteAdapter.ViewHolder>(DiffUtill()) {
   inner class ViewHolder(private val v :View): RecyclerView.ViewHolder(v){
        var quoteText:TextView = v.findViewById(R.id.quote_favorite)
       var writerName:TextView = v.findViewById(R.id.writer_favorite)
       var imgResource:CheckBox = v.findViewById(R.id.checkbox_favorite)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.favorite_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val currentPosition = getItem(position)
        holder.quoteText.text = currentPosition.quoteText
        holder.writerName.text = currentPosition.quoteAuthor
        holder.imgResource.setOnClickListener(null)
        holder.imgResource.setOnCheckedChangeListener {
                _, isChecked ->

            if (isChecked){
                holder.imgResource.isChecked = false
                Toast.makeText(context, "Quote removed from favorites", Toast.LENGTH_SHORT).show()
            }
            onClickListener(currentPosition.copy(isFavorite = isChecked))
        }
    }
}