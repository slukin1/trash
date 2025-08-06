package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.huobi.view.chart.Chart;
import e5.c;
import e5.d;
import f5.f;
import g5.b;

public class CombinedChart extends BarLineChartBase<CombinedData> implements f {
    public DrawOrder[] A0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f65383x0 = true;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f65384y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f65385z0 = false;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a() {
        return this.f65383x0;
    }

    public boolean b() {
        return this.f65384y0;
    }

    public boolean c() {
        return this.f65385z0;
    }

    public BarData getBarData() {
        T t11 = this.f65358c;
        if (t11 == null) {
            return null;
        }
        return ((CombinedData) t11).w();
    }

    public BubbleData getBubbleData() {
        T t11 = this.f65358c;
        if (t11 == null) {
            return null;
        }
        return ((CombinedData) t11).x();
    }

    public CandleData getCandleData() {
        T t11 = this.f65358c;
        if (t11 == null) {
            return null;
        }
        return ((CombinedData) t11).y();
    }

    public CombinedData getCombinedData() {
        return (CombinedData) this.f65358c;
    }

    public DrawOrder[] getDrawOrder() {
        return this.A0;
    }

    public LineData getLineData() {
        T t11 = this.f65358c;
        if (t11 == null) {
            return null;
        }
        return ((CombinedData) t11).B();
    }

    public ScatterData getScatterData() {
        T t11 = this.f65358c;
        if (t11 == null) {
            return null;
        }
        return ((CombinedData) t11).C();
    }

    public void i(Canvas canvas) {
        if (this.E != null && p() && v()) {
            int i11 = 0;
            while (true) {
                d[] dVarArr = this.B;
                if (i11 < dVarArr.length) {
                    d dVar = dVarArr[i11];
                    b<? extends Entry> A = ((CombinedData) this.f65358c).A(dVar);
                    Entry i12 = ((CombinedData) this.f65358c).i(dVar);
                    if (i12 != null && ((float) A.b(i12)) <= ((float) A.getEntryCount()) * this.f65377v.a()) {
                        float[] l11 = l(dVar);
                        if (this.f65376u.x(l11[0], l11[1])) {
                            this.E.a(i12, dVar);
                            this.E.draw(canvas, l11[0], l11[1]);
                        }
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
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
        this.A0 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new c(this, this));
        setHighlightFullBarEnabled(true);
        this.f65374s = new i5.f(this, this.f65377v, this.f65376u);
    }

    public void setDrawBarShadow(boolean z11) {
        this.f65385z0 = z11;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr != null && drawOrderArr.length > 0) {
            this.A0 = drawOrderArr;
        }
    }

    public void setDrawValueAboveBar(boolean z11) {
        this.f65383x0 = z11;
    }

    public void setHighlightFullBarEnabled(boolean z11) {
        this.f65384y0 = z11;
    }

    public void setData(CombinedData combinedData) {
        super.setData(combinedData);
        setHighlighter(new c(this, this));
        ((i5.f) this.f65374s).i();
        this.f65374s.g();
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
