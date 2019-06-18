package com.zmj.mykotlon.initdata

import com.zmj.mykotlon.entry.LawItem
import com.zmj.mykotlon.entry.Rid
import com.zmj.mykotlon.net.IResponse

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/17
 * Description :
 */
interface IBaseData {
    interface WelcomeView {
        fun showLoading()
        fun hideLoading()

        fun onGetRid(ridData : ArrayList<Rid>)
        fun onGetLaw(lawData : ArrayList<LawItem>)

        fun onError(msg : String)
    }

    interface IModel {
        fun getRid(listener : IResponse<ArrayList<Rid>>)
        fun getLaw(listener : IResponse<ArrayList<LawItem>>)
    }
    interface IWelcomePresenter{
        fun fetchRidData()
        fun fetchLawData()
    }
}