package com.naxtre.layoutconversionproject

import org.json.JSONObject

interface ServiceResponseListener {
    fun Success(json: JSONObject)

    fun Failure(json: JSONObject)
}