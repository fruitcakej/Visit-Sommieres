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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JamieC on 09/04/2018.
 */

public class HotelsFragment extends Fragment{

    List<Items> itemsList;
    RecyclerView recyclerView;

    public HotelsFragment() {
        // Required empty public constructor
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









        ItemsAdapter adapter = new ItemsAdapter(getActivity(), itemsList);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}





