package io.github.rajdeep1008.wishfietest.ui.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.rajdeep1008.wishfietest.R;
import io.github.rajdeep1008.wishfietest.app.EndlessRecyclerViewScrollListener;
import io.github.rajdeep1008.wishfietest.app.WishfieApplication;
import io.github.rajdeep1008.wishfietest.model.Post;

public class FeedActivity extends AppCompatActivity implements FeedView{

    @Inject
    FeedPresenter presenter;

    @BindView(R.id.feed_list)
    RecyclerView postsRecyclerView;

    @BindView(R.id.loading)
    ProgressBar progressBar;

    EndlessRecyclerViewScrollListener scrollListener;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        ((WishfieApplication)getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this);

        postsRecyclerView.setLayoutManager(linearLayoutManager);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Toast.makeText(FeedActivity.this, "" + page, Toast.LENGTH_SHORT).show();
                presenter.loadMore(page + 1);
            }
        };

        postsRecyclerView.addOnScrollListener(scrollListener);

        presenter.setView(this);
        presenter.getFeed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int sortBy = -1;

        switch (item.getItemId()) {
            case R.id.sort_date:
                sortBy = 0;
                break;
            case R.id.sort_likes:
                sortBy = 1;
                break;
            case R.id.sort_views:
                sortBy = 2;
                break;
            case R.id.sort_shares:
                sortBy = 3;
                break;
        }

        presenter.sortFeed(sortBy);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showFeed(List<Post> feedItemsList) {
            postsRecyclerView.setAdapter(new FeedAdapter(feedItemsList, FeedActivity.this));
            postsRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "cannot load list", Toast.LENGTH_SHORT).show();
    }
}
