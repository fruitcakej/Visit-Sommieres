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

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context context;

    //we are storing all the products in a list
    private List<Items> itemsList;

    //Holder for geo location
    private String toMaps;

    //getting the context and product list with constructor
    public ItemsAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning view holder
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_items, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageItem, googleMaps;
        TextView attraction_name, short_desc, more_info;


        public ProductViewHolder(final View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.imageItem);
            attraction_name = itemView.findViewById(R.id.attraction_name);
            short_desc = itemView.findViewById(R.id.short_desc);
            more_info = itemView.findViewById(R.id.more_info);
            googleMaps = itemView.findViewById(R.id.googleMapsButton);

            googleMaps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                // Create a Uri from an intent string. Use the result to create an Intent.



                    Uri sendToMap = Uri.parse(toMaps);
                    Intent intent = new Intent(Intent.ACTION_VIEW, sendToMap);
                    // Make the Intent explicit by setting the Google Maps package
                    intent.setPackage("com.google.android.apps.maps");

                    if (intent.getPackage() != null) {
                        itemView.getContext().startActivity(intent);
                    }




                }
            });




        }
    }



    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        //getting the product of the specified position
        Items items = itemsList.get(position);

        toMaps = items.getgMapsLocation();
        Log.d("value", toMaps);

        //binding the data with the viewholder views
        holder.imageItem.setImageResource(items.getImageResourceID());
        holder.attraction_name.setText(items.getNameOfAttraction());
        holder.short_desc.setText(items.getShortdesc());
        holder.more_info.setText(items.getMoreInfo());

    }

}