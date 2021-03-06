package com.forste.manicure.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.forste.manicure.R;
import com.forste.manicure.contract.AuthorizationContract;
import com.forste.manicure.model.User;
import com.forste.manicure.present.AuthorizationPresenter;
import com.forste.manicure.view.callback.CallBackActivityFragment;
import com.github.glomadrian.loadingballs.BallView;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class AuthorizationFragment extends Fragment implements AuthorizationContract.View,
        View.OnClickListener, Validator.ValidationListener {

    private View mView;
    private AuthorizationContract.Presenter mPresenter;
    private Validator mValidator;
    private CallBackActivityFragment mCallBack;
    private BallView mProgressBar;

    @Email(messageResId = R.string.error_email_empty)
    private EditText mEditTextEmail;

    @NotEmpty(messageResId = R.string.error_password_empty)
    @Password(min = 4, scheme = Password.Scheme.NUMERIC, messageResId = R.string.error_registration_min)
    private EditText mEditTextPassword;

    public AuthorizationFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_authorization, container, false);
        updateViewDependencies(mView);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mPresenter = new AuthorizationPresenter();
        mPresenter.attachView(this);
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CallBackActivityFragment) {
            mCallBack = (CallBackActivityFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CallBackActivityFragment.Authorization");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    @Override
    public void authorizationWasSuccessful() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mCallBack.goToHomeScreen();
    }

    @Override
    public void showError(String message) {
        mProgressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(mView.findViewById(R.id.relative_layout_authorization), message, Snackbar.LENGTH_LONG)
                .show();
    }

    private void updateViewDependencies(View view) {
        mProgressBar = (BallView) view.findViewById(R.id.progress_bar);
        mEditTextPassword = (EditText) view.findViewById(R.id.edit_text_password);
        mEditTextEmail = (EditText) view.findViewById(R.id.edit_text_email);

        view.findViewById(R.id.button_authorization).setOnClickListener(this);
        view.findViewById(R.id.button_registration).setOnClickListener(this);
        view.findViewById(R.id.button_forgot_password).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_authorization: {
                mEditTextEmail.setBackgroundResource(R.drawable.edit_text_border_neutrally);
                mEditTextPassword.setBackgroundResource(R.drawable.edit_text_border_neutrally);
                mValidator.validate();
                break;
            }
            case R.id.button_registration: {
                mCallBack.clickRegistration();
                break;
            }
            case R.id.button_forgot_password: {
                mCallBack.clickForgotPassword();
                break;
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        User user = new User(
                mEditTextEmail.getText().toString(),
                mEditTextPassword.getText().toString()
        );
        mPresenter.authorization(user);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        String textError = "";
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(view.getContext());
            if (view instanceof EditText) {
                ((EditText) view).setBackgroundResource(R.drawable.edit_text_border);
                textError += message + "\n";
            } else {
                Snackbar.make(mView.findViewById(R.id.relative_layout_authorization), message, Snackbar.LENGTH_LONG)
                        .show();
            }
        }
        Snackbar.make(mView.findViewById(R.id.relative_layout_authorization), textError, Snackbar.LENGTH_LONG)
                .show();
    }
}
