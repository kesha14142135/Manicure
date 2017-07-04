package com.forste.manicure.data;

import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/3/17.
 */

public interface AuthorizationBaseDataSource {
    void userVerification(User user, CallBackVerification callBack);

    interface CallBackVerification {
        void onSuccess();

        void onFailure(String message);
    }
}
