package com.demo.reactivemvp;

import android.app.Activity;
import android.app.Application;

import com.demo.reactivemvp.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

import javax.inject.Inject;

/*
 * we use our custom App instance to inject our Application class.
 * By doing this, a DispatchingAndroidInjector instance is injected which is
 * then returned when an injector for an activity is requested.
 * */
public class App extends Application implements HasActivityInjector {

    @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    private void initLoggingLib() {
        Timber.plant(new Timber.DebugTree());
    }
}
