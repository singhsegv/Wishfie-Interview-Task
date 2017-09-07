package io.github.rajdeep1008.wishfietest.ui.feed;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import io.github.rajdeep1008.wishfietest.app.Constants;
import io.github.rajdeep1008.wishfietest.app.WishfieApplication;
import io.github.rajdeep1008.wishfietest.model.ResponseModel;
import io.github.rajdeep1008.wishfietest.model.Post;
import io.github.rajdeep1008.wishfietest.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

public class FeedPresenterImpl implements FeedPresenter {

    private FeedView view;
    List<Post> postsList;
    ArrayList<Post> tempList;

    @Inject
    ApiService apiService;

    @Override
    public void setView(FeedView view) {
        this.view = view;
    }

    public FeedPresenterImpl(Context context) {
        ((WishfieApplication)context).getAppComponent().inject(this);
    }

    @Override
    public void getFeed() {
        view.showLoading();

        apiService.getData(Constants.PARAM_ONE).enqueue(new Callback<ResponseModel<Post>>() {
            @Override
            public void onResponse(Call<ResponseModel<Post>> call, Response<ResponseModel<Post>> response) {

                if (response.code() != 200) {
                    view.showErrorMessage();
                } else {
                    postsList = response.body().getPosts();
                    tempList = new ArrayList<Post>(postsList);
                    view.showFeed(postsList);
                }
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<ResponseModel<Post>> call, Throwable t) {
                view.showErrorMessage();
                view.hideLoading();
            }
        });
    }

    @Override
    public void loadMore(int page) {

        if (page == 2) {
            apiService.getData(Constants.PARAM_TWO).enqueue(new Callback<ResponseModel<Post>>() {
                @Override
                public void onResponse(Call<ResponseModel<Post>> call, Response<ResponseModel<Post>> response) {

                    if (response.code() != 200) {
                        view.showErrorMessage();
                    } else {
                        for(Post post : response.body().getPosts()) {
                            tempList.add(post);
                        }
                        postsList = tempList;
                        view.showFeed(tempList);
                    }
                    view.hideLoading();
                }

                @Override
                public void onFailure(Call<ResponseModel<Post>> call, Throwable t) {
                    view.showErrorMessage();
                    view.hideLoading();
                }
            });

        } else if (page == 3) {
            apiService.getData(Constants.PARAM_THREE).enqueue(new Callback<ResponseModel<Post>>() {
                @Override
                public void onResponse(Call<ResponseModel<Post>> call, Response<ResponseModel<Post>> response) {

                    if (response.code() != 200) {
                        view.showErrorMessage();
                    } else {
                        for(Post post : response.body().getPosts()) {
                            tempList.add(post);
                        }
                        postsList = tempList;
                        view.showFeed(tempList);
                    }
                    view.hideLoading();
                }

                @Override
                public void onFailure(Call<ResponseModel<Post>> call, Throwable t) {
                    view.showErrorMessage();
                    view.hideLoading();
                }
            });
        }
    }

    @Override
    public void sortFeed(final int sortBy) {
        Collections.sort(postsList, new Comparator<Post>() {
            @Override
            public int compare(Post post, Post t1) {
                if (sortBy == 0) {
                    return post.getEventTimestamp() - t1.getEventTimestamp();
                } else if (sortBy == 1) {
                    return post.getLikes() - t1.getLikes();
                } else if (sortBy == 2) {
                    return post.getViews() - t1.getViews();
                } else if (sortBy == 3) {
                    return post.getShares() - t1.getShares();
                }
                return -1;
            }
        });

        view.showFeed(postsList);
    }
}
