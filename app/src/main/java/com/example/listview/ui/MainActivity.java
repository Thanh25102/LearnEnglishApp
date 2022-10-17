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
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Topic> topics;
    private RecyclerView recyclerView;
    private LessonRecyclerAdapter lessonRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadCustomActionBar();
        List<Topic> data = loadData();
        recyclerView = findViewById(R.id.recyclerTopic);

        lessonRecyclerAdapter = new LessonRecyclerAdapter( this::displayVocabulariesActivity,LessonRecyclerAdapter.TYPE_TOPIC_LINEAR);
        lessonRecyclerAdapter.setData(data);
        recyclerView.setAdapter(lessonRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void loadCustomActionBar(){
        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.manhthanh);
        Drawable drawable = new BitmapDrawable(getResources(), createCircleBitmap(sourceBitmap));

        NavigationView navigationView = findViewById(R.id.navigationView);
        View header = navigationView.getHeaderView(0);

        ImageView avatar = header.findViewById(R.id.avatar);
        avatar.setImageDrawable(drawable);
        // set event
    }

    private void displayVocabulariesActivity(Topic topic) {
        Intent vocabulariesIntent = new Intent(this, CardActivity.class);
        vocabulariesIntent.putExtra("TOPIC_KEY", topic);
        startActivity(vocabulariesIntent);
    }

    public List<Topic> loadData(){
        return  List.of(new Topic(null, null, "Economic", "Kinh tế chính trị", null),
                new Topic(null, null, "Information Teachnology", "Công nghệ thông tin", null),
                new Topic(null, null, "Comedy", "Hài kịch", null),
                new Topic(null, null, "Movie", "Phim ảnh", null),
                new Topic(null, null, "Sex", "Giới tính", null),
                new Topic(null, null, "Friend", "Bạn bè", null),
                new Topic(null, null, "Comedy", "Hài kịch", null));
    }
    public Bitmap createCircleBitmap(Bitmap bitMapping) {
        Bitmap output = Bitmap.createBitmap(bitMapping.getWidth(),
                bitMapping.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitMapping.getWidth(),
                bitMapping.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitMapping.getWidth() / 2,
                bitMapping.getHeight() / 2, bitMapping.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitMapping, rect, rect, paint);
        return output;
    }

}