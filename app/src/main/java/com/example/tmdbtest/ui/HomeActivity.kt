package com.example.tmdbtest.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tmdbtest.R
import com.example.tmdbtest.databinding.ActivityHomeBinding
import com.example.tmdbtest.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity(), MovieRecyclerAdapter.OnItemClickListener {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MovieRecyclerAdapter(viewModel.movies, this)
    }

    override fun onItemClick(position: Int) {

    }
}
