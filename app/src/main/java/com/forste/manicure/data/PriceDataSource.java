package com.forste.manicure.data;

import com.forste.manicure.model.Price;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergejkozin on 7/17/17.
 */

public class PriceDataSource implements PriceBaseDataSource {

    @Override
    public void getPrices(CallBackPrice callBack) {
        List<Price> prices = new ArrayList<>();
        prices.add(new Price("Обрезно маникюр", 120, 2));
        prices.add(new Price("Обрезно маникюр", 120, 2));
        prices.add(new Price("Обрезно маникюр", 120, 2));
        prices.add(new Price("Обрезно маникюр", 120, 2));
        prices.add(new Price("Обрезно маникюр", 120, 2));
        callBack.onSuccess(prices);
    }
}
