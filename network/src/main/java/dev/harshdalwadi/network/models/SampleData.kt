package dev.harshdalwadi.network.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SampleData(
    @SerializedName("heading-text")
    var headingText: String? = null, // Ezetap Android Assignment
    @SerializedName("logo-url")
    var logoUrl: String? = null, // https://demo.ezetap.com/portal/images/logo.gif
    @SerializedName("uidata")
    var uidata: List<UiData?>? = null
) : Serializable