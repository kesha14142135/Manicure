package com.forste.manicure.contract;

import android.graphics.Bitmap;

import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.Person;

import java.util.List;

/**
 * Created by sergejkozin on 7/8/17.
 */

public interface ProfileContract {
    interface View extends BaseContract.View {

        void getAllManicureRecord(List<ManicureRecord> manicureRecordList);

        void getPerson(Person person);

        void changedCreate(String message);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void getManicureRecord();

        void getCurrentPersonData();

        void changName(String name);

        void changPhoto(Bitmap photo);

        void changTelephoneNumber(String telephoneNumber);

        void changPassword(String password);
    }
}
