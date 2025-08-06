package com.huobi.view.chart.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.huobi.view.chart.Chart;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.utils.FSize;
import com.huobi.view.chart.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage implements IMarker {
    private Context mContext;
    private Drawable mDrawable;
    private Rect mDrawableBoundsCache = new Rect();
    private MPPointF mOffset = new MPPointF();
    private MPPointF mOffset2 = new MPPointF();
    private FSize mSize = new FSize();
    private WeakReference<Chart> mWeakChart;

    public MarkerImage(Context context, int i11) {
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mDrawable = context.getResources().getDrawable(i11, (Resources.Theme) null);
        } else {
            this.mDrawable = context.getResources().getDrawable(i11);
        }
    }

    public void draw(Canvas canvas, float f11, float f12) {
        if (this.mDrawable != null) {
            MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f11, f12);
            FSize fSize = this.mSize;
            float f13 = fSize.width;
            float f14 = fSize.height;
            if (f13 == 0.0f) {
                f13 = (float) this.mDrawable.getIntrinsicWidth();
            }
            if (f14 == 0.0f) {
                f14 = (float) this.mDrawable.getIntrinsicHeight();
            }
            this.mDrawable.copyBounds(this.mDrawableBoundsCache);
            Drawable drawable = this.mDrawable;
            Rect rect = this.mDrawableBoundsCache;
            int i11 = rect.left;
            int i12 = rect.top;
            drawable.setBounds(i11, i12, ((int) f13) + i11, ((int) f14) + i12);
            int save = canvas.save();
            canvas.translate(f11 + offsetForDrawingAtPoint.f19016x, f12 + offsetForDrawingAtPoint.f19017y);
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(save);
            this.mDrawable.setBounds(this.mDrawableBoundsCache);
        }
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
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f19016x = offset.f19016x;
        mPPointF.f19017y = offset.f19017y;
        Chart chartView = getChartView();
        FSize fSize = this.mSize;
        float f13 = fSize.width;
        float f14 = fSize.height;
        if (f13 == 0.0f && (drawable2 = this.mDrawable) != null) {
            f13 = (float) drawable2.getIntrinsicWidth();
        }
        if (f14 == 0.0f && (drawable = this.mDrawable) != null) {
            f14 = (float) drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.mOffset2;
        float f15 = mPPointF2.f19016x;
        if (f11 + f15 < 0.0f) {
            mPPointF2.f19016x = -f11;
        } else if (chartView != null && f11 + f13 + f15 > ((float) chartView.getWidth())) {
            this.mOffset2.f19016x = (((float) chartView.getWidth()) - f11) - f13;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f16 = mPPointF3.f19017y;
        if (f12 + f16 < 0.0f) {
            mPPointF3.f19017y = -f12;
        } else if (chartView != null && f12 + f14 + f16 > ((float) chartView.getHeight())) {
            this.mOffset2.f19017y = (((float) chartView.getHeight()) - f12) - f14;
        }
        return this.mOffset2;
    }

    public FSize getSize() {
        return this.mSize;
    }

    public void refreshContent(Entry entry, Highlight highlight) {
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public void setOffset(float f11, float f12) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f19016x = f11;
        mPPointF.f19017y = f12;
    }

    public void setSize(FSize fSize) {
        this.mSize = fSize;
        if (fSize == null) {
            this.mSize = new FSize();
        }
    }

    public void setOffset(MPPointF mPPointF) {
        this.mOffset = mPPointF;
        if (mPPointF == null) {
            this.mOffset = new MPPointF();
        }
    }
}
