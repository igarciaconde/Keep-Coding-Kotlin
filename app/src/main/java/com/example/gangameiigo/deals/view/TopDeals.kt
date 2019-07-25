package com.example.gangameiigo.deals.view



import androidx.recyclerview.widget.RecyclerView
import com.example.commons.BaseLineFragment
import com.example.commons.DataBindingViewHolderAdapter
import com.example.gangameiigo.BR
import com.example.gangameiigo.R
import com.example.gangameiigo.model.Deal
import com.example.gangameiigo.model.DealMapper
import com.example.gangameiigo.model.GangGameDataSource



class TopDeals : BaseLineFragment() {

    val model = com.example.gangameiigo.deals.viewModel.Deal()


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
        //Dispatching cache data
        val deals = arrayListOf<Deal>()
        model.getCache().map { list ->
            deals.add(DealMapper.fromCache(list))
        }
        replaceItems(deals)
    }


}