package com.demo.reactivemvp.feature;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.demo.reactivemvp.R;
import com.demo.reactivemvp.base.BaseFragment;
import dagger.android.support.AndroidSupportInjection;
import timber.log.Timber;

import javax.inject.Inject;

public class SomeFeatureFragment extends BaseFragment {

    @Inject SomeFeatureAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        AndroidSupportInjection.inject(this);

        if (adapter != null){
            Timber.d("good");
        } else {
            Timber.d("bad");
        }

        return inflater.inflate(R.layout.some_fragment, container, false);
    }
}
