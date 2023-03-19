package com.movieapptask.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.movieapptask.R
import com.movieapptask.app.ui.main.MainActivity
import com.movieapptask.databinding.ItemCategoryBinding
import com.movieapptask.domain.model.response.GenresModel


class CategoryAdapter(var context: Context, var list: MutableList<GenresModel.Genre>) :
    RecyclerView.Adapter<CategoryAdapter.MyHolder>() {
    var oldHolder: MyHolder? = null
    var currentPos = -1
    var oldPos = currentPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemCategoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_category, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val myHolder: MyHolder = holder as MyHolder
        val article = list[position]
        myHolder.bind(article)

        if (oldHolder == null) {
            oldHolder = myHolder
            val model: GenresModel.Genre = list[position]
            model.isSelected = true
            list[position] = model
            myHolder.bind(model)
            oldPos = position

            if (context is MainActivity) {
                val activity: MainActivity = context as MainActivity
                activity.setItemCategory(model, position)
            }
        }
        myHolder.itemView.setOnClickListener {
            if (oldHolder != null) {
                val oldCategoryModel: GenresModel.Genre = list[oldPos]
                oldCategoryModel.isSelected = false
                list[oldPos] = oldCategoryModel
                val oHolder: MyHolder = oldHolder as MyHolder
                myHolder.bind(oldCategoryModel)
                notifyItemChanged(oldPos)
            }

            currentPos = myHolder.adapterPosition
            val categoryModel: GenresModel.Genre = list[currentPos]
            categoryModel.isSelected = true
            list[currentPos] = categoryModel
            myHolder.bind(categoryModel)
            notifyItemChanged(currentPos)

            oldHolder = myHolder
            oldPos = currentPos

            if (context is MainActivity) {
                val activity: MainActivity = context as MainActivity
                activity.setItemCategory(categoryModel, currentPos)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GenresModel.Genre) {
            binding.model = item
        }
    }
}