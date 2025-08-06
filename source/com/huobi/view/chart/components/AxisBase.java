package com.huobi.view.chart.components;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.huobi.view.chart.formatter.DefaultAxisValueFormatter;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
    private int mAxisLineColor = -7829368;
    private DashPathEffect mAxisLineDashPathEffect = null;
    private float mAxisLineWidth = 1.0f;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;
    public ValueFormatter mAxisValueFormatter;
    public boolean mCenterAxisLabels = false;
    public float[] mCenteredEntries = new float[0];
    public boolean mCustomAxisMax = false;
    public boolean mCustomAxisMin = false;
    public int mDecimals;
    public boolean mDrawAxisLine = true;
    public boolean mDrawGridLines = true;
    public boolean mDrawGridLinesBehindData = true;
    public boolean mDrawLabels = true;
    public boolean mDrawLimitLineBehindData = false;
    public float[] mEntries = new float[0];
    public int mEntryCount;
    public boolean mForceLabels = false;
    public float mGranularity = 1.0f;
    public boolean mGranularityEnabled = false;
    private int mGridColor = -7829368;
    private DashPathEffect mGridDashPathEffect = null;
    private float mGridLineWidth = 1.0f;
    private int mLabelCount = 6;
    public List<LimitLine> mLimitLines;
    public float mSpaceMax = 0.0f;
    public float mSpaceMin = 0.0f;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        if (this.mLimitLines.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public void calculate(float f11, float f12) {
        float f13 = this.mCustomAxisMin ? this.mAxisMinimum : f11 - this.mSpaceMin;
        float f14 = this.mCustomAxisMax ? this.mAxisMaximum : f12 + this.mSpaceMax;
        if (Math.abs(f14 - f13) == 0.0f) {
            f14 += 1.0f;
            f13 -= 1.0f;
        }
        this.mAxisMinimum = f13;
        this.mAxisMaximum = f14;
        this.mAxisRange = Math.abs(f14 - f13);
    }

    public void disableAxisLineDashedLine() {
        this.mAxisLineDashPathEffect = null;
    }

    public void disableGridDashedLine() {
        this.mGridDashPathEffect = null;
    }

    public void enableAxisLineDashedLine(float f11, float f12, float f13) {
        this.mAxisLineDashPathEffect = new DashPathEffect(new float[]{f11, f12}, f13);
    }

    public void enableGridDashedLine(float f11, float f12, float f13) {
        this.mGridDashPathEffect = new DashPathEffect(new float[]{f11, f12}, f13);
    }

    public int getAxisLineColor() {
        return this.mAxisLineColor;
    }

    public DashPathEffect getAxisLineDashPathEffect() {
        return this.mAxisLineDashPathEffect;
    }

    public float getAxisLineWidth() {
        return this.mAxisLineWidth;
    }

    public float getAxisMaximum() {
        return this.mAxisMaximum;
    }

    public float getAxisMinimum() {
        return this.mAxisMinimum;
    }

    public String getFormattedLabel(int i11) {
        return (i11 < 0 || i11 >= this.mEntries.length) ? "" : getValueFormatter().getAxisLabel(this.mEntries[i11], this);
    }

    public float getGranularity() {
        return this.mGranularity;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.mGridDashPathEffect;
    }

    public float getGridLineWidth() {
        return this.mGridLineWidth;
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i11 = 0; i11 < this.mEntries.length; i11++) {
            String formattedLabel = getFormattedLabel(i11);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public float getSpaceMax() {
        return this.mSpaceMax;
    }

    public float getSpaceMin() {
        return this.mSpaceMin;
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mAxisValueFormatter;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).getDecimalDigits() != this.mDecimals)) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }

    public boolean isAxisLineDashedLineEnabled() {
        return this.mAxisLineDashPathEffect != null;
    }

    public boolean isAxisMaxCustom() {
        return this.mCustomAxisMax;
    }

    public boolean isAxisMinCustom() {
        return this.mCustomAxisMin;
    }

    public boolean isCenterAxisLabelsEnabled() {
        return this.mCenterAxisLabels && this.mEntryCount > 0;
    }

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public boolean isDrawGridLinesBehindDataEnabled() {
        return this.mDrawGridLinesBehindData;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public boolean isGranularityEnabled() {
        return this.mGranularityEnabled;
    }

    public boolean isGridDashedLineEnabled() {
        return this.mGridDashPathEffect != null;
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void resetAxisMaximum() {
        this.mCustomAxisMax = false;
    }

    public void resetAxisMinimum() {
        this.mCustomAxisMin = false;
    }

    public void setAxisLineColor(int i11) {
        this.mAxisLineColor = i11;
    }

    public void setAxisLineDashedLine(DashPathEffect dashPathEffect) {
        this.mAxisLineDashPathEffect = dashPathEffect;
    }

    public void setAxisLineWidth(float f11) {
        this.mAxisLineWidth = Utils.convertDpToPixel(f11);
    }

    @Deprecated
    public void setAxisMaxValue(float f11) {
        setAxisMaximum(f11);
    }

    public void setAxisMaximum(float f11) {
        this.mCustomAxisMax = true;
        this.mAxisMaximum = f11;
        this.mAxisRange = Math.abs(f11 - this.mAxisMinimum);
    }

    @Deprecated
    public void setAxisMinValue(float f11) {
        setAxisMinimum(f11);
    }

    public void setAxisMinimum(float f11) {
        this.mCustomAxisMin = true;
        this.mAxisMinimum = f11;
        this.mAxisRange = Math.abs(this.mAxisMaximum - f11);
    }

    public void setCenterAxisLabels(boolean z11) {
        this.mCenterAxisLabels = z11;
    }

    public void setDrawAxisLine(boolean z11) {
        this.mDrawAxisLine = z11;
    }

    public void setDrawGridLines(boolean z11) {
        this.mDrawGridLines = z11;
    }

    public void setDrawGridLinesBehindData(boolean z11) {
        this.mDrawGridLinesBehindData = z11;
    }

    public void setDrawLabels(boolean z11) {
        this.mDrawLabels = z11;
    }

    public void setDrawLimitLinesBehindData(boolean z11) {
        this.mDrawLimitLineBehindData = z11;
    }

    public void setGranularity(float f11) {
        this.mGranularity = f11;
        this.mGranularityEnabled = true;
    }

    public void setGranularityEnabled(boolean z11) {
        this.mGranularityEnabled = z11;
    }

    public void setGridColor(int i11) {
        this.mGridColor = i11;
    }

    public void setGridDashedLine(DashPathEffect dashPathEffect) {
        this.mGridDashPathEffect = dashPathEffect;
    }

    public void setGridLineWidth(float f11) {
        this.mGridLineWidth = Utils.convertDpToPixel(f11);
    }

    public void setLabelCount(int i11, boolean z11) {
        setLabelCount(i11);
        this.mForceLabels = z11;
    }

    public void setSpaceMax(float f11) {
        this.mSpaceMax = f11;
    }

    public void setSpaceMin(float f11) {
        this.mSpaceMin = f11;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        } else {
            this.mAxisValueFormatter = valueFormatter;
        }
    }

    public void setLabelCount(int i11) {
        if (i11 > 25) {
            i11 = 25;
        }
        if (i11 < 2) {
            i11 = 2;
        }
        this.mLabelCount = i11;
        this.mForceLabels = false;
    }
}
