package com.forste.manicure.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.forste.manicure.R;
import com.forste.manicure.contract.PriceContract;
import com.forste.manicure.model.Price;
import com.forste.manicure.present.PricePresenter;
import com.forste.manicure.view.adapter.NewsFeedAdapter;
import com.forste.manicure.view.adapter.PriceAdapter;

import java.util.List;

public class PriceFragment extends Fragment implements PriceContract.View {

    private View mView;
    private PriceContract.Presenter mPresenter;
    private PriceAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public PriceFragment() {
    }

    public static PriceFragment newInstance() {
        PriceFragment fragment = new PriceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_price, container, false);
        updateViewDependencies(mView);
        mPresenter = new PricePresenter();
        mPresenter.attachView(this);
        mPresenter.getAllPriceRecords();
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
        Snackbar.make(mView.findViewById(R.id.relative_layout_price), message, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showAllPriceRecords(List<Price> prices) {
        mAdapter = new PriceAdapter(mView.getContext(), prices);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void updateViewDependencies(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_price);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
