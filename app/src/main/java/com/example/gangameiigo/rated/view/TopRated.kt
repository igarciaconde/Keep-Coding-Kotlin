package com.example.gangameiigo.rated.view




import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.GangGameDataSource
import com.example.gangameiigo.model.TopGame
import com.example.gangameiigo.model.TopGameMapper



class TopRated : BaseLineFragment() {

    val model = com.example.gangameiigo.rated.viewModel.Rated()

    override fun getAdapter(): RecyclerView.Adapter<*> = DataBindingViewHolderAdapter<TopGame>(BR.game, R.layout.item_top_game)

    override fun onResume() {
        super.onResume()
        showRated()
    }

    @SuppressLint("CheckResult")
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
        //Dispatching cache data
        val ratedList = arrayListOf<TopGame>()
        model.getCache()
            .map{  list ->
            ratedList.add(TopGameMapper.fromCache(list,0))
        }
        ratedList
            .sortWith(Comparator{ p0, p1 ->
            when{
                p0.steamRating > p1.steamRating -> -1
                p0.steamRating == p1.steamRating -> 0
                else -> 1
            }
        })
        (1 until ratedList.size).map { ratedList[it].position = it }
        replaceItems(ratedList)
    }

}