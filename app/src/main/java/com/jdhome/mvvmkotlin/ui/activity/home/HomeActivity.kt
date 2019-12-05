package com.jdhome.mvvmkotlin.ui.activity.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jdhome.mvvmkotlin.R
import com.jdhome.mvvmkotlin.database.statickt.StaticVarVal
import timber.log.Timber

class HomeActivity : AppCompatActivity() {


    private lateinit var homeViewModel: HomeViewModel
    private lateinit var parameters: HashMap<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        parameters = HashMap()

        parameters[0] = ""/*StaticVarVal.apiKey*/
        parameters[1] = "all"
        parameters[2] = "en"
        parameters[3] = "50"


        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.getAllImages(
            parameters
        )
        homeViewModel.mutableLiveData.observe(this, Observer {
            Timber.e(it.toString())
        })


    }//end of onCreate


}
