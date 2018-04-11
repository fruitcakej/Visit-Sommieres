package com.example.android.visitsommieres;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JamieC on 02/04/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Items itemsList);
    }

    private final List<Items> itemsList;
    private final OnItemClickListener listener;

    public ItemsAdapter(List<Items> itemsList, OnItemClickListener listener) {
        this.itemsList = itemsList;
        this.listener = listener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(itemsList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView attraction_name, short_desc, more_info;
        private ImageView imageItem, googleMaps;

        public ViewHolder(View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.imageItem);
            attraction_name = itemView.findViewById(R.id.attraction_name);
            short_desc = itemView.findViewById(R.id.short_desc);
            more_info = itemView.findViewById(R.id.more_info);
            googleMaps = itemView.findViewById(R.id.googleMapsButton);
        }

        public void bind(final Items itemList, final OnItemClickListener listener) {
            attraction_name.setText(itemList.getNameOfAttraction());
            short_desc.setText(itemList.getShortdesc());
            more_info.setText(itemList.getMoreInfo());
            imageItem.setImageResource(itemList.getImageResourceID());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(itemList);
                }
            });
        }
    }
}