package com.forste.manicure.present;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.forste.manicure.R;
import com.forste.manicure.contract.NewsFeedContract;
import com.forste.manicure.data.NewsFeedBaseDataSource;
import com.forste.manicure.data.NewsFeedDataSource;
import com.forste.manicure.model.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class NewsFeedPresenter implements NewsFeedContract.Presenter {

    private NewsFeedContract.View mView;
    private NewsFeedBaseDataSource mData;

    @Override
    public void attachView(NewsFeedContract.View view) {
        mView = view;
        mData = new NewsFeedDataSource();

    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void getAllNewsFeed() {
        List<News> news = new ArrayList<>();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(mView.getContext().getResources(), R.drawable.manicure_first);
        Bitmap bitmapSecond = BitmapFactory.decodeResource(mView.getContext().getResources(), R.drawable.manicure_first);
        news.add(new News(new Date(2017, 3, 21), bitmap, bitmapSecond));
        news.add(new News(new Date(2017, 3, 22), bitmap, bitmapSecond));
        news.add(new News(new Date(2017, 3, 23), bitmap, bitmapSecond));
        news.add(new News(new Date(2017, 3, 24), bitmap, bitmapSecond));
        mView.getNewsFeeds(news);
    }
}
