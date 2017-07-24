package com.forste.manicure.contract;

import com.forste.manicure.model.Person;
import com.forste.manicure.model.User;

/**
 * Created by sergejkozin on 7/2/17.
 */

public interface RegistrationContract {
    interface View extends BaseContract.View {
        void registrationSuccessful();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void registration(Person person, String password);
    }
}
