package io.github.rajdeep1008.wishfietest.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.rajdeep1008.wishfietest.ui.feed.FeedPresenter;
import io.github.rajdeep1008.wishfietest.ui.feed.FeedPresenterImpl;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    FeedPresenter provideFeedPresenter(Context context) {
        return new FeedPresenterImpl(context);
    }
}
