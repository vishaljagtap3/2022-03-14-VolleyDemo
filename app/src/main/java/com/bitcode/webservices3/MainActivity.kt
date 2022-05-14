package com.bitcode.webservices3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bitcode.webservices3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //requestQueue = Volley.newRequestQueue(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStringRequest.setOnClickListener {
            var stringRequest = StringRequest(
                Request.Method.GET,
                "https://reqres.in/api/users?page=2",
                MyStringReqSuccessListener(),
                MyErrorListener()
            )

            //requestQueue.add(stringRequest)
            MyReqQueue.getRequestQueue(this)
                .add(stringRequest)
        }

        binding.btnJsonObjectRequest.setOnClickListener {

            var jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                "https://reqres.in/api/users?page=2",
                null,
                {
                    Log.e("tagj", it.toString())
                },
                {

                }

            )
            //requestQueue.add(jsonObjectRequest)
            MyReqQueue.getRequestQueue(this)
                .add(jsonObjectRequest)

        }

        binding.btnJsonArrayRequest.setOnClickListener {

            var jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                "https://reqres.in/api/users?page=2",
                null,
                {
                    Log.e("tagj", it.toString())
                },
                {

                }
            )
            //requestQueue.add(jsonArrayRequest)
            MyReqQueue.getRequestQueue(this)
                .add(jsonArrayRequest)

        }

        /*binding.btnStringRequest.setOnClickListener {
            var stringRequest = StringRequest(
                Request.Method.GET,
                "https://reqres.in/api/users?page=2",
                {

                },
                {

                }
            )
        }*/
    }

    private inner class MyStringReqSuccessListener : Listener<String> {
        override fun onResponse(response: String?) {
            Log.e("tag", response.toString())
        }

    }

    private inner class MyErrorListener : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            Log.e("tag","Error: ${error?.message}")
        }
    }
}