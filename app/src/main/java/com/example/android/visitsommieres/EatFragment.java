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

public class EatFragment extends Fragment implements ItemsAdapter.OnItemClickListener {

    List<Items> itemsList;
    RecyclerView recyclerView;

    public EatFragment() {
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
        itemsList.add(new Items(R.drawable.eat_lepix_bar_tapas, getString(R.string.eat_gps1), getString(R.string.eat_nameOfAtt1),
                getString(R.string.eat_shortDes1), getString(R.string.eat_moreIn1)));
        itemsList.add(new Items(R.drawable.eat_lou_caleou_next, getString(R.string.eat_gps2), getString(R.string.eat_nameOfAtt2),
                getString(R.string.eat_shortDes2), getString(R.string.eat_moreIn2)));
        itemsList.add(new Items(R.drawable.eat_le_table_du_quai, getString(R.string.eat_gps3), getString(R.string.eat_nameOfAtt3),
                getString(R.string.eat_shortDes3), getString(R.string.eat_moreIn3)));
        itemsList.add(new Items(R.drawable.eat_les_korrigans_du_vidourle, getString(R.string.eat_gps4), getString(R.string.eat_nameOfAtt4),
                getString(R.string.eat_shortDes4), getString(R.string.eat_moreIn4)));
        itemsList.add(new Items(R.drawable.eat_le_nulle_par_ailleurs, getString(R.string.eat_gps5), getString(R.string.eat_nameOfAtt5),
                getString(R.string.eat_shortDes5), getString(R.string.eat_moreIn5)));
        itemsList.add(new Items(R.drawable.eat_sansavino, getString(R.string.eat_gps6), getString(R.string.eat_nameOfAtt6),
                getString(R.string.eat_shortDes6), getString(R.string.eat_moreIn6)));

        ItemsAdapter adapter = new ItemsAdapter(itemsList, this);

        recyclerView = recyclerView.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}
