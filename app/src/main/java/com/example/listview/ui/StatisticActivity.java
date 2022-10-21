package com.example.listview.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.listview.R;
import com.example.listview.util.ActionBarUtil;
import com.example.listview.util.CustomBarChartRender;
import com.example.listview.util.ValueFormatter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.*;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {
    private BarChart barChart;
    private ImageView imgTimer;
    private ImageView imgLearn;
    private Dialog dialog;
    private RelativeLayout timerRemember;
    private RelativeLayout rememberVocubulary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        actionBarUtil.loadCustomActionBar(getApplicationContext(),findViewById(R.id.navigationView));

        imgTimer = findViewById(R.id.imgTimer);
        imgLearn = findViewById(R.id.imgLearn);

        timerRemember = findViewById(R.id.timerRemember);
        rememberVocubulary = findViewById(R.id.rememberVocubulary);

        dialog = new Dialog(this);

        imgTimer.setOnClickListener(v->{
            rememberVocubulary.setVisibility(View.VISIBLE);
            timerRemember.setVisibility(View.INVISIBLE);
        });
        imgLearn.setOnClickListener(v->{
            timerRemember.setVisibility(View.VISIBLE);
            rememberVocubulary.setVisibility(View.INVISIBLE);
            openNoticeDialog();
        });
        barChart = findViewById(R.id.barChart);
        setUpBarChart(barChart);
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