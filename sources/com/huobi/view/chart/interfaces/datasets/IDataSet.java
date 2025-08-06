package com.huobi.view.chart.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.data.DataSet;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.model.GradientColor;
import com.huobi.view.chart.utils.MPPointF;
import java.util.List;

public interface IDataSet<T extends Entry> {
    boolean addEntry(T t11);

    void addEntryOrdered(T t11);

    void calcMinMax();

    void calcMinMaxY(float f11, float f12);

    void clear();

    boolean contains(T t11);

    YAxis.AxisDependency getAxisDependency();

    int getColor();

    int getColor(int i11);

    List<Integer> getColors();

    List<T> getEntriesForXValue(float f11);

    int getEntryCount();

    T getEntryForIndex(int i11);

    T getEntryForXValue(float f11, float f12);

    T getEntryForXValue(float f11, float f12, DataSet.Rounding rounding);

    int getEntryIndex(float f11, float f12, DataSet.Rounding rounding);

    int getEntryIndex(T t11);

    Legend.LegendForm getForm();

    DashPathEffect getFormLineDashEffect();

    float getFormLineWidth();

    float getFormSize();

    GradientColor getGradientColor();

    GradientColor getGradientColor(int i11);

    List<GradientColor> getGradientColors();

    MPPointF getIconsOffset();

    int getIndexInEntries(int i11);

    String getLabel();

    ValueFormatter getValueFormatter();

    int getValueTextColor();

    int getValueTextColor(int i11);

    float getValueTextSize();

    Typeface getValueTypeface();

    float getXMax();

    float getXMin();

    float getYMax();

    float getYMin();

    boolean isDrawIconsEnabled();

    boolean isDrawValuesEnabled();

    boolean isHighlightEnabled();

    boolean isVisible();

    boolean needsFormatter();

    boolean removeEntry(int i11);

    boolean removeEntry(T t11);

    boolean removeEntryByXValue(float f11);

    boolean removeFirst();

    boolean removeLast();

    void setAxisDependency(YAxis.AxisDependency axisDependency);

    void setDrawIcons(boolean z11);

    void setDrawValues(boolean z11);

    void setHighlightEnabled(boolean z11);

    void setIconsOffset(MPPointF mPPointF);

    void setLabel(String str);

    void setValueFormatter(ValueFormatter valueFormatter);

    void setValueTextColor(int i11);

    void setValueTextColors(List<Integer> list);

    void setValueTextSize(float f11);

    void setValueTypeface(Typeface typeface);

    void setVisible(boolean z11);
}
