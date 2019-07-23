package com.example.gangameiigo.view.deals


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.Deal
import com.example.gangameiigo.model.GangGameDataSource
import com.google.android.material.snackbar.Snackbar


class TopDeals : BaseLineFragment() {


    override fun getAdapter(): RecyclerView.Adapter<*> = DataBindingViewHolderAdapter<Deal>(BR.deal, R.layout.item_top_deal)


    override fun onResume() {
        super.onResume()
        showItems()
    }

    private fun showItems() {
        GangGameDataSource
            .getDeals()
            .subscribe( { list ->
                replaceItems(list)},
                { error ->
                    showErrors(error)})
    }

    private fun replaceItems(list : ArrayList<Deal>){
        with(listAdapter as DataBindingViewHolderAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

    }

    private fun showErrors(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.errorMessage, Snackbar.LENGTH_LONG)
                .setAction(R.string.label_retry, { _ : View -> showItems()})
                .show()
        }
    }


}