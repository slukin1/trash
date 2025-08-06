package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.huobi.view.chart.Chart;
import e5.d;
import f5.a;
import i5.b;

public class BarChart extends BarLineChartBase<BarData> implements a {
    public boolean A0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f65333x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f65334y0 = true;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f65335z0 = false;

    public BarChart(Context context) {
        super(context);
    }

    public boolean a() {
        return this.f65334y0;
    }

    public boolean b() {
        return this.f65333x0;
    }

    public boolean c() {
        return this.f65335z0;
    }

    public BarData getBarData() {
        return (BarData) this.f65358c;
    }

    public d k(float f11, float f12) {
        if (this.f65358c == null) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        d highlight = getHighlighter().getHighlight(f11, f12);
        return (highlight == null || !b()) ? highlight : new d(highlight.h(), highlight.j(), highlight.i(), highlight.k(), highlight.d(), -1, highlight.b());
    }

    public void n() {
        super.n();
        this.f65374s = new b(this, this.f65377v, this.f65376u);
        setHighlighter(new e5.a(this));
        getXAxis().M(0.5f);
        getXAxis().L(0.5f);
    }

    public void setDrawBarShadow(boolean z11) {
        this.f65335z0 = z11;
    }

    public void setDrawValueAboveBar(boolean z11) {
        this.f65334y0 = z11;
    }

    public void setFitBars(boolean z11) {
        this.A0 = z11;
    }

    public void setHighlightFullBarEnabled(boolean z11) {
        this.f65333x0 = z11;
    }

    public void x() {
        if (this.A0) {
            this.f65365j.j(((BarData) this.f65358c).n() - (((BarData) this.f65358c).v() / 2.0f), ((BarData) this.f65358c).m() + (((BarData) this.f65358c).v() / 2.0f));
        } else {
            this.f65365j.j(((BarData) this.f65358c).n(), ((BarData) this.f65358c).m());
        }
        YAxis yAxis = this.f65337b0;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.j(((BarData) this.f65358c).r(axisDependency), ((BarData) this.f65358c).p(axisDependency));
        YAxis yAxis2 = this.f65338c0;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.j(((BarData) this.f65358c).r(axisDependency2), ((BarData) this.f65358c).p(axisDependency2));
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
