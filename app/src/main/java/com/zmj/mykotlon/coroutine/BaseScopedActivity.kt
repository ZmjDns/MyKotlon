package com.zmj.mykotlon.coroutine

import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/3
 * Description :Activity实现协程基础类
 */
abstract class BaseScopedActivity : AppCompatActivity(),CoroutineScope by MainScope() {

    override fun onDestroy() {
        super.onDestroy()
        cancel()        //销毁Activity对象时取消协程
    }
}