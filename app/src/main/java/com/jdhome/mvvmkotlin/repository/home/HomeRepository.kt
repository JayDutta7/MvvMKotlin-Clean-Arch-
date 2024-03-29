package com.jdhome.mvvmkotlin.repository.home

import com.jdhome.mvvmkotlin.database.statickt.StaticVarVal
import com.jdhome.mvvmkotlin.networking.ApiInterface
import com.jdhome.mvvmkotlin.networking.modelClass.ResponseImages
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class HomeRepository {

    private var homeRepoApiService: ApiInterface? = null

    init {
        homeRepoApiService = ApiInterface.CreateRetrofit().apiService(StaticVarVal.baseUrl)
    }

    fun getAllImages(values: HashMap<Int, String>): Single<ResponseImages>? {

        return homeRepoApiService?.getAllImages(
            values[0].toString(),
            values[1].toString(),
            values[2].toString(),
            values[3].toString()
        )?.doOnError {
            Timber.e(it)
        }?.subscribeOn(Schedulers.io())
         ?.observeOn(AndroidSchedulers.mainThread())

    }


}