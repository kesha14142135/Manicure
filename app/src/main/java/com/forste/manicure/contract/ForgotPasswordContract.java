package com.forste.manicure.contract;

/**
 * Created by sergejkozin on 7/3/17.
 */

public interface ForgotPasswordContract {

    interface View extends BaseContract.View {
        void onSuccess();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void sandMail(String mail);
    }

}
