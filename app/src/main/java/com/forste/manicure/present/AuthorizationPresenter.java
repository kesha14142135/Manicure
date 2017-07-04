package com.forste.manicure.present;

import com.forste.manicure.contract.AuthorizationContract;
import com.forste.manicure.data.AuthorizationBaseDataSource;
import com.forste.manicure.data.AuthorizationDataSource;
import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class AuthorizationPresenter implements AuthorizationContract.Presenter {

    private AuthorizationContract.View mView;
    private AuthorizationBaseDataSource mDataSource;

    @Override
    public void authorization(User user) {
        mDataSource = new AuthorizationDataSource();
        mDataSource.userVerification(user,
                new AuthorizationBaseDataSource.CallBackVerification() {
                    @Override
                    public void onSuccess() {
                        mView.authorizationWasSuccessful();
                    }

                    @Override
                    public void onFailure(String message) {
                        mView.showError(message);
                    }
                });
    }

    @Override
    public void attachView(AuthorizationContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
