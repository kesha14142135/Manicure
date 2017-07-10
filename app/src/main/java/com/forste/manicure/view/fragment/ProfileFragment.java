package com.forste.manicure.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.contract.ProfileContract;
import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.Person;
import com.forste.manicure.view.callback.CallBackActivityFragment;
import com.forste.manicure.view.callback.CallBackDialogFragmentPerson;
import com.forste.manicure.view.fragment.dialog.ChangePersonDataFragmentDialog;

import java.util.List;


public class ProfileFragment extends Fragment implements ProfileContract.View, View.OnClickListener, CallBackDialogFragmentPerson {
    private ProfileContract.Presenter mPresenter;
    private View mView;
    private ImageView mImageViewPhoto;
    private TextView mTextViewName;
    private TextView mTextViewTelephoneNumber;
    private TextView mTextViewMail;


    public static ProfileFragment newInstance(CharSequence text, CharSequence mTextViewTelephoneNumberText, CharSequence mTextViewMailText) {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        updateViewDependencies(mView);
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getAllManicureRecord(List<ManicureRecord> manicureRecordList) {

    }

    @Override
    public void getPerson(Person person) {

    }

    @Override
    public void changedCreate(String message) {

    }

    private void updateViewDependencies(View view) {
        view.findViewById(R.id.button_open_fragment_dialog_to_change_person_data).setOnClickListener(this);
        mImageViewPhoto = (ImageView) view.findViewById(R.id.image_view_photo_profile);
        mTextViewName = (TextView) view.findViewById(R.id.text_view_name);
        mTextViewTelephoneNumber = (TextView) view.findViewById(R.id.text_view_telephone_number);
        mTextViewMail = (TextView) view.findViewById(R.id.text_view_email);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_open_fragment_dialog_to_change_person_data) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            DialogFragment fragmentDialog = ChangePersonDataFragmentDialog.newInstance(
                    mTextViewName.getText().toString(),
                    mTextViewTelephoneNumber.getText().toString(),
                    mTextViewMail.getText().toString()
            );
            fragmentDialog.setTargetFragment(this,0);
            fragmentDialog.onAttachFragment(this);
            fragmentDialog.show(fragmentTransaction, "dialog");
        }
    }

    @Override
    public void clickButtonChangePersonData(String name, String telephoneNumber, String email) {

    }

    @Override
    public void clickButtonDoNotChangePersonData() {

    }
}
