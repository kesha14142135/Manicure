package com.forste.manicure.model;

import android.graphics.Bitmap;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class Person implements Serializable {
    private String mName;
    private String mTelephoneNumber;
    private String mEmail;

    @Exclude
    private Bitmap mPhoto;

    public Person(String name, String telephoneNumber, String email, Bitmap photo) {
        mName = name;
        mTelephoneNumber = telephoneNumber;
        mEmail = email;
        mPhoto = photo;
    }

    public Person(String name, String telephoneNumber, String email) {
        mName = name;
        mTelephoneNumber = telephoneNumber;
        mEmail = email;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        mTelephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return mTelephoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
    @Exclude
    public Bitmap getPhoto() {
        return mPhoto;
    }
    @Exclude
    public void setPhoto(Bitmap photo) {
        mPhoto = photo;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        if (person.getName() == mName &&
                person.getTelephoneNumber() == mTelephoneNumber &&
                person.getEmail() == mEmail) {
            return true;
        } else {
            return false;
        }
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put(Constant.NAME, mName);
        result.put(Constant.PHONE, mTelephoneNumber);
        result.put(Constant.EMAIL, mEmail);
        return result;
    }
}
