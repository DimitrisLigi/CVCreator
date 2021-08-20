package repository

import androidx.lifecycle.LiveData
import api.RetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import models.colormodels.ColorDomainModel
import models.usermodels.UserDomainModel

object RepositoryApiRequests {
    private var job: CompletableJob? = null

    fun getColorDataFromTheNet(): LiveData<ColorDomainModel>{
        job  = Job()
        return object: LiveData<ColorDomainModel>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO+it).launch {
                        val colorModel = RetrofitBuilder.serviceApi.getTheListOfColors()
                        withContext(Main){
                            value = colorModel
                            it.complete()
                        }
                    }
                }
            }
        }
    }


    fun getTheListOfUsersFromTheNet(): LiveData<UserDomainModel>{
        job = Job()
        return object: LiveData<UserDomainModel>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO+it).launch {
                        val listOfUsers = RetrofitBuilder.serviceApi.getTheListOfUsers()
                        withContext(Main){
                            value = listOfUsers
                            it.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }
}