package com.example.question1

import android.graphics.pdf.PdfDocument.Page
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseModel(
//    @SerializedName("page")
//    @Expose
//    val page: Int? = null,
//
//    @SerializedName("id")
//    @Expose
//    val id: Int? = null,
//
//    @SerializedName("email")
//    @Expose
//    val email: String? = null,
//
//    @SerializedName("first_name")
//    @Expose
//    val first_name: String? = null,
//
//    @SerializedName("last_name")
//    @Expose
//    val last_name: String? = null,
//
//    @SerializedName("avatar")
//    @Expose
//    val avatar: String? = null
    val page: Int,
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
