package com.jdhome.mvvmkotlin.networking.modelClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseImages (
    @SerializedName("totalHits")
    @Expose
    val totalHits:Int,
    @SerializedName("total")
    @Expose
    val total:Int,
    @SerializedName("hits")
    @Expose
    val responseValue:MutableList<ResponseData>
)