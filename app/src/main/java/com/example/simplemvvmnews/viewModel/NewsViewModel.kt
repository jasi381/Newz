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

    private val newsLiveDataObject = MutableLiveData<News>()
    var category:String?= null

    val newsLiveData get() = newsLiveDataObject

    fun getNews(){
        val response = RetrofitServices.retrofitInstance.getHeadlines(category!!)
        response.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                newsLiveData.value = response.body()
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })

    }
}