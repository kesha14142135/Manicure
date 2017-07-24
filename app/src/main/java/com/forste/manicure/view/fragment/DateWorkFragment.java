package com.forste.manicure.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forste.manicure.R;
import com.forste.manicure.contract.DateContract;
import com.forste.manicure.model.WorkDateTime;
import com.forste.manicure.present.DatePresenter;
import com.forste.manicure.view.adapter.DateWorkAdapter;

import java.util.ArrayList;
import java.util.List;


public class DateWorkFragment extends Fragment implements DateContract.View {
    private View mView;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<TimeWorkFragment> mGridFragments;
    private DateContract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_date_work, container, false);
        updateViewDependencis(mView);
        mPresenter = new DatePresenter();
        mPresenter.attachView(this);
        mPresenter.getAllWorkDateTime();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mView.findViewById(R.id.relative_layout_date_work), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void showAllWorkDateTime(List<WorkDateTime> workDateTimeList) {
        for (WorkDateTime workDate :
                workDateTimeList) {
            mGridFragments.add(TimeWorkFragment.newInstance(workDate));
        }
        mPagerAdapter = new DateWorkAdapter(this.getFragmentManager(), mGridFragments);
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void updateViewDependencis(View view) {
        mGridFragments = new ArrayList<TimeWorkFragment>();
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager_time_work);
    }
}
