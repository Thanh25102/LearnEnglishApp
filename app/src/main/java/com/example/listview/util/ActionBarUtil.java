package com.example.listview.util;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.example.listview.R;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class ActionBarUtil{
    private static ActionBarUtil actionBarUtil;

    private ActionBarUtil(){}

    public static ActionBarUtil getInstance(){
        if(actionBarUtil == null){
            actionBarUtil = new ActionBarUtil();
        }
        return actionBarUtil;
    }

    public void loadCustomActionBar(Context context, NavigationView navigationView ){
        Bitmap sourceBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.manhthanh);
        Drawable drawable = new BitmapDrawable(context.getResources(), createCircleBitmap(sourceBitmap));
        View header = navigationView.getHeaderView(0);
        ImageView avatar = header.findViewById(R.id.avatar);
        avatar.setImageDrawable(drawable);
        // set event
    }
    public List<Topic> loadTopicData(){
        return  List.of(new Topic(null, null, "Economic", "Kinh tế chính trị", null),
                new Topic(null, null, "Information Teachnology", "Công nghệ thông tin", null),
                new Topic(null, null, "Comedy", "Hài kịch", null),
                new Topic(null, null, "Movie", "Phim ảnh", null),
                new Topic(null, null, "Sex", "Giới tính", null),
                new Topic(null, null, "Friend", "Bạn bè", null),
                new Topic(null, null, "Comedy", "Hài kịch", null));
    }
    private Bitmap createCircleBitmap(Bitmap bitMapping) {
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

    public List<Lesson> loadLessonData(){
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
}