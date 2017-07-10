package com.forste.manicure.contract;

import com.forste.manicure.model.News;

import java.util.List;

/**
 * Created by sergejkozin on 7/7/17.
 */

public interface NewsFeedContract {
    interface View extends BaseContract.View {
        void getNewsFeeds(List<News> newses);

    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getAllNewsFeed();
    }
}
