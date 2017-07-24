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
import com.forste.manicure.contract.ForgotPasswordContract;
import com.forste.manicure.present.ForgotPasswordPresenter;
import com.forste.manicure.view.callback.CallBackActivityFragment;
import com.github.glomadrian.loadingballs.BallView;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

public class ForgotPasswordFragment extends Fragment implements View.OnClickListener,
        ForgotPasswordContract.View, Validator.ValidationListener {

    private View mView;
    private Validator mValidator;
    private ForgotPasswordContract.Presenter mPresenter;
    private CallBackActivityFragment mCallBack;
    private BallView mProgressBar;


    @NotEmpty(messageResId = R.string.error_email_empty)
    @Email(messageResId = R.string.error_not_email)
    private EditText mEditTextEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        updateViewDependencies(mView);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mPresenter = new ForgotPasswordPresenter();
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
    public void onSuccess() {
        mProgressBar.setVisibility(View.INVISIBLE);
        getActivity().onBackPressed();
    }

    @Override
    public void showError(String message) {
        mProgressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(mView.findViewById(R.id.relative_layout_forgot_password), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back: {
                getActivity().onBackPressed();
                break;
            }
            case R.id.button_registration: {
                mEditTextEmail.setBackgroundResource(R.drawable.edit_text_border_neutrally);
                mValidator.validate();
                break;
            }
        }

    }

    @Override
    public void onValidationSucceeded() {
        mPresenter.sandMail(mEditTextEmail.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(view.getContext());
            if (view instanceof EditText) {
                ((EditText) view).setBackgroundResource(R.drawable.edit_text_border);
            } else {
                Snackbar.make(mView.findViewById(R.id.relative_layout_forgot_password), message, Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }

    private void updateViewDependencies(View view) {
        mProgressBar = (BallView) view.findViewById(R.id.progress_bar);
        mEditTextEmail = (EditText) mView.findViewById(R.id.edit_text_email);
        view.findViewById(R.id.button_registration).setOnClickListener(this);
        view.findViewById(R.id.button_back).setOnClickListener(this);
    }


}
