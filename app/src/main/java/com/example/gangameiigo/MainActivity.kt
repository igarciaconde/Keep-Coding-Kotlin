package com.example.gangameiigo

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gangameiigo.deals.view.TopDeals
import com.example.gangameiigo.owned.view.TopOwned
import com.example.gangameiigo.rated.view.TopRated
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.contentView


class MainActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_OPTION = R.id.navigation_deals
    }

    val fragments : HashMap<Int, Fragment> = hashMapOf(
        Pair(R.id.navigation_deals, TopDeals()),
        Pair(R.id.navigation_rated, TopRated()),
        Pair(R.id.navigation_owned, TopOwned())
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isNetworkAvailable()){
           initWithConnection()
        }else{
            Snackbar.make(contentView!!, "Check network signal", Snackbar.LENGTH_LONG)
        }
    }




    private fun initWithConnection()
    {
        initView()

        nav_view.selectedItemId = DEFAULT_OPTION
        nav_view.setOnNavigationItemSelectedListener { item ->

            val frag : Fragment? = fragments[item.itemId]
            if(frag != null)
                replaceFragment(frag)
            true
        }
    }


    private fun replaceFragment(frag : Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, frag)
            .commit()
    }



    private fun initView(){
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(fragment == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, TopDeals())
                .commit()

        }
    }


    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
