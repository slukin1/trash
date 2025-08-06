package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.Utils;
import com.huobi.view.chart.Chart;
import e5.d;
import e5.e;
import i5.h;
import i5.r;
import i5.u;
import k5.a;
import k5.b;

public class HorizontalBarChart extends BarChart {
    public RectF B0 = new RectF();
    public float[] C0 = new float[2];

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void P() {
        a aVar = this.f65342g0;
        YAxis yAxis = this.f65338c0;
        float f11 = yAxis.G;
        float f12 = yAxis.H;
        XAxis xAxis = this.f65365j;
        aVar.m(f11, f12, xAxis.H, xAxis.G);
        a aVar2 = this.f65341f0;
        YAxis yAxis2 = this.f65337b0;
        float f13 = yAxis2.G;
        float f14 = yAxis2.H;
        XAxis xAxis2 = this.f65365j;
        aVar2.m(f13, f14, xAxis2.H, xAxis2.G);
    }

    public void f() {
        y(this.B0);
        RectF rectF = this.B0;
        float f11 = rectF.left + 0.0f;
        float f12 = rectF.top + 0.0f;
        float f13 = rectF.right + 0.0f;
        float f14 = rectF.bottom + 0.0f;
        if (this.f65337b0.c0()) {
            f12 += this.f65337b0.S(this.f65339d0.c());
        }
        if (this.f65338c0.c0()) {
            f14 += this.f65338c0.S(this.f65340e0.c());
        }
        XAxis xAxis = this.f65365j;
        float f15 = (float) xAxis.K;
        if (xAxis.f()) {
            if (this.f65365j.P() == XAxis.XAxisPosition.BOTTOM) {
                f11 += f15;
            } else {
                if (this.f65365j.P() != XAxis.XAxisPosition.TOP) {
                    if (this.f65365j.P() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f11 += f15;
                    }
                }
                f13 += f15;
            }
        }
        float extraTopOffset = f12 + getExtraTopOffset();
        float extraRightOffset = f13 + getExtraRightOffset();
        float extraBottomOffset = f14 + getExtraBottomOffset();
        float extraLeftOffset = f11 + getExtraLeftOffset();
        float e11 = Utils.e(this.V);
        this.f65376u.K(Math.max(e11, extraLeftOffset), Math.max(e11, extraTopOffset), Math.max(e11, extraRightOffset), Math.max(e11, extraBottomOffset));
        if (this.f65357b) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Content: ");
            sb2.append(this.f65376u.o().toString());
            Log.i(Chart.LOG_TAG, sb2.toString());
        }
        O();
        P();
    }

    public float getHighestVisibleX() {
        d(YAxis.AxisDependency.LEFT).h(this.f65376u.h(), this.f65376u.j(), this.f65352v0);
        return (float) Math.min((double) this.f65365j.F, this.f65352v0.f65589d);
    }

    public float getLowestVisibleX() {
        d(YAxis.AxisDependency.LEFT).h(this.f65376u.h(), this.f65376u.f(), this.f65351u0);
        return (float) Math.max((double) this.f65365j.G, this.f65351u0.f65589d);
    }

    public d k(float f11, float f12) {
        if (this.f65358c != null) {
            return getHighlighter().getHighlight(f12, f11);
        }
        if (!this.f65357b) {
            return null;
        }
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public float[] l(d dVar) {
        return new float[]{dVar.f(), dVar.e()};
    }

    public void n() {
        this.f65376u = new HorizontalViewPortHandler();
        super.n();
        this.f65341f0 = new b(this.f65376u);
        this.f65342g0 = new b(this.f65376u);
        this.f65374s = new h(this, this.f65377v, this.f65376u);
        setHighlighter(new e(this));
        this.f65339d0 = new u(this.f65376u, this.f65337b0, this.f65341f0);
        this.f65340e0 = new u(this.f65376u, this.f65338c0, this.f65342g0);
        this.f65343h0 = new r(this.f65376u, this.f65365j, this.f65341f0, this);
    }

    public void setVisibleXRangeMaximum(float f11) {
        this.f65376u.R(this.f65365j.H / f11);
    }

    public void setVisibleXRangeMinimum(float f11) {
        this.f65376u.P(this.f65365j.H / f11);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
