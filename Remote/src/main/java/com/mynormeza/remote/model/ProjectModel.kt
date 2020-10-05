package com.mynormeza.remote.model

import com.google.gson.annotations.SerializedName

class ProjectModel(
    val id: Int,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("stargazers_count") val starCount: Int,
    @SerializedName("created_at") val dateCreated: String,
    @SerializedName("owner") val ownerModel: OwnerModel
)
