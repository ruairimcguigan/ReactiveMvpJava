package com.demo.reactivemvp.di;

import com.demo.reactivemvp.feature.SomeFeatureFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract SomeFeatureFragment contributesSomeFeatureFragment();
}
