package com.zmj.mykotlon.entry

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :
 */
class LoginRep(var phone : String, var checkcode : String) {
    override fun toString(): String {
        return "($phone,$checkcode)"
    }
}