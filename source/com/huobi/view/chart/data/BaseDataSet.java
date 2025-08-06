package com.huobi.view.chart.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.interfaces.datasets.IDataSet;
import com.huobi.view.chart.model.GradientColor;
import com.huobi.view.chart.utils.ColorTemplate;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {
    public YAxis.AxisDependency mAxisDependency;
    public List<Integer> mColors;
    public boolean mDrawIcons;
    public boolean mDrawValues;
    private Legend.LegendForm mForm;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    public GradientColor mGradientColor;
    public List<GradientColor> mGradientColors;
    public boolean mHighlightEnabled;
    public MPPointF mIconsOffset;
    private String mLabel;
    public List<Integer> mValueColors;
    public transient ValueFormatter mValueFormatter;
    public float mValueTextSize;
    public Typeface mValueTypeface;
    public boolean mVisible;

    public BaseDataSet() {
        this.mColors = null;
        this.mGradientColor = null;
        this.mGradientColors = null;
        this.mValueColors = null;
        this.mAxisDependency = YAxis.AxisDependency.LEFT;
        this.mHighlightEnabled = true;
        this.mDrawValues = true;
        this.mDrawIcons = true;
        this.mIconsOffset = new MPPointF();
        this.mValueTextSize = 17.0f;
        this.mVisible = true;
        this.mLabel = "DataSet";
        this.mForm = Legend.LegendForm.DEFAULT;
        this.mFormSize = Float.NaN;
        this.mFormLineWidth = Float.NaN;
        this.mFormLineDashEffect = null;
        this.mColors = new ArrayList();
        this.mValueColors = new ArrayList();
        this.mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.mValueColors.add(Integer.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR));
    }

    public void addColor(int i11) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.add(Integer.valueOf(i11));
    }

    public boolean contains(T t11) {
        for (int i11 = 0; i11 < getEntryCount(); i11++) {
            if (getEntryForIndex(i11).equals(t11)) {
                return true;
            }
        }
        return false;
    }

    public void copy(BaseDataSet baseDataSet) {
        baseDataSet.mAxisDependency = this.mAxisDependency;
        baseDataSet.mColors = this.mColors;
        baseDataSet.mDrawIcons = this.mDrawIcons;
        baseDataSet.mDrawValues = this.mDrawValues;
        baseDataSet.mForm = this.mForm;
        baseDataSet.mFormLineDashEffect = this.mFormLineDashEffect;
        baseDataSet.mFormLineWidth = this.mFormLineWidth;
        baseDataSet.mFormSize = this.mFormSize;
        baseDataSet.mGradientColor = this.mGradientColor;
        baseDataSet.mGradientColors = this.mGradientColors;
        baseDataSet.mHighlightEnabled = this.mHighlightEnabled;
        baseDataSet.mIconsOffset = this.mIconsOffset;
        baseDataSet.mValueColors = this.mValueColors;
        baseDataSet.mValueFormatter = this.mValueFormatter;
        baseDataSet.mValueColors = this.mValueColors;
        baseDataSet.mValueTextSize = this.mValueTextSize;
        baseDataSet.mVisible = this.mVisible;
    }

    public YAxis.AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public int getColor() {
        return this.mColors.get(0).intValue();
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public Legend.LegendForm getForm() {
        return this.mForm;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public GradientColor getGradientColor() {
        return this.mGradientColor;
    }

    public List<GradientColor> getGradientColors() {
        return this.mGradientColors;
    }

    public MPPointF getIconsOffset() {
        return this.mIconsOffset;
    }

    public int getIndexInEntries(int i11) {
        for (int i12 = 0; i12 < getEntryCount(); i12++) {
            if (((float) i11) == getEntryForIndex(i12).getX()) {
                return i12;
            }
        }
        return -1;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public List<Integer> getValueColors() {
        return this.mValueColors;
    }

    public ValueFormatter getValueFormatter() {
        if (needsFormatter()) {
            return Utils.getDefaultValueFormatter();
        }
        return this.mValueFormatter;
    }

    public int getValueTextColor() {
        return this.mValueColors.get(0).intValue();
    }

    public float getValueTextSize() {
        return this.mValueTextSize;
    }

    public Typeface getValueTypeface() {
        return this.mValueTypeface;
    }

    public boolean isDrawIconsEnabled() {
        return this.mDrawIcons;
    }

    public boolean isDrawValuesEnabled() {
        return this.mDrawValues;
    }

    public boolean isHighlightEnabled() {
        return this.mHighlightEnabled;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public boolean needsFormatter() {
        return this.mValueFormatter == null;
    }

    public void notifyDataSetChanged() {
        calcMinMax();
    }

    public boolean removeEntry(int i11) {
        return removeEntry(getEntryForIndex(i11));
    }

    public boolean removeEntryByXValue(float f11) {
        return removeEntry(getEntryForXValue(f11, Float.NaN));
    }

    public boolean removeFirst() {
        if (getEntryCount() > 0) {
            return removeEntry(getEntryForIndex(0));
        }
        return false;
    }

    public boolean removeLast() {
        if (getEntryCount() > 0) {
            return removeEntry(getEntryForIndex(getEntryCount() - 1));
        }
        return false;
    }

    public void resetColors() {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.clear();
    }

    public void setAxisDependency(YAxis.AxisDependency axisDependency) {
        this.mAxisDependency = axisDependency;
    }

    public void setColor(int i11) {
        resetColors();
        this.mColors.add(Integer.valueOf(i11));
    }

    public void setColors(int... iArr) {
        this.mColors = ColorTemplate.createColors(iArr);
    }

    public void setDrawIcons(boolean z11) {
        this.mDrawIcons = z11;
    }

    public void setDrawValues(boolean z11) {
        this.mDrawValues = z11;
    }

    public void setForm(Legend.LegendForm legendForm) {
        this.mForm = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f11) {
        this.mFormLineWidth = f11;
    }

    public void setFormSize(float f11) {
        this.mFormSize = f11;
    }

    public void setGradientColor(int i11, int i12) {
        this.mGradientColor = new GradientColor(i11, i12);
    }

    public void setGradientColors(List<GradientColor> list) {
        this.mGradientColors = list;
    }

    public void setHighlightEnabled(boolean z11) {
        this.mHighlightEnabled = z11;
    }

    public void setIconsOffset(MPPointF mPPointF) {
        MPPointF mPPointF2 = this.mIconsOffset;
        mPPointF2.f19016x = mPPointF.f19016x;
        mPPointF2.f19017y = mPPointF.f19017y;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            this.mValueFormatter = valueFormatter;
        }
    }

    public void setValueTextColor(int i11) {
        this.mValueColors.clear();
        this.mValueColors.add(Integer.valueOf(i11));
    }

    public void setValueTextColors(List<Integer> list) {
        this.mValueColors = list;
    }

    public void setValueTextSize(float f11) {
        this.mValueTextSize = Utils.convertDpToPixel(f11);
    }

    public void setValueTypeface(Typeface typeface) {
        this.mValueTypeface = typeface;
    }

    public void setVisible(boolean z11) {
        this.mVisible = z11;
    }

    public int getColor(int i11) {
        List<Integer> list = this.mColors;
        return list.get(i11 % list.size()).intValue();
    }

    public GradientColor getGradientColor(int i11) {
        List<GradientColor> list = this.mGradientColors;
        return list.get(i11 % list.size());
    }

    public int getValueTextColor(int i11) {
        List<Integer> list = this.mValueColors;
        return list.get(i11 % list.size()).intValue();
    }

    public void setColors(List<Integer> list) {
        this.mColors = list;
    }

    public void setColor(int i11, int i12) {
        setColor(Color.argb(i12, Color.red(i11), Color.green(i11), Color.blue(i11)));
    }

    public void setColors(int[] iArr, Context context) {
        if (this.mColors == null) {
            this.mColors = new ArrayList();
        }
        this.mColors.clear();
        for (int color : iArr) {
            this.mColors.add(Integer.valueOf(context.getResources().getColor(color)));
        }
    }

    public void setColors(int[] iArr, int i11) {
        resetColors();
        for (int i12 : iArr) {
            addColor(Color.argb(i11, Color.red(i12), Color.green(i12), Color.blue(i12)));
        }
    }

    public BaseDataSet(String str) {
        this();
        this.mLabel = str;
    }
}
