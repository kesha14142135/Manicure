package com.forste.manicure.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.model.ManicureRecord;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {

    private Context mContext;
    private List<ManicureRecord> mRecords;

    public RecordAdapter(Context context, List<ManicureRecord> records) {
        mContext = context;
        mRecords = records;
    }

    public void update(List<ManicureRecord> records) {
        if (mRecords != null) {
            mRecords.clear();
        } else {
            mRecords = new ArrayList<>();
        }
        mRecords.addAll(records);
        notifyDataSetChanged();
    }

    @Override
    public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recicler_view_record, parent, false);
        return new RecordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecordViewHolder holder, int position) {
        holder.mTextViewRecordName.setText(mRecords.get(position).getManicureService().getName());
        holder.mTextViewRecordDate.setText(mRecords.get(position).recordDate());
        holder.mTextViewRecordTime.setText(mRecords.get(position).recordTime());
        if (mRecords.get(position).currentTimeIsShorter()) {
            holder.mImageViewFireRecord.setImageResource(R.drawable.ic_fire_active);
            holder.mButtonRecordCheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            holder.mButtonRecordDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  }
            });
        } else {
            holder.mImageViewFireRecord.setImageResource(R.drawable.ic_fire_no_active);
            holder.mButtonRecordCheng.setVisibility(View.INVISIBLE);
            holder.mButtonRecordDelete.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public int getItemCount() {
        return mRecords != null ? mRecords.size() : 0;
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder {


        private ImageView mImageViewFireRecord;
        private TextView mTextViewRecordName;
        private TextView mTextViewRecordDate;
        private TextView mTextViewRecordTime;
        private Button mButtonRecordCheng;
        private Button mButtonRecordDelete;

        public RecordViewHolder(View itemView) {
            super(itemView);
            mImageViewFireRecord = (ImageView) itemView.findViewById(R.id.image_view_fire_record);
            mTextViewRecordName = (TextView) itemView.findViewById(R.id.text_view_record_name);
            mTextViewRecordDate = (TextView) itemView.findViewById(R.id.text_view_record_date);
            mTextViewRecordTime = (TextView) itemView.findViewById(R.id.text_view_record_time);
            mButtonRecordCheng = (Button) itemView.findViewById(R.id.button_chenge_record);
            mButtonRecordDelete = (Button) itemView.findViewById(R.id.button_delete_record);
        }
    }
}
