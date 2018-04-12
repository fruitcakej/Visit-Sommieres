package com.example.android.visitsommieres;

/**
 * Created by JamieC on 29/03/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Home", "Visit", "Eat", "Shop", "Hotels" };

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1){
            return new VisitFragment();
        } else if (position == 2) {
            return new EatFragment();
        } else if (position == 3)  {
            return new ShopFragment();
        } else  {
            return new HotelsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 5;
    }
}