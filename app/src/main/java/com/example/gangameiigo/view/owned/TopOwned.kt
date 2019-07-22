package com.example.gangameiigo.view.owned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderApadter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.TopGame


class TopOwned : BaseLineFragment() {


    override fun getAdapter(): RecyclerView.Adapter<*> = DataBindingViewHolderApadter<TopGame>(BR.game, R.layout.item_top_game)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingViewHolderApadter<TopGame>)?.items.addAll(getThumbItems())
        listAdapter.notifyDataSetChanged()
    }

    fun getThumbItems(): ArrayList<TopGame>{
        return arrayListOf( TopGame("Counter Strike",
            "http://lorempixel.com/400/400/technics/3/",
            80,
            5600000,
            22f,
            "Valve",
            12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12),
            TopGame("Counter Strike",
                "http://lorempixel.com/400/400/technics/3/",
                80,
                5600000,
                22f,
                "Valve",
                12)
        )
    }

}