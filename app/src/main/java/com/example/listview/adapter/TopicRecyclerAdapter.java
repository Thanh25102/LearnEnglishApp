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

public class TopicRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    @Override
    public int getItemViewType(int position) {
        return typeView;
    }

    public final static int TYPE_TOPIC_LINEAR = 1;
    public final static int TYPE_TOPIC_GRID= 2;
    private List<Topic> topics;
    private IClickTopic clickedTopic;
    private int typeView;

    public void setData(List<Topic> topics){
        this.topics = topics;
        notifyDataSetChanged();
    }

    public TopicRecyclerAdapter(IClickTopic clickedTopic, int typeView) {
        this.clickedTopic = clickedTopic;
        this.typeView = typeView;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if(TYPE_TOPIC_LINEAR == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_holder, parent, false);
            return new TopicViewHolderLinear(view);
        }else if(TYPE_TOPIC_GRID == viewType){
/*            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_holder_home, parent, false);
            return new LessonRecyclerAdapter.LessonViewHolderGrid(view);*/
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if(TYPE_TOPIC_LINEAR == holder.getItemViewType()){
            TopicViewHolderLinear topicViewHolder = (TopicViewHolderLinear) holder;
            topicViewHolder.getTitleTextView().setText(topics.get(position).getDescription());
            topicViewHolder.getThumbnailTextView().setText(topics.get(position).getDescriptiveMeaning());
            topicViewHolder.linearLayout.setOnClickListener(v->clickedTopic.clickedTopic(topics.get(position)));
        } else if(TYPE_TOPIC_GRID == holder.getItemViewType()){
           /* LessonRecyclerAdapter.LessonViewHolderGrid topicViewHolder = (LessonRecyclerAdapter.LessonViewHolderGrid) holder;
            topicViewHolder.getTopicName().setText(lessons.get(position).getDescription());*/
        }
    }

    @Override
    public int getItemCount() {
        return topics !=null ? topics.size() : 0;
    }
    public interface IClickTopic{
        void clickedTopic(Topic topic);
    }
    public class TopicViewHolderLinear extends RecyclerView.ViewHolder {

        private ImageView urlImageView;
        private TextView titleTextView;
        private TextView thumbnailTextView;
        private LinearLayout linearLayout;



        public TopicViewHolderLinear(@NonNull @NotNull View itemView) {
            super(itemView);

            urlImageView = itemView.findViewById(R.id.urlImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            thumbnailTextView = itemView.findViewById(R.id.thumbnailTextView);
            linearLayout = itemView.findViewById(R.id.layoutCardTopic);
        }

        public ImageView getUrlImageView() {
            return urlImageView;
        }

        public void setUrlImageView(ImageView urlImageView) {
            this.urlImageView = urlImageView;
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public void setTitleTextView(TextView titleTextView) {
            this.titleTextView = titleTextView;
        }

        public TextView getThumbnailTextView() {
            return thumbnailTextView;
        }

        public void setThumbnailTextView(TextView thumbnailTextView) {
            this.thumbnailTextView = thumbnailTextView;
        }
    }
}
