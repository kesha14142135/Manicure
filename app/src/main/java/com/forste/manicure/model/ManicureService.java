package com.forste.manicure.model;

/**
 * Created by sergejkozin on 7/8/17.
 */

class ManicureService {
    private int mId;
    private String mName;
    private int mPrice;

    ManicureService(int id, String name, int price) {
        mId = id;
        mName = name;
        mPrice = price;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }
}
