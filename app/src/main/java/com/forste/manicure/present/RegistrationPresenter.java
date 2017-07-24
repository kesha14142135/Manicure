package com.forste.manicure.present;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.forste.manicure.R;
import com.forste.manicure.SessionManager;
import com.forste.manicure.contract.RegistrationContract;
import com.forste.manicure.data.RegistrationBaseDataSource;
import com.forste.manicure.data.RegistrationDataSource;
import com.forste.manicure.model.Constant;
import com.forste.manicure.model.Person;
import com.forste.manicure.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter, RegistrationBaseDataSource.CallBackUserRegistration, RegistrationBaseDataSource.CallBackPersonRegistration, RegistrationBaseDataSource.CallBackPhoto {

    private RegistrationContract.View mView;
    private RegistrationBaseDataSource mDataSource;
    private Person mPerson;
    private SessionManager mSessionManager;

    @Override
    public void registration(Person person, String password) {
        mPerson = person;
        mDataSource = new RegistrationDataSource();
        if (!mSessionManager.userAuthorized()) {
            mDataSource.userRegistration(new User(person.getTelephoneNumber(), password), this);
        } else {
            onSuccessRegistrationUser();
        }
    }

    @Override
    public void attachView(RegistrationContract.View view) {
        mView = view;
        mSessionManager = new SessionManager(mView.getContext());
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onSuccessRegistrationUser() {
        mSessionManager.createLoginSession(mSessionManager.userToken());
        mDataSource.userAdditionalRegistration(mPerson, mSessionManager.userToken(), this);
    }

    @Override
    public void onFailureRegistrationUser() {
        mView.showError(mView.getContext().getResources().getString(R.string.error_registration_user));
    }

    @Override
    public void onSuccessRegistrationPerson() {
        mSessionManager.createLoginSession(mSessionManager.userToken());
        mDataSource.addUserPhoto(mView.getContext(), mPerson, mSessionManager.userToken(), this);

    }

    @Override
    public void onFailureRegistrationPerson() {
        mView.showError(mView.getContext().getResources().getString(R.string.error_additional_registration_person));
    }

    @Override
    public void onSuccessPhoto() {
        mView.registrationSuccessful();
    }

    @Override
    public void onFailurePhoto() {
        mView.showError(mView.getContext().getResources().getString(R.string.error_user_photo));
    }
}
