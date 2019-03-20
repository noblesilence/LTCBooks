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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("title") &&
            getIntent().hasExtra("content")
        ) {
            String title = getIntent().getStringExtra("title");
            String content = getIntent().getStringExtra("content");

            TextView tvContent = findViewById(R.id.tvContent);

            getSupportActionBar().setTitle(title);

            tvContent.setText(content);
            tvContent.setMovementMethod(new ScrollingMovementMethod());
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
