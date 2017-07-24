package com.forste.manicure.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.contract.MasterProfileContract;
import com.forste.manicure.model.Master;
import com.forste.manicure.present.MasterProfilePresenter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MasterProfileFragment extends Fragment implements View.OnClickListener, MasterProfileContract.View, OnMapReadyCallback {

    private View mView;
    private ImageView mImageViewMasterPhoto;
    private TextView mTextViewNameMaster;
    private TextView mTextViewDescription;
    private MasterProfileContract.Presenter mPresenter;
    private GoogleMap mMap;

    public MasterProfileFragment() {
    }

    public static MasterProfileFragment newInstance() {
        MasterProfileFragment fragment = new MasterProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_master_profile, container, false);
        updateViewDependencies(mView);
        mPresenter = new MasterProfilePresenter();
        mPresenter.attachView(this);
        mPresenter.getMasterData();
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

    private void updateViewDependencies(View view) {
        view.findViewById(R.id.image_view_instagram).setOnClickListener(this);
        view.findViewById(R.id.image_view_phone).setOnClickListener(this);
        mImageViewMasterPhoto = (ImageView) view.findViewById(R.id.image_view_master);
        mTextViewNameMaster = (TextView) view.findViewById(R.id.text_view_master_name);
        mTextViewDescription = (TextView) view.findViewById(R.id.text_view_about_master);
        SupportMapFragment map = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map));
        map.getMapAsync(this);
    }

    private void callMaster() {
        String uri = getResources().getString(R.string.tel)
                + getResources().getString(R.string.telephone_number_master).trim();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    private void openInstagram() {
        Uri uri = Uri.parse(getResources().getString(R.string.instagram_master_path));
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage(getResources().getString(R.string.instagram_path));
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(getResources().getString(R.string.instagram_master_path))));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_view_instagram: {
                openInstagram();
                break;
            }
            case R.id.image_view_phone: {
                callMaster();
                break;
            }
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getMasterProfileData(Master master) {
        mTextViewNameMaster.setText(master.getName());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
