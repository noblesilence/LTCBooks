package com.learnteachcenter.ltcbooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements RecyclerViewAdapter.OnItemListener
{
    private String[] mTitles;
    private String[] mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initChapters();
        initRecyclerView();
    }

    private void initChapters(){
        mTitles = getResources().getStringArray(R.array.chapter_titles);
        mContents = getResources().getStringArray(R.array.chapter_contents);
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                this,
                mTitles,
                this
        );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", mTitles[position]);
        intent.putExtra("content", mContents[position]);
        startActivity(intent);
    }
}