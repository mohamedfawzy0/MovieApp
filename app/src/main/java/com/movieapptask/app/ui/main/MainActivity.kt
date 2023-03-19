package com.movieapptask.app.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.movieapptask.R
import com.movieapptask.app.adapter.CategoryAdapter
import com.movieapptask.app.adapter.MovieAdapter
import com.movieapptask.app.ui.favourite.FavouriteActivity
import com.movieapptask.app.ui.search.SearchActivity
import com.movieapptask.databinding.ActivityMainBinding
import com.movieapptask.domain.model.response.GenresModel
import com.movieapptask.domain.model.response.MoviesModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MoviesViewModel>()
    private var categoryList = mutableListOf<GenresModel.Genre>()
    private val categoryAdapter: CategoryAdapter by lazy { CategoryAdapter(this, categoryList) }
    private var movieList = mutableListOf<MoviesModel.Movie>()
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter(movieList) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.getCategories()
        initView()
        setUpObservers()
        setUpListeners()
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar.toolbar)
        binding.toolbar.title = getString(R.string.movies)
        binding.recViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recViewCategories.adapter = categoryAdapter

        binding.recView.layoutManager = GridLayoutManager(this, 2)
        binding.recView.adapter = movieAdapter

    }

    private fun setUpObservers() {
        viewModel.isLoading.observe(this) {
            binding.refresh.isRefreshing = it
        }
        viewModel.errorMessage.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE).show()
        }
        viewModel.categoriesLiveData.observe(this) {
            it?.let {
                binding.recViewCategories.isVisible = it.isNotEmpty()
                if (it.isNotEmpty()) {
                    categoryList.clear()
                    categoryList.addAll(it)
                    categoryAdapter.notifyDataSetChanged()
                }
            }
        }

        viewModel.moviesLiveData.observe(this) {
            it?.let {
                binding.cardNoData.isVisible = it.isEmpty()
                binding.recView.isVisible = it.isNotEmpty()
                if (it.isNotEmpty()) {
                    movieList.clear()
                    movieList.addAll(it)
                    movieAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun setUpListeners() {
        binding.refresh.setOnRefreshListener {
            if (binding.refresh.isRefreshing) {
                viewModel.getCategories()
                categoryAdapter.oldHolder=null
            }
        }
    }

    fun setItemCategory(model: GenresModel.Genre, position: Int) {
        viewModel.getMoviesByCategory(model.id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.favourite) {
            startActivity(Intent(this, FavouriteActivity::class.java))
        } else if (item?.itemId == R.id.search) {
            startActivity(Intent(this, SearchActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}