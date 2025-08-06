package com.huobi.view.chart.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.huobi.view.chart.components.LimitLine;
import com.huobi.view.chart.components.XAxis;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.utils.FSize;
import com.huobi.view.chart.utils.MPPointD;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.List;

public class XAxisRenderer extends AxisRenderer {
    public RectF mGridClippingRect = new RectF();
    public RectF mLimitLineClippingRect = new RectF();
    private Path mLimitLinePath = new Path();
    public float[] mLimitLineSegmentsBuffer = new float[4];
    public float[] mRenderGridLinesBuffer = new float[2];
    public Path mRenderGridLinesPath = new Path();
    public float[] mRenderLimitLinesBuffer = new float[2];
    public XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    public void computeAxis(float f11, float f12, boolean z11) {
        float f13;
        double d11;
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (z11) {
                f13 = (float) valuesByTouchPoint2.f19014x;
                d11 = valuesByTouchPoint.f19014x;
            } else {
                f13 = (float) valuesByTouchPoint.f19014x;
                d11 = valuesByTouchPoint2.f19014x;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f11 = f13;
            f12 = (float) d11;
        }
        computeAxisValues(f11, f12);
    }

    public void computeAxisValues(float f11, float f12) {
        super.computeAxisValues(f11, f12);
        computeSize();
    }

    public void computeSize() {
        String longestLabel = this.mXAxis.getLongestLabel();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize calcTextSize = Utils.calcTextSize(this.mAxisLabelPaint, longestLabel);
        float f11 = calcTextSize.width;
        float calcTextHeight = (float) Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f11, calcTextHeight, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(f11);
        this.mXAxis.mLabelHeight = Math.round(calcTextHeight);
        this.mXAxis.mLabelRotatedWidth = Math.round(sizeOfRotatedRectangleByDegrees.width);
        this.mXAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
        FSize.recycleInstance(calcTextSize);
    }

    public void drawGridLine(Canvas canvas, float f11, float f12, Path path) {
        path.moveTo(f11, this.mViewPortHandler.contentBottom());
        path.lineTo(f11, this.mViewPortHandler.contentTop());
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    public void drawLabel(Canvas canvas, String str, float f11, float f12, MPPointF mPPointF, float f13) {
        Utils.drawXAxisValue(canvas, str, f11, f12, this.mAxisLabelPaint, mPPointF, f13);
    }

    public void drawLabels(Canvas canvas, float f11, MPPointF mPPointF) {
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        boolean isCenterAxisLabelsEnabled = this.mXAxis.isCenterAxisLabelsEnabled();
        int i11 = this.mXAxis.mEntryCount * 2;
        float[] fArr = new float[i11];
        for (int i12 = 0; i12 < i11; i12 += 2) {
            if (isCenterAxisLabelsEnabled) {
                fArr[i12] = this.mXAxis.mCenteredEntries[i12 / 2];
            } else {
                fArr[i12] = this.mXAxis.mEntries[i12 / 2];
            }
        }
        this.mTrans.pointValuesToPixel(fArr);
        for (int i13 = 0; i13 < i11; i13 += 2) {
            float f12 = fArr[i13];
            if (this.mViewPortHandler.isInBoundsX(f12)) {
                ValueFormatter valueFormatter = this.mXAxis.getValueFormatter();
                XAxis xAxis = this.mXAxis;
                int i14 = i13 / 2;
                String axisLabel = valueFormatter.getAxisLabel(xAxis.mEntries[i14], xAxis);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    int i15 = this.mXAxis.mEntryCount;
                    if (i14 == i15 - 1 && i15 > 1) {
                        float calcTextWidth = (float) Utils.calcTextWidth(this.mAxisLabelPaint, axisLabel);
                        if (calcTextWidth > this.mViewPortHandler.offsetRight() * 2.0f && f12 + calcTextWidth > this.mViewPortHandler.getChartWidth()) {
                            f12 -= calcTextWidth / 2.0f;
                        }
                    } else if (i13 == 0) {
                        f12 += ((float) Utils.calcTextWidth(this.mAxisLabelPaint, axisLabel)) / 2.0f;
                    }
                }
                drawLabel(canvas, axisLabel, f12, f11, mPPointF, labelRotationAngle);
            }
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0f);
        return this.mGridClippingRect;
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float yOffset = this.mXAxis.getYOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            MPPointF instance = MPPointF.getInstance(0.0f, 0.0f);
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                instance.f19016x = 0.5f;
                instance.f19017y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                instance.f19016x = 0.5f;
                instance.f19017y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() + yOffset + ((float) this.mXAxis.mLabelRotatedHeight), instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                instance.f19016x = 0.5f;
                instance.f19017y = 0.0f;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, instance);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                instance.f19016x = 0.5f;
                instance.f19017y = 0.0f;
                drawLabels(canvas, (this.mViewPortHandler.contentBottom() - yOffset) - ((float) this.mXAxis.mLabelRotatedHeight), instance);
            } else {
                instance.f19016x = 0.5f;
                instance.f19017y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, instance);
                instance.f19016x = 0.5f;
                instance.f19017y = 0.0f;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, instance);
            }
            MPPointF.recycleInstance(instance);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            this.mAxisLinePaint.setPathEffect(this.mXAxis.getAxisLineDashPathEffect());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            int save = canvas.save();
            canvas.clipRect(getGridClippingRect());
            if (this.mRenderGridLinesBuffer.length != this.mAxis.mEntryCount * 2) {
                this.mRenderGridLinesBuffer = new float[(this.mXAxis.mEntryCount * 2)];
            }
            float[] fArr = this.mRenderGridLinesBuffer;
            for (int i11 = 0; i11 < fArr.length; i11 += 2) {
                float[] fArr2 = this.mXAxis.mEntries;
                int i12 = i11 / 2;
                fArr[i11] = fArr2[i12];
                fArr[i11 + 1] = fArr2[i12];
            }
            this.mTrans.pointValuesToPixel(fArr);
            setupGridPaint();
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i13 = 0; i13 < fArr.length; i13 += 2) {
                drawGridLine(canvas, fArr[i13], fArr[i13 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void renderLimitLineLabel(Canvas canvas, LimitLine limitLine, float[] fArr, float f11) {
        String label = limitLine.getLabel();
        if (label != null && !label.equals("")) {
            this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
            this.mLimitLinePaint.setPathEffect((PathEffect) null);
            this.mLimitLinePaint.setColor(limitLine.getTextColor());
            this.mLimitLinePaint.setStrokeWidth(0.5f);
            this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
            float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
            LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
            if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + f11 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - f11, this.mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + f11 + ((float) Utils.calcTextHeight(this.mLimitLinePaint, label)), this.mLimitLinePaint);
            } else {
                this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - f11, this.mLimitLinePaint);
            }
        }
    }

    public void renderLimitLineLine(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.mLimitLineSegmentsBuffer;
        fArr2[0] = fArr[0];
        fArr2[1] = this.mViewPortHandler.contentTop();
        float[] fArr3 = this.mLimitLineSegmentsBuffer;
        fArr3[2] = fArr[0];
        fArr3[3] = this.mViewPortHandler.contentBottom();
        this.mLimitLinePath.reset();
        Path path = this.mLimitLinePath;
        float[] fArr4 = this.mLimitLineSegmentsBuffer;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.mLimitLinePath;
        float[] fArr5 = this.mLimitLineSegmentsBuffer;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(limitLine.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
        this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
        canvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = this.mRenderLimitLinesBuffer;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i11 = 0; i11 < limitLines.size(); i11++) {
                LimitLine limitLine = limitLines.get(i11);
                if (limitLine.isEnabled()) {
                    int save = canvas.save();
                    this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                    this.mLimitLineClippingRect.inset(-limitLine.getLineWidth(), 0.0f);
                    canvas.clipRect(this.mLimitLineClippingRect);
                    fArr[0] = limitLine.getLimit();
                    fArr[1] = 0.0f;
                    this.mTrans.pointValuesToPixel(fArr);
                    renderLimitLineLine(canvas, limitLine, fArr);
                    renderLimitLineLabel(canvas, limitLine, fArr, limitLine.getYOffset() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    public void setupGridPaint() {
        this.mGridPaint.setColor(this.mXAxis.getGridColor());
        this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
        this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
    }
}
