package com.labianlabs.tinhpt.cavarsandmultiingthread;

import java.util.List;

public class PortraitsChart {
    private List<ChartColumn> columns;
    private String titleChart;


    public PortraitsChart(List<ChartColumn> columns, String titleChart) {
        this.columns = columns;
        this.titleChart = titleChart;
    }

    public int getNumberColumns(){
        return  this.columns.size();
    }

    public List<ChartColumn> getColumns(){
        return columns;
    }

    public String getTitleChart() {
        return titleChart;
    }
}
