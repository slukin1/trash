package com.huobi.view.chart.data;

import com.huobi.view.chart.interfaces.datasets.IPieDataSet;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private boolean mAutomaticallyDisableSliceSpacing;
    private float mShift = 18.0f;
    private float mSliceSpace = 0.0f;
    private boolean mUsingSliceColorAsValueLineColor;
    private int mValueLineColor;
    private float mValueLinePart1Length;
    private float mValueLinePart1OffsetPercentage;
    private float mValueLinePart2Length;
    private boolean mValueLineVariableLength;
    private float mValueLineWidth;
    private ValuePosition mXValuePosition;
    private ValuePosition mYValuePosition;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.mXValuePosition = valuePosition;
        this.mYValuePosition = valuePosition;
        this.mUsingSliceColorAsValueLineColor = false;
        this.mValueLineColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.mValueLineWidth = 1.0f;
        this.mValueLinePart1OffsetPercentage = 75.0f;
        this.mValueLinePart1Length = 0.3f;
        this.mValueLinePart2Length = 0.4f;
        this.mValueLineVariableLength = true;
    }

    public DataSet<PieEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.mValues.size(); i11++) {
            arrayList.add(((PieEntry) this.mValues.get(i11)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        copy(pieDataSet);
        return pieDataSet;
    }

    public float getSelectionShift() {
        return this.mShift;
    }

    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    public int getValueLineColor() {
        return this.mValueLineColor;
    }

    public float getValueLinePart1Length() {
        return this.mValueLinePart1Length;
    }

    public float getValueLinePart1OffsetPercentage() {
        return this.mValueLinePart1OffsetPercentage;
    }

    public float getValueLinePart2Length() {
        return this.mValueLinePart2Length;
    }

    public float getValueLineWidth() {
        return this.mValueLineWidth;
    }

    public ValuePosition getXValuePosition() {
        return this.mXValuePosition;
    }

    public ValuePosition getYValuePosition() {
        return this.mYValuePosition;
    }

    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.mAutomaticallyDisableSliceSpacing;
    }

    public boolean isUsingSliceColorAsValueLineColor() {
        return this.mUsingSliceColorAsValueLineColor;
    }

    public boolean isValueLineVariableLength() {
        return this.mValueLineVariableLength;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean z11) {
        this.mAutomaticallyDisableSliceSpacing = z11;
    }

    public void setSelectionShift(float f11) {
        this.mShift = Utils.convertDpToPixel(f11);
    }

    public void setSliceSpace(float f11) {
        if (f11 > 20.0f) {
            f11 = 20.0f;
        }
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.mSliceSpace = Utils.convertDpToPixel(f11);
    }

    public void setUsingSliceColorAsValueLineColor(boolean z11) {
        this.mUsingSliceColorAsValueLineColor = z11;
    }

    public void setValueLineColor(int i11) {
        this.mValueLineColor = i11;
    }

    public void setValueLinePart1Length(float f11) {
        this.mValueLinePart1Length = f11;
    }

    public void setValueLinePart1OffsetPercentage(float f11) {
        this.mValueLinePart1OffsetPercentage = f11;
    }

    public void setValueLinePart2Length(float f11) {
        this.mValueLinePart2Length = f11;
    }

    public void setValueLineVariableLength(boolean z11) {
        this.mValueLineVariableLength = z11;
    }

    public void setValueLineWidth(float f11) {
        this.mValueLineWidth = f11;
    }

    public void setXValuePosition(ValuePosition valuePosition) {
        this.mXValuePosition = valuePosition;
    }

    public void setYValuePosition(ValuePosition valuePosition) {
        this.mYValuePosition = valuePosition;
    }

    public void calcMinMax(PieEntry pieEntry) {
        if (pieEntry != null) {
            calcMinMaxY(pieEntry);
        }
    }

    public void copy(PieDataSet pieDataSet) {
        super.copy(pieDataSet);
    }
}
