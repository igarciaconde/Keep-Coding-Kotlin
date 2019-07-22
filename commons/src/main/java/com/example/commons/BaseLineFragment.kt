package com.example.commons

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.view.*


abstract class BaseLineFragment : BaseFragment() {

    lateinit var listAdapter : RecyclerView.Adapter<*>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = getAdapter()
        with(view.list){
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }



    }

    override fun getLayoutResId(): Int = R.layout.fragment_list

    abstract fun getAdapter() : RecyclerView.Adapter<*>


}