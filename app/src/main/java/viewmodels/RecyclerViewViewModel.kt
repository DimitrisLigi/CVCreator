package viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import api.RetrofitBuilder
import models.ColorData
import models.ColorDomainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewViewModel: ViewModel(){
    private var listOfColorData: MutableLiveData<ColorDomainModel> = MutableLiveData()


    fun getRecyclerColorData(): MutableLiveData<ColorDomainModel>{
        return listOfColorData
    }


    fun makeApiCall(){
        val retroInstance = RetrofitBuilder.serviceApi.getTheListOfColors()

        retroInstance.enqueue(object : Callback<ColorDomainModel>{
            override fun onResponse(call: Call<ColorDomainModel>, response: Response<ColorDomainModel>){
                if (response.isSuccessful){
                    listOfColorData.postValue(response.body())
                }else{
                    listOfColorData.postValue(null)
                }
            }

            override fun onFailure(call: Call<ColorDomainModel>, t: Throwable) {
                listOfColorData.postValue(null)
            }

        })
    }
}