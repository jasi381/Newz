package com.example.simplemvvmnews.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.simplemvvmnews.R
import com.example.simplemvvmnews.databinding.ItemNewsBinding
import com.example.simplemvvmnews.models.Article

class NewsAdapter(private var mContext :Context, private val list :List<Article>):Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(view: View):ViewHolder(view){
        val binding = ItemNewsBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(mContext)
                .inflate(R.layout.item_news,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        val item = list[position]
        holder.binding.tvTitle.text = item.title
        Glide.with(mContext).load(item.urlToImage).into(holder.binding.newsImg)

        holder.itemView.setOnClickListener {
            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(mContext, Uri.parse(item.url))
        }

    }
}