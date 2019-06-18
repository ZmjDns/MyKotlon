package com.zmj.mykotlon.ui.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.zmj.mykotlon.R
import com.zmj.mykotlon.entry.Group
import com.zmj.mykotlon.entry.Item

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/3
 * Description :
 */
class ExpandListAdapter(context: Context,gData : ArrayList<Group>,iData : ArrayList<ArrayList<Item>>) : BaseExpandableListAdapter() {

    private var context = context
    private var gData = gData
    private var iData = iData

    override fun getGroupCount(): Int {
        return gData.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return iData.get(groupPosition).size
    }

    override fun getGroup(groupPosition: Int): Any {
        return gData.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return iData.get(groupPosition).get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var groupView = LayoutInflater.from(context).inflate(R.layout.expand_group_item,parent,false)
        var group : Group = gData.get(groupPosition)
        groupView.findViewById<TextView>(R.id.tv_type).text = group.type
        groupView.findViewById<TextView>(R.id.tv_name).text = group.name


        return groupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var childView : View = LayoutInflater.from(context).inflate(R.layout.expand_child_item,parent,false)
        childView.findViewById<TextView>(R.id.tv_name).text = iData.get(groupPosition).get(childPosition).name

        return childView
    }

    //设置子View是否可选中 非常重要，否则点击子View会报错
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}