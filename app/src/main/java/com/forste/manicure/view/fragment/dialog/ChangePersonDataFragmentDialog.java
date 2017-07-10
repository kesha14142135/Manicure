package com.forste.manicure.view.fragment.dialog;

import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.forste.manicure.R;

import com.forste.manicure.view.callback.CallBackDialogFragmentPerson;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

/**
 * Created by sergejkozin on 7/10/17.
 */

public class ChangePersonDataFragmentDialog extends DialogFragment implements View.OnClickListener, Validator.ValidationListener {

    private View mView;
    private TextView mTextViewTitle;

    @NotEmpty(messageResId = R.string.error_email_empty)
    @Email(messageResId = R.string.error_not_email)
    private EditText mEditTextEmail;

    @NotEmpty(messageResId = R.string.error_name_empty)
    private EditText mEditTextName;

    @NotEmpty(messageResId = R.string.error_telephone_number_empty)
    @Password(min = 9, scheme = Password.Scheme.NUMERIC, messageResId = R.string.error_telephone_number_min)
    private EditText mEditTextTelephoneNumber;

    private Validator mValidator;
    private CallBackDialogFragmentPerson mCallBack;
    private static String NAME = "NAME";
    private static String PHONE = "TELEPHONE_NUMBER";
    private static String EMAIL = "EMAIL";

    public static ChangePersonDataFragmentDialog newInstance(String name, String phoneNumber, String email) {
        ChangePersonDataFragmentDialog fragment = new ChangePersonDataFragmentDialog();
        Bundle args = new Bundle();
        args.putString(NAME, name);
        args.putString(PHONE, phoneNumber);
        args.putString(EMAIL, email);
        fragment.setArguments(args);
        return fragment;
    }

    public ChangePersonDataFragmentDialog() {
    }

    public void setDialogTitle(String title) {
        mTextViewTitle.setText(title);
    }

    @Override
    public void setStyle(int style, @StyleRes int theme) {
        super.setStyle(style, theme);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        mCallBack = (CallBackDialogFragmentPerson)childFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(
                R.layout.fragment_dialog_chang_person, container);

        updateViewDependencies(mView);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        return mView;
    }

    private void updateViewDependencies(View view) {
        mTextViewTitle = (TextView) view.findViewById(R.id.text_view_dialog_title);
        mEditTextName = (EditText) view.findViewById(R.id.edit_text_name);
        mEditTextTelephoneNumber = (EditText) view.findViewById(R.id.edit_text_telephone_number);
        mEditTextEmail = (EditText) view.findViewById(R.id.edit_text_email);
        view.findViewById(R.id.button_change_person_data).setOnClickListener(this);
        view.findViewById(R.id.button_do_not_change_person_data).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_change_person_data: {
                mValidator.validate();
                dismiss();
                break;
            }
            case R.id.button_do_not_change_person_data: {
                mCallBack.clickButtonDoNotChangePersonData();
                dismiss();
                break;
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        mCallBack.clickButtonChangePersonData(
                mEditTextName.getText().toString(),
                mEditTextTelephoneNumber.getText().toString(),
                mEditTextEmail.getText().toString()
        );
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(view.getContext());
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Snackbar.make(mView.findViewById(R.id.relative_layout_authorization), message, Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }
}
