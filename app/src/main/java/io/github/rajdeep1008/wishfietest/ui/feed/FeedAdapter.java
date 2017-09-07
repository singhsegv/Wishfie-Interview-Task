package io.github.rajdeep1008.wishfietest.ui.feed;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.rajdeep1008.wishfietest.R;
import io.github.rajdeep1008.wishfietest.model.Post;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private ArrayList<Post> feedItemsList;
    private Context context;

    public FeedAdapter(List<Post> feedItemsList, Context context) {
        this.feedItemsList = new ArrayList<>(feedItemsList);
        this.context = context;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_feed_item, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.IdTextView.setText(feedItemsList.get(position).getId());
        Picasso.with(context).load(feedItemsList.get(position).getThumbnailImage()).into(holder.ImageTextView);
        holder.NameTextView.setText(feedItemsList.get(position).getEventName());
        holder.TimeTextView.setText("Date: " + String.valueOf(feedItemsList.get(position).getEventTimestamp()));
        holder.ViewsTextView.setText("Views: " + String.valueOf(feedItemsList.get(position).getViews()));
        holder.LikesTextView.setText("Likes: " + String.valueOf(feedItemsList.get(position).getLikes()));
        holder.SharesTextView.setText("Shared: " + String.valueOf(feedItemsList.get(position).getShares()));
    }

    @Override
    public int getItemCount() {
        return feedItemsList.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id_view)
        TextView IdTextView;

        @BindView(R.id.image_view)
        ImageView ImageTextView;

        @BindView(R.id.event_name_view)
        TextView NameTextView;

        @BindView(R.id.timestamp_view)
        TextView TimeTextView;

        @BindView(R.id.views)
        TextView ViewsTextView;

        @BindView(R.id.likes_view)
        TextView LikesTextView;

        @BindView(R.id.shares_view)
        TextView SharesTextView;

        public FeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
