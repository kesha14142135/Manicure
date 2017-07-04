package com.forste.manicure.model;

/**
 * Created by sergejkozin on 7/2/17.
 */

public class User {

    private String mTelephoneNumber;
    private String mPassword;

    public User(String telephoneNumber, String password) {
        mTelephoneNumber = telephoneNumber;
        mPassword = password;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        mTelephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return mTelephoneNumber;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }
}
