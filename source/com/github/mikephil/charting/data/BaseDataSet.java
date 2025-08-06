package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.huobi.view.roundimg.RoundedDrawable;
import g5.e;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<Integer> f65457a;

    /* renamed from: b  reason: collision with root package name */
    public List<Integer> f65458b;

    /* renamed from: c  reason: collision with root package name */
    public String f65459c;

    /* renamed from: d  reason: collision with root package name */
    public YAxis.AxisDependency f65460d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65461e;

    /* renamed from: f  reason: collision with root package name */
    public transient d5.e f65462f;

    /* renamed from: g  reason: collision with root package name */
    public Typeface f65463g;

    /* renamed from: h  reason: collision with root package name */
    public Legend.LegendForm f65464h;

    /* renamed from: i  reason: collision with root package name */
    public float f65465i;

    /* renamed from: j  reason: collision with root package name */
    public float f65466j;

    /* renamed from: k  reason: collision with root package name */
    public DashPathEffect f65467k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f65468l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f65469m;

    /* renamed from: n  reason: collision with root package name */
    public MPPointF f65470n;

    /* renamed from: o  reason: collision with root package name */
    public float f65471o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f65472p;

    public BaseDataSet() {
        this.f65457a = null;
        this.f65458b = null;
        this.f65459c = "DataSet";
        this.f65460d = YAxis.AxisDependency.LEFT;
        this.f65461e = true;
        this.f65464h = Legend.LegendForm.DEFAULT;
        this.f65465i = Float.NaN;
        this.f65466j = Float.NaN;
        this.f65467k = null;
        this.f65468l = true;
        this.f65469m = true;
        this.f65470n = new MPPointF();
        this.f65471o = 17.0f;
        this.f65472p = true;
        this.f65457a = new ArrayList();
        this.f65458b = new ArrayList();
        this.f65457a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f65458b.add(Integer.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR));
    }

    public void I(d5.e eVar) {
        if (eVar != null) {
            this.f65462f = eVar;
        }
    }

    public void d0() {
        calcMinMax();
    }

    public void e0() {
        if (this.f65457a == null) {
            this.f65457a = new ArrayList();
        }
        this.f65457a.clear();
    }

    public void f0(int i11) {
        e0();
        this.f65457a.add(Integer.valueOf(i11));
    }

    public void g0(List<Integer> list) {
        this.f65457a = list;
    }

    public YAxis.AxisDependency getAxisDependency() {
        return this.f65460d;
    }

    public int getColor() {
        return this.f65457a.get(0).intValue();
    }

    public List<Integer> getColors() {
        return this.f65457a;
    }

    public Legend.LegendForm getForm() {
        return this.f65464h;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.f65467k;
    }

    public float getFormLineWidth() {
        return this.f65466j;
    }

    public float getFormSize() {
        return this.f65465i;
    }

    public MPPointF getIconsOffset() {
        return this.f65470n;
    }

    public String getLabel() {
        return this.f65459c;
    }

    public d5.e getValueFormatter() {
        if (needsFormatter()) {
            return Utils.j();
        }
        return this.f65462f;
    }

    public int getValueTextColor(int i11) {
        List<Integer> list = this.f65458b;
        return list.get(i11 % list.size()).intValue();
    }

    public float getValueTextSize() {
        return this.f65471o;
    }

    public Typeface getValueTypeface() {
        return this.f65463g;
    }

    public boolean isDrawIconsEnabled() {
        return this.f65469m;
    }

    public boolean isDrawValuesEnabled() {
        return this.f65468l;
    }

    public boolean isHighlightEnabled() {
        return this.f65461e;
    }

    public boolean isVisible() {
        return this.f65472p;
    }

    public boolean needsFormatter() {
        return this.f65462f == null;
    }

    public void setDrawValues(boolean z11) {
        this.f65468l = z11;
    }

    public void setValueTextSize(float f11) {
        this.f65471o = Utils.e(f11);
    }

    public int getColor(int i11) {
        List<Integer> list = this.f65457a;
        return list.get(i11 % list.size()).intValue();
    }

    public BaseDataSet(String str) {
        this();
        this.f65459c = str;
    }
}
