package com.jdhome.mvvmkotlin.viewmodel.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdhome.mvvmkotlin.networking.modelClass.ResponseData
import com.jdhome.mvvmkotlin.networking.modelClass.ResponseImages
import com.jdhome.mvvmkotlin.networking.sealedClass.CommonResponse
import com.jdhome.mvvmkotlin.repository.home.HomeRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber


class HomeViewModel : ViewModel() {

    //Access to repository
    private var homeRepository: HomeRepository? = null
    //Add all disposable
    private var compositeDisposables: CompositeDisposable? = null
    //Access from view
    var mutableLiveData: MutableLiveData<CommonResponse<MutableList<ResponseData>>>
    //Loading information
    var isLoadingMutableLiveData: MutableLiveData<Boolean>

    init {
        homeRepository = HomeRepository()
        mutableLiveData = MutableLiveData()
        compositeDisposables = CompositeDisposable()
        isLoadingMutableLiveData = MutableLiveData()
    }

    @SuppressLint("CheckResult")
    fun getAllImages(values: HashMap<Int, String>) {
        isLoadingMutableLiveData.value = true
        homeRepository?.getAllImages(
            values
        )?.doOnError {
            Timber.e(it)
        }/*?.doOnSubscribe {
            mutableLiveData.value = CommonResponse.Loading()
        }?*/?.subscribeWith(object : SingleObserver<ResponseImages> {
            override fun onSuccess(resPonse: ResponseImages) {

                isLoadingMutableLiveData.value = false

                if (resPonse.responseValue.isNotEmpty())
                    mutableLiveData.postValue(CommonResponse.Success(resPonse.responseValue))
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposables?.add(d)
            }

            override fun onError(e: Throwable) {

                isLoadingMutableLiveData.value = false

                mutableLiveData.value = CommonResponse.Failure(e)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposables?.clear()
    }


}