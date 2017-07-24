package com.forste.manicure.model;

import android.graphics.Bitmap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class News {
    private Calendar mDate;
    private Bitmap mImageFirst;
    private Bitmap mImageSecond;

    public News(Calendar date, Bitmap imageFirst, Bitmap imageSecond) {
        mDate = date;
        mImageFirst = imageFirst;
        mImageSecond = imageSecond;
    }

    public Calendar getDate() {
        return mDate;
    }

    public void setDate(Calendar date) {
        mDate = date;
    }

    public Bitmap getImageFirst() {
        return mImageFirst;
    }

    public void setImageFirst(Bitmap imageFirst) {
        mImageFirst = imageFirst;
    }

    public Bitmap getImageSecond() {
        return mImageSecond;
    }

    public void setImageSecond(Bitmap imageSecond) {
        mImageSecond = imageSecond;
    }

    public String publicationDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        dateFormat.setCalendar(mDate);
        String dateFormatted = dateFormat.format(mDate.getTime());
        return dateFormatted;
    }
}
