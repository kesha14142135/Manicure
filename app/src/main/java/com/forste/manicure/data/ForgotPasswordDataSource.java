package com.forste.manicure.data;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class ForgotPasswordDataSource implements ForgotPasswordBaseDataSource {
    @Override
    public void sandMail(String mail, CallBackMailSand callBack) {
        callBack.onSuccess();
    }
}
