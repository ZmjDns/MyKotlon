package com.zmj.mykotlon.net.impl

import com.zmj.mykotlon.entry.LoginRep
import com.zmj.mykotlon.entry.SmsResponse
import com.zmj.mykotlon.entry.Template
import com.zmj.mykotlon.net.IResponse
import com.zmj.mykotlon.net.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :
 */
object ImplUtils {
    //
    fun getSms(phone : String,sms : String,smsListener : IResponse<SmsResponse>){
        //val map : Map<String,String> = hashMapOf("phone" to phone, Pair("sms",sms))
        val call : Call<SmsResponse> = MyRetrofit.service.getSms(phone,sms)

        call.enqueue(object : Callback<SmsResponse>{
            override fun onResponse(call: Call<SmsResponse>, response: Response<SmsResponse>) {
                println(response.body())
                smsListener.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<SmsResponse>, t: Throwable) {
                println(t.message)
                smsListener.onFailed(t)
            }
        })
    }
}