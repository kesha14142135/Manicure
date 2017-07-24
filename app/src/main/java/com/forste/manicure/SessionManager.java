package com.forste.manicure;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sergejkozin on 7/21/17.
 */

public class SessionManager {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "AndroidHivePref";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String TOKEN = "token";

    public SessionManager(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreferences.edit();
    }

    public void createLoginSession(String token) {
        mEditor.putBoolean(IS_LOGIN, true);
        mEditor.putString(TOKEN, token);
        mEditor.commit();
    }

    public boolean userAuthorized() {
        return mSharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public String userToken() {
        return mSharedPreferences.getString(TOKEN, "");
    }

    public void createLogOutSession() {
        mEditor.putBoolean(IS_LOGIN, false);
        mEditor.putString(TOKEN, "");
        mEditor.commit();
    }
}
