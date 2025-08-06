package com.huobi.view.barchart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.io.Serializable;

public class BarChartItemShape implements Serializable {
    private Paint.Align align;
    private int chartColor;
    private String label;
    private final Paint labelTextPaint;
    private int lineEndRadius;
    private Paint linePaint;
    private Path linePath = new Path();
    private int[] linePathPoints;
    private final int lineTextMargin;
    private int lineWidth = 3;
    private String percentText;
    private final Paint percentTextPaint;
    private float starAngel;
    private float sweepAngel;

    public BarChartItemShape(int i11, Paint paint, Paint paint2, int i12, int i13) {
        this.lineEndRadius = i11;
        this.lineTextMargin = i13;
        this.labelTextPaint = paint;
        this.percentTextPaint = paint2;
    }

    public void draw(Canvas canvas, RectF rectF, Paint paint) {
        float f11;
        float f12;
        paint.setColor(this.chartColor);
        canvas.drawArc(rectF, this.starAngel, this.sweepAngel, false, paint);
        Path path = this.linePath;
        int[] iArr = this.linePathPoints;
        path.moveTo((float) iArr[0], (float) iArr[1]);
        Path path2 = this.linePath;
        int[] iArr2 = this.linePathPoints;
        path2.lineTo((float) iArr2[2], (float) iArr2[3]);
        Path path3 = this.linePath;
        int[] iArr3 = this.linePathPoints;
        path3.lineTo((float) iArr3[4], (float) iArr3[5]);
        this.linePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.linePath, this.linePaint);
        this.linePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        int[] iArr4 = this.linePathPoints;
        canvas.drawCircle((float) iArr4[4], (float) iArr4[5], (float) this.lineEndRadius, this.linePaint);
        this.labelTextPaint.setTextAlign(this.align);
        float measureText = this.labelTextPaint.measureText(this.label);
        float measureText2 = this.percentTextPaint.measureText(this.percentText);
        Paint.Align align2 = this.align;
        Paint.Align align3 = Paint.Align.LEFT;
        if (align2 == align3) {
            int[] iArr5 = this.linePathPoints;
            f12 = (float) iArr5[4];
            f11 = ((float) iArr5[4]) + measureText + 8.0f;
        } else {
            this.labelTextPaint.setTextAlign(align3);
            this.percentTextPaint.setTextAlign(Paint.Align.LEFT);
            f12 = ((((float) this.linePathPoints[4]) - measureText) - measureText2) - 8.0f;
            f11 = measureText + f12 + 8.0f;
        }
        canvas.drawText(this.label, f12, BarChart.fixTextY(this.labelTextPaint, (float) (this.linePathPoints[5] - this.lineTextMargin), false) - ((float) this.lineTextMargin), this.labelTextPaint);
        canvas.drawText(this.percentText, f11, BarChart.fixTextY(this.percentTextPaint, (float) (this.linePathPoints[5] - this.lineTextMargin), false) - ((float) this.lineTextMargin), this.percentTextPaint);
    }

    public void setChartColor(int i11) {
        this.chartColor = i11;
        Paint paint = new Paint(1);
        this.linePaint = paint;
        paint.setColor(i11);
        this.linePaint.setStrokeWidth((float) this.lineWidth);
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLineEndRadius(int i11) {
        this.lineEndRadius = i11;
    }

    public void setLinePaint(Paint paint) {
        this.linePaint = paint;
    }

    public void setLinePath(Path path) {
        this.linePath = path;
    }

    public void setLinePathPoints(int[] iArr) {
        this.linePathPoints = iArr;
    }

    public void setPercentText(String str) {
        this.percentText = str;
    }

    public void setStarAngel(float f11) {
        this.starAngel = f11;
    }

    public void setSweepAngel(float f11) {
        this.sweepAngel = f11;
    }

    public void setTextAlign(Paint.Align align2) {
        this.align = align2;
    }
}
