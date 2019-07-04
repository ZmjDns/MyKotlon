package com.zmj.mykotlon.coroutine

import kotlinx.coroutines.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/3
 * Description :
 */
class TestBaseScopedAct : BaseScopedActivity() {

    fun asyncShowData() = launch {//Activiy的Job作为父结构时，这里将在UI上下文被调用
        //实际实现


        showIOData()
    }

    suspend fun showIOData(){
        val deferred  = async(Dispatchers.IO){
            //实现（请求网络、耗时操作）

        }
        withContext(Dispatchers.Main){
            val data = deferred.await()
            //在Ui中展示数据
        }
    }
}