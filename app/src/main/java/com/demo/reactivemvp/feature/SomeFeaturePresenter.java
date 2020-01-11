package com.demo.reactivemvp.feature;

import com.demo.reactivemvp.feature.SomeFeatureContract.Presenter;
import timber.log.Timber;

import javax.inject.Inject;

public class SomeFeaturePresenter implements Presenter{

    private SomeFeatureAdapter adapter;

    @Inject
    public SomeFeaturePresenter(SomeFeatureAdapter adapter) {
        this.adapter = adapter;

        if (adapter != null) {
            Timber.i("All good");
        } else {
            Timber.i("Not good");
        }
    }

    @Override
    public void someFeaturePresenterMethod() {

    }

    @Override
    public void anotherFeaturePresenterMethod() {

    }
}
