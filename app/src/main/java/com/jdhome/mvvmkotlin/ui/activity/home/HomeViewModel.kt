package com.jdhome.mvvmkotlin.ui.activity.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdhome.mvvmkotlin.networking.Res
import com.jdhome.mvvmkotlin.networking.modelClass.ResponseImages
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class HomeViewModel : ViewModel() {


    private var homeRepository: HomeRepository? = null
    private var compositeDisposables: CompositeDisposable? = null

    var mutableLiveData: MutableLiveData<Res<ResponseImages>>

    init {
        homeRepository = HomeRepository()
        mutableLiveData = MutableLiveData()
        compositeDisposables = CompositeDisposable()
    }

    @SuppressLint("CheckResult")
    fun getAllImages(values: HashMap<Int, String>) {

        homeRepository?.getAllImages(
            values
        )?.doOnError {
            Timber.e(it)
        }/*?.doOnSubscribe {
            mutableLiveData.value = Res.loading()
        }*/?.doOnTerminate {
            //hide loader

        }?.subscribeWith(object : SingleObserver<ResponseImages> {
            override fun onSuccess(resPonse: ResponseImages) {
                if (resPonse.responseValue.isNotEmpty())
                    mutableLiveData.value = Res.Success(resPonse)
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposables?.add(d)
            }

            override fun onError(e: Throwable) {
                mutableLiveData.value = Res.Error(e)
            }

        })
    }


}