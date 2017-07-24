package com.forste.manicure.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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
        openFragmentWithOutBackStack(new AuthorizationFragment());
    }

    @Override
    public void goToHomeScreen() {
        Intent intent = new Intent(AuthenticationActivity.this,
                HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean handleReturn = super.dispatchTouchEvent(ev);
        View view = getCurrentFocus();
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        if (view instanceof EditText) {
            View innerView = getCurrentFocus();
            if (ev.getAction() == MotionEvent.ACTION_UP &&
                    !getLocationOnScreen((EditText) innerView).contains(x, y)) {
                InputMethodManager input = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(getWindow().getCurrentFocus()
                        .getWindowToken(), 0);
            }
        }
        return handleReturn;
    }

    @Override
    public void clickRegistration() {
        openFragmentOnBackStack(new RegistrationFragment());
    }

    @Override
    public void clickForgotPassword() {
        openFragmentOnBackStack(new ForgotPasswordFragment());
    }

    private void openFragmentOnBackStack(Fragment fragment) {
        fragment.onAttach((Context) this);
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_authentication, fragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    private void openFragmentWithOutBackStack(Fragment fragment) {
        fragment.onAttach((Context) this);
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_authentication, fragment);
        mTransaction.commit();
    }

    protected Rect getLocationOnScreen(EditText mEditText) {
        Rect mRect = new Rect();
        int[] location = new int[2];
        mEditText.getLocationOnScreen(location);
        mRect.left = location[0];
        mRect.top = location[1];
        mRect.right = location[0] + mEditText.getWidth();
        mRect.bottom = location[1] + mEditText.getHeight();
        return mRect;
    }
}
