package com.example.android.visitsommieres;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnItemClick;

/**
 * Created by JamieC on 09/04/2018.
 */

public class ShopFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    List<Items> itemsList;
    RecyclerView recyclerView;

    public ShopFragment() {
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
        itemsList.add(new Items(R.drawable.shop_market, getString(R.string.shop_gps1), getString(R.string.shop_nameOfAtt1),
                getString(R.string.shop_shortDes1), getString(R.string.shop_moreIn1)));
        itemsList.add(new Items(R.drawable.shop_courtin_chocolatier, getString(R.string.shop_gps2), getString(R.string.shop_nameOfAtt2),
                getString(R.string.shop_shortDes2), getString(R.string.shop_moreIn2)));
        itemsList.add(new Items(R.drawable.shop_lanneau_dor, getString(R.string.shop_gps3), getString(R.string.shop_nameOfAtt3),
                getString(R.string.shop_shortDes3), getString(R.string.shop_moreIn3)));


        ItemsAdapter adapter = new ItemsAdapter(itemsList, this);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}
