package com.bitcode.webservices3

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

object MyReqQueue {

    private var requestQueue : RequestQueue? = null

    fun getRequestQueue(context: Context) : RequestQueue{

        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context)
        }

        return requestQueue!!
    }

}