package com.zmj.mykotlon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zmj.mykotlon.entry.Group
import com.zmj.mykotlon.entry.Item
import com.zmj.mykotlon.ui.adpter.ExpandListAdapter
import com.zmj.mykotlon.ui.adpter.ExpandListAdapterJ
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var gData : ArrayList<Group>? = null
    private var iData : ArrayList<ArrayList<Item>>? = null
    private var lData : ArrayList<Item>? = null
    private var expandAdapter : ExpandListAdapterJ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
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
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}
