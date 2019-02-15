package com.vaibhav.expandablelistview;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> intenttexts;
    private List<String> listtitles;
    private int lastExpandedPos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.expandableListView);
        listtitles=getExpandableListTitles();
        intenttexts=getExpandableListitemIntentTexts();
        expandableListAdapter=new CustomExpandableListViewAdapter(this,listtitles,intenttexts);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPos!=-1 && i!=lastExpandedPos){
                    expandableListView.collapseGroup(lastExpandedPos);
                }
                lastExpandedPos=i;
            }
        });

    }

    private List<String> getExpandableListTitles(){
        List<String> list=new ArrayList<>();
        list.add("1st Expandable List Item");
        list.add("2nd Expandable List Item");
        list.add("3rd Expandable List Item");
        return list;
    }
    private List<String> getExpandableListitemIntentTexts(){
        List<String> list=new ArrayList<>();
        list.add("1st item's child's intent");
        list.add("2nd item's child's intent");
        list.add("3rd item's child's intent");
        return list;
    }
}
