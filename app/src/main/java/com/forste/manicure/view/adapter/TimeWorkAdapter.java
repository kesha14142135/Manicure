package com.forste.manicure.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.forste.manicure.R;
import com.forste.manicure.view.callback.CallBackAdapterTime;

import java.util.List;

/**
 * Created by sergejkozin on 7/18/17.
 */

public class TimeWorkAdapter extends ArrayAdapter<Boolean> {
    private Context mContext;
    private int mLayoutResourceId;
    private List<Boolean> mTimeWork;
    private String[] mTime;
    private CallBackAdapterTime mCallBack;

    public TimeWorkAdapter(Context context, int layoutResourceId, List<Boolean> data, CallBackAdapterTime callBack) {
        super(context, layoutResourceId, data);
        mLayoutResourceId = layoutResourceId;
        mContext = context;
        mTimeWork = data;
        mCallBack = callBack;
        mTime = context.getResources().getStringArray(R.array.time_array);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        RecordHolder holder;
        if (view == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            view = inflater.inflate(mLayoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.buttonHour = (Button) view.findViewById(R.id.button_time_work);
            view.setTag(holder);
        } else {
            holder = (RecordHolder) view.getTag();
        }

        holder.buttonHour.setText(mTime[position]);
        if (mTimeWork.get(position)) {
            holder.buttonHour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.onClick(position);
                }
            });
        } else {
            holder.buttonHour.setAlpha((float) 0.3);
        }
        return view;
    }

    static class RecordHolder {
        Button buttonHour;
    }
}

