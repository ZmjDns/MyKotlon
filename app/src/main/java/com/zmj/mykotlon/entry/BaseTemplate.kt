package com.zmj.mykotlon.entry

import android.os.Build

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :  基础信息模板
 */
open class BaseTemplate(var code : Int,var state : String) {
    override fun toString(): String {
        return "($code,$state)"
    }
}