package com.example.listview.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.TopicRecyclerAdapter;
import com.example.listview.dto.Topic;
import com.example.listview.util.ActionBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class TopicActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopicRecyclerAdapter topicRecyclerAdapter;
    private BottomNavigationView bottomNavigationViewOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        bottomNavigationViewOn = findViewById(R.id.bottomNavVIew);

        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        List<Topic> data = actionBarUtil.loadTopicData();
        recyclerView = findViewById(R.id.recyclerTopic);
        topicRecyclerAdapter = new TopicRecyclerAdapter(t->{
            Intent intent = new Intent(this,CardActivity.class);
            intent.putExtra("TOPIC_KEY", t);
            startActivity(intent);
        },TopicRecyclerAdapter.TYPE_TOPIC_LINEAR);
        topicRecyclerAdapter.setData(data);
        recyclerView.setAdapter(topicRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.manhthanh);
        Drawable drawable = new BitmapDrawable(getResources(), actionBarUtil.createCircleBitmap(sourceBitmap));

        bottomNavigationViewOn.setItemIconTintList(null);
        bottomNavigationViewOn.getMenu().findItem(R.id.action_avatar).setIcon(drawable);
    }
}