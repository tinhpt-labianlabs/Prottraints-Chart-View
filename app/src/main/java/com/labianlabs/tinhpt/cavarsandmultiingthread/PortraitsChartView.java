package com.labianlabs.tinhpt.cavarsandmultiingthread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.List;

public class PortraitsChartView extends View {

    //region SYSTEM EVENTS
    public PortraitsChartView(Context context,PortraitsChart portraitsChart, int widthView, int heightView) {
        super(context);
        this.portraitsChart = portraitsChart;
        this.widthView = widthView;
        this.heightView = heightView;
    }

    public PortraitsChartView(Context context, PortraitsChart portraitsChart, int widthView, int heightView, int distance) {
        super(context);
        this.portraitsChart = portraitsChart;
        this.widthView = widthView;
        this.heightView = heightView;
        this.distance = distance;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        columnPaint.setStyle(Paint.Style.FILL);
        columnPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        setRectForColumns();
        for (int i = 0; i < portraitsChart.getNumberColumns(); i++) {
            ChartColumn column = portraitsChart.getColumns().get(i);
            columnPaint.setColor(column.getColor());
            float left = column.getLeft();
            float right = column.getRight();
            float top = column.getTop();
            float bottom = column.getBottom();
            canvas.drawRect(left, top, right, bottom, columnPaint);
            drawValueInfo(canvas,column);
        }

    }


    //endregion

    //region UTILS

    private void calculatorWidthColumn() {
        int number = portraitsChart.getNumberColumns();
        widthColumn = (widthView -((number +1)*DimenUtils.DISTANCE_COLUMN))/number;
    }

    private void setRectForColumns() {
        calculatorWidthColumn();
        int heightChart = heightView;
        float top = 0;
        float bottom = heightChart;
        float left = 0;
        float right = 0;
        for (int i = 0; i < portraitsChart.getColumns().size(); i++) {
            if (i == 0) {
                left = distance;
            } else {
               left = portraitsChart.getColumns().get(i-1).getRight() + distance;
            }
            float h = (heightChart * portraitsChart.getColumns().get(i).getValue())/100;
            top = heightChart - h;
            right = left + widthColumn;
            portraitsChart.getColumns().get(i).setRect(left, top, right, bottom);
        }
    }

    private void drawValueInfo(Canvas canvas, ChartColumn column){
        Paint titlePaint = new Paint();
        titlePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        titlePaint.setColor(Color.BLACK);
        titlePaint.setStyle(Paint.Style.FILL);
        titlePaint.setTextSize(64f);
        titlePaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(String.valueOf(column.getValue() +" %"),column.getLeft()+widthColumn/2,column.getTop() -5,titlePaint);
    }
    //endregion

    //region VARS
    private PortraitsChart portraitsChart;
    private Paint columnPaint = new Paint();
    private List<ChartColumn> columns;
    private int widthView = DimenUtils.WIDTH_PORTRAITS_CHAR;
    private int heightView = DimenUtils.HEIGHT_PORTRAITS_CHAR;
    private int distance = DimenUtils.DISTANCE_COLUMN;
    private int widthColumn = 0;
    //endregion
}
