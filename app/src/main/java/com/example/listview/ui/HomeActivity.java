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
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LessonRecyclerAdapter lessonRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadCustomActionBar();
        List<Lesson> data = loadData();
        recyclerView = findViewById(R.id.recyclerView);

        lessonRecyclerAdapter = new LessonRecyclerAdapter( this::displayVocabulariesActivity,LessonRecyclerAdapter.TYPE_LESSON_GRID);
        lessonRecyclerAdapter.setData(data);
        recyclerView.setAdapter(lessonRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
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
    private void displayVocabulariesActivity(Lesson lesson) {
        Intent topicIntent = new Intent(this, MainActivity.class);
        topicIntent.putExtra("LESSON_KEY", lesson.getId());
        startActivity(topicIntent);
    }

    public List<Lesson> loadData(){
        return List.of(new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"),
                new Lesson(null,"TOEIC 500","Giành cho người muốn skip tiếng anh 1 2 3","học trong 10 tháng"));
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