package com.api.testapplication.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.api.testapplication.Adapter.ExampleAdapter;
import com.api.testapplication.Interface.RetrofitClient;
import com.api.testapplication.Model.Data;
import com.api.testapplication.Model.Result;
import com.api.testapplication.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private String pageNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mRecyclerView = findViewById(R.id.rvPlaces);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (getIntent() != null) {
            pageNo = getIntent().getStringExtra("pageNo");
        }
        loadData();
    }

    private void loadData() {
        Map<String, String> params = new HashMap<>();
        params.put("page", pageNo);
        Call<Result> call = RetrofitClient.getInstance().getMyApi().getDisplayData(params);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result myData = response.body();
                List<Data> mData = myData.getData();
                if (mData.size() > 0) {
                    ExampleAdapter adapter = new ExampleAdapter(mData);
                    mRecyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "No Data available", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();
            }

        });
    }
}