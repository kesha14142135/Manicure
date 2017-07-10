package com.forste.manicure.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.forste.manicure.R;
import com.forste.manicure.view.callback.CallBackActivityFragment;
import com.forste.manicure.view.fragment.AuthorizationFragment;
import com.forste.manicure.view.fragment.ForgotPasswordFragment;
import com.forste.manicure.view.fragment.RegistrationFragment;

public class AuthenticationActivity extends AppCompatActivity implements CallBackActivityFragment {

    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        Fragment numberFragment = new AuthorizationFragment();
        numberFragment.onAttach((Context) this);
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(R.id.frame_layout_authentication, numberFragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    @Override
    public void goToHomeScreen() {
        Intent intent = new Intent(AuthenticationActivity.this,
                HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void clickRegistration() {
        Fragment numberFragment = new RegistrationFragment();
        numberFragment.onAttach((Context) this);
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_authentication, numberFragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    @Override
    public void clickForgotPassword() {
        Fragment numberFragment = new ForgotPasswordFragment();
        numberFragment.onAttach((Context) this);
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_authentication, numberFragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }
}
