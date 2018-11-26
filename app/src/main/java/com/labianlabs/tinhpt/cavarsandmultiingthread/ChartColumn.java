package com.labianlabs.tinhpt.cavarsandmultiingthread;

public class ChartColumn {
    private float value;
    private String title;
    private int color;
    private float left = 0;
    private float top = 0;
    private float right = 0;
    private float bottom = 0;

    public ChartColumn(float value, String title, int color) {
        this.value = value;
        this.title = title;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public float getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public void setRect(float left, float top, float right, float bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    public float getLeft() {
        return left;
    }

    public float getTop() {
        return top;
    }

    public float getRight() {
        return right;
    }

    public float getBottom() {
        return bottom;
    }
}
