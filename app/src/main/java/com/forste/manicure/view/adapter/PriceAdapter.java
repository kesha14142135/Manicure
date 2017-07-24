package com.forste.manicure.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.forste.manicure.R;
import com.forste.manicure.model.News;
import com.forste.manicure.model.Price;

import java.util.List;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceViewHolder> {

    private Context mContext;
    private List<Price> mPrices;

    public PriceAdapter(Context context, List<Price> prices) {
        mContext = context;
        mPrices = prices;
    }

    @Override
    public PriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recicler_view_price, parent, false);

        return new PriceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PriceViewHolder holder, int position) {
        holder.mTextViewNameManicure.setText(mPrices.get(position).getName());
        holder.mTextViewPriceManicure.setText(String.valueOf(mPrices.get(position).getCost()));
        holder.mTextViewTimeManicure.setText(String.valueOf(mPrices.get(position).getTime()));
    }

    @Override
    public int getItemCount() {
        return mPrices.size();
    }

    public class PriceViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewNameManicure;
        private TextView mTextViewPriceManicure;
        private TextView mTextViewTimeManicure;

        public PriceViewHolder(View itemView) {
            super(itemView);
            mTextViewNameManicure = (TextView) itemView.findViewById(R.id.text_view_name_of_the_manicure);
            mTextViewPriceManicure = (TextView) itemView.findViewById(R.id.text_view_price_of_the_manicure);
            mTextViewTimeManicure = (TextView) itemView.findViewById(R.id.text_view_time_of_the_manicure);
        }
    }
}
