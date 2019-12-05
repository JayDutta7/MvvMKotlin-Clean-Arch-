package com.jdhome.mvvmkotlin.viewmodel.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdhome.mvvmkotlin.networking.CommonResponse
import com.jdhome.mvvmkotlin.networking.modelClass.ResponseImages
import com.jdhome.mvvmkotlin.repository.home.HomeRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class HomeViewModel : ViewModel() {


    private var homeRepository: HomeRepository? = null
    private var compositeDisposables: CompositeDisposable? = null

    var mutableLiveData: MutableLiveData<CommonResponse<ResponseImages>>
    lateinit var isLoadingMutableLiveData: MutableLiveData<Boolean>

    init {
        homeRepository = HomeRepository()
        mutableLiveData = MutableLiveData()
        compositeDisposables = CompositeDisposable()
        isLoadingMutableLiveData.value = true
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
                    mutableLiveData.value = CommonResponse.Success(resPonse)
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposables?.add(d)
            }

            override fun onError(e: Throwable) {
                mutableLiveData.value = CommonResponse.Error(e)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposables?.clear()
    }


}