package com.forste.manicure.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.contract.ProfileContract;
import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.Person;
import com.forste.manicure.present.ProfilePresenter;
import com.forste.manicure.view.adapter.RecordAdapter;
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
    private RecyclerView mRecyclerView;
    private RecordAdapter mAdapter;


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
        mAdapter = new RecordAdapter(mView.getContext(), null);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter = new ProfilePresenter();
        mPresenter.attachView(this);
        mPresenter.getCurrentPersonData();
        mPresenter.getManicureRecord();
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
        Snackbar.make(mView.findViewById(R.id.relative_layout_fragment_profile), message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void getAllManicureRecord(List<ManicureRecord> manicureRecordList) {
        mAdapter.update(manicureRecordList);
    }

    @Override
    public void getPerson(Person person) {
        mTextViewName.setText(person.getName());
        mTextViewMail.setText(person.getEmail());
        mTextViewTelephoneNumber.setText(person.getTelephoneNumber());
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

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_record);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_open_fragment_dialog_to_change_person_data) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            DialogFragment fragmentDialog = ChangePersonDataFragmentDialog.newInstance(
                    new Person(
                            mTextViewName.getText().toString(),
                            mTextViewTelephoneNumber.getText().toString(),
                            mTextViewMail.getText().toString())
            );
            fragmentDialog.setTargetFragment(this, 0);
            fragmentDialog.onAttachFragment(this);
            fragmentDialog.show(fragmentTransaction, "dialog");
        }
    }

    @Override
    public void clickButtonChangePersonData(Person person) {
        mPresenter.changPersonData(person);
        mTextViewName.setText(person.getName());
        mTextViewTelephoneNumber.setText(person.getTelephoneNumber());
        mTextViewMail.setText(person.getEmail());
    }

    @Override
    public void clickButtonDoNotChangePersonData() {

    }
}
