package models.colormodels


import com.google.gson.annotations.SerializedName

data class ColorData(
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pantone_value")
    val pantoneValue: String,
    @SerializedName("year")
    val year: Int
)