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

    private static final String TAG = "LTC";

    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mContents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initChapters();
        initRecyclerView();
    }

    private void initChapters(){
        Log.d(TAG, "initChapters: ");

        mTitles.add(getString(R.string.chapter_1_title_zg));
        mTitles.add(getString(R.string.chapter_2_title_zg));
        mTitles.add(getString(R.string.chapter_3_title_zg));

        mContents.add(getString(R.string.chapter_1_content_zg));
        mContents.add(getString(R.string.chapter_2_content_zg));
        mContents.add(getString(R.string.chapter_3_content_zg));

        Log.d(TAG, "mTitles size: " + mTitles.size());
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: ");

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
        Log.d(TAG, "onItemClick: " + position);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", mTitles.get(position));
        intent.putExtra("content", mContents.get(position));
        startActivity(intent);
    }
}