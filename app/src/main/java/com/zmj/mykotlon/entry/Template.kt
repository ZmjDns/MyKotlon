package com.zmj.mykotlon.entry

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description : 信息模板
 */
class Template<T>(var code:Int,var state : String, var t : T) {

//    class Response(var phone : String, var checkcode : String){
//        override fun toString(): String {
//            return "($phone,$checkcode)"
//        }
//    }

    override fun toString(): String {
        return "(code:$code,state:$state,t：$t)"
    }
}