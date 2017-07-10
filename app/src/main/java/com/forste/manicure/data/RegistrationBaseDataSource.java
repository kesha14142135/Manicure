package com.forste.manicure.data;

import com.forste.manicure.model.Person;
import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/3/17.
 */

public interface RegistrationBaseDataSource {
    void userRegistration(Person person, CallBackRegistration callBack);

    interface CallBackRegistration {
        void onSuccess(String token);

        void onFailure(String message);
    }
}
