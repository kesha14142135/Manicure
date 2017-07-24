package com.forste.manicure.present;

import android.content.Context;

import com.forste.manicure.contract.DateContract;
import com.forste.manicure.model.WorkDateTime;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by sergejkozin on 7/19/17.
 */

public class DatePresenter implements DateContract.Presenter {
    private DateContract.View mView;
    private Context mContext;

    @Override
    public void attachView(DateContract.View view) {
        mView = view;
        mContext = view.getContext();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getAllWorkDateTime() {
        List<Boolean> workTime = new ArrayList<>();
        workTime.add(false);
        workTime.add(true);
        workTime.add(true);
        workTime.add(false);
        workTime.add(false);

        workTime.add(true);
        workTime.add(false);
        workTime.add(false);
        workTime.add(true);
        workTime.add(false);

        workTime.add(false);
        workTime.add(true);
        workTime.add(true);
        workTime.add(true);
        workTime.add(true);

        workTime.add(false);
        workTime.add(true);
        workTime.add(true);
        workTime.add(true);
        workTime.add(false);

        workTime.add(false);
        workTime.add(true);
        workTime.add(true);
        workTime.add(false);

        List<WorkDateTime> timeList = new ArrayList<>();
        timeList.add(new WorkDateTime(new GregorianCalendar(2017, 11, 2), workTime));
        timeList.add(new WorkDateTime(new GregorianCalendar(2017, 11, 3), workTime));
        timeList.add(new WorkDateTime(new GregorianCalendar(2017, 11, 4), workTime));
        timeList.add(new WorkDateTime(new GregorianCalendar(2017, 11, 5), workTime));
        timeList.add(new WorkDateTime(new GregorianCalendar(2017, 11, 6), workTime));

        mView.showAllWorkDateTime(timeList);
    }
}
