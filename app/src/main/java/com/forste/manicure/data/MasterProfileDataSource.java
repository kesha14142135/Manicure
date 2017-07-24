package com.forste.manicure.data;

import android.graphics.Bitmap;

import com.forste.manicure.contract.MasterProfileContract;
import com.forste.manicure.model.Master;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class MasterProfileDataSource implements MasterProfileBaseDataSource {
    @Override
    public void getMasterData(CallBackMasterProfile callBack) {
        Master master = new Master("Дарья Митрофанова","Лучшая","0974216279","dasha",null);
        callBack.onSuccess(master);
    }
}
