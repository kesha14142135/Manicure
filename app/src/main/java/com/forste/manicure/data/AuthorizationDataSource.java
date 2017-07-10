package com.forste.manicure.data;

import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class AuthorizationDataSource implements AuthorizationBaseDataSource {
    @Override
    public void userVerification(User user, CallBackVerification callBack) {
        callBack.onSuccess("sfj3r034r309we0wef9fwf3ff3r34f");
    }
}
