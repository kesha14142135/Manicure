package com.forste.manicure.present;

import com.forste.manicure.R;
import com.forste.manicure.contract.ForgotPasswordContract;
import com.forste.manicure.data.ForgotPasswordBaseDataSource;
import com.forste.manicure.data.ForgotPasswordDataSource;

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
                mView.onSuccess();
            }

            @Override
            public void onFailure() {
                mView.showError(mView.getContext().getString(R.string.error_change_password));
            }
        });
    }

    @Override
    public void attachView(ForgotPasswordContract.View view) {
        mView = view;
        mDataSource = new ForgotPasswordDataSource();
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
