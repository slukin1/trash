package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

public interface b {
    void a(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void b(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void onChartDoubleTapped(MotionEvent motionEvent);

    void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12);

    void onChartLongPressed(MotionEvent motionEvent);

    void onChartScale(MotionEvent motionEvent, float f11, float f12);

    void onChartSingleTapped(MotionEvent motionEvent);

    void onChartTranslate(MotionEvent motionEvent, float f11, float f12);
}
