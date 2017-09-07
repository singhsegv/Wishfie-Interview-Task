package io.github.rajdeep1008.wishfietest.app;

import android.app.Application;

import io.github.rajdeep1008.wishfietest.dagger.AppComponent;
import io.github.rajdeep1008.wishfietest.dagger.AppModule;
import io.github.rajdeep1008.wishfietest.dagger.DaggerAppComponent;


/**
 * Created by rajdeep1008 on 4/9/17.
 */

public class WishfieApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(WishfieApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
}
