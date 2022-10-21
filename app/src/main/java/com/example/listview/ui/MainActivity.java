package com.example.listview.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.*;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.LessonRecyclerAdapter;
import com.example.listview.adapter.TopicRecyclerAdapter;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import com.example.listview.util.ActionBarUtil;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TopicRecyclerAdapter topicRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        actionBarUtil.loadCustomActionBar(getApplicationContext(),findViewById(R.id.navigationView));
        List<Topic> data = actionBarUtil.loadTopicData();
        recyclerView = findViewById(R.id.recyclerTopic);
        topicRecyclerAdapter = new TopicRecyclerAdapter(this::displayVocabulariesActivity,TopicRecyclerAdapter.TYPE_TOPIC_LINEAR);
        topicRecyclerAdapter.setData(data);
        recyclerView.setAdapter(topicRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void displayVocabulariesActivity(Topic topic) {
        Intent vocabulariesIntent = new Intent(this, CardActivity.class);
        vocabulariesIntent.putExtra("TOPIC_KEY", topic);
        startActivity(vocabulariesIntent);
    }



}