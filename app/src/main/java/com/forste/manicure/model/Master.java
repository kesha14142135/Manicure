package com.forste.manicure.model;

import android.graphics.Bitmap;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class Master {
    private String mName;
    private String mAboutMaster;
    private String mTelephoneNumber;
    private String mInstagram;
    private Bitmap mPhoto;

    public Master(String name, String aboutMaster, String telephoneNumber, String instagram, Bitmap photo) {
        mName = name;
        mAboutMaster = aboutMaster;
        mTelephoneNumber = telephoneNumber;
        mInstagram = instagram;
        mPhoto = photo;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAboutMaster() {
        return mAboutMaster;
    }

    public void setAboutMaster(String aboutMaster) {
        mAboutMaster = aboutMaster;
    }

    public String getTelephoneNumber() {
        return mTelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        mTelephoneNumber = telephoneNumber;
    }

    public String getInstagram() {
        return mInstagram;
    }

    public void setmInstagram(String instagram) {
        mInstagram = instagram;
    }

    public Bitmap getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Bitmap photo) {
        mPhoto = photo;
    }
}
