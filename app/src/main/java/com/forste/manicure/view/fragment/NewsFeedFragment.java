package com.forste.manicure.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forste.manicure.R;
import com.forste.manicure.contract.NewsFeedContract;
import com.forste.manicure.model.News;
import com.forste.manicure.present.NewsFeedPresenter;
import com.forste.manicure.view.adapter.NewsFeedAdapter;

import java.util.List;

public class NewsFeedFragment extends Fragment implements NewsFeedContract.View {

    private RecyclerView mRecyclerView;
    private NewsFeedAdapter mAdapter;
    private NewsFeedContract.Presenter mPresenter;
    private View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_news_feed, container, false);
        mPresenter = new NewsFeedPresenter();
        mPresenter.attachView(this);
        updateViewDependencies(mView);
        mPresenter.getAllNewsFeed();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mView.findViewById(R.id.relative_layout_news_feed), message, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void getNewsFeeds(List<News> newses) {
        mAdapter = new NewsFeedAdapter(mView.getContext(), newses);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void updateViewDependencies(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_news_feed);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
