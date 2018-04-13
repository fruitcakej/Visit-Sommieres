package com.example.android.visitsommieres;

/**
 * Created by JamieC on 29/03/2018.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
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
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab1);
            case 1:
                return mContext.getString(R.string.tab2);
            case 2:
                return mContext.getString(R.string.tab3);
            case 3:
                return mContext.getString(R.string.tab4);
            case 4:
                return mContext.getString(R.string.tab5);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}