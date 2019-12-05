package com.jdhome.mvvmkotlin.networking.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PictureApiResponse(
    @SerializedName("totalHits")
    @Expose
    val totalHits:Int,
    @SerializedName("total")
    @Expose
    val total:Int,


)