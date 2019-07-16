package com.zmj.mykotlon.net

import com.zmj.mykotlon.entry.*
import kotlinx.coroutines.Deferred
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :
 */
interface ApiService {

    //@GET("/gov/saic/web/controller/PrimaryInfoIndexAppController/search?")
    @POST("?action=smscode")
    @FormUrlEncoded
    fun getSms(@Field("phone") phone : String,@Field("checkCode") code : String) : Call<SmsResponse>

    @POST("?action=ridData")
    fun getRid() : Call<ArrayList<Rid>>

    @POST("?action=lawItem")
    fun getLawItems() : Call<ArrayList<LawItem>>

    @GET("?action=ridData")
    fun getMethodRid() : Deferred<ArrayList<Rid>>
    /**
     * 封装上传多个字段
     */
    @POST("?action=XXXX")
    @FormUrlEncoded
    suspend fun uploadInfo(@FieldMap data: MutableMap<String,String>)
    /**
     * 上传文字+图片
     */
    @POST("?actiion=XXXX")
    @FormUrlEncoded
    suspend fun uploadFile(@PartMap fileData: MutableMap<String,RequestBody>)
}