package com.forste.manicure.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;

import com.forste.manicure.R;
import com.forste.manicure.view.fragment.AuthorizationFragment;
import com.forste.manicure.view.fragment.NewsFeedFragment;
import com.forste.manicure.view.fragment.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class HomeActivity extends AppCompatActivity implements OnTabSelectListener {
    private FragmentTransaction mTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        if (tabId == R.id.tab_history) {

        } else if (tabId == R.id.tab_time) {

        } else if (tabId == R.id.tab_list) {
            Fragment numberFragment = new NewsFeedFragment();
            //numberFragment.onAttach((Context) this);
            mTransaction = getSupportFragmentManager().beginTransaction();
            mTransaction.replace(R.id.frame_layout_home, numberFragment);
            mTransaction.commit();
        } else if (tabId == R.id.tab_profile) {
            Fragment numberFragment = new ProfileFragment();
            //numberFragment.onAttach((Context) this);
            mTransaction = getSupportFragmentManager().beginTransaction();
            mTransaction.replace(R.id.frame_layout_home, numberFragment);
            mTransaction.commit();
        } else if (tabId == R.id.tab_price) {

        }
    }
}