package com.api.testapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.api.testapplication.Model.Data;
import com.api.testapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    private List<Data> myData;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFirstName , tvLastName, tvEmail;
        private ImageView imageView;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            this.tvFirstName = itemView.findViewById(R.id.firstName);
            this.tvLastName = itemView.findViewById(R.id.lastName);
            this.tvEmail = itemView.findViewById(R.id.email);
            this.imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public ExampleAdapter(List<Data> data) {
        myData = data;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_places_search, parent, false);;

        ExampleViewHolder viewHolder = new ExampleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, final int position) {
        holder.tvFirstName.setText(myData.get(position).getFirst_name());
        holder.tvLastName.setText(myData.get(position).getLast_name());
        holder.tvEmail.setText(myData.get(position).getEmail());
        Picasso.get()
                .load(myData.get(position).getAvatar())
                .into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return myData.size();
    }
}
