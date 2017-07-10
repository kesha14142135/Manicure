package com.forste.manicure.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.forste.manicure.R;
import com.forste.manicure.contract.RegistrationContract;
import com.forste.manicure.model.Person;
import com.forste.manicure.present.RegistrationPresenter;
import com.forste.manicure.view.callback.CallBackActivityFragment;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mvc.imagepicker.ImagePicker;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RegistrationFragment extends Fragment implements RegistrationContract.View,
        View.OnClickListener, Validator.ValidationListener {

    private View mView;
    private Validator mValidator;
    private RegistrationContract.Presenter mPresenter;
    private CallBackActivityFragment mCallBack;

    private ImageView mImageViewPhoto;

    @NotEmpty(messageResId = R.string.error_password_empty)
    @Password(min = 4, messageResId = R.string.error_registration_min)
    private EditText mEditTextPassword;

    @NotEmpty(messageResId = R.string.error_email_empty)
    @Email(messageResId = R.string.error_not_email)
    private EditText mEditTextEmail;

    @NotEmpty(messageResId = R.string.error_name_empty)
    private EditText mEditTextName;

    @NotEmpty(messageResId = R.string.error_telephone_number_empty)
    @Password(min = 9, scheme = Password.Scheme.NUMERIC, messageResId = R.string.error_telephone_number_min)
    private EditText mEditTextTelephoneNumber;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_registration, container, false);
        updateViewDependencies(mView);
        mPresenter = new RegistrationPresenter();
        mPresenter.attachView(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
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

    }

    @Override
    public void showError(String message) {
        Snackbar.make(mView.findViewById(R.id.relative_layout_registration), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void registrationSuccessful() {
        mCallBack.goToHomeScreen();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_registration: {
                mValidator.validate();
                break;
            }
            case R.id.button_back: {
                getActivity().onBackPressed();
                break;
            }
            case R.id.image_view_photo_user: {
                ImagePicker.pickImage(RegistrationFragment.this, getResources().getString(R.string.select_photo));
                break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(getActivity(), requestCode, resultCode, data);
        if (bitmap != null) {

            mImageViewPhoto.setImageBitmap(cropCenterOfImage(bitmap));
        }
        InputStream is = ImagePicker.getInputStreamFromResult(getActivity(), requestCode, resultCode, data);
        if (is != null) {

            try {
                is.close();
            } catch (IOException ex) {
                // ignore
            }
        } else {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onValidationSucceeded() {
        Person person = new Person(
                mEditTextName.getText().toString(),
                mEditTextEmail.getText().toString(),
                mEditTextPassword.getText().toString(),
                mEditTextTelephoneNumber.getText().toString(),
                mImageViewPhoto.getDrawingCache()
        );
        mPresenter.registration(person);

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(view.getContext());
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Snackbar.make(mView.findViewById(R.id.relative_layout_registration), message, Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }

    private Bitmap cropCenterOfImage(Bitmap srcBmp) {
        Bitmap dstBmp;
        if (srcBmp.getWidth() >= srcBmp.getHeight()) {
            dstBmp = Bitmap.createBitmap(
                    srcBmp,
                    srcBmp.getWidth() / 2 - srcBmp.getHeight() / 2,
                    0,
                    srcBmp.getHeight(),
                    srcBmp.getHeight()
            );
        } else {
            dstBmp = Bitmap.createBitmap(
                    srcBmp,
                    0,
                    srcBmp.getHeight() / 2 - srcBmp.getWidth() / 2,
                    srcBmp.getWidth(),
                    srcBmp.getWidth()
            );
        }
        return dstBmp;
    }

    private void updateViewDependencies(View view) {
        mImageViewPhoto = (ImageView) view.findViewById(R.id.image_view_photo_user);
        mImageViewPhoto.setOnClickListener(this);
        mEditTextName = (EditText) view.findViewById(R.id.edit_text_name);
        mEditTextPassword = (EditText) view.findViewById(R.id.edit_text_password);
        mEditTextEmail = (EditText) view.findViewById(R.id.edit_text_email);
        mEditTextTelephoneNumber = (EditText) view.findViewById(R.id.edit_text_phone_number);

        view.findViewById(R.id.button_registration).setOnClickListener(this);
        view.findViewById(R.id.button_back).setOnClickListener(this);
    }
}
