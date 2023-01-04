package dev.harshdalwadi.network.models


import com.google.gson.annotations.SerializedName

data class UiData(
    @SerializedName("hint")
    var hint: String? = null, // Enter your name
    @SerializedName("key")
    var key: String? = null, // label_name
    @SerializedName("uitype")
    var uitype: String? = null, // label
    @SerializedName("value")
    var value: String? = null // Your Name
): java.io.Serializable