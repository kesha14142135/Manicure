package com.forste.manicure.contract;

import com.forste.manicure.model.Master;

import java.util.List;

/**
 * Created by sergejkozin on 7/17/17.
 */

public interface MasterProfileContract {
    interface View extends BaseContract.View {
        void getMasterProfileData(Master master);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getMasterData();
    }
}
