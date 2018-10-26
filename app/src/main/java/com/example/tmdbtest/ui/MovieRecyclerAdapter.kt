package com.example.tmdbtest.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tmdbtest.data.models.Movie
import com.example.tmdbtest.databinding.RvItemMovieBinding

class MovieRecyclerAdapter(private var items: ArrayList<Movie>,
                           private var listener: OnItemClickListener
):
    RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding = RvItemMovieBinding.inflate(layoutInflater, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        return p0.bind(items[p1], listener)
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun replaceData(items: ArrayList<Movie>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: RvItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(mov: Movie, listener: OnItemClickListener?){
            binding.movie = mov
            binding.root.setOnClickListener { _ -> listener?.onItemClick(layoutPosition) }
            binding.executePendingBindings()
        }
    }
}