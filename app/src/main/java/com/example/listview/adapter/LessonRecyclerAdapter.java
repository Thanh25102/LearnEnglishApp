package com.example.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.holder.TopicViewHolder;
import com.example.listview.dto.Lesson;
import com.example.listview.dto.Topic;
import org.jetbrains.annotations.NotNull;

public class LessonRecyclerAdapter extends RecyclerView.Adapter<TopicViewHolder> {

    private Lesson lesson;
    private Context context;

    private IClickedTopic clickedTopic;
    public interface IClickedTopic{
        void topicIsClicked(Topic topic);
    }

    public LessonRecyclerAdapter(Context context,Lesson lesson,IClickedTopic clickedTopic) {
        this.lesson = lesson;
        this.context = context;
        this.clickedTopic = clickedTopic;
    }

    @NonNull
    @NotNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_view_holder, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopicViewHolder holder, int position) {
        holder.getTitleTextView().setText(lesson.getTopics().get(position).getDescription());
        holder.getThumbnailTextView().setText(lesson.getTopics().get(position).getDescriptiveMeaning());

        holder.linearLayout.setOnClickListener(v->{
            clickedTopic.topicIsClicked(lesson.getTopics().get(position));
        });
    }

    @Override
    public int getItemCount() {
        return lesson.getTopics().size();
    }
}
