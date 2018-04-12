package com.example.android.visitsommieres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Simple pop up window
 * Tutorial from: https://www.youtube.com/watch?v=fn5OlqQuOCk
 */

public class PopUpWindow extends Activity {

    private TextView more_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));

        //Get intent for more info

        more_info = findViewById(R.id.more_info);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle !=null)
        {
            String mInfo = (String) bundle.get("data");
            more_info.setText(mInfo);
        }
    }
}
