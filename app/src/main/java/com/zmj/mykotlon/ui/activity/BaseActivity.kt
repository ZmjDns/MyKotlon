package com.zmj.mykotlon.ui.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :
 */
abstract class BaseActivity : AppCompatActivity() {

    private val imm :InputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(setLayoutId())

    }
    protected abstract fun setLayoutId() : Int


    override fun finish(){
        if (!isFinishing){
            super.finish()
            hideSoftKeyBord()
        }
    }


    private fun hideSoftKeyBord(){
        currentFocus?.let {
            imm.hideSoftInputFromWindow(it.windowToken,2)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}