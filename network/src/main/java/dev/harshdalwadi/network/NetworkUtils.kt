package dev.harshdalwadi.network

import dev.harshdalwadi.network.api.ApiAdapter
import dev.harshdalwadi.network.interfaces.NetworkInterface
import org.json.JSONObject


/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 04-01-2023
 */
class NetworkUtils : NetworkInterface {
    private val TAG = NetworkUtils::class.java.simpleName

    override suspend fun fetchCustomUI(url: String): JSONObject {
        val result = ApiAdapter.apiClient.fetchData(url).string()
        return if (result.isNotEmpty()) {
            JSONObject(result)
        } else {
            JSONObject()
        }
    }

    override suspend fun fetchLogo(url: String): ByteArray {
        val result = ApiAdapter.apiClient.getImage(url)
        return result?.bytes() ?: ByteArray(0)
    }
}