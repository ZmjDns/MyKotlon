package com.zmj.mykotlon

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.Toast
import com.zmj.mykotlon.coroutine.CoroutonePraticeAct
import com.zmj.mykotlon.entry.*
import com.zmj.mykotlon.initdata.WelcomeAct
import com.zmj.mykotlon.mixture.TestWebviewAct
import com.zmj.mykotlon.net.IResponse
import com.zmj.mykotlon.net.impl.ImplUtils
import com.zmj.mykotlon.ui.activity.BaseActivity
import com.zmj.mykotlon.ui.activity.SacnActivity
import com.zmj.mykotlon.ui.activity.TestNetAct
import com.zmj.mykotlon.ui.adpter.ExpandListAdapterJ
import com.zmj.mykotlon.utils.PreferencesManager
import com.zmj.mykotlon.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.litepal.LitePal
import org.litepal.crud.LitePalSupport

class MainActivity : BaseActivity() {

    private var gData : ArrayList<Group>? = null
    private var iData : ArrayList<ArrayList<Item>>? = null
    private var lData : ArrayList<Item>? = null
    private var expandAdapter : ExpandListAdapterJ? = null


    private var indexHashSign : String by PreferencesManager("indexHashSign","defaultHash")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        indexHashSign = "testInfo"

        toast(indexHashSign)

        initData()

        btn_nextPage.setOnClickListener { startActivity(Intent(this,SacnActivity::class.java)) }
        btn_mvp.setOnClickListener {
            startActivity(Intent(this,WelcomeAct::class.java))
        }
        btn_mixture.setOnClickListener {
            startActivity(Intent(this,TestWebviewAct::class.java))
        }
        btn_coRoutine.setOnClickListener {
            startActivity(Intent(this,CoroutonePraticeAct::class.java))
        }

        //getRidData()
        val rid = Rid("A","1.1.2","ACPI110250","testContent","hhahaahha","1.1","1","1","")
        toast(rid.toString())
        println("ridJson ： $rid")

        initMyTabLayout()
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    fun initData(){
        gData = ArrayList()
        gData!!.add(Group("AD","AD"))
        gData!!.add(Group("AP","AP"))
        gData!!.add(Group("TANK","TANK"))

        iData = ArrayList()

        //AD组
        lData = ArrayList()
        lData!!.add(Item("剑圣"))
        lData!!.add(Item("德莱文"))
        lData!!.add(Item("男枪"))
        lData!!.add(Item("韦鲁斯"))
        iData!!.add(lData!!)

        //AP组
        lData = ArrayList()
        lData!!.add(Item("提莫"))
        lData!!.add(Item("安妮"))
        lData!!.add(Item("天使"))
        lData!!.add(Item("泽拉斯"))
        lData!!.add(Item("狐狸"))
        iData!!.add(lData!!)

        //TANK组
        lData = ArrayList()
        lData!!.add(Item("诺手"))
        lData!!.add(Item("德邦"))
        lData!!.add(Item("奥拉夫"))
        lData!!.add(Item("龙女"))
        lData!!.add(Item("狗熊"))
        iData!!.add(lData!!)


        //expandAdapter = ExpandListAdapter(this,gData!!,iData!!)

        //el_expand.setAdapter(expandAdapter!!)

        expandAdapter = ExpandListAdapterJ(this,gData!!,iData!!)

        el_expand.setAdapter(expandAdapter)

        getNet.setOnClickListener {
            getNetInfo()
        }
    }

    fun getNetInfo(){
        try {
            GlobalScope.launch {
                ImplUtils.getSms("18302451883","4256",object : IResponse<SmsResponse> {
                    override fun onSuccess(t: SmsResponse) {
                        Toast.makeText(this@MainActivity,"${t.toString()}", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailed(throwable: Throwable) {
                        Toast.makeText(this@MainActivity,"${throwable}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }catch (e : Exception){
            e.printStackTrace()
        }

    }



    fun getRidData(){
        GlobalScope.launch {
            ImplUtils.getBaseRid(object : IResponse<ArrayList<Rid>>{
                override fun onSuccess(t: ArrayList<Rid>) {
                    t.size
                    //LitePal.delete(Rid::class.java,11)
                    LitePal.saveAll(t)
//                    for (index in 0..10){
//                        var rid = t.get(index)
//
//                        val newRid = Rid(rid.type,rid.rid,rid.auditCode,rid.content,rid.auditReminds,rid.superRid,rid.isAuditPoint,rid.isMust,rid.values)
//                        try {
//                            newRid.saveThrows()
//                        }catch (e : Exception){
//                            e.printStackTrace()
//                        }
//                    }
//                    for ( rid in t){
//                        val newRid = Rid(rid.type,rid.rid,rid.auditCode,rid.content,rid.auditReminds,rid.superRid,rid.isAuditPoint,rid.isMust,rid.values)
//                        newRid.save()
//                    }
                }

                override fun onFailed(throwable: Throwable) {
                    throwable.message
                }
            })
        }
    }

    fun initMyTabLayout(){
        tl_tab.addTab(tl_tab.newTab().setText("审计要素1：职责程序"),true)
        tl_tab.addTab(tl_tab.newTab().setText("审计要素2：职责程序"),false)
        tl_tab.addTab(tl_tab.newTab().setText("审计要素3：职责程序"),false)
        tl_tab.addTab(tl_tab.newTab().setText("审计要素4：职责程序"),false)
        tl_tab.addTab(tl_tab.newTab().setText("审计要素5：职责程序"),false)
        tl_tab.addTab(tl_tab.newTab().setText("审计要素6：职责程序"),false)

        tl_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
                //再次选中
                Toast.makeText(this@MainActivity,"我被再次选中了${p0!!.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                //未选中
                Toast.makeText(this@MainActivity,"我没被选中${p0!!.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                //选中
                Toast.makeText(this@MainActivity,"我被选中了${p0!!.text}",Toast.LENGTH_SHORT).show()
            }

        })


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
