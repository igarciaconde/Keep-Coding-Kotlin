package com.example.gangameiigo.rated.view



import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.GangGameDataSource
import com.example.gangameiigo.model.TopGame
import com.google.android.material.snackbar.Snackbar


class TopRated : BaseLineFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> = DataBindingViewHolderAdapter<TopGame>(BR.game, R.layout.item_top_game)

    override fun onResume() {
        super.onResume()
        showRated()
    }

    private fun showRated(){
        GangGameDataSource
            .getTopRated()
            .subscribe({ list ->
                replaceItems(list)},
                { error ->
                    showError(error)})
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
                .setAction(R.string.label_retry, { _ : View -> showRated()})
                .show()
        }
    }

}