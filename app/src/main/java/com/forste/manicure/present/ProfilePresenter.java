package com.forste.manicure.present;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.forste.manicure.R;
import com.forste.manicure.contract.ProfileContract;
import com.forste.manicure.data.ProfileBaseDataSource;
import com.forste.manicure.data.ProfileDataSource;
import com.forste.manicure.model.ManicureRecord;
import com.forste.manicure.model.ManicureService;
import com.forste.manicure.model.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by sergejkozin on 7/12/17.
 */

public class ProfilePresenter implements ProfileContract.Presenter {

    private Context mContext;
    private ProfileContract.View mView;
    private List<ManicureRecord> mRecords;
    private ProfileBaseDataSource mDataSource;
    private Person mPerson;

    @Override
    public void attachView(ProfileContract.View view) {
        mView = view;
        mContext = view.getContext();
        mDataSource = new ProfileDataSource();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getManicureRecord() {
        mRecords = new ArrayList<>();
        mRecords.add(new ManicureRecord(new GregorianCalendar(2017, 11, 22, 10, 15), new ManicureService(0, "Обрезно маникюр", 120)));
        mRecords.add(new ManicureRecord(new GregorianCalendar(2016, 11, 22, 10, 15), new ManicureService(0, "Педикюр", 100)));
        mRecords.add(new ManicureRecord(new GregorianCalendar(2016, 10, 22, 11, 15), new ManicureService(0, "Обрезно маникюр", 120)));
        mRecords.add(new ManicureRecord(new GregorianCalendar(2016, 9, 22, 10, 15), new ManicureService(0, "Обрезно маникюр", 120)));
        mRecords.add(new ManicureRecord(new GregorianCalendar(2016, 8, 22, 12, 15), new ManicureService(0, "Обрезно маникюр", 120)));
        mRecords.add(new ManicureRecord(new GregorianCalendar(2016, 7, 22, 10, 15), new ManicureService(0, "Обрезно маникюр", 120)));
        mView.getAllManicureRecord(mRecords);
    }

    @Override
    public void getCurrentPersonData() {
        Bitmap bitmap = BitmapFactory.decodeResource(mView.getContext().getResources(), R.drawable.manicure_first);
        mPerson = new Person("Саша", "0974216279", "kozinsergej@gmail.com", bitmap);
        mView.getPerson(mPerson);
    }

    @Override
    public void changPersonData(Person person) {
        if (person.equals(mPerson)) {
            mDataSource.changePersonData(person, new ProfileBaseDataSource.CallBackChange() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onFailure() {
                    //mView.showError();
                }
            });
        }
        mPerson = person;
    }

    @Override
    public void changPhoto(Bitmap photo) {

    }

}
