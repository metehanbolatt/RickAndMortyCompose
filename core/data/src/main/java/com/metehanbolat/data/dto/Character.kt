package com.metehanbolat.data.dto


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("episode")
    val episode: List<String?>? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("origin")
    val origin: Origin? = null,
    @SerializedName("species")
    val species: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)