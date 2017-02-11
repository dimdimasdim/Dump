package com.android.beginner.dump.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.beginner.dump.R;
import com.android.beginner.dump.model.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 30/01/17.
 */

public class DumpAdapter extends RecyclerView.Adapter<DumpAdapter.DumpHolder>{
    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface  ItemClickCallback{
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public DumpAdapter (List<ListItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public DumpAdapter.DumpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new DumpHolder(view);
    }

    @Override
    public void onBindViewHolder(DumpHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
//        if (item.isFavourite()){
//            holder.secondaryIcon.setImageResource(android.R.drawable.btn_star_big_on);
//        } else {
//            holder.secondaryIcon.setImageResource(android.R.drawable.btn_star_big_off);
//        }
    }
    public void setListData(ArrayList<ListItem> exerciseList){
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DumpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView subTitle;
        ImageView thumbnail;
         //ImageView secondaryIcon;
         //View container;

        Button load;

        public DumpHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            subTitle = (TextView)itemView.findViewById(R.id.lbl_item_sub_title);
            thumbnail = (ImageView)itemView.findViewById(R.id.im_item_icon);
//            secondaryIcon = (ImageView)itemView.findViewById(R.id.im_item_icon_secondary);
//            container =itemView.findViewById(R.id.cont_item_root);
//            container.setOnClickListener(this);
//            secondaryIcon.setOnClickListener(this);

            load = (Button) itemView.findViewById(R.id.btn_card_load);
            load.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_card_load){
                itemClickCallback.onItemClick(getAdapterPosition());
            }else {
                //itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }
        }
    }
}
