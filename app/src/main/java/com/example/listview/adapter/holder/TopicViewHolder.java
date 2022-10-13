package com.example.listview.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.dto.Topic;
import org.jetbrains.annotations.NotNull;


public class TopicViewHolder extends RecyclerView.ViewHolder {

    private ImageView urlImageView;
    private TextView titleTextView;
    private TextView thumbnailTextView;

    public LinearLayout linearLayout;


    public TopicViewHolder(@NonNull @NotNull View itemView) {
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
