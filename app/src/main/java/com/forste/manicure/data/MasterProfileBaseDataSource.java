package com.forste.manicure.data;

import com.forste.manicure.model.Master;

/**
 * Created by sergejkozin on 7/17/17.
 */

public interface MasterProfileBaseDataSource {
    void getMasterData(CallBackMasterProfile callBack);

    interface CallBackMasterProfile {
        void onSuccess(Master master);

        void onFailure();
    }
}
