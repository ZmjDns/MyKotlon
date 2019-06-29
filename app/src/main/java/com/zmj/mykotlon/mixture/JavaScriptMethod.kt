package com.zmj.mykotlon.mixture

import android.content.Context
import android.webkit.JavascriptInterface
import com.zmj.mykotlon.utils.toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/24
 * Description :h5与kotlin通信的桥梁类
 */
class JavaScriptMethod {
    private var context : Context? = null

    constructor(context: Context){
        this.context = context
    }

    @JavascriptInterface  //Android4.2以后，如果不加注解 H5不能调用kotlin方法
    fun showToast(json:String){
        //context.toast(json)
        context.let { it!!.toast(json) }
    }
    @JavascriptInterface
    fun getHotelData(){

        println("酒店数据。。。。。。")


    }
}