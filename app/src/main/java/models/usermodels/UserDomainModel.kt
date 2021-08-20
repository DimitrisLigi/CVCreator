package models.usermodels


import com.google.gson.annotations.SerializedName

data class UserDomainModel(
    @SerializedName("data")
    val `data`: List<UserDataFromDomainModel>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)