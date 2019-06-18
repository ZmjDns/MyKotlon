package com.zmj.mykotlon.initdata

import android.widget.Toast
import com.zmj.mykotlon.entry.LawItem
import com.zmj.mykotlon.entry.Rid
import com.zmj.mykotlon.net.IResponse
import okhttp3.internal.Util

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/17
 * Description :
 */
class WelcomePresenter(var welcomeView: IBaseData.WelcomeView) : IBaseData.IWelcomePresenter {

    private val model : Model = Model()

    override fun fetchRidData() {
        welcomeView.showLoading()
        model.getRid(object : IResponse<ArrayList<Rid>>{
            override fun onSuccess(t: ArrayList<Rid>) {
                welcomeView.onGetRid(t)
                welcomeView.hideLoading()
            }

            override fun onFailed(throwable: Throwable) {
                welcomeView.onError("获取ridData失败：" + throwable)
                welcomeView.hideLoading()
            }
        })
    }

    override fun fetchLawData() {
        model.getLaw(object : IResponse<ArrayList<LawItem>>{
            override fun onSuccess(t: ArrayList<LawItem>) {
                welcomeView.onGetLaw(t)

                welcomeView.hideLoading()
            }

            override fun onFailed(throwable: Throwable) {
                welcomeView.onError("获取lawData失败:" + throwable)
                welcomeView.hideLoading()
            }
        })
    }
}