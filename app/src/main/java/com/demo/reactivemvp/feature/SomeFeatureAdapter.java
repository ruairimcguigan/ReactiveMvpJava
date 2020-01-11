package com.demo.reactivemvp.feature;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

public class SomeFeatureAdapter extends RecyclerView.Adapter<SomeFeatureViewHolder> {

    @Inject
    public SomeFeatureAdapter() {
    }

    @NonNull
    @Override
    public SomeFeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SomeFeatureViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

