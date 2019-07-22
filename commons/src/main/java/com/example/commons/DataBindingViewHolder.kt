package com.example.commons

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingViewHolder<MODEL>(val variableBindingId: Int, val binding : ViewDataBinding): RecyclerView.ViewHolder(binding.root){

    fun bindItem(model: MODEL){
        binding.setVariable(variableBindingId,model)
        binding.executePendingBindings()
    }

}