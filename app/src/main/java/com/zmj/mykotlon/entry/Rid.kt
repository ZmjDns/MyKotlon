package com.zmj.mykotlon.entry

import com.google.gson.Gson
import org.litepal.LitePal
import org.litepal.crud.LitePalSupport

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/14
 * Description :
 */
class Rid(var type:String,
          var rid:String,
          var auditCode : String?,
          var content : String?,
          var auditReminds : String?,
          var superRid:String,
          var isAuditPoint:String,
          var isMust:String?,
          var values : String?) : LitePalSupport() {

    override fun toString(): String {
//        return "(type:$type,rid:$rid,auditCode:$auditCode,content:$content,auditReminds:$auditReminds," +
//                "superRid:$superRid,isAuditPoint:$isAuditPoint,isMust:$isMust,values:$values)"

        return Gson().toJson(this)
    }
}