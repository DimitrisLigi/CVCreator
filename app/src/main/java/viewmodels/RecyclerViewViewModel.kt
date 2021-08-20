package viewmodels

import androidx.lifecycle.ViewModel
import repository.RepositoryApiRequests

class RecyclerViewViewModel: ViewModel(){

    val listOfColorData = RepositoryApiRequests.getColorDataFromTheNet()
    val listOfUsers = RepositoryApiRequests.getTheListOfUsersFromTheNet()

    fun cancelJobs(){
        RepositoryApiRequests.cancelJobs()
    }
}