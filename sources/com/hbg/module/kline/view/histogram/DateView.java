package com.hbg.module.kline.view.histogram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import com.hbg.module.kline.R$styleable;

public class DateView extends AbsDateChartView {
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f24469a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f24470b0;

    /* renamed from: c0  reason: collision with root package name */
    public float f24471c0;

    /* renamed from: d0  reason: collision with root package name */
    public a f24472d0;

    /* renamed from: e0  reason: collision with root package name */
    public Paint f24473e0;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Paint f24474a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f24475b;

        /* renamed from: c  reason: collision with root package name */
        public Paint f24476c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f24477d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f24478e;

        public a() {
            this.f24474a = DateView.this.m(DateView.this.R);
            this.f24475b = DateView.this.m(DateView.this.T);
            this.f24476c = DateView.this.m(DateView.this.R);
            this.f24477d = DateView.this.m(-7829368);
            Paint m11 = DateView.this.m(DateView.this.f24454u);
            this.f24478e = m11;
            m11.setTextSize(DateView.this.f24455v);
        }
    }

    public DateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void y(Context context, AttributeSet attributeSet, int i11, int i12) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HistogramView, i11, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i13 = 0; i13 < indexCount; i13++) {
            int index = obtainStyledAttributes.getIndex(i13);
            if (index == R$styleable.HistogramView_histogram_width_percent) {
                this.f24471c0 = obtainStyledAttributes.getFloat(index, 0.5f);
            } else if (index == R$styleable.HistogramView_histogram_positive_bottom_color) {
                this.S = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_positive_top_color) {
                this.R = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_negative_bottom_color) {
                this.U = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_negative_top_color) {
                this.T = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_negative_bottom_color) {
                this.f24470b0 = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_negative_top_color) {
                this.f24469a0 = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_positive_bottom_color) {
                this.W = obtainStyledAttributes.getColor(index, -7829368);
            } else if (index == R$styleable.HistogramView_histogram_select_positive_top_color) {
                this.V = obtainStyledAttributes.getColor(index, -7829368);
            }
        }
        obtainStyledAttributes.recycle();
        this.f24472d0 = new a();
        Paint paint = new Paint();
        this.f24473e0 = paint;
        paint.setTextSize((float) L(10.0f));
        this.f24473e0.setColor(-7829368);
        M();
    }

    public void C(Canvas canvas) {
        float cellWidth = getCellWidth();
        float zeroLine = getZeroLine();
        canvas.save();
        canvas.translate(this.f24444k, 0.0f);
        Log.d("DateView", "mOriginalX: " + this.f24444k + " mHeight : " + this.f24446m + " mOriginalY: " + this.f24445l + " baseLine:" + zeroLine);
        float f11 = ((1.0f - this.f24471c0) * cellWidth) / 2.0f;
        l();
        getCount();
        l();
        for (int i11 = 0; i11 < getCount(); i11++) {
            ge.a t11 = t(i11);
            if (t11 != null) {
                q(i11);
                this.f24473e0.measureText(t11.f25272c);
                canvas.save();
                canvas.translate((((float) i11) * cellWidth) + f11 + 7.0f, this.f24446m / 2.0f);
                canvas.drawText(t11.f25272c, 0.0f, 0.0f, this.f24473e0);
                canvas.restore();
            }
        }
        canvas.restore();
    }

    public void G(Canvas canvas) {
    }

    public final int L(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void M() {
        if (this.V == -1) {
            this.V = this.R;
        }
        if (this.W == -1) {
            this.W = this.S;
        }
        if (this.f24469a0 == -1) {
            this.f24469a0 = this.T;
        }
        if (this.f24470b0 == -1) {
            this.f24470b0 = this.U;
        }
    }

    public void setFallColor(int i11) {
        this.T = i11;
        this.U = i11;
    }

    public void setRiseColor(int i11) {
        this.R = i11;
        this.S = i11;
    }

    public DateView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.R = -7829368;
        this.S = -7829368;
        this.T = -7829368;
        this.U = -7829368;
        this.V = -1;
        this.W = -1;
        this.f24469a0 = -1;
        this.f24470b0 = -1;
        this.f24471c0 = 0.5f;
        y(context, attributeSet, i11, 0);
    }
}
