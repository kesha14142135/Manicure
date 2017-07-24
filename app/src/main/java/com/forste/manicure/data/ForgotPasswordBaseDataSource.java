package com.forste.manicure.data;

/**
 * Created by sergejkozin on 7/3/17.
 */

public interface ForgotPasswordBaseDataSource {
    void sandMail(String mail,CallBackMailSand callBack);

    interface CallBackMailSand {
        void onSuccess();

        void onFailure();
    }
}
