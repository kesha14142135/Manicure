package com.forste.manicure.model;

/**
 * Created by sergejkozin on 7/2/17.
 */

public class User {

    private String mEmail;
    private String mPassword;

    public User(String telephoneNumber, String password) {
        mEmail = telephoneNumber;
        mPassword = password;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getPassword() {
        return mPassword;
    }
}
