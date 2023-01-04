package dev.harshdalwadi.network.api

import dev.harshdalwadi.network.BuildConfig
import okhttp3.HttpUrl

object URLFactory {

    private var SCHEME = "https"
    private lateinit var HOST: String
    private lateinit var API_PATH: String
    const val URL_TESTING = "demo.ezetap.com"
    const val URL_PROD = "demo.ezetap.com"

    fun provideHttpUrl(): HttpUrl {
        val httpUrl = HttpUrl.Builder()
        when (BuildConfig.BUILD_TYPE) {
            "release" -> {
                SCHEME = "https"
                HOST = URL_PROD
                API_PATH = "mobileapps/"
            }
            else -> {
                SCHEME = "https"
                HOST = URL_TESTING
                API_PATH = "mobileapps/"
            }
        }
        return httpUrl
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(API_PATH)
            .build()
    }

    /*------------------------- **************** ------------------------------------*/

    const val EP_FETCH_DATA = "android_assignment.json"

    /*------------------------- **************** ------------------------------------*/
}

