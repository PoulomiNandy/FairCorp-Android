package com.poulomi.faircorpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_services.*
import org.json.JSONException

class MyServices : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_services)



        btn_id_windows.setOnClickListener{
            var url:String="https://app-2486da62-82f9-4a1f-b5c1-1cb4c65491c5.cleverapps.io/api/windows/"+editText2.text.toString() //dynamic id input
            var rq: RequestQueue= Volley.newRequestQueue(this)
            val jor = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {response ->
                textView13.text=response.getString("id")
                textView9.text=response.getString("name")
                textView10.text=response.getString("windowStatus")
                textView11.text=response.getString("roomName")
                textView12.text=response.getString("roomId")
            }
            , Response.ErrorListener { error ->
                    error.printStackTrace()   // error handling
                })
            rq.add(jor)
        }

    }
}


