package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import utils.Constants

object RetrofitBuilder {
    private val retrofitBuilderForRESREQ : Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val serviceApi: ApiService by lazy {
        retrofitBuilderForRESREQ.build().create(ApiService::class.java)
    }

}