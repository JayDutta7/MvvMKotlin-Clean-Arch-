package com.jdhome.mvvmkotlin.networking.modelClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("largeImageURL")
    @Expose
    val largeImageURL: String,
    @SerializedName("type")
    @Expose
    val imgType: String,
    @SerializedName("imageSize")
    @Expose
    val imgSize: Int,
    @SerializedName("views")
    @Expose
    val views: Int,
    @SerializedName("downloads")
    @Expose
    val downloads: Int,
    @SerializedName("favorites")
    @Expose
    val favorites: Int,
    @SerializedName("likes")
    @Expose
    val likes: Int,
    @SerializedName("user")
    @Expose
    val imgOwner: String,
    @SerializedName("userImageURL")
    @Expose
    val userImageURL: String
)