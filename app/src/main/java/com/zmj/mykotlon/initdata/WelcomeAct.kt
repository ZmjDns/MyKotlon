package com.zmj.mykotlon.initdata

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.zmj.mykotlon.R
import com.zmj.mykotlon.entry.LawItem
import com.zmj.mykotlon.entry.Rid
import com.zmj.mykotlon.net.IResponse
import com.zmj.mykotlon.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.act_welcome_act.*
import org.litepal.LitePal

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/17
 * Description :
 */
class WelcomeAct : BaseActivity(),IBaseData.WelcomeView{

    //presenter的懒加载方式？？？
    private val welcomePresenter : WelcomePresenter by lazy {
        WelcomePresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.act_welcome_act)

        //welcomePresenter = WelcomePresenter(this)

        //welcomePresenter.fetchRidData()

        welcomePresenter.fetchLawData()

    }

    override fun setLayoutId(): Int {
        return R.layout.act_welcome_act
    }

    override fun showLoading() {
        pb_loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loadingBar.visibility = View.GONE
    }

    override fun onGetRid(ridData: ArrayList<Rid>) {
        ridData.size
        LitePal.saveAll(ridData)
        Toast.makeText(this,"获取指标数据成功" + ridData.size ,Toast.LENGTH_SHORT).show()
    }

    override fun onGetLaw(lawData: ArrayList<LawItem>) {
        lawData.size
        LitePal.saveAll(lawData)
        Toast.makeText(this,"获取lawFIle数据成功" + lawData.size ,Toast.LENGTH_SHORT).show()
    }

    override fun onError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        println("WelcomeAct : " + msg)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}