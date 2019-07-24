package com.example.gangameiigo.owned.view


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.DealMapper
import com.example.gangameiigo.model.GangGameDataSource
import com.example.gangameiigo.model.TopGame
import com.example.gangameiigo.model.TopGameMapper
import com.example.gangameiigo.owned.viewModel.Owned
import com.google.android.material.snackbar.Snackbar
import com.google.gson.JsonObject


class TopOwned : BaseLineFragment() {

    val model = Owned()

    override fun getAdapter(): RecyclerView.Adapter<*> =
        DataBindingViewHolderAdapter<TopGame>(BR.game, R.layout.item_top_game)

    override fun onResume() {
        super.onResume()
        showOwned()
    }

    private fun showOwned(){
        GangGameDataSource
            .getTopOwned()
            .subscribe({ list ->
                replaceItems(list)},
                { error -> showError(error)})
    }

    private fun replaceItems(list: ArrayList<TopGame>) {
        with(listAdapter as DataBindingViewHolderAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.errorMessage, Snackbar.LENGTH_LONG)
                .setAction(R.string.label_retry, { _ : View -> showOwned()})
                .show()
        }
        val ownedList = arrayListOf<TopGame>()
        model.getCache().map { list ->
            
        }
        replaceItems(ownedList)
    }

}