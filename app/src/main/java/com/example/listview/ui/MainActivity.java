package com.example.listview.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.LessonRecyclerAdapter;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Topic> topics;
    private RecyclerView recyclerView;
    private LessonRecyclerAdapter lessonRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics = List.of(new Topic(null,null,"Economic","Kinh tế chính trị",null),
                new Topic(null,null,"Information Teachnology","Công nghệ thông tin",null),
                new Topic(null,null,"Comedy","Hài kịch",null),
                new Topic(null,null,"Movie","Phim ảnh",null),
                new Topic(null,null,"Sex","Giới tính",null),
                new Topic(null,null,"Friend","Bạn bè",null),
                new Topic(null,null,"Comedy","Hài kịch",null));

//        // recycler view
        recyclerView = findViewById(R.id.recyclerTopic);
        Lesson lesson = new Lesson();
        lesson.setTopics(topics);
        lessonRecyclerAdapter = new LessonRecyclerAdapter(this, lesson, this::displayVocabulariesActivity);
        recyclerView.setAdapter(lessonRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayVocabulariesActivity(Topic topic){
        Intent vocabulariesIntent = new Intent(this,CardActivity.class);
        vocabulariesIntent.putExtra("TOPIC_KEY",topic);
        startActivity(vocabulariesIntent);
    }
}