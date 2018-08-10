package com.example.hemant.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Hemant on 7/17/2017.
 */

public class SimpleFragmentViewadapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Numbers", "Colors", "Family","Phrases" };
    public SimpleFragmentViewadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new NumberFragment();
        else if(position==1)
            return  new ColorsFragment();
        else if(position==2)
            return new FamilyFragment();
        else
            return new PhrasesFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
