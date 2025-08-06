package com.huobi.view.chart.components;

import android.graphics.Canvas;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.utils.MPPointF;

public interface IMarker {
    void draw(Canvas canvas, float f11, float f12);

    MPPointF getOffset();

    MPPointF getOffsetForDrawingAtPoint(float f11, float f12);

    void refreshContent(Entry entry, Highlight highlight);
}
