package com.example.listview;

import android.widget.Adapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Topic> topics;
    private TopicAdapter topicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics = List.of(new Topic(null,"Economic","Kinh tế chính trị",null),
                new Topic(null,"Information Teachnology","Công nghệ thông tin",null),
                new Topic(null,"Comedy","Hài kịch",null),
                new Topic(null,"Movie","Phim ảnh",null),
                new Topic(null,"Sex","Giới tính",null),
                new Topic(null,"Friend","Bạn bè",null),
                new Topic(null,"Comedy","Hài kịch",null));
        topicAdapter = new TopicAdapter(MainActivity.this,R.layout.list_item,topics);
        listView = findViewById(R.id.listView);
        listView.setAdapter(topicAdapter);
    }
}