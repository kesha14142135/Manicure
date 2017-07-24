package com.forste.manicure.data;

import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.Person;

/**
 * Created by sergejkozin on 7/13/17.
 */

public class ProfileDataSource implements ProfileBaseDataSource {

    @Override
    public void getPersonData(int idUser, CallBackPerson callBackPerson) {

    }

    @Override
    public void getAllRecord(int idUser, CallBackRecords callBackRecords) {

    }

    @Override
    public void changePersonData(Person person, CallBackChange callBackChange) {

    }

    @Override
    public void deleteRecord(ManicureRecord manicureRecord, CallBackChange callBackChange) {

    }
}
