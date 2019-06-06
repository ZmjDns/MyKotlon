package com.zmj.mykotlon.net

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :网络响应接口
 */
interface IResponse<T> {
    fun onSuccess(t : T)
    fun onFailed(throwable: Throwable)
}