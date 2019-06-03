package com.zmj.mykotlon.ui.adpter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.zmj.mykotlon.R;
import com.zmj.mykotlon.entry.Group;
import com.zmj.mykotlon.entry.Item;

import java.util.ArrayList;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/6/3
 * Description :
 */
public class ExpandListAdapterJ extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData;

    public ExpandListAdapterJ(Context context, ArrayList<Group> gData, ArrayList<ArrayList<Item>> iData) {
        this.context = context;
        this.gData = gData;
        this.iData = iData;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup group = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_group_item,parent,false);
            group = new ViewHolderGroup(convertView);
            convertView.setTag(group);
        }else {
            group = (ViewHolderGroup) convertView.getTag();
        }
        Group groupData = gData.get(groupPosition);
        group.tv_type.setText(groupData.getType());
        group.tv_name.setText(groupData.getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.expand_child_item,parent,false);
            itemHolder = new ViewHolderItem(convertView);
            convertView.setTag(itemHolder);
        }else {
            itemHolder = (ViewHolderItem) convertView.getTag();
        }

        Item item = iData.get(groupPosition).get(childPosition);
        itemHolder.tv_name.setText(item.getName());

        return convertView;
    }

    //设置子View可以选中    否则报错
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ViewHolderGroup{
        TextView tv_type ,tv_name;

        public ViewHolderGroup(View convertView) {
            tv_type = convertView.findViewById(R.id.tv_type);
            tv_name = convertView.findViewById(R.id.tv_typeName);
        }
    }

    static class ViewHolderItem{
        TextView tv_name;

        public ViewHolderItem(View convertView) {
            tv_name = convertView.findViewById(R.id.tv_name);
        }
    }
}
