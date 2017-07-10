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

import java.util.List;

/**
 * Created by sergejkozin on 7/7/17.
 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder> {

    private Context mContext;
    private List<News> mNewses;

    public NewsFeedAdapter(Context context, List<News> newses) {
        mContext = context;
        mNewses = newses;
    }

    @Override
    public NewsFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_news_feed, parent, false);

        return new NewsFeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsFeedViewHolder holder, int position) {
        holder.mTextViewNewsFeed.setText(mNewses.get(position).getDate().toString());
        if (mNewses.get(position).getImageFirst() != null)
        holder.mImageViewManicureFirst.setImageBitmap(mNewses.get(position).getImageFirst());
        if (mNewses.get(position).getImageSecond() != null)
            holder.mImageViewManicureSecond.setImageBitmap(mNewses.get(position).getImageSecond());

    }

    @Override
    public int getItemCount() {
        return mNewses.size();
    }

    public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewNewsFeed;
        private ImageView mImageViewManicureFirst;
        private ImageView mImageViewManicureSecond;

        public NewsFeedViewHolder(View itemView) {
            super(itemView);
            mTextViewNewsFeed = (TextView) itemView.findViewById(R.id.text_view_data_of_creation_of_manicure);
            mImageViewManicureFirst = (ImageView) itemView.findViewById(R.id.image_view_first_manicure);
            mImageViewManicureSecond = (ImageView) itemView.findViewById(R.id.image_view_second_manicure);
        }
    }
}
