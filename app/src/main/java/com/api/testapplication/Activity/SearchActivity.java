package com.api.testapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.api.testapplication.R;

public class SearchActivity extends AppCompatActivity{
    EditText etSearchPage;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etSearchPage = findViewById(R.id.etSearchPage);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(view -> {
         if(!etSearchPage.getText().toString().equals("")){
             getSearchResults(etSearchPage.getText().toString());
         }
        });
    }
    private void getSearchResults(String inputText)
    {
        //Enter the code here
    }
}