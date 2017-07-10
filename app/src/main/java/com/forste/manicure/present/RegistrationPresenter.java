package com.forste.manicure.present;

import android.content.Context;
import android.content.SharedPreferences;

import com.forste.manicure.R;
import com.forste.manicure.contract.RegistrationContract;
import com.forste.manicure.data.RegistrationBaseDataSource;
import com.forste.manicure.data.RegistrationDataSource;
import com.forste.manicure.model.Person;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class RegistrationPresenter implements RegistrationContract.Presenter {

    private static final String STORAGE_NAME = "USER_TOKEN";
    private RegistrationContract.View mView;
    private RegistrationBaseDataSource mDataSource;
    private SharedPreferences mSharedPreferencesToken;

    @Override
    public void registration(Person person) {
        mDataSource = new RegistrationDataSource();
        mDataSource.userRegistration(person,
                new RegistrationBaseDataSource.CallBackRegistration() {
                    @Override
                    public void onSuccess(String token) {
                        mView.registrationSuccessful();
                    }

                    @Override
                    public void onFailure(String message) {
                        mView.showError(message);
                    }
                });
    }

    @Override
    public void attachView(RegistrationContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
