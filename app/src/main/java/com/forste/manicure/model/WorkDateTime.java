package com.forste.manicure.model;

import android.support.v4.app.Fragment;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class WorkDateTime implements Serializable {
    private Calendar mCalendar;
    private List<Boolean> mWorkingHours;

    public WorkDateTime() {
    }

    public WorkDateTime(Calendar calendar, List<Boolean> workingHours) {
        mCalendar = calendar;
        mWorkingHours = workingHours;
    }

    public void setDate(Calendar calendar) {
        mCalendar = calendar;
    }

    public Calendar getDate() {
        return mCalendar;
    }

    public void setWorkingHours(List<Boolean> workingHours) {
        mWorkingHours = workingHours;
    }

    public List<Boolean> getWorkingHours() {
        return mWorkingHours;
    }

    public String recordDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateFormat.setCalendar(mCalendar);
        String dateFormatted = dateFormat.format(mCalendar.getTime());
        return dateFormatted;
    }
}
