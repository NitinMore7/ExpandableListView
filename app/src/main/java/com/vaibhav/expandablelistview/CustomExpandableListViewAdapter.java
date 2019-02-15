package com.vaibhav.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listtitles;
    private List<String> listChildIntents;

    public CustomExpandableListViewAdapter(Context context, List<String> listtitles,List<String> listChildIntents) {
        this.context = context;
        this.listtitles = listtitles;
        this.listChildIntents=listChildIntents;
    }


    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        final String intentstring = (String) getChild(i,i1);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_contents,null);

        }

        TextView intentText=view.findViewById(R.id.intent_list_text);
        Button button=view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),intentstring + " was clicked",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)getGroup(i);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_list_item,null);
        }
        TextView listTitleView=view.findViewById(R.id.list_text);
        listTitleView.setText(title);
        return view;
    }

    @Override
    public int getGroupCount() {
        return this.listtitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return this.listtitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listChildIntents.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
