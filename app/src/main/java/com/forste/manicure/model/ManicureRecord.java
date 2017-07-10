package com.forste.manicure.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by sergejkozin on 7/8/17.
 */

public class ManicureRecord {
    private Time mTime;
    private Date mDate;
    private List<ManicureService> mManicureServices;


   public ManicureRecord(Time time, Date date, List<ManicureService> manicureServices) {
        mTime = time;
        mDate = date;
        mManicureServices = manicureServices;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Time getTime() {
        return mTime;
    }

    public void setTime(Time time) {
        mTime = time;
    }

    public List<ManicureService> getManicureServices() {
        return mManicureServices;
    }

    public void setManicureServices(List<ManicureService> manicureServices) {
        mManicureServices = manicureServices;
    }
}
