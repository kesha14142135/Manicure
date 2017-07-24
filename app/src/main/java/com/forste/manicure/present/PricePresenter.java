package com.forste.manicure.present;

import android.content.Context;
import android.view.View;

import com.forste.manicure.contract.BaseContract;
import com.forste.manicure.contract.PriceContract;
import com.forste.manicure.data.PriceBaseDataSource;
import com.forste.manicure.data.PriceDataSource;
import com.forste.manicure.model.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class PricePresenter implements PriceContract.Presenter {

    private PriceContract.View mView;
    private Context mContext;
    private List<Price> mPrices;
    private PriceBaseDataSource mDataSource;

    @Override
    public void attachView(PriceContract.View view) {
        mView = view;
        mContext = view.getContext();
        mDataSource = new PriceDataSource();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getAllPriceRecords() {
        mDataSource.getPrices(new PriceBaseDataSource.CallBackPrice() {
            @Override
            public void onSuccess(List<Price> prices) {
                mPrices = prices;
                mView.showAllPriceRecords(prices);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
