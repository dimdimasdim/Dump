package com.android.beginner.dump.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.beginner.dump.R;
import com.android.beginner.dump.adapter.DumpAdapter;
import com.android.beginner.dump.model.DumpData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DumpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DumpAdapter(DumpData.getListData(), this);

        recyclerView.setAdapter(adapter);
    }
}
