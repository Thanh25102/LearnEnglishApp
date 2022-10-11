package com.example.listview.activity;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.listview.R;
import com.example.listview.adapter.TopicAdapter;
import com.example.listview.dto.Topic;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Topic> topics;
    private TopicAdapter topicAdapter;

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
        topicAdapter = new TopicAdapter(MainActivity.this,R.layout.topic_item,topics);
        listView = findViewById(R.id.listView);
        listView.setAdapter(topicAdapter);
    }
}