package com.forste.manicure.data;

import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.Person;

import java.util.List;

/**
 * Created by sergejkozin on 7/13/17.
 */

public interface ProfileBaseDataSource {
    void getPersonData(int idUser, CallBackPerson callBackPerson);

    interface CallBackPerson {
        void onSuccess(Person person);

        void onFailure();
    }

    void getAllRecord(int idUser, CallBackRecords callBackRecords);

    interface CallBackRecords {
        void onSuccess(List<ManicureRecord> manicureRecords);

        void onFailure();
    }

    void changePersonData(Person person, CallBackChange callBackChange);

    void deleteRecord(ManicureRecord manicureRecord, CallBackChange callBackChange);

    interface CallBackChange {
        void onSuccess();

        void onFailure();
    }

}
