package com.android.beginner.dump.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.beginner.dump.R;
import com.android.beginner.dump.model.ListItem;

import java.util.List;

/**
 * Created by root on 30/01/17.
 */

public class DumpAdapter extends RecyclerView.Adapter<DumpAdapter.DumpHolder>{
    private List<ListItem> listData;
    private LayoutInflater inflater;

    public DumpAdapter (List<ListItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public DumpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new DumpHolder(view);
    }

    @Override
    public void onBindViewHolder(DumpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DumpHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView icon;
        private View container;

        public DumpHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.tv_item_icon);
            icon = (ImageView)itemView.findViewById(R.id.iv_item_icon);
            container =itemView.findViewById(R.id.cont_item_root);

        }
    }
}
