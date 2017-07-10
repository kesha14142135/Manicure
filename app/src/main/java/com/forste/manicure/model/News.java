package com.forste.manicure.model;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class News {
    private Date mDate;
    private Bitmap mImageFirst;
    private Bitmap mImageSecond;

    public News(Date date, Bitmap imageFirst, Bitmap imageSecond) {
        mDate = date;
        mImageFirst = imageFirst;
        mImageSecond = imageSecond;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
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
}
