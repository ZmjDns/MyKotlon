package com.zmj.mykotlon.utils

import android.content.Context
import android.content.SharedPreferences
import com.zmj.mykotlon.config.Constant
import kotlinx.android.synthetic.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/25
 * Description :SharedPreferences使用工具类
 */
class PreferencesManager<T>(private val name : String,private val default : T) : ReadWriteProperty<Any?,T> {

    companion object{
        lateinit var preferences : SharedPreferences

        fun setContext(context: Context){
            preferences = context.getSharedPreferences(context.packageName + Constant.SHARED_PER,Context.MODE_PRIVATE)
        }

        fun clear(){
            preferences.edit().clear().apply()
        }
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T = findPreference(name,default)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putPreference(name,value)


    private fun <U>findPreference(name: String,default: U) : U = with(preferences){
        val res: Any = when(default) {
            is Long -> getLong(name,default)
            is String -> getString(name,default)
            is Int -> getInt(name,default)
            is Boolean -> getBoolean(name,default)
            is Float -> getFloat(name,default)
            else -> throw IllegalArgumentException("This type can not be saved in to Preferences")
        }
        res as U
    }

    private fun <U>putPreference(name: String,value: U) = with(preferences.edit()){
        when(value){
            is Long -> putLong(name,value)
            is String -> putString(name,value)
            is Int -> putInt(name,value)
            is Boolean -> putBoolean(name,value)
            is Float -> putFloat(name,value)
            else -> throw java.lang.IllegalArgumentException("This type can not be saved in to Preferences")
        }.apply()
    }

}