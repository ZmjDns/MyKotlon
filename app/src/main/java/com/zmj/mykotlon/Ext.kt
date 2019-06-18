package com.zmj.mykotlon

import android.content.Context
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import com.zmj.mykotlon.config.Constant

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/18
 * Description : 类似与工具类，可以直接拿来用的
 */

/**
 * 打印日志
 */
fun loge(tag : String,content : String?){
    Log.e(tag,content)
}

/**
 * 牛逼的Toast？？？？
 */
fun Context.toast(content: String?){
    Constant.showToast?.apply {
        setText(content)
        show()
    } ?:run {
        Toast.makeText(this.applicationContext,content,Toast.LENGTH_SHORT).apply {
            Constant.showToast = this
        }.show()
    }
}
fun Context.toast(@StringRes id : Int){
    toast(getString(id))
}

inline fun tryCatch(catchBlock : (Throwable) -> Unit = {}, tryBlock : () -> Unit){
    try {
        tryBlock()
    } catch (t : Throwable) {
        catchBlock(t)
    }
}


