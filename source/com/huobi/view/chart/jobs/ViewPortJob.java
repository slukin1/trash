package com.huobi.view.chart.jobs;

import android.view.View;
import com.huobi.view.chart.utils.ObjectPool;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.ViewPortHandler;

public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    public Transformer mTrans;
    public ViewPortHandler mViewPortHandler;
    public float[] pts = new float[2];
    public View view;
    public float xValue = 0.0f;
    public float yValue = 0.0f;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view2) {
        this.mViewPortHandler = viewPortHandler;
        this.xValue = f11;
        this.yValue = f12;
        this.mTrans = transformer;
        this.view = view2;
    }

    public float getXValue() {
        return this.xValue;
    }

    public float getYValue() {
        return this.yValue;
    }
}
