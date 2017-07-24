package com.forste.manicure.model;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sergejkozin on 7/8/17.
 */

public class ManicureRecord {
    private Calendar mDate;
    private ManicureService mManicureService;


    public ManicureRecord(Calendar date, ManicureService manicureService) {
        mDate = date;
        mManicureService = manicureService;
    }

    public ManicureRecord() {

    }

    public Calendar getDate() {
        return mDate;
    }

    public void setDate(Calendar date) {
        mDate = date;
    }

    public ManicureService getManicureService() {
        return mManicureService;
    }

    public void setManicureService(ManicureService manicureService) {
        mManicureService = manicureService;
    }

    public boolean currentTimeIsShorter() {
        return mDate.getTimeInMillis() > Calendar.getInstance().getTimeInMillis();
    }

    public String recordDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateFormat.setCalendar(mDate);
        String dateFormatted = dateFormat.format(mDate.getTime());
        return dateFormatted;
    }

    public String recordTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setCalendar(mDate);
        String dateFormatted = dateFormat.format(mDate.getTime());
        return dateFormatted;
    }
}
