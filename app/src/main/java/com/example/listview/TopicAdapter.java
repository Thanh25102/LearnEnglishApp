package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TopicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Topic> topics;

    public TopicAdapter(Context context, int layout, List<Topic> topics) {
        this.context = context;
        this.layout = layout;
        this.topics = topics;
    }

    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        Topic topic = topics.get(i);

        TextView title = view.findViewById(R.id.title);
        TextView thumbnail = view.findViewById(R.id.thumbnail);

        title.setText(topic.getDescription());
        thumbnail.setText(topic.getDescriptiveMeaning());

        return view;
    }
}
