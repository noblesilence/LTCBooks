package com.learnteachcenter.ltcbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "LTC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("title") &&
            getIntent().hasExtra("content")
        ) {
            String title = getIntent().getStringExtra("title");
            String content = getIntent().getStringExtra("content");

            TextView tvTitle = findViewById(R.id.tvTitle);
            TextView tvContent = findViewById(R.id.tvContent);

            tvTitle.setText(title);
            tvContent.setText(content);

            tvContent.setMovementMethod(new ScrollingMovementMethod());
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
