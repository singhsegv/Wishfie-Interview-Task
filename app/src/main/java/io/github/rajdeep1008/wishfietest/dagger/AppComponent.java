package io.github.rajdeep1008.wishfietest.dagger;

import javax.inject.Singleton;

import dagger.Component;
import io.github.rajdeep1008.wishfietest.ui.feed.FeedActivity;
import io.github.rajdeep1008.wishfietest.ui.feed.FeedPresenterImpl;

/**
 * Created by rajdeep1008 on 4/9/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {
    void inject(FeedPresenterImpl target);
    void inject(FeedActivity target);
}
