package com.zmj.mykotlon

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import org.litepal.LitePalApplication
import org.litepal.tablemanager.Connector

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/14
 * Description :
 */
class MyApplication: LitePalApplication() {
    var sqlDB : SQLiteDatabase? = null
    override fun onCreate() {
        super.onCreate()

        sqlDB = Connector.getDatabase()
    }

}