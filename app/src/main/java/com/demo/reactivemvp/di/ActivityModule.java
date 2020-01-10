package com.demo.reactivemvp.di;

import com.demo.reactivemvp.feature.SomeFeatureActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract SomeFeatureActivity contributesMainActivity();

}
