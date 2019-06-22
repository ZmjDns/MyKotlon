package com.zmj.mykotlon.testkt

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/15
 * Description :小母驴、小公驴、小公马的后代
 */
/**
 * sealed class 印章类  子类类型有限的class
 * 类似于枚举  更在意的是数据
 * sealed class 更在意类型
 */
sealed class Son {
    fun sayHello(){
        println("Hello")
    }
    class xaioXiaoLV()
    class xiaoLuoZi()


    /**
     * 印章类不能直接被实例，只能实例其中包含的类
     */
    var son = Son.xaioXiaoLV()
}