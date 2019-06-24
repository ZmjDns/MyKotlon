package com.zmj.mykotlon.mixture

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.zmj.mykotlon.R
import com.zmj.mykotlon.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.act_test_webview.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/23
 * Description :
 */
class TestWebviewAct : BaseActivity() {

    private val webView : WebView by lazy {
        wv_web
    }

    override fun setLayoutId(): Int {
        return R.layout.act_test_webview
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setWebView()
    }
    //lambad表达式
    //var add = {a: Int,b:Int -> a + b}

    var setWebView = {
        //1.开启kotlin与H5通信的开关
        webView.settings.javaScriptEnabled = true
        //2.设置两个WebViewClient
        webView.webViewClient = MyWebvieClient()
        webView.webChromeClient = MyWebChromeClient()

        //kotlin与H5的通信方式1：H5调用kotlin
        //设置h5与kotlin通信的桥梁类
        //webView.addJavascriptInterface(对象，字符串) ： 对象.方法名,  字符串就是参数1对象的别名
        webView.addJavascriptInterface(JavaScriptMethod(this),"jsInterface")


        //3.加载网页
        webView.loadUrl("https://baidu.com")
    }

    private class MyWebvieClient : WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            //调用H5方法

        }
    }

    private class MyWebChromeClient : WebChromeClient(){

        //加载进度条  （微信顶部的界面打开进度条）
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
    }
}