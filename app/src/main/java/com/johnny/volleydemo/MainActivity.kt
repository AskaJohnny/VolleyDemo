package com.johnny.volleydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.showTitle)
        val shortDescTextView = findViewById<TextView>(R.id.showShortDesc)

        //val url = "https://weather.api.bdymkt.com/day?city=无锡"
        //
        val requestQueue = Volley.newRequestQueue(this)
        val url =
            "https://www.askajohnny.com/blogs/blogInfo/303/15"
        //1.StringRequest 案例
//        val stringRequest = StringRequest(Request.Method.GET,
//            url, {
//                val data = String(
//                    it.toByteArray(Charsets.ISO_8859_1),
//                    Charsets.UTF_8
//                )
//                Log.d(TAG, "onCreate: stringRequest  ${data}")
//                val blogInfo = Gson().fromJson(data, BlogInfo::class.java)
//                titleTextView.text = blogInfo.data.blogTitle
//                shortDescTextView.text = blogInfo.data.blogShortContent
//            }, {
//                Log.d(TAG, "onCreate: stringRequest error ${it.message}")
//            })

//        val stringRequest = object : StringRequest(Request.Method.GET,
//            url, {
////                val data = String(
////                    it.toByteArray(Charsets.ISO_8859_1),
////                    Charsets.UTF_8
////                )
//                val data = it
//                Log.d(TAG, "onCreate: stringRequest  ${data}")
//                val blogInfo = Gson().fromJson(data, BlogInfo::class.java)
//                titleTextView.text = blogInfo.data.blogTitle
//                shortDescTextView.text = blogInfo.data.blogShortContent
//            }, {
//                Log.d(TAG, "onCreate: stringRequest error ${it.message}")
//            }) {
//            override fun getHeaders(): MutableMap<String, String> {
//                //返回 map map里面添加 需要放入Header的数据
//                val headers = mutableMapOf<String,String>()
//                headers["Content-Type"] = "application/json; charset=UTF-8";
//                return headers
//            }
//
//            override fun getParams(): MutableMap<String, String>? {
//                //返回 map map里面添加 需要添加的 query params
//                return super.getParams()
//            }
//        }
        //requestQueue.add(stringRequest)

        //2.JsonObjectRequest 案例  第二个参数不传 表示 Get请求 第二个参数传递 表示POST请求
        val postRequest = object : JsonObjectRequest(url, null,
            {
                Log.d(TAG, "volleyInitData: request success $it")
                titleTextView.text = it.getJSONObject("data").get("blogTitle") as String?
                shortDescTextView.text = it.getJSONObject("data").get("blogShortContent") as String
            }, {
                Log.d(TAG, "volleyInitData: request error ${it.message}")
            }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = mutableMapOf<String, String>()
                headers["Accept"] = "application/json"
                headers["Content-Type"] = "application/json; charset=UTF-8"
                return headers
            }
        }

        requestQueue.add(postRequest)

    }
}