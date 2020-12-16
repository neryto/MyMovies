package com.nery.lbustos.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    var movies : ArrayList<MovieItem> = arrayListOf()
    private var adapter : MoviesAdapter?  = null
    private var recyclerView : RecyclerView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        getMovies()

    }

   private fun initView(){
        recyclerView = findViewById(R.id.recyclerViewMovies)
        recyclerView?.layoutManager = GridLayoutManager(this,3)
        adapter = MoviesAdapter(movies) {
            BottomSheetDetailFragment(it)
                .apply {
                show(supportFragmentManager,BottomSheetDetailFragment.TAG)
            }
        }
       recyclerView?.adapter = adapter
    }







    fun getMovies(){
        getRetrofit().create(MoviesWebservices :: class.java)
            .getMovies("117d1bd56ea2f98e9662d5cfbd5408e2").enqueue(object  : Callback<MoviesResponse>{
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.d("TAG1",t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                   movies.addAll( response.body()!!.results)
                   adapter?.notifyDataSetChanged()
                }

            })
    }


    fun getRetrofit() : Retrofit {
       val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
       val httpClientBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor!!)
       return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .client(httpClientBuilder?.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}


