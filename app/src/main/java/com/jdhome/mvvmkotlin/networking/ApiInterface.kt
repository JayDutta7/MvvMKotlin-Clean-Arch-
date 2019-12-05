package com.jdhome.mvvmkotlin.networking



import com.jdhome.mvvmkotlin.database.localDatabase.model.picture.PictureTbl
import com.jdhome.mvvmkotlin.database.statickt.StaticVarVal
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import timber.log.Timber


interface ApiInterface {


    /**********************************todo Api Service's***********************************/
    //@Field parameters can only be used with form encoding (POST)
    //@Url pass runtime url
    //@Query This annotation represents any query key value pair to be sent along with the network request GET/POST
    //@Path parameter name must match \{([a-zA-Z][a-zA-Z0-9_-]*)\}.


    //todo------((Api1--All images))
    @GET(WebService.BaseUrl)
    @Headers(
        "Accept:application/json"
    )
    fun getAllImages(
        @Path("client_key") clientKey: String?,
        @Path("image_type") imageType: String?,
        @Path("lang") lang: String?,
        @Path("order") order:String?,
        @Path("per_page") perPage : String
    ): Single<PictureTbl>

    //toDo---((Api 2--SearchImages))
    @GET(WebService.BaseUrl)
    @Headers(
        "Accept:application/json"
    )
    fun getSpecificImages(
        @Path("client_key") clientKey: String?,
        @Path("image_type") imageType: String?,
        @Path("order") order:String?,
        @Path("per_page") perPage : String
    ): Single<AppSettingsData>


    //toDo--((Api3--All Videos))
    @Multipart
    @POST
    fun getAllVideos(
        @Url url: String,
        @Part("profile_pic") image: MultipartBody.Part,
        @Part("name") name: RequestBody
    ): Single<AppSettingsData>


    //toDo((Api-4--SearchVideos))*(Post-Raw)
    @POST
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json"
    )
    fun getSpecificVideos(
        @Header("Authorization") token: String,
        @Url url: String,
        @Body params: AppSettingsData
    ): Single<AppSettingsData>




    /**Create Retrofit Service--By Calling class Create Retrofit**/
    class CreateRetrofit {
        fun apiService(url: String): ApiInterface {
            Timber.e("""RetrofitUrl$url""")
            return when (url) {
                StaticVarVal.gMap -> {
                    RetrofitNetworking.getClient(WebService.BaseUrl)!!.create(ApiInterface::class.java)
                }
                else -> {
                    RetrofitNetworking.getClient(url)!!.create(ApiInterface::class.java)
                }
            }
        }
    }


}