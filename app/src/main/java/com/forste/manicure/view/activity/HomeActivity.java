package com.forste.manicure.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.forste.manicure.R;
import com.forste.manicure.view.fragment.MasterProfileFragment;
import com.forste.manicure.view.fragment.NewsFeedFragment;
import com.forste.manicure.view.fragment.PriceFragment;
import com.forste.manicure.view.fragment.ProfileFragment;
import com.forste.manicure.view.fragment.DateWorkFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends AppCompatActivity implements OnTabSelectListener {
    private FragmentTransaction mTransaction;
    private Fragment mTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        bottomBar.selectTabWithId(R.id.tab_time);
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        if (tabId == R.id.tab_history) {
            mTabFragment = new MasterProfileFragment();
        } else if (tabId == R.id.tab_time) {
            mTabFragment = new DateWorkFragment();
        } else if (tabId == R.id.tab_list) {
            mTabFragment = new NewsFeedFragment();
        } else if (tabId == R.id.tab_profile) {
            mTabFragment = new ProfileFragment();
        } else if (tabId == R.id.tab_price) {
            mTabFragment = new PriceFragment();
        }
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_home, mTabFragment);
        mTransaction.commit();
    }
}