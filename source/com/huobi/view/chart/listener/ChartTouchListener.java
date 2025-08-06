package com.huobi.view.chart.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.huobi.view.chart.Chart;
import com.huobi.view.chart.highlight.Highlight;

public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    public static final int DRAG = 1;
    public static final int NONE = 0;
    public static final int PINCH_ZOOM = 4;
    public static final int POST_ZOOM = 5;
    public static final int ROTATE = 6;
    public static final int X_ZOOM = 2;
    public static final int Y_ZOOM = 3;
    public T mChart;
    public GestureDetector mGestureDetector;
    public ChartGesture mLastGesture = ChartGesture.NONE;
    public Highlight mLastHighlighted;
    public int mTouchMode = 0;

    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t11) {
        this.mChart = t11;
        this.mGestureDetector = new GestureDetector(t11.getContext(), this);
    }

    public static float distance(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f12;
        float f16 = f13 - f14;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    public void endAction(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.mChart.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartGestureEnd(motionEvent, this.mLastGesture);
        }
    }

    public ChartGesture getLastGesture() {
        return this.mLastGesture;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    public void performHighlight(Highlight highlight, MotionEvent motionEvent) {
        if (highlight == null || highlight.equalTo(this.mLastHighlighted)) {
            this.mChart.highlightValue((Highlight) null, true);
            this.mLastHighlighted = null;
            return;
        }
        this.mChart.highlightValue(highlight, true);
        this.mLastHighlighted = highlight;
    }

    public void setLastHighlighted(Highlight highlight) {
        this.mLastHighlighted = highlight;
    }

    public void startAction(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.mChart.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartGestureStart(motionEvent, this.mLastGesture);
        }
    }
}
