package com.mynormeza.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerModel(
    @SerializedName("login") val ownerName: String,
    @SerializedName("avatar_url") val avatarUrl: String
)