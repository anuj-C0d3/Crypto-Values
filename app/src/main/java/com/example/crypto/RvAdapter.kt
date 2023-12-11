package com.example.crypto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.databinding.RvItemsBinding

class RvAdapter(val context: Context, var data:ArrayList<modal>) :RecyclerView.Adapter<RvAdapter.viewHolder>(){
    fun changeData(filterdata:ArrayList<modal>){
        data = filterdata
        notifyDataSetChanged()
    }
    inner class viewHolder(val binding: RvItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = RvItemsBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        setAnimation(holder.itemView)
        holder.binding.Symbol.text=data[position].symbol
        holder.binding.name.text=data[position].name
        holder.binding.prize.text=data[position].prize
    }
    fun setAnimation(view: View){
        val anim = AlphaAnimation(0.0f,1.0f)
        anim.duration = 400
        view.startAnimation(anim)
    }

}