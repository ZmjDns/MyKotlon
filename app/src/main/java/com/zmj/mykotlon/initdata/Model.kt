package com.zmj.mykotlon.initdata

import android.provider.Contacts
import com.zmj.mykotlon.entry.LawItem
import com.zmj.mykotlon.entry.Rid
import com.zmj.mykotlon.net.IResponse
import com.zmj.mykotlon.net.MyRetrofit
import com.zmj.mykotlon.tryCatch
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/17
 * Description : 获取基础数据Model
 */
class Model : IBaseData.IModel{
    override fun getRid(listener: IResponse<ArrayList<Rid>>) {
        try{
            GlobalScope.launch {
                val call : Call<ArrayList<Rid>> = MyRetrofit.service.getRid()

                call.enqueue(object : Callback<ArrayList<Rid>>{
                    override fun onResponse(call: Call<ArrayList<Rid>>, response: Response<ArrayList<Rid>>) {
                        listener.onSuccess(response.body() as ArrayList<Rid>)
                    }

                    override fun onFailure(call: Call<ArrayList<Rid>>, t: Throwable) {
                        listener.onFailed(t)
                    }
                })
            }
        }catch (e : Exception){
            e.printStackTrace()
        }

//        GlobalScope.launch {
//            async{
//                tryCatch({
//                    it.printStackTrace()
//                    listener.onFailed(it)
//                }){
//                    val ridAsync :Deferred<ArrayList<Rid>> = MyRetrofit.service.getMethodRid()
//                    val result =ridAsync.await()
//                    listener.onSuccess(result)
//                }
//            }
//        }
    }

    override fun getLaw(listener: IResponse<ArrayList<LawItem>>) {
        try {
            GlobalScope.launch {
                getLawItemsByNet(listener)
            }
        }catch (e : Exception){
            e.printStackTrace()
        }
    }


    suspend private fun getLawItemsByNet(listener: IResponse<ArrayList<LawItem>>){
        val call : Call<ArrayList<LawItem>> = MyRetrofit.service.getLawItems()

        call.enqueue(object : Callback<ArrayList<LawItem>>{
            override fun onResponse(call: Call<ArrayList<LawItem>>, response: Response<ArrayList<LawItem>>) {
                listener.onSuccess(response.body() as ArrayList<LawItem>)
            }

            override fun onFailure(call: Call<ArrayList<LawItem>>, t: Throwable) {
                listener.onFailed(t)
            }
        })

    }
}