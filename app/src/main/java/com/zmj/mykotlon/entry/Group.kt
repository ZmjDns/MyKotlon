package com.zmj.mykotlon.entry

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/3
 * Description :
 */
class Group(var type : String,var name : String) {
    override fun toString(): String {
        return "($type,$name)"
    }
}