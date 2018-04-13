package com.example.android.visitsommieres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.WindowCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by JamieC on 29/03/2018.
 */

public class HomeFragment extends Fragment{

 private ImageView blogIV, videoIV;
 View home_bg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_home, container, false);

        home_bg = rootView.findViewById(R.id.home_bg);
        home_bg.setBackgroundResource(R.drawable.bg);

        // doesn't seem to work when trying programmatically
        if (getActivity().getWindow() == null) {
        getActivity().getWindow().requestFeature(WindowCompat.FEATURE_ACTION_BAR_OVERLAY);
        }


        blogIV = rootView.findViewById(R.id.blog);
        blogIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.blog_link))));
            }
        });

        videoIV = rootView.findViewById(R.id.video);
        videoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoIntent = new Intent(getContext(), VideoActivity.class);
                startActivity(videoIntent);
            }
        });

        return rootView;
    }
}
