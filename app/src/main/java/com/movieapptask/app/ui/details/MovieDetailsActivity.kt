package com.movieapptask.app.ui.details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.movieapptask.R
import com.movieapptask.adapter.GenreAdapter
import com.movieapptask.app.ui.main.MoviesViewModel
import com.movieapptask.app.utils.Constants
import com.movieapptask.databinding.ActivityMovieDetailsBinding
import com.movieapptask.domain.model.request.AddRemoveFavouriteBody
import com.movieapptask.domain.model.response.MoviesModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private val viewModel by viewModels<MoviesViewModel>()
    private var movieId: Int? = null
    private var genreList = mutableListOf<MoviesModel.Movie.Genre>()
    private val adapter: GenreAdapter by lazy { GenreAdapter(genreList) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        movieId = intent.extras?.getInt(Constants.KEY_ID)

        viewModel.getMovieDetails(movieId!!)
        viewModel.getFavouriteStatus(movieId!!)
        initView()
        setUpObservers()
        setUpListeners()
    }

    private fun initView() {
        binding.lang = Locale.getDefault().language
        binding.llBack.visibility = View.VISIBLE
        binding.recViewGenre.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        binding.recViewGenre.adapter = adapter

    }

    private fun setUpObservers() {
        viewModel.isLoading.observe(this) {
            binding.refresh.isRefreshing = it
        }
        viewModel.errorMessage.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE).show()
        }
        viewModel.movieDetailsLiveData.observe(this) {
            binding.model = it
            Glide.with(this).load(Constants.PATH + binding.model!!.poster_path)
                .into(binding.movieImg)

            if (it.genres.isNotEmpty()) {
                genreList.clear()
                genreList.addAll(it.genres)
                adapter.notifyDataSetChanged()

            }
        }

        viewModel.isFavouriteLivData.observe(this) {
            binding.fav = it
        }
        viewModel.addRemoveFavouriteLivData.observe(this) {
            if (!it.isNullOrEmpty()){
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                viewModel.getFavouriteStatus(movieId!!)
            }else{}
        }
    }

    private fun setUpListeners() {
        binding.refresh.setOnRefreshListener {
            if (binding.refresh.isRefreshing) {
                viewModel.getMovieDetails(movieId!!)
                viewModel.getFavouriteStatus(movieId!!)
            }
        }
        binding.icFav.setOnClickListener {
            if (binding.fav == false) {
                viewModel.addRemoveFavourite(AddRemoveFavouriteBody(true, movieId!!, "movie"))
            } else {
                viewModel.addRemoveFavourite(AddRemoveFavouriteBody(false, movieId!!, "movie"))
            }
        }
        binding.llBack.setOnClickListener { onBackPressed() }
    }
}