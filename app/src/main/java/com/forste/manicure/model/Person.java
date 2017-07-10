package com.forste.manicure.model;

import android.graphics.Bitmap;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class Person {
    private String mName;
    private String mTelephoneNumber;
    private String mEmail;
    private Bitmap mPhoto;
    private String mPassword;

    public Person(String name, String telephoneNumber, String email, String password, Bitmap photo) {
        mName = name;
        mTelephoneNumber = telephoneNumber;
        mEmail = email;
        mPassword = password;
        mPhoto = photo;
    }

    public void getName(String name) {
        mName = name;
    }

    public String setName() {
        return mName;
    }

    public void getTelephoneNumber(String telephoneNumber) {
        mTelephoneNumber = telephoneNumber;
    }

    public String setTelephoneNumber() {
        return mTelephoneNumber;
    }

    public void getPassword(String password) {
        mPassword = password;
    }

    public String setPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Bitmap getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Bitmap photo) {
        mPhoto = photo;
    }
}
