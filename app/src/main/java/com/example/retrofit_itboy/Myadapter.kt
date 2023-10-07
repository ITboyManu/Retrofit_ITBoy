package com.example.retrofit_itboy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Myadapter(var con: Context,var list:List<UsersItem>):RecyclerView.Adapter<Myadapter.Viewholder>(){
    inner class Viewholder(v: View):RecyclerView.ViewHolder(v){


        var img=v.findViewById<ImageView>(R.id.image)

        var txt=v.findViewById<TextView>(R.id.textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view=LayoutInflater.from(con).inflate(R.layout.rv_items,parent,false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val data=list[position]
        Glide.with(con).load(data.avatar_url).into(holder.img)
        holder.txt.text=data.login

    }
}


