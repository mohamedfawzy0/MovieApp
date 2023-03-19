package com.movieapptask.app.ui.search

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.movieapptask.R
import com.movieapptask.adapter.MovieAdapter
import com.movieapptask.app.ui.main.MoviesViewModel
import com.movieapptask.databinding.ActivitySearchBinding
import com.movieapptask.domain.model.response.MoviesModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val viewModel by viewModels<MoviesViewModel>()
    private var movieList = mutableListOf<MoviesModel.Movie>()
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter(movieList) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        initView()
        setUpObservers()
        setUpListeners()
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar.toolbar)
        binding.toolbar.llBack.visibility = View.VISIBLE
        binding.toolbar.title = getString(R.string.search_result)

        binding.recView.layoutManager = GridLayoutManager(this, 2)
        binding.recView.adapter = movieAdapter
    }

    private fun setUpObservers() {
        viewModel.isLoading.observe(this) {
//            binding.refresh.isRefreshing = it
        }
        viewModel.errorMessage.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE).show()
        }

        viewModel.moviesLiveData.observe(this) {
            it?.let {
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
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                viewModel.search(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText!!)

                return false
            }

        })
        binding.toolbar.llBack.setOnClickListener { onBackPressed() }
    }
}