package com.example.gangameiigo.view.deals


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderApadter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.Deal


class TopDeals : BaseLineFragment() {


    override fun getAdapter(): RecyclerView.Adapter<*> = DataBindingViewHolderApadter<Deal>(BR.deal, R.layout.item_top_deal)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (listAdapter as DataBindingViewHolderApadter<Deal>)?.items.addAll(getThumbItems())
        listAdapter.notifyDataSetChanged()
    }

    private fun getThumbItems(): ArrayList<Deal>{
        return arrayListOf( Deal("Counter Strike",
            "http://lorempixel.com/400/200/",
            80,
            56,
            22f,
            45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
                80,
                56,
                22f,
                45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
                80,
                56,
                22f,
                45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
                80,
                56,
                22f,
                45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
            80,
            56,
            22f,
            45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
            80,
            56,
            22f,
            45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
            80,
            56,
            22f,
            45f),

            Deal("Counter Strike",
                "http://lorempixel.com/400/200/",
            80,
            56,
            22f,
            45f))
    }

}