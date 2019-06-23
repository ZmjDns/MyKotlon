package com.zmj.mykotlon.mixture

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.zmj.mykotlon.R
import com.zmj.mykotlon.ui.activity.BaseActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/23
 * Description :
 */
class TestWebviewAct : BaseActivity() {

    private val wv_web : WebView by lazy {
        wv_web
    }

    override fun setLayoutId(): Int {
        return R.layout.act_test_webview
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1.开启kotlin与H5通信的开关
        wv_web.settings.javaScriptEnabled = true
        //设置两个WebViewClient
        wv_web.webViewClient = MyWebvieClient()
        wv_web.webChromeClient = MyWebChromeClient()

        wv_web.loadUrl("https://baidu.com")
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