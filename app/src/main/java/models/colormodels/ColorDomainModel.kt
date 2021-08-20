package models.colormodels


import com.google.gson.annotations.SerializedName

data class ColorDomainModel(
    @SerializedName("data")
    val `data`: List<ColorData>,
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