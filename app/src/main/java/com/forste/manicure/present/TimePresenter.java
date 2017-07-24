package com.forste.manicure.present;

import com.forste.manicure.contract.TimeContract;
import com.forste.manicure.model.WorkDateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sergejkozin on 7/20/17.
 */

public class TimePresenter implements TimeContract.Presenter {

    private TimeContract.View mView;
    private WorkDateTime mWorkDateTime;

    @Override
    public void attachView(TimeContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void isCurrentTimeFree(Calendar date, int time) {
        mWorkDateTime = new WorkDateTime();
        mWorkDateTime.setDate(date);
        List<Boolean> listTime = new ArrayList<>();
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);

        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);

        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);

        listTime.add(false);
        listTime.add(true);
        listTime.add(true);
        listTime.add(true);
        listTime.add(false);

        listTime.add(false);
        listTime.add(true);
        listTime.add(true);
        listTime.add(false);
        mWorkDateTime.setWorkingHours(listTime);
        mView.updateDateTime(mWorkDateTime);
    }
}
