package com.example.listview.ui.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.listview.R;
import com.example.listview.util.ActionBarUtil;
import com.example.listview.util.CustomBarChartRender;
import com.example.listview.util.ValueFormatter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BarChart barChart;
    private ImageView imgTimer;
    private ImageView imgLearn;
    private Dialog dialog;
    private RelativeLayout timerRemember;
    private RelativeLayout rememberVocubulary;

    public ChartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChartFragment newInstance(String param1, String param2) {
        ChartFragment fragment = new ChartFragment();
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
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        imgTimer = view.findViewById(R.id.imgTimer);
        imgLearn = view.findViewById(R.id.imgLearn);

        timerRemember = view.findViewById(R.id.timerRemember);
        rememberVocubulary = view.findViewById(R.id.rememberVocubulary);

        dialog = new Dialog(getContext());

        imgTimer.setOnClickListener(v->{
            rememberVocubulary.setVisibility(View.VISIBLE);
            timerRemember.setVisibility(View.INVISIBLE);
        });
        imgLearn.setOnClickListener(v->{
            timerRemember.setVisibility(View.VISIBLE);
            rememberVocubulary.setVisibility(View.INVISIBLE);
            openNoticeDialog();
        });
        barChart = view.findViewById(R.id.barChart);
        setUpBarChart(barChart);
        return view;
    }
    private void openNoticeDialog() {
        dialog.setContentView(R.layout.notice_learning_english_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void setUpBarChart(BarChart barChartSetUp){
        List<BarEntry> barEntries = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            float value = (float) (i*5.0);
            BarEntry barEntry = new BarEntry(i,value);
            barEntries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"Employees");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(true);

        barDataSet.setBarBorderWidth(1f);
        barDataSet.setValueTextSize(12f);
        barDataSet.setValueFormatter(new ValueFormatter());
        barDataSet.setHighlightEnabled(true);
        barDataSet.setValueTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL));

        barChartSetUp.setData(new BarData(barDataSet));
        barChartSetUp.animateY(2000);

        barChartSetUp.setTouchEnabled(false);
        barChartSetUp.getDescription().setEnabled(false);
        barChartSetUp.setDrawBorders(false);
        barChartSetUp.setDrawValueAboveBar(false);

        //Legend
        barChartSetUp.getLegend().setEnabled(false);
        //Y-axis - left
        YAxis yAxisLeft = barChartSetUp.getAxisLeft();
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setDrawLabels(false);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawZeroLine(false);
        //Y-axis - right
        YAxis yAxisRight = barChartSetUp.getAxisRight();
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawLabels(false);
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawZeroLine(false);
        //X-axis
        List<String> xVals = List.of("0","1","2","3","4","5");
        XAxis xAxis = barChartSetUp.getXAxis();
        xAxis.setAxisLineWidth(2.5f);
        xAxis.setDrawLabels(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        xAxis.setTextSize(16f);
        xAxis.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));

        CustomBarChartRender barChartSetUpRender = new CustomBarChartRender(barChartSetUp,barChartSetUp.getAnimator(), barChartSetUp.getViewPortHandler());
        barChartSetUpRender.setRadius(50);
        barChartSetUp.setRenderer(barChartSetUpRender);
        barChartSetUp.invalidate();
    }
}