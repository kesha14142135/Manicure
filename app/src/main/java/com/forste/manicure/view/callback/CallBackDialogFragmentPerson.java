package com.forste.manicure.view.callback;

import com.forste.manicure.model.Person;

/**
 * Created by sergejkozin on 7/10/17.
 */

public interface CallBackDialogFragmentPerson {

    void clickButtonChangePersonData(String name, String telephoneNumber, String email);

    void clickButtonDoNotChangePersonData();
}
