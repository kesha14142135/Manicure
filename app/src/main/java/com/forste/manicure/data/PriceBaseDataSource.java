package com.forste.manicure.data;

import com.forste.manicure.model.Price;

import java.util.List;

/**
 * Created by sergejkozin on 7/17/17.
 */

public interface PriceBaseDataSource {

    void getPrices(CallBackPrice callBack);

    interface CallBackPrice {
        void onSuccess(List<Price> prices);

        void onFailure();
    }
}
