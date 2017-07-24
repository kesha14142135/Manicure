package com.forste.manicure.present;

import com.forste.manicure.contract.MasterProfileContract;
import com.forste.manicure.data.MasterProfileBaseDataSource;
import com.forste.manicure.data.MasterProfileDataSource;
import com.forste.manicure.model.Master;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class MasterProfilePresenter implements MasterProfileContract.Presenter {
    private MasterProfileContract.View mView;
    private MasterProfileBaseDataSource mDataSource;

    @Override
    public void attachView(MasterProfileContract.View view) {
        mView = view;
        mDataSource = new MasterProfileDataSource();
    }


    @Override
    public void detachView() {

    }

    @Override
    public void getMasterData() {
        mDataSource.getMasterData(new MasterProfileBaseDataSource.CallBackMasterProfile() {
            @Override
            public void onSuccess(Master master) {
                mView.getMasterProfileData(master);
            }

            @Override
            public void onFailure() {
            }
        });
    }
}
