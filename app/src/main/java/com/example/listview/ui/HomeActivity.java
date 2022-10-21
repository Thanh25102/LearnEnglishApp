package com.example.listview.ui;

import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.LessonRecyclerAdapter;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import com.example.listview.util.ActionBarUtil;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LessonRecyclerAdapter lessonRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        actionBarUtil.loadCustomActionBar(getApplicationContext(),findViewById(R.id.navigationView));
        List<Lesson> data = actionBarUtil.loadLessonData();
        recyclerView = findViewById(R.id.recyclerView);
        lessonRecyclerAdapter = new LessonRecyclerAdapter( this::displayVocabulariesActivity,LessonRecyclerAdapter.TYPE_LESSON_GRID);
        lessonRecyclerAdapter.setData(data);
        recyclerView.setAdapter(lessonRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }
     private void displayVocabulariesActivity(Lesson lesson) {
        Intent topicIntent = new Intent(this, MainActivity.class);
        topicIntent.putExtra("LESSON_KEY", lesson.getId());
        startActivity(topicIntent);
    }
}