package com.android.beginner.dump.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.beginner.dump.R;
import com.android.beginner.dump.adapter.DumpAdapter;
import com.android.beginner.dump.model.DumpData;
import com.android.beginner.dump.model.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DumpAdapter.ItemClickCallback{

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView recyclerView;
    private DumpAdapter adapter;

    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = (ArrayList) DumpData.getListData();

        recyclerView = (RecyclerView)findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DumpAdapter(DumpData.getListData(), this);

        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }

    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());
        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {
        ListItem item = (ListItem) listData.get(p);
        //perbaharui data

        if (item.isFavourite()){
            item.setFavourite(false);
        }else{
            item.setFavourite(true);
        }
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();
    }
}
