package com.example.listview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LessonRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public int getItemViewType(int position) {
        return typeView;
    }

    public final static int TYPE_LESSON_LINEAR = 1;
    public final static int TYPE_LESSON_GRID= 2;
    private List<Lesson> lessons;
     private IClickedLesson clickedLesson;
    private int typeView;
    public void setData(List<Lesson> lessons){
        this.lessons = lessons;
        notifyDataSetChanged();
    }

    public LessonRecyclerAdapter(IClickedLesson clickedLesson,int typeView) {
        this.clickedLesson = clickedLesson;
        this.typeView = typeView;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if(TYPE_LESSON_LINEAR == viewType){
            /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_holder, parent, false);
            return new LessonViewHolderLinear(view);*/
        }else if(TYPE_LESSON_GRID == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_holder_home, parent, false);
            return new LessonViewHolderGrid(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if(TYPE_LESSON_LINEAR == holder.getItemViewType()){
           /* LessonViewHolderLinear topicViewHolder = (LessonViewHolderLinear) holder;
            topicViewHolder.getTitleTextView().setText(lessons.get(position).getName());
            topicViewHolder.getThumbnailTextView().setText(lessons.get(position).getDescription());
            topicViewHolder.linearLayout.setOnClickListener(v->clickedTopic.topicIsClicked(lessons.get(position)));*/
        } else if(TYPE_LESSON_GRID == holder.getItemViewType()){
            LessonViewHolderGrid lessonViewHolder = (LessonViewHolderGrid) holder;
            lessonViewHolder.getTopicName().setText(lessons.get(position).getDescription());
            lessonViewHolder.getImageView().setOnClickListener(v->clickedLesson.lessonIsClicked(lessons.get(position)));
        }
    }
    @Override
    public int getItemCount() {
        return lessons != null ? lessons.size() : 0;
    }
    public interface IClickedLesson{
        void lessonIsClicked(Lesson lesson);
    }

    public class LessonViewHolderGrid extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView topicName;
        public LessonViewHolderGrid(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            topicName = itemView.findViewById(R.id.topicName);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getTopicName() {
            return topicName;
        }

        public void setTopicName(TextView topicName) {
            this.topicName = topicName;
        }
    }
}
