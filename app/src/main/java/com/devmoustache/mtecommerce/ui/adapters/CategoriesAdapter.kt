package com.devmoustache.mtecommerce.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devmoustache.mtecommerce.R
import kotlinx.android.synthetic.main.category_row.view.*

class CategoriesAdapter(private val categories: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = categories[position]
    }

    class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val categoryName = view.categoryName
    }
}