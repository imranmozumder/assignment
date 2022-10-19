package com.api.testapplication.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.api.testapplication.R;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    Activity mActivity;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ExampleViewHolder(View itemView) {
            super(itemView);

        }
    }

    public ExampleAdapter(Activity activity) {
        mActivity =activity;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_places_search, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, final int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
