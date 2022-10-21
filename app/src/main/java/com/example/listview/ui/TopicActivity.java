package com.example.listview.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.TopicRecyclerAdapter;
import com.example.listview.dto.Topic;
import com.example.listview.util.ActionBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class TopicActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopicRecyclerAdapter topicRecyclerAdapter;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

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

        navigationView = findViewById(R.id.navigationView);
        View header = navigationView.getHeaderView(0);
        ImageView back = header.findViewById(R.id.backBtn);
        back.setOnClickListener(backView ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}