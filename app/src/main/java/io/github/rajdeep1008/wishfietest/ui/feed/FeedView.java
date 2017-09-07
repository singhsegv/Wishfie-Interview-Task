package io.github.rajdeep1008.wishfietest.ui.feed;

import java.util.List;

import io.github.rajdeep1008.wishfietest.model.Post;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public interface FeedView {
    void showLoading();

    void hideLoading();

    void showFeed(List<Post> feedItemsList);

    void showErrorMessage();

}
