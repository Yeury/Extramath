package com.example.kfont.themathchips;
//git is not letting me commit unless I change something - Jeff
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class MainMenu extends Activity {
    LayoutInflater inflater;
    List<String> ChildList;
    Map<String, List<String>> ParentListItems;
    ExpandableListView expandablelistView;

    // Assign Parent list items here.
    List<String> ParentList = new ArrayList<String>();
    { ParentList.add("ANDROID");
        ParentList.add("PHP");
        ParentList.add("BLOGGER");
        ParentList.add("PHOTOSHOP");
        ParentList.add("WORDPRESS");
        ParentList.add("SEO"); }

    // Assign children list element using string array.
    String[] AndroidName = { "ANDROID STUDIO","ANDROID EXAMPLES","ANDROID TUTORIALS" };
    String[] PhpName = { "XAMPP","PHPMYADMIN","MYSQL" };
    String[] BloggerName = { "BLOG NAME","SUB DOMAIN NAME","BLOGGER" };
    String[] PhotoshopName = { "COLOR TOOL","MOVE TOOL","CROP TOOL" };
    String[] WordPressName = { "LOGIN","ADD NEW POST","PLUGINS" };
    String[] SEOName = { "SEARCH","ENGINE","OPTIMIZATION" };
    String[] ByDefalutMessage = {"Items Loading"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inflater=getLayoutInflater();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParentListItems = new LinkedHashMap<String, List<String>>();

        for ( String HoldItem : ParentList) {
            if (HoldItem.equals("ANDROID")) {
                loadChild(AndroidName);
            } else if (HoldItem.equals("PHP"))
                loadChild(PhpName);
            else if (HoldItem.equals("BLOGGER"))
                loadChild(BloggerName);
            else if (HoldItem.equals("PHOTOSHOP"))
                loadChild(PhotoshopName);
            else if (HoldItem.equals("WORDPRESS"))
                loadChild(WordPressName);
            else if (HoldItem.equals("SEO"))
                loadChild(SEOName);
            else
                loadChild(ByDefalutMessage);

            ParentListItems.put(HoldItem, ChildList);
        }

        expandablelistView = (ExpandableListView) findViewById(R.id.expandableListView1);
        final ExpandableListAdapter expListAdapter = new ListAdapter(
                this, ParentList, ParentListItems);
        expandablelistView.setAdapter(expListAdapter);

        expandablelistView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();

                return true;
            }
        });
    }

    private void loadChild(String[] ParentElementsName) {
        ChildList = new ArrayList<String>();
        for (String model : ParentElementsName)
            ChildList.add(model);
    }

}