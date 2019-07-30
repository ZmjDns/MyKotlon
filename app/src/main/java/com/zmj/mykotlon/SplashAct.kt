package com.zmj.mykotlon

import android.os.Bundle
import com.zmj.mykotlon.ui.activity.BaseActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/20
 * Description :
 */
class SplashAct:BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.splash_act
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //check Data Version


    }


}