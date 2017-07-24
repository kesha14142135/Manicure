package com.forste.manicure;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forste.manicure.view.activity.AuthenticationActivity;
import com.forste.manicure.view.activity.HomeActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent intent;
        if (!isNetworkAvaliable(getBaseContext())) {
            //TODO Internet inclusion request
//            Intent intent1 = new Intent(Intent.ACTION_MAIN);
//            intent1.setComponent(new ComponentName("com.android.settings",
//                    "com.android.settings.Settings$DataUsageSummaryActivity"));
//            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent1);
        }
        SessionManager session = new SessionManager(getBaseContext());
        if (session.userAuthorized()) {
            intent = new Intent(this, HomeActivity.class);
        } else {
            intent = new Intent(this, AuthenticationActivity.class);
        }
        startActivity(intent);
        finish();
    }

    public static boolean isNetworkAvaliable(Context context) {
        Boolean isConnectInternet = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                isConnectInternet = true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                isConnectInternet = true;
            }
        } else {
            isConnectInternet = false;
        }
        return isConnectInternet;
    }
}
