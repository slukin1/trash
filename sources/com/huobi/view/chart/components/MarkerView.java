package com.huobi.view.chart.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.huobi.view.chart.Chart;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF mOffset = new MPPointF();
    private MPPointF mOffset2 = new MPPointF();
    private WeakReference<Chart> mWeakChart;

    public MarkerView(Context context, int i11) {
        super(context);
        setupLayoutResource(i11);
    }

    private void setupLayoutResource(int i11) {
        View inflate = LayoutInflater.from(getContext()).inflate(i11, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void draw(Canvas canvas, float f11, float f12) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f11, f12);
        int save = canvas.save();
        canvas.translate(f11 + offsetForDrawingAtPoint.f19016x, f12 + offsetForDrawingAtPoint.f19017y);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.mWeakChart;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF getOffset() {
        return this.mOffset;
    }

    public MPPointF getOffsetForDrawingAtPoint(float f11, float f12) {
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f19016x = offset.f19016x;
        mPPointF.f19017y = offset.f19017y;
        Chart chartView = getChartView();
        float width = (float) getWidth();
        float height = (float) getHeight();
        MPPointF mPPointF2 = this.mOffset2;
        float f13 = mPPointF2.f19016x;
        if (f11 + f13 < 0.0f) {
            mPPointF2.f19016x = -f11;
        } else if (chartView != null && f11 + width + f13 > ((float) chartView.getWidth())) {
            this.mOffset2.f19016x = (((float) chartView.getWidth()) - f11) - width;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f14 = mPPointF3.f19017y;
        if (f12 + f14 < 0.0f) {
            mPPointF3.f19017y = -f12;
        } else if (chartView != null && f12 + height + f14 > ((float) chartView.getHeight())) {
            this.mOffset2.f19017y = (((float) chartView.getHeight()) - f12) - height;
        }
        return this.mOffset2;
    }

    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public void setOffset(float f11, float f12) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f19016x = f11;
        mPPointF.f19017y = f12;
    }

    public void setOffset(MPPointF mPPointF) {
        this.mOffset = mPPointF;
        if (mPPointF == null) {
            this.mOffset = new MPPointF();
        }
    }
}
