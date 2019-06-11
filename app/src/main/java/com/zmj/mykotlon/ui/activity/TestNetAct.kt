package com.zmj.mykotlon.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.zmj.mykotlon.R
import com.zmj.mykotlon.entry.LoginRep
import com.zmj.mykotlon.entry.SmsResponse
import com.zmj.mykotlon.entry.Template
import com.zmj.mykotlon.net.IResponse
import com.zmj.mykotlon.net.impl.ImplUtils
import kotlinx.android.synthetic.main.act_test_net.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/6
 * Description :
 */
class TestNetAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.act_test_net)

        initView()
    }

    fun initView(){
        getSms.setOnClickListener {
            ImplUtils.getSms("18302451883","4256",object : IResponse<SmsResponse>{
                override fun onSuccess(t: SmsResponse) {
                    Toast.makeText(this@TestNetAct,"${t.toString()}",Toast.LENGTH_SHORT).show()
                }

                override fun onFailed(throwable: Throwable) {
                    Toast.makeText(this@TestNetAct,"${throwable}",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}