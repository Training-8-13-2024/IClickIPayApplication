package com.iclickipay.data.model.learn


import com.google.gson.annotations.SerializedName

data class TeacherDataItemItemModel(
    @SerializedName("address")
    val address: AddressModel? = AddressModel(),
    @SerializedName("age")
    val age: Int? = 0,
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("subjects")
    val subjects: List<String?>? = listOf(),
    @SerializedName("years_of_experience")
    val yearsOfExperience: Int? = 0
)