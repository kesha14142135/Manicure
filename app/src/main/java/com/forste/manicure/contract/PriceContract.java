package com.forste.manicure.contract;

import com.forste.manicure.model.Price;

import java.util.List;

/**
 * Created by sergejkozin on 7/17/17.
 */

public interface PriceContract {
    interface View extends BaseContract.View {
        void showAllPriceRecords(List<Price> prices);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getAllPriceRecords();
    }
}
