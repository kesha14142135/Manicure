package com.forste.manicure.present;

import com.forste.manicure.contract.ForgotPasswordContract;
import com.forste.manicure.data.ForgotPasswordBaseDataSource;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class ForgotPasswordPresenter implements ForgotPasswordContract.Presenter {

    private ForgotPasswordContract.View mView;
    ForgotPasswordBaseDataSource mDataSource;

    @Override
    public void sandMail(String mail) {
        mDataSource.sandMail(mail, new ForgotPasswordBaseDataSource.CallBackMailSand() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure(String massage) {

            }
        });
    }

    @Override
    public void attachView(ForgotPasswordContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
