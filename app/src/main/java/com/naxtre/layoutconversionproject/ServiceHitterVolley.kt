package com.naxtre.layoutconversionproject

import android.content.Context
import android.os.Handler
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class ServiceHitterVolley constructor(context: Context, private var listener: ServiceResponseListener?) {
    private lateinit var serviceHitterVolley: ServiceHitterVolley
    public var volleySingletonRequestQueueAndImageLoader : VolleySingletonRequestQueueAndImageLoader

    init {
        volleySingletonRequestQueueAndImageLoader = VolleySingletonRequestQueueAndImageLoader.getInstance(context)
    }

    public fun hitService(){
        val jsonArrayRequest = JsonObjectRequest(
            Request.Method.GET, Constants.url, null,
            Response.Listener { response ->
                println(response)
                Handler().postDelayed({
                    listener!!.Success(response)
                },4000)
            },
            Response.ErrorListener { error ->
                println(error)
            }
        )
        volleySingletonRequestQueueAndImageLoader.addToRequestQueue(jsonArrayRequest)
    }
}