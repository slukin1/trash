package com.huobi.view.chart.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.huobi.view.chart.components.AxisBase;
import com.huobi.view.chart.utils.MPPointD;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;

public abstract class AxisRenderer extends Renderer {
    public AxisBase mAxis;
    public Paint mAxisLabelPaint;
    public Paint mAxisLinePaint;
    public Paint mGridPaint;
    public Paint mLimitLinePaint;
    public Transformer mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!z11) {
                f13 = (float) valuesByTouchPoint2.f19015y;
                d11 = valuesByTouchPoint.f19015y;
            } else {
                f13 = (float) valuesByTouchPoint.f19015y;
                d11 = valuesByTouchPoint2.f19015y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f11 = f13;
            f12 = (float) d11;
        }
        computeAxisValues(f11, f12);
    }

    public void computeAxisValues(float f11, float f12) {
        double d11;
        double d12;
        float f13 = f11;
        float f14 = f12;
        int labelCount = this.mAxis.getLabelCount();
        double abs = (double) Math.abs(f14 - f13);
        if (labelCount == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            AxisBase axisBase = this.mAxis;
            axisBase.mEntries = new float[0];
            axisBase.mCenteredEntries = new float[0];
            axisBase.mEntryCount = 0;
            return;
        }
        double roundToNextSignificant = (double) Utils.roundToNextSignificant(abs / ((double) labelCount));
        if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < ((double) this.mAxis.getGranularity())) {
            roundToNextSignificant = (double) this.mAxis.getGranularity();
        }
        double roundToNextSignificant2 = (double) Utils.roundToNextSignificant(Math.pow(10.0d, (double) ((int) Math.log10(roundToNextSignificant))));
        if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
            roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
        }
        int isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled()) {
            roundToNextSignificant = (double) (((float) abs) / ((float) (labelCount - 1)));
            AxisBase axisBase2 = this.mAxis;
            axisBase2.mEntryCount = labelCount;
            if (axisBase2.mEntries.length < labelCount) {
                axisBase2.mEntries = new float[labelCount];
            }
            for (int i11 = 0; i11 < labelCount; i11++) {
                this.mAxis.mEntries[i11] = f13;
                f13 = (float) (((double) f13) + roundToNextSignificant);
            }
        } else {
            int i12 = (roundToNextSignificant > 0.0d ? 1 : (roundToNextSignificant == 0.0d ? 0 : -1));
            if (i12 == 0) {
                d11 = 0.0d;
            } else {
                d11 = Math.ceil(((double) f13) / roundToNextSignificant) * roundToNextSignificant;
            }
            if (this.mAxis.isCenterAxisLabelsEnabled()) {
                d11 -= roundToNextSignificant;
            }
            if (i12 == 0) {
                d12 = 0.0d;
            } else {
                d12 = Utils.nextUp(Math.floor(((double) f14) / roundToNextSignificant) * roundToNextSignificant);
            }
            if (i12 != 0) {
                for (double d13 = d11; d13 <= d12; d13 += roundToNextSignificant) {
                    isCenterAxisLabelsEnabled++;
                }
            }
            AxisBase axisBase3 = this.mAxis;
            axisBase3.mEntryCount = isCenterAxisLabelsEnabled;
            if (axisBase3.mEntries.length < isCenterAxisLabelsEnabled) {
                axisBase3.mEntries = new float[isCenterAxisLabelsEnabled];
            }
            for (int i13 = 0; i13 < isCenterAxisLabelsEnabled; i13++) {
                if (d11 == 0.0d) {
                    d11 = 0.0d;
                }
                this.mAxis.mEntries[i13] = (float) d11;
                d11 += roundToNextSignificant;
            }
            labelCount = isCenterAxisLabelsEnabled;
        }
        if (roundToNextSignificant < 1.0d) {
            this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
        } else {
            this.mAxis.mDecimals = 0;
        }
        if (this.mAxis.isCenterAxisLabelsEnabled()) {
            AxisBase axisBase4 = this.mAxis;
            if (axisBase4.mCenteredEntries.length < labelCount) {
                axisBase4.mCenteredEntries = new float[labelCount];
            }
            float f15 = ((float) roundToNextSignificant) / 2.0f;
            for (int i14 = 0; i14 < labelCount; i14++) {
                AxisBase axisBase5 = this.mAxis;
                axisBase5.mCenteredEntries[i14] = axisBase5.mEntries[i14] + f15;
            }
        }
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);
}
