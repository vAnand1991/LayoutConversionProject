package com.naxtre.layoutconversionproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.naxtre.layoutconversionproject.Constants.Companion.url
import kotlinx.android.synthetic.main.oakremote_hotspot_fragment_layout.*
import org.json.JSONObject

class ServiceHittingActivity: AppCompatActivity(), ServiceResponseListener {
    lateinit var serviceHitterVolley: ServiceHitterVolley
    private val TAG: String = "ServiceHittinActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.oakremote_hotspot_fragment_layout)

        ServiceHitterVolley(this,this).hitService()

    }

    override fun Success(json: JSONObject) {
        Log.e(TAG, json.toString())
    }

    override fun Failure(json: JSONObject) {
        Log.e(TAG, json.toString())
    }

    override fun onDestroy() {
        Log.e(TAG, "Destroy")
        super.onDestroy()
    }
}