package com.example.listview.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listview.R;
import com.example.listview.adapter.LessonRecyclerAdapter;
import com.example.listview.dto.Lesson;
import com.example.listview.ui.TopicActivity;
import com.example.listview.util.ActionBarUtil;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LessonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LessonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private LessonRecyclerAdapter lessonRecyclerAdapter;

    public LessonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LessonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LessonFragment newInstance(String param1, String param2) {
        LessonFragment fragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, container, false);

        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        List<Lesson> data = actionBarUtil.loadLessonData();

        lessonRecyclerAdapter = new LessonRecyclerAdapter(lesson->{
            Intent intent = new Intent(getActivity(), TopicActivity.class);
            startActivity(intent);
        },LessonRecyclerAdapter.TYPE_LESSON_LINEAR);

        lessonRecyclerAdapter.setData(data);
        recyclerView = view.findViewById(R.id.recyclerViewLesson);
        recyclerView.setAdapter(lessonRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Inflate the layout for this fragment
        return view;
    }
}