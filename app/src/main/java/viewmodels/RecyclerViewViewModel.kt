package viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.ColorDomainModel
import repository.RepositoryApiRequests

class RecyclerViewViewModel: ViewModel(){
    val listOfColorData = RepositoryApiRequests.getColorDataFromTheNet()
    fun cancelJobs(){
        RepositoryApiRequests.cancelJobs()
    }
}