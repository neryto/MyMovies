package com.nery.lbustos.mymovies.movies.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nery.lbustos.mymovies.databinding.ActivityMainBinding
import com.nery.lbustos.mymovies.detail.views.BottomSheetDetailFragment
import com.nery.lbustos.mymovies.entities.MovieItem
import com.nery.lbustos.mymovies.movies.interfaces.MoviePresenter
import com.nery.lbustos.mymovies.movies.interfaces.MovieView
import com.nery.lbustos.mymovies.movies.presenters.MoviePresenterImpl

class MainActivity : AppCompatActivity(), MovieView {


    var movies: ArrayList<MovieItem> = arrayListOf()
    private var adapter: MovieAdapter? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MoviePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MoviePresenterImpl(this)
        initView()
    }


    private fun initView() {
        binding.recyclerViewMovies
        binding.recyclerViewMovies.layoutManager = StaggeredGridLayoutManager(
            3,
            StaggeredGridLayoutManager.VERTICAL
        )
        adapter = MovieAdapter(movies) {
            BottomSheetDetailFragment(it)
                .apply {
                    show(
                        supportFragmentManager,
                        BottomSheetDetailFragment.TAG
                    )
                }
        }
        binding.recyclerViewMovies?.adapter = adapter
        presenter.getMovies()
    }


    override fun showShimmer() {
        binding.mainView.startShimmer()
    }

    override fun hideShimmer() {
        binding.mainView.stopShimmer()
        binding.mainView.visibility = View.GONE
    }

    override fun successGetMovies(movies: List<MovieItem>) {
        this.movies.clear()
        this.movies.addAll(movies)
        adapter?.notifyDataSetChanged()
    }

    override fun errorGetMovies(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG)
    }

}


