package com.movieapptask.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.movieapptask.R
import com.movieapptask.databinding.ItemGenreRowBinding
import com.movieapptask.domain.model.response.MoviesModel


class GenreAdapter(
    var genreList: MutableList<MoviesModel.Movie.Genre>
) :
    RecyclerView.Adapter<GenreAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemGenreRowBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_genre_row, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val model = genreList[position]
        holder.bind(model)

    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    inner class MyHolder(private val binding: ItemGenreRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: MoviesModel.Movie.Genre) {
            binding.model = genre
        }
    }

}