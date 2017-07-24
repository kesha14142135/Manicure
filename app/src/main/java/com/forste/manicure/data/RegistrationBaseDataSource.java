package com.forste.manicure.data;

import android.content.Context;

import com.forste.manicure.model.Person;
import com.forste.manicure.model.User;
import com.forste.manicure.present.RegistrationPresenter;
import com.google.android.gms.tasks.OnFailureListener;

/**
 * Created by sergejkozin on 7/3/17.
 */

public interface RegistrationBaseDataSource {

    void userRegistration(User user, CallBackUserRegistration callBack);

    interface CallBackUserRegistration {
        void onSuccessRegistrationUser();

        void onFailureRegistrationUser();
    }

    void userAdditionalRegistration(Person person, String token, CallBackPersonRegistration callBack);

    interface CallBackPersonRegistration {

        void onSuccessRegistrationPerson();

        void onFailureRegistrationPerson();
    }

    void addUserPhoto(Context context, Person person, String token, CallBackPhoto callBack);

    interface CallBackPhoto {

        void onSuccessPhoto();

        void onFailurePhoto();
    }
}
