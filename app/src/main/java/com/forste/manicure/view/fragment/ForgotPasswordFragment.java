package com.forste.manicure.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forste.manicure.R;
import com.forste.manicure.contract.ForgotPasswordContract;
import com.forste.manicure.data.ForgotPasswordBaseDataSource;
import com.forste.manicure.present.ForgotPasswordPresenter;

public class ForgotPasswordFragment extends Fragment implements ForgotPasswordContract.View {

    ForgotPasswordContract.Presenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new ForgotPasswordPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_forgot_password, container, false);
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
    public void onSuccess() {

    }

    @Override
    public void showError(String message) {

    }
}
