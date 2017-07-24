package com.forste.manicure.model;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class Price {
    private String mName;
    private int mCost;
    private int mTime;

    public Price(String name, int cost, int time) {
        mName = name;
        mCost = cost;
        mTime = time;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCost() {
        return mCost;
    }

    public void setCost(int cost) {
        mCost = cost;
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        mTime = time;
    }
}
