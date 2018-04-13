package com.example.android.visitsommieres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JamieC on 11/04/2018.
 */

public class HotelsFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    List<Items> itemsList;
    RecyclerView recyclerView;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onMoreInfoClick(Items itemsList) {

        String more_info;
        more_info = itemsList.getMoreInfo();
        Intent intent = new Intent(getContext(), PopUpWindow.class);
        intent.putExtra(getString(R.string.intent_data), more_info);
        startActivity(intent);
    }

    @Override
    public void onMapItemClick(Items itemsList) {

        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri sendToMap = Uri.parse(itemsList.getgMapsLocation());
        Intent intent = new Intent(Intent.ACTION_VIEW, sendToMap);
        // Make the Intent explicit by setting the Google Maps package
        intent.setPackage(getString(R.string.set_package));

        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            getContext().startActivity(intent);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        recyclerView = (RecyclerView) inflater.inflate(R.layout.layout_recycler, container, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setBackgroundResource(0);

        itemsList = new ArrayList<>();
        itemsList.add(new Items(R.drawable.hotels_estelou, getString(R.string.hotels_gps1), getString(R.string.hotels_nameOfAtt1),
                getString(R.string.hotels_shortDes1), getString(R.string.hotels_moreIn1)));
        itemsList.add(new Items(R.drawable.hotels_chateau_de_pondres, getString(R.string.hotels_gps2), getString(R.string.hotels_nameOfAtt2),
                getString(R.string.hotels_shortDes2), getString(R.string.hotels_moreIn2)));

        ItemsAdapter adapter = new ItemsAdapter(itemsList, this);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}





