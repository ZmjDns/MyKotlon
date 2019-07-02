package com.zmj.mykotlon.mixture

import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.zmj.mykotlon.utils.toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/24
 * Description :h5与kotlin通信的桥梁类
 */
class JavaScriptMethod {
    private var context : Context? = null
    private var webView : WebView? = null

    constructor(context: Context?,webView: WebView?){
        this.context = context
        this.webView = webView
    }

    @JavascriptInterface  //Android4.2以后，如果不加注解 H5不能调用kotlin方法
    fun showToast(json:String){
        //context.toast(json)
        context.let { it!!.toast(json) }
    }
    @JavascriptInterface
    fun getHotelData(){

        GlobalScope.launch {
            async {
                val url : URL = URL("http://10.0.2.2:8080/tsdb/testH5/hotel.json")

                val result : String = url.readText()

                println("酒店数据：$result")

                context.let {
//                    it.runOnUiThread{
//                        webView?.loadUrl("jsvascript:receiveHotelData($result)")
//                    }
                }
            }
        }


    }
}