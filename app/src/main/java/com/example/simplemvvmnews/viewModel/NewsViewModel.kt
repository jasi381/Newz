package com.example.simplemvvmnews.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvmnews.api.RetrofitServices
import com.example.simplemvvmnews.models.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel:ViewModel() {

     val newsLiveData = MutableLiveData<News>()

    fun getNews(category:String,from:String){
        val response = RetrofitServices.retrofitInstance.getHeadlines(category,from)
        response.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                //show loading
                newsLiveData.value = response.body()
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })

    }
}