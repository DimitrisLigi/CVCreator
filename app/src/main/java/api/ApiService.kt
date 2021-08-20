package api

import models.colormodels.ColorDomainModel
import models.usermodels.UserDomainModel
import retrofit2.http.GET
import utils.Constants

interface ApiService {
    //Getting tha color domain model from the net
    @GET(Constants.END_POINT_FOR_COLORS)
    suspend fun getTheListOfColors(): ColorDomainModel

    //Getting the user domain model from the net
    @GET(Constants.END_POINT_FOR_LIST_OF_USERS)
    suspend fun getTheListOfUsers():UserDomainModel

}