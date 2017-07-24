package com.forste.manicure.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.forste.manicure.view.fragment.TimeWorkFragment;

import java.util.List;

/**
 * Created by sergejkozin on 7/19/17.
 */

public class DateWorkAdapter extends FragmentStatePagerAdapter {

    private List<TimeWorkFragment> mTimeGridViewFragment;

    public DateWorkAdapter(FragmentManager fm, List<TimeWorkFragment> timeGridViewFragment) {
        super(fm);
         mTimeGridViewFragment = timeGridViewFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mTimeGridViewFragment.get(position);
    }

    @Override
    public int getCount() {
        return mTimeGridViewFragment.size();
    }
}
