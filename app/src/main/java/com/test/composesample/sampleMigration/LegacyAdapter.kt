package com.test.composesample.sampleMigration


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.bumptech.glide.load.engine.DiskCacheStrategy

import com.test.composesample.R
import java.util.*

data class SampleData(val text:String, val url:String)
class LegacyAdapter(val context: Context) : RecyclerView.Adapter<LegacyAdapter.ItemViewHolder>() {

    private var listData: ArrayList<SampleData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holderItem: ItemViewHolder, position: Int) {
        listData[position].let {
            holderItem.bind(it)
        }
    }
    override fun getItemCount(): Int {
        return listData.size
    }

    fun initItem(list: ArrayList<SampleData>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }



    inner class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        private var img: ImageView? = null
        private var txt: TextView? = null
        init {
            img = view.findViewById<ImageView>(R.id.img)
            txt = view.findViewById<TextView>(R.id.txt)
        }
        fun bind(item: SampleData) {
            img!!.glideLoadForUrl(item.url)
            txt!!.text = item.text
            img!!.setOnClickListener {
                Toast.makeText(context, "click $txt", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



fun ImageView.glideLoadForUrl(url: String) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}
