package com.oswaldo.test_mvvm.data

import com.google.gson.annotations.SerializedName

class Restroom(
    @SerializedName("id") val id: Integer,
    @SerializedName("name") val name: String,
    @SerializedName("street") val street: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("unisex") val unisex: Boolean
)