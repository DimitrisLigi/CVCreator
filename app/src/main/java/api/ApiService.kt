package api

import models.ColorDomainModel
import retrofit2.Call
import retrofit2.http.GET
import utils.Constants

interface ApiService {
    @GET(Constants.END_POINT_FOR_COLORS)
    suspend fun getTheListOfColors(): ColorDomainModel
}