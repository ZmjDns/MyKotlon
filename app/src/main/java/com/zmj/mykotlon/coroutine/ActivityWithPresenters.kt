package com.zmj.mykotlon.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/4
 * Description :
 * coroutineScope 构建起提供了一个嵌套Scope
 * 在presenter方法参数中接收CoroutineScope
 * 使方法在CoroutineScope上实现扩展
 */
class ActivityWithPresenters : BaseScopedActivity() {


    fun init(){
        val presenter = Presenter()
        val presenter2 = ScopePresenter(this)
    }
}

class Presenter{
    suspend fun loadData() = coroutineScope {
        //外部Activity的嵌套作用域

    }
    suspend fun loadData(uiScope:CoroutineScope) = uiScope.launch {
        //在ui作用域中调用

    }
}

class ScopePresenter(scope: CoroutineScope) : CoroutineScope by scope{
    fun loadData() = launch {
        //作为ActivityWithPresenter 的作用域的扩展

    }
}

//扩展？？？？？
suspend fun CoroutineScope.launchInIO() = launch (Dispatchers.IO){
    //在调用者的作用域中启动，但使用IO调度器

}