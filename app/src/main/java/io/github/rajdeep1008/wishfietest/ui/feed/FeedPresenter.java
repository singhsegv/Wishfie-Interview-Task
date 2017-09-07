package io.github.rajdeep1008.wishfietest.ui.feed;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public interface FeedPresenter {
    void setView(FeedView view);

    void getFeed();

    void loadMore(int page);

    void sortFeed(int sortBy);
}
