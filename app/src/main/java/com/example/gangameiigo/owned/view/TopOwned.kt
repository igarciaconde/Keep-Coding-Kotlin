package com.example.gangameiigo.owned.view



import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.GangGameDataSource
import com.example.gangameiigo.model.TopGame
import com.example.gangameiigo.model.TopGameMapper
import com.example.gangameiigo.owned.viewModel.Owned


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
        //Dispatching cache data
        val ownedList = arrayListOf<TopGame>()
        model.getCache().mapIndexed { index, list ->
            ownedList.add(TopGameMapper.fromCache(list,index))
        }
        replaceItems(ownedList)
    }

}