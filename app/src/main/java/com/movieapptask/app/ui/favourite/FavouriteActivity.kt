package com.movieapptask.app.ui.favourite

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.movieapptask.R
import com.movieapptask.adapter.MovieAdapter
import com.movieapptask.app.ui.main.MoviesViewModel
import com.movieapptask.databinding.ActivityFavouriteBinding
import com.movieapptask.domain.model.response.MoviesModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteBinding
    private val viewModel by viewModels<MoviesViewModel>()
    private var movieList = mutableListOf<MoviesModel.Movie>()
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter(movieList) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favourite)

        viewModel.getFavourites()
        initView()
        setUpObservers()
        setUpListeners()
    }

    private fun initView() {
        setSupportActionBar(binding.toolBar.toolbar)
        binding.toolBar.llBack.visibility = View.VISIBLE
        binding.toolBar.title = getString(R.string.favourites)

        binding.recViewFavourites.layoutManager = GridLayoutManager(this, 2)
        binding.recViewFavourites.adapter = movieAdapter
    }

    private fun setUpObservers() {
        viewModel.isLoading.observe(this) {
            binding.swipe.isRefreshing = it
        }
        viewModel.errorMessage.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE).show()
        }

        viewModel.moviesLiveData.observe(this) {
            it?.let {
                binding.recViewFavourites.isVisible = it.isNotEmpty()
                if (it.isNotEmpty()) {
                    movieList.clear()
                    movieList.addAll(it)
                    movieAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun setUpListeners() {
        binding.swipe.setOnRefreshListener {
            if (binding.swipe.isRefreshing){
                viewModel.getFavourites()
            }
        }
        binding.toolBar.llBack.setOnClickListener { onBackPressed() }
    }
}