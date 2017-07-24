package com.forste.manicure.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.contract.TimeContract;
import com.forste.manicure.model.WorkDateTime;
import com.forste.manicure.present.TimePresenter;
import com.forste.manicure.view.adapter.TimeWorkAdapter;
import com.forste.manicure.view.callback.CallBackAdapterTime;

/**
 * Created by sergejkozin on 7/19/17.
 */

public class TimeWorkFragment extends Fragment implements TimeContract.View, CallBackAdapterTime {
    private GridView mGridView;
    private TextView mTextViewDateWork;
    private TimeWorkAdapter mGridAdapter;
    private TimePresenter mPresenter;
    private WorkDateTime mTimeList;
    private Context mContext;
    private View mView;
    private static String TIME = "time";

    public TimeWorkFragment() {

    }

    public static TimeWorkFragment newInstance(WorkDateTime timeList) {
        TimeWorkFragment fragment = new TimeWorkFragment();
        Bundle args = new Bundle();
        args.putSerializable(TIME, timeList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_time_work, container, false);
        updateViewDependencis(mView);
        mTimeList = (WorkDateTime) getArguments().getSerializable(TIME);
        mPresenter = new TimePresenter();
        mPresenter.attachView(this);
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mContext != null) {
            mTextViewDateWork.setText(mTimeList.recordDate());
            mGridAdapter = new TimeWorkAdapter(mContext, R.layout.grid_view_time_work, mTimeList.getWorkingHours(), this);
            if (mGridView != null) {
                mGridView.setAdapter(mGridAdapter);
            }
        }
    }

    private void updateViewDependencis(View view) {
        mGridView = (GridView) view.findViewById(R.id.grid_view_time);
        mTextViewDateWork = (TextView) view.findViewById(R.id.text_view_date_work);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mView.findViewById(R.id.relative_layout_time_work), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void recordToMaster() {
        ChoiceOfServiceFragment fragment2 = new ChoiceOfServiceFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.relative_layout_time_work, fragment2);
        fragmentTransaction.commit();
    }

    @Override
    public void updateDateTime(WorkDateTime workDateTime) {
        mGridAdapter = new TimeWorkAdapter(mContext, R.layout.grid_view_time_work, workDateTime.getWorkingHours(), this);
        mGridView.invalidateViews();
        mGridView.setAdapter(mGridAdapter);
    }

    @Override
    public void onClick(int position) {
        mPresenter.isCurrentTimeFree(mTimeList.getDate(), position);
        recordToMaster();
    }
}
