package com.example.retrofit_itboy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recyler:RecyclerView
    lateinit var myadpater:Myadapter
    val base_url="https://api.github.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyler=findViewById(R.id.recyleview)
        recyler.layoutManager=LinearLayoutManager(this)

        getAllData()
    }

    private fun getAllData() {
        val retrofit=Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
        var retrodata=retrofit.getData()
        retrodata.enqueue(object :Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val data = response.body()!!
                myadpater=Myadapter(baseContext,data)
                recyler.adapter=myadpater
                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {

            }
        })
    }
}