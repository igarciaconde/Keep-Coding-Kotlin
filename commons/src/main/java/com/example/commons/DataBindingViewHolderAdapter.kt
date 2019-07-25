package com.example.commons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolderAdapter <MODEL> (val variableBindingId : Int, val viewResId: Int): RecyclerView.Adapter<DataBindingViewHolder<MODEL>>() {

    val items : MutableList<MODEL> = mutableListOf()
    

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<MODEL> {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),viewResId,parent,false)
        return DataBindingViewHolder(variableBindingId,binding) //6.12
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<MODEL>, position: Int) {
        var item = items[position]
        holder.bindItem(item)
    }
}