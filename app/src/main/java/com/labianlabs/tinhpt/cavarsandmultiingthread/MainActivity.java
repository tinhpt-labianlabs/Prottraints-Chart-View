package com.labianlabs.tinhpt.cavarsandmultiingthread;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //region SYSTEM EVENTS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSizeScreen();
        initDataChart();
        initView();
        addChartView();
    }
    //endregion

    //region UTILS

    private void initView() {
        containerChart = findViewById(R.id.container_chart);
        tvTitleChart = findViewById(R.id.text_title_chart);
    }

    private void addChartView() {
        portraitsChartView = new PortraitsChartView(this, portraitsChart, width, height);
        containerChart.addView(portraitsChartView);
        tvTitleChart.setText(portraitsChart.getTitleChart());
    }

    private void getSizeScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
    }

    private void initDataChart() {
        List<ChartColumn> columns = new ArrayList<>();
        columns.add(new ChartColumn(90, "1", Color.RED));
        columns.add(new ChartColumn(70, "3", Color.YELLOW));
        columns.add(new ChartColumn(50, "4", Color.GREEN));
        columns.add(new ChartColumn(80, "4", Color.BLUE));
        portraitsChart = new PortraitsChart(columns, "Title Default");
    }

    //endregion

    //region VARS
    private PortraitsChartView portraitsChartView;
    private PortraitsChart portraitsChart;
    private int width = 0;
    private int height = 0;
    private LinearLayout containerChart;
    private TextView tvTitleChart;
    //endregion
}
