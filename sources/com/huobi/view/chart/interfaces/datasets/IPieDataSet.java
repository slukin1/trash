package com.huobi.view.chart.interfaces.datasets;

import com.huobi.view.chart.data.PieDataSet;
import com.huobi.view.chart.data.PieEntry;

public interface IPieDataSet extends IDataSet<PieEntry> {
    float getSelectionShift();

    float getSliceSpace();

    int getValueLineColor();

    float getValueLinePart1Length();

    float getValueLinePart1OffsetPercentage();

    float getValueLinePart2Length();

    float getValueLineWidth();

    PieDataSet.ValuePosition getXValuePosition();

    PieDataSet.ValuePosition getYValuePosition();

    boolean isAutomaticallyDisableSliceSpacingEnabled();

    boolean isUsingSliceColorAsValueLineColor();

    boolean isValueLineVariableLength();
}
