package com.forste.manicure.model;

import java.util.Date;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class WorkDateTime {
    private Date mDate;
    private boolean[] mWorkingHours;

    public void getDate(Date date) {
        mDate = date;
    }

    public Date setDate() {
        return mDate;
    }

    public void getWorkingHours(boolean[] workingHours) {
        mWorkingHours = workingHours;
    }

    public boolean[] setWorkingHours() {
        return mWorkingHours;
    }
}
