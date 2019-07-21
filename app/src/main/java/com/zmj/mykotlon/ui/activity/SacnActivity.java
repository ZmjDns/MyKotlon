package com.zmj.mykotlon.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zmj.mykotlon.R;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/13
 * Description :
 */
public class SacnActivity extends BaseActivity {

    String ROMATEURL = "http://47.94.142.99:9090/MainServer/services/IMain?wsdl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.scan_activity);


    }

    @Override
    protected int setLayoutId() {
        return R.layout.scan_activity;
    }

    private void requestNet(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
