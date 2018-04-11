package com.example.android.visitsommieres;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JamieC on 03/04/2018.
 */

public class VisitFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    List<Items> itemsList;
    RecyclerView recyclerView;

    public VisitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onItemClick(Items itemsList) {

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
        itemsList.add(new Items(R.drawable.visit_rb, getString(R.string.visit_gps1), getString(R.string.visit_nameOfAtt1),
                getString(R.string.visit_shortDes1), getString(R.string.visit_moreIn1)));
        itemsList.add(new Items(R.drawable.visit_chateau_de_villevieille,  getString(R.string.visit_gps2),
                getString(R.string.visit_nameOfAtt2),getString(R.string.visit_shortDes2), getString(R.string.visit_moreIn2)));
        itemsList.add(new Items(R.drawable.visit_jazz_a_junas,  getString(R.string.visit_gps3),
                getString(R.string.visit_nameOfAtt3),getString(R.string.visit_shortDes3), getString(R.string.visit_moreIn3)));
        itemsList.add(new Items(R.drawable.visit_green_trail, getString(R.string.visit_gps4),
                getString(R.string.visit_nameOfAtt4),getString(R.string.visit_shortDes4), getString(R.string.visit_moreIn4)));
        itemsList.add(new Items(R.drawable.visit_roc_de_massereau, getString(R.string.visit_gps5),
                getString(R.string.visit_nameOfAtt5),getString(R.string.visit_shortDes5), getString(R.string.visit_moreIn5)));

        ItemsAdapter adapter = new ItemsAdapter(itemsList, this);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        return recyclerView;

    }
}
