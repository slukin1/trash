package com.huobi.view.chart.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.huobi.view.chart.components.LimitLine;
import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.utils.MPPointD;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.List;

public class YAxisRenderer extends AxisRenderer {
    public Path mDrawZeroLinePath = new Path();
    public float[] mGetTransformedPositionsBuffer = new float[2];
    public RectF mGridClippingRect = new RectF();
    public RectF mLimitLineClippingRect = new RectF();
    public Path mRenderGridLinesPath = new Path();
    public Path mRenderLimitLines = new Path();
    public float[] mRenderLimitLinesBuffer = new float[2];
    public YAxis mYAxis;
    public RectF mZeroLineClippingRect = new RectF();
    public Paint mZeroLinePaint;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.mYAxis = yAxis;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
            Paint paint = new Paint(1);
            this.mZeroLinePaint = paint;
            paint.setColor(-7829368);
            this.mZeroLinePaint.setStrokeWidth(1.0f);
            this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
        }
    }

    public void drawYLabels(Canvas canvas, float f11, float[] fArr, float f12) {
        int i11;
        if (this.mYAxis.isDrawTopYLabelEntryEnabled()) {
            i11 = this.mYAxis.mEntryCount;
        } else {
            i11 = this.mYAxis.mEntryCount - 1;
        }
        for (int i12 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i12 < i11; i12++) {
            canvas.drawText(this.mYAxis.getFormattedLabel(i12), f11, fArr[(i12 * 2) + 1] + f12, this.mAxisLabelPaint);
        }
    }

    public void drawZeroLine(Canvas canvas) {
        int save = canvas.save();
        this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mZeroLineClippingRect.inset(0.0f, -this.mYAxis.getZeroLineWidth());
        canvas.clipRect(this.mZeroLineClippingRect);
        MPPointD pixelForValues = this.mTrans.getPixelForValues(0.0f, 0.0f);
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path path = this.mDrawZeroLinePath;
        path.reset();
        path.moveTo(this.mViewPortHandler.contentLeft(), (float) pixelForValues.f19015y);
        path.lineTo(this.mViewPortHandler.contentRight(), (float) pixelForValues.f19015y);
        canvas.drawPath(path, this.mZeroLinePaint);
        canvas.restoreToCount(save);
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(0.0f, -this.mAxis.getGridLineWidth());
        return this.mGridClippingRect;
    }

    public float[] getTransformedPositions() {
        int length = this.mGetTransformedPositionsBuffer.length;
        int i11 = this.mYAxis.mEntryCount;
        if (length != i11 * 2) {
            this.mGetTransformedPositionsBuffer = new float[(i11 * 2)];
        }
        float[] fArr = this.mGetTransformedPositionsBuffer;
        for (int i12 = 0; i12 < fArr.length; i12 += 2) {
            fArr[i12 + 1] = this.mYAxis.mEntries[i12 / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        return fArr;
    }

    public Path linePath(Path path, int i11, float[] fArr) {
        int i12 = i11 + 1;
        path.moveTo(this.mViewPortHandler.offsetLeft(), fArr[i12]);
        path.lineTo(this.mViewPortHandler.contentRight(), fArr[i12]);
        return path;
    }

    public void renderAxisLabels(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            float[] transformedPositions = getTransformedPositions();
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            float xOffset = this.mYAxis.getXOffset();
            float calcTextHeight = (((float) Utils.calcTextHeight(this.mAxisLabelPaint, "A")) / 2.5f) + this.mYAxis.getYOffset();
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                    f12 = this.mViewPortHandler.offsetLeft();
                    f11 = f12 - xOffset;
                    drawYLabels(canvas, f11, transformedPositions, calcTextHeight);
                }
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f13 = this.mViewPortHandler.offsetLeft();
            } else if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f13 = this.mViewPortHandler.contentRight();
            } else {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                f12 = this.mViewPortHandler.contentRight();
                f11 = f12 - xOffset;
                drawYLabels(canvas, f11, transformedPositions, calcTextHeight);
            }
            f11 = f13 + xOffset;
            drawYLabels(canvas, f11, transformedPositions, calcTextHeight);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
                return;
            }
            canvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isEnabled()) {
            if (this.mYAxis.isDrawGridLinesEnabled()) {
                int save = canvas.save();
                canvas.clipRect(getGridClippingRect());
                float[] transformedPositions = getTransformedPositions();
                this.mGridPaint.setColor(this.mYAxis.getGridColor());
                this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
                this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
                Path path = this.mRenderGridLinesPath;
                path.reset();
                for (int i11 = 0; i11 < transformedPositions.length; i11 += 2) {
                    canvas.drawPath(linePath(path, i11, transformedPositions), this.mGridPaint);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.mYAxis.isDrawZeroLineEnabled()) {
                drawZeroLine(canvas);
            }
        }
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = this.mRenderLimitLinesBuffer;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.mRenderLimitLines;
            path.reset();
            for (int i11 = 0; i11 < limitLines.size(); i11++) {
                LimitLine limitLine = limitLines.get(i11);
                if (limitLine.isEnabled()) {
                    int save = canvas.save();
                    this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                    this.mLimitLineClippingRect.inset(0.0f, -limitLine.getLineWidth());
                    canvas.clipRect(this.mLimitLineClippingRect);
                    this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    fArr[1] = limitLine.getLimit();
                    this.mTrans.pointValuesToPixel(fArr);
                    path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
                    path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                    canvas.drawPath(path, this.mLimitLinePaint);
                    path.reset();
                    String label = limitLine.getLabel();
                    if (label != null && !label.equals("")) {
                        this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                        this.mLimitLinePaint.setPathEffect((PathEffect) null);
                        this.mLimitLinePaint.setColor(limitLine.getTextColor());
                        this.mLimitLinePaint.setTypeface(limitLine.getTypeface());
                        this.mLimitLinePaint.setStrokeWidth(0.5f);
                        this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                        float calcTextHeight = (float) Utils.calcTextHeight(this.mLimitLinePaint, label);
                        float convertDpToPixel = Utils.convertDpToPixel(4.0f) + limitLine.getXOffset();
                        float lineWidth = limitLine.getLineWidth() + calcTextHeight + limitLine.getYOffset();
                        LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                        if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.contentLeft() + convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.offsetLeft() + convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }
}
