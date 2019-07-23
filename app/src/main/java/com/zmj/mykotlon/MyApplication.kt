package com.zmj.mykotlon

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.zmj.mykotlon.utils.PreferencesManager
import com.zmj.mykotlon.utils.loge
import org.litepal.LitePal
import org.litepal.LitePalApplication
import org.litepal.tablemanager.Connector
import org.litepal.tablemanager.callback.DatabaseListener

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/14
 * Description :
 */
class MyApplication: Application()/*CasePackageApp()*/ {
    var sqlDB : SQLiteDatabase? = null
    override fun onCreate() {
        super.onCreate()

        //设置全局SharedPreference
        PreferencesManager.setContext(applicationContext)

        LitePal.registerDatabaseListener(object : DatabaseListener{
            override fun onCreate() {
                loge("MyApplication", "execute OnCreate()")
            }

            override fun onUpgrade(oldVersion: Int, newVersion: Int) {
                loge("MyApplication", "oldVersion:$oldVersion,newVersion:$newVersion")
                //LitePal.deleteAll(LawItem::class.java)
            }
        })

        //sqlDB = Connector.getDatabase()
    }

}