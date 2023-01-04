package dev.harshdalwadi.network.interfaces

import org.json.JSONObject


/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 04-01-2023
 */
interface NetworkInterface {
    suspend fun fetchCustomUI(url: String): JSONObject

    suspend fun fetchLogo(url: String): ByteArray
}