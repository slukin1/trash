package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import e5.d;

public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public ChartGesture f65500b = ChartGesture.NONE;

    /* renamed from: c  reason: collision with root package name */
    public int f65501c = 0;

    /* renamed from: d  reason: collision with root package name */
    public d f65502d;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f65503e;

    /* renamed from: f  reason: collision with root package name */
    public T f65504f;

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
        this.f65504f = t11;
        this.f65503e = new GestureDetector(t11.getContext(), this);
    }

    public static float a(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f12;
        float f16 = f13 - f14;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    public void b(MotionEvent motionEvent) {
        b onChartGestureListener = this.f65504f.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, this.f65500b);
        }
    }

    public void c(d dVar, MotionEvent motionEvent) {
        if (dVar == null || dVar.a(this.f65502d)) {
            this.f65504f.m((d) null, true);
            this.f65502d = null;
            return;
        }
        this.f65504f.m(dVar, true);
        this.f65502d = dVar;
    }

    public void d(d dVar) {
        this.f65502d = dVar;
    }

    public void e(MotionEvent motionEvent) {
        b onChartGestureListener = this.f65504f.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f65500b);
        }
    }
}
