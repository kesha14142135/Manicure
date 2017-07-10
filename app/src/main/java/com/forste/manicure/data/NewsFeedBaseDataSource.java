package com.forste.manicure.data;

import com.forste.manicure.model.News;

import java.util.Date;
import java.util.List;

/**
 * Created by sergejkozin on 7/8/17.
 */

public interface NewsFeedBaseDataSource {

    void getNews(CallBackNews callBack);

    void getNewsFromLastData(Date data);

    interface CallBackNews {

        void onSuccess(List<News> news, CallBackNews callBack);

        void onFailure();
    }
}
