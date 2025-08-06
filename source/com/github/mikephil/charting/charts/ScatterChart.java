package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import f5.h;
import i5.p;

public class ScatterChart extends BarLineChartBase<ScatterData> implements h {

    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");
        
        private final String shapeIdentifier;

        private ScatterShape(String str) {
            this.shapeIdentifier = str;
        }

        public static ScatterShape[] getAllDefaultShapes() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }

        public String toString() {
            return this.shapeIdentifier;
        }
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterData getScatterData() {
        return (ScatterData) this.f65358c;
    }

    public void n() {
        super.n();
        this.f65374s = new p(this, this.f65377v, this.f65376u);
        getXAxis().M(0.5f);
        getXAxis().L(0.5f);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
