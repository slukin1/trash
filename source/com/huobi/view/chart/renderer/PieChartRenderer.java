package com.huobi.view.chart.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.huobi.view.chart.PieChart;
import com.huobi.view.chart.animation.ChartAnimator;
import com.huobi.view.chart.data.PieData;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.interfaces.datasets.IPieDataSet;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.chart.utils.ViewPortHandler;
import com.huobi.view.roundimg.RoundedDrawable;
import java.lang.ref.WeakReference;

public class PieChartRenderer extends DataRenderer {
    public Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds = new RectF();
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    public PieChart mChart;
    public WeakReference<Bitmap> mDrawBitmap;
    public Path mDrawCenterTextPathBuffer = new Path();
    public RectF mDrawHighlightedRectF = new RectF();
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath = new Path();
    public Paint mHolePaint;
    private RectF mInnerRectBuffer = new RectF();
    private Path mPathBuffer = new Path();
    private RectF[] mRectBuffer = {new RectF(), new RectF(), new RectF()};
    public Paint mTransparentCirclePaint;
    public Paint mValueLinePaint;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    public float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f11, float f12, float f13, float f14, float f15, float f16) {
        MPPointF mPPointF2 = mPPointF;
        double d11 = (double) ((f15 + f16) * 0.017453292f);
        float cos = mPPointF2.f19016x + (((float) Math.cos(d11)) * f11);
        float sin = mPPointF2.f19017y + (((float) Math.sin(d11)) * f11);
        double d12 = (double) ((f15 + (f16 / 2.0f)) * 0.017453292f);
        return (float) (((double) (f11 - ((float) ((Math.sqrt(Math.pow((double) (cos - f13), 2.0d) + Math.pow((double) (sin - f14), 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f12)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((double) ((mPPointF2.f19016x + (((float) Math.cos(d12)) * f11)) - ((cos + f13) / 2.0f)), 2.0d) + Math.pow((double) ((mPPointF2.f19017y + (((float) Math.sin(d12)) * f11)) - ((sin + f14) / 2.0f)), 2.0d)));
    }

    public void drawCenterText(Canvas canvas) {
        float f11;
        MPPointF mPPointF;
        Canvas canvas2 = canvas;
        CharSequence centerText = this.mChart.getCenterText();
        if (this.mChart.isDrawCenterTextEnabled() && centerText != null) {
            MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
            MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
            float f12 = centerCircleBox.f19016x + centerTextOffset.f19016x;
            float f13 = centerCircleBox.f19017y + centerTextOffset.f19017y;
            if (!this.mChart.isDrawHoleEnabled() || this.mChart.isDrawSlicesUnderHoleEnabled()) {
                f11 = this.mChart.getRadius();
            } else {
                f11 = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
            }
            RectF[] rectFArr = this.mRectBuffer;
            RectF rectF = rectFArr[0];
            rectF.left = f12 - f11;
            rectF.top = f13 - f11;
            rectF.right = f12 + f11;
            rectF.bottom = f13 + f11;
            RectF rectF2 = rectFArr[1];
            rectF2.set(rectF);
            float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
            if (((double) centerTextRadiusPercent) > 0.0d) {
                rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
            }
            if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
                this.mCenterTextLastBounds.set(rectF2);
                this.mCenterTextLastValue = centerText;
                mPPointF = centerTextOffset;
                StaticLayout staticLayout = r3;
                StaticLayout staticLayout2 = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil((double) this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                this.mCenterTextLayout = staticLayout;
            } else {
                mPPointF = centerTextOffset;
            }
            float height = (float) this.mCenterTextLayout.getHeight();
            canvas.save();
            if (Build.VERSION.SDK_INT >= 18) {
                Path path = this.mDrawCenterTextPathBuffer;
                path.reset();
                path.addOval(rectF, Path.Direction.CW);
                canvas2.clipPath(path);
            }
            canvas2.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
            this.mCenterTextLayout.draw(canvas2);
            canvas.restore();
            MPPointF.recycleInstance(centerCircleBox);
            MPPointF.recycleInstance(mPPointF);
        }
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == chartWidth && bitmap.getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                bitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
                this.mDrawBitmap = new WeakReference<>(bitmap);
                this.mBitmapCanvas = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    public void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f11;
        float[] fArr;
        float f12;
        float f13;
        int i11;
        RectF rectF;
        int i12;
        float f14;
        int i13;
        MPPointF mPPointF;
        RectF rectF2;
        float f15;
        int i14;
        float f16;
        float f17;
        float f18;
        int i15;
        RectF rectF3;
        RectF rectF4;
        MPPointF mPPointF2;
        int i16;
        float f19;
        MPPointF mPPointF3;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z11 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z11 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF5 = new RectF();
        boolean z12 = z11 && this.mChart.isDrawRoundedSlicesEnabled();
        int i17 = 0;
        for (int i18 = 0; i18 < entryCount; i18++) {
            if (Math.abs(((PieEntry) iPieDataSet2.getEntryForIndex(i18)).getY()) > Utils.FLOAT_EPSILON) {
                i17++;
            }
        }
        if (i17 <= 1) {
            f11 = 0.0f;
        } else {
            f11 = getSliceSpace(iPieDataSet2);
        }
        int i19 = 0;
        float f21 = 0.0f;
        while (i19 < entryCount) {
            float f22 = drawAngles[i19];
            float abs = Math.abs(iPieDataSet2.getEntryForIndex(i19).getY());
            float f23 = Utils.FLOAT_EPSILON;
            if (abs > f23 && (!this.mChart.needsHighlight(i19) || z12)) {
                boolean z13 = f11 > 0.0f && f22 <= 180.0f;
                i12 = entryCount;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i19));
                float f24 = i17 == 1 ? 0.0f : f11 / (radius * 0.017453292f);
                float f25 = rotationAngle + ((f21 + (f24 / 2.0f)) * phaseY);
                float f26 = (f22 - f24) * phaseY;
                float f27 = f26 < 0.0f ? 0.0f : f26;
                this.mPathBuffer.reset();
                if (z12) {
                    float f28 = radius - holeRadius2;
                    i11 = i19;
                    i14 = i17;
                    double d11 = (double) (f25 * 0.017453292f);
                    f13 = rotationAngle;
                    f12 = phaseX;
                    float cos = centerCircleBox.f19016x + (((float) Math.cos(d11)) * f28);
                    float sin = centerCircleBox.f19017y + (f28 * ((float) Math.sin(d11)));
                    rectF5.set(cos - holeRadius2, sin - holeRadius2, cos + holeRadius2, sin + holeRadius2);
                } else {
                    i11 = i19;
                    i14 = i17;
                    f13 = rotationAngle;
                    f12 = phaseX;
                }
                double d12 = (double) (f25 * 0.017453292f);
                float f29 = holeRadius;
                float cos2 = centerCircleBox.f19016x + (((float) Math.cos(d12)) * radius);
                float sin2 = centerCircleBox.f19017y + (((float) Math.sin(d12)) * radius);
                int i21 = (f27 > 360.0f ? 1 : (f27 == 360.0f ? 0 : -1));
                if (i21 < 0 || f27 % 360.0f > f23) {
                    fArr = drawAngles;
                    if (z12) {
                        this.mPathBuffer.arcTo(rectF5, f25 + 180.0f, -180.0f);
                    }
                    this.mPathBuffer.arcTo(circleBox, f25, f27);
                } else {
                    fArr = drawAngles;
                    this.mPathBuffer.addCircle(centerCircleBox.f19016x, centerCircleBox.f19017y, radius, Path.Direction.CW);
                }
                RectF rectF6 = this.mInnerRectBuffer;
                float f31 = centerCircleBox.f19016x;
                float f32 = centerCircleBox.f19017y;
                RectF rectF7 = rectF5;
                rectF6.set(f31 - f29, f32 - f29, f31 + f29, f32 + f29);
                if (!z11) {
                    f17 = radius;
                    f18 = f29;
                    i15 = i14;
                    rectF3 = rectF7;
                    rectF4 = circleBox;
                    mPPointF = centerCircleBox;
                    f16 = 360.0f;
                } else if (f29 > 0.0f || z13) {
                    if (z13) {
                        int i22 = i11;
                        i13 = i14;
                        float f33 = radius;
                        rectF = circleBox;
                        RectF rectF8 = rectF7;
                        f15 = f29;
                        i16 = 1;
                        f14 = radius;
                        float f34 = f25;
                        mPPointF2 = centerCircleBox;
                        float calculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, f33, f22 * phaseY, cos2, sin2, f34, f27);
                        if (calculateMinimumRadiusForSpacedSlice < 0.0f) {
                            calculateMinimumRadiusForSpacedSlice = -calculateMinimumRadiusForSpacedSlice;
                        }
                        f19 = Math.max(f15, calculateMinimumRadiusForSpacedSlice);
                    } else {
                        f14 = radius;
                        mPPointF2 = centerCircleBox;
                        f15 = f29;
                        i13 = i14;
                        rectF = circleBox;
                        i16 = 1;
                        f19 = f15;
                    }
                    float f35 = (i13 == i16 || f19 == 0.0f) ? 0.0f : f11 / (f19 * 0.017453292f);
                    float f36 = f13 + ((f21 + (f35 / 2.0f)) * phaseY);
                    float f37 = (f22 - f35) * phaseY;
                    if (f37 < 0.0f) {
                        f37 = 0.0f;
                    }
                    float f38 = f36 + f37;
                    if (i21 < 0 || f27 % 360.0f > f23) {
                        if (z12) {
                            float f39 = f14 - holeRadius2;
                            double d13 = (double) (0.017453292f * f38);
                            mPPointF3 = mPPointF2;
                            float cos3 = mPPointF2.f19016x + (((float) Math.cos(d13)) * f39);
                            float sin3 = mPPointF3.f19017y + (f39 * ((float) Math.sin(d13)));
                            rectF2 = rectF7;
                            rectF2.set(cos3 - holeRadius2, sin3 - holeRadius2, cos3 + holeRadius2, sin3 + holeRadius2);
                            this.mPathBuffer.arcTo(rectF2, f38, 180.0f);
                        } else {
                            mPPointF3 = mPPointF2;
                            rectF2 = rectF7;
                            double d14 = (double) (f38 * 0.017453292f);
                            this.mPathBuffer.lineTo(mPPointF3.f19016x + (((float) Math.cos(d14)) * f19), mPPointF3.f19017y + (f19 * ((float) Math.sin(d14))));
                        }
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f38, -f37);
                    } else {
                        this.mPathBuffer.addCircle(mPPointF2.f19016x, mPPointF2.f19017y, f19, Path.Direction.CCW);
                        mPPointF3 = mPPointF2;
                        rectF2 = rectF7;
                    }
                    mPPointF = mPPointF3;
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f21 += f22 * f12;
                } else {
                    f17 = radius;
                    f18 = f29;
                    i15 = i14;
                    rectF3 = rectF7;
                    f16 = 360.0f;
                    rectF4 = circleBox;
                    mPPointF = centerCircleBox;
                }
                if (f27 % f16 > f23) {
                    if (z13) {
                        float calculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f14, f22 * phaseY, cos2, sin2, f25, f27);
                        double d15 = (double) (0.017453292f * (f25 + (f27 / 2.0f)));
                        this.mPathBuffer.lineTo(mPPointF.f19016x + (((float) Math.cos(d15)) * calculateMinimumRadiusForSpacedSlice2), mPPointF.f19017y + (calculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d15))));
                    } else {
                        this.mPathBuffer.lineTo(mPPointF.f19016x, mPPointF.f19017y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                f21 += f22 * f12;
            } else {
                f21 += f22 * phaseX;
                i11 = i19;
                f14 = radius;
                f13 = rotationAngle;
                f12 = phaseX;
                rectF = circleBox;
                i12 = entryCount;
                fArr = drawAngles;
                i13 = i17;
                rectF2 = rectF5;
                f15 = holeRadius;
                mPPointF = centerCircleBox;
            }
            i19 = i11 + 1;
            iPieDataSet2 = iPieDataSet;
            holeRadius = f15;
            rectF5 = rectF2;
            centerCircleBox = mPPointF;
            i17 = i13;
            radius = f14;
            entryCount = i12;
            circleBox = rectF;
            rotationAngle = f13;
            phaseX = f12;
            drawAngles = fArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    public void drawEntryLabel(Canvas canvas, String str, float f11, float f12) {
        canvas.drawText(str, f11, f12, this.mEntryLabelsPaint);
    }

    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap((Bitmap) this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        boolean z11;
        float[] fArr;
        float f11;
        MPPointF mPPointF;
        float f12;
        int i11;
        RectF rectF;
        float f13;
        IPieDataSet dataSetByIndex;
        float f14;
        int i12;
        float f15;
        int i13;
        float f16;
        float[] fArr2;
        float f17;
        float f18;
        Highlight[] highlightArr2 = highlightArr;
        boolean z12 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (!z12 || !this.mChart.isDrawRoundedSlicesEnabled()) {
            float phaseX = this.mAnimator.getPhaseX();
            float phaseY = this.mAnimator.getPhaseY();
            float rotationAngle = this.mChart.getRotationAngle();
            float[] drawAngles = this.mChart.getDrawAngles();
            float[] absoluteAngles = this.mChart.getAbsoluteAngles();
            MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
            float radius = this.mChart.getRadius();
            float holeRadius = z12 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
            RectF rectF2 = this.mDrawHighlightedRectF;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            int i14 = 0;
            while (i14 < highlightArr2.length) {
                int x11 = (int) highlightArr2[i14].getX();
                if (x11 < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i14].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                    int entryCount = dataSetByIndex.getEntryCount();
                    int i15 = 0;
                    for (int i16 = 0; i16 < entryCount; i16++) {
                        if (Math.abs(((PieEntry) dataSetByIndex.getEntryForIndex(i16)).getY()) > Utils.FLOAT_EPSILON) {
                            i15++;
                        }
                    }
                    if (x11 == 0) {
                        i12 = 1;
                        f14 = 0.0f;
                    } else {
                        f14 = absoluteAngles[x11 - 1] * phaseX;
                        i12 = 1;
                    }
                    if (i15 <= i12) {
                        f15 = 0.0f;
                    } else {
                        f15 = dataSetByIndex.getSliceSpace();
                    }
                    float f19 = drawAngles[x11];
                    float selectionShift = dataSetByIndex.getSelectionShift();
                    int i17 = i14;
                    float f21 = radius + selectionShift;
                    float f22 = holeRadius;
                    rectF2.set(this.mChart.getCircleBox());
                    float f23 = -selectionShift;
                    rectF2.inset(f23, f23);
                    boolean z13 = f15 > 0.0f && f19 <= 180.0f;
                    this.mRenderPaint.setColor(dataSetByIndex.getColor(x11));
                    float f24 = i15 == 1 ? 0.0f : f15 / (radius * 0.017453292f);
                    float f25 = i15 == 1 ? 0.0f : f15 / (f21 * 0.017453292f);
                    float f26 = rotationAngle + (((f24 / 2.0f) + f14) * phaseY);
                    float f27 = (f19 - f24) * phaseY;
                    float f28 = f27 < 0.0f ? 0.0f : f27;
                    float f29 = (((f25 / 2.0f) + f14) * phaseY) + rotationAngle;
                    float f31 = (f19 - f25) * phaseY;
                    if (f31 < 0.0f) {
                        f31 = 0.0f;
                    }
                    this.mPathBuffer.reset();
                    int i18 = (f28 > 360.0f ? 1 : (f28 == 360.0f ? 0 : -1));
                    if (i18 < 0 || f28 % 360.0f > Utils.FLOAT_EPSILON) {
                        fArr2 = drawAngles;
                        f16 = f14;
                        double d11 = (double) (f29 * 0.017453292f);
                        i13 = i15;
                        z11 = z12;
                        this.mPathBuffer.moveTo(centerCircleBox.f19016x + (((float) Math.cos(d11)) * f21), centerCircleBox.f19017y + (f21 * ((float) Math.sin(d11))));
                        this.mPathBuffer.arcTo(rectF2, f29, f31);
                    } else {
                        this.mPathBuffer.addCircle(centerCircleBox.f19016x, centerCircleBox.f19017y, f21, Path.Direction.CW);
                        fArr2 = drawAngles;
                        f16 = f14;
                        i13 = i15;
                        z11 = z12;
                    }
                    if (z13) {
                        double d12 = (double) (f26 * 0.017453292f);
                        i11 = i17;
                        rectF = rectF2;
                        f12 = f22;
                        mPPointF = centerCircleBox;
                        fArr = fArr2;
                        f17 = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f19 * phaseY, (((float) Math.cos(d12)) * radius) + centerCircleBox.f19016x, centerCircleBox.f19017y + (((float) Math.sin(d12)) * radius), f26, f28);
                    } else {
                        rectF = rectF2;
                        mPPointF = centerCircleBox;
                        i11 = i17;
                        f12 = f22;
                        fArr = fArr2;
                        f17 = 0.0f;
                    }
                    RectF rectF3 = this.mInnerRectBuffer;
                    float f32 = mPPointF.f19016x;
                    float f33 = mPPointF.f19017y;
                    rectF3.set(f32 - f12, f33 - f12, f32 + f12, f33 + f12);
                    if (!z11 || (f12 <= 0.0f && !z13)) {
                        f13 = phaseX;
                        f11 = phaseY;
                        if (f28 % 360.0f > Utils.FLOAT_EPSILON) {
                            if (z13) {
                                double d13 = (double) ((f26 + (f28 / 2.0f)) * 0.017453292f);
                                this.mPathBuffer.lineTo(mPPointF.f19016x + (((float) Math.cos(d13)) * f17), mPPointF.f19017y + (f17 * ((float) Math.sin(d13))));
                            } else {
                                this.mPathBuffer.lineTo(mPPointF.f19016x, mPPointF.f19017y);
                            }
                        }
                    } else {
                        if (z13) {
                            if (f17 < 0.0f) {
                                f17 = -f17;
                            }
                            f18 = Math.max(f12, f17);
                        } else {
                            f18 = f12;
                        }
                        float f34 = (i13 == 1 || f18 == 0.0f) ? 0.0f : f15 / (f18 * 0.017453292f);
                        float f35 = ((f16 + (f34 / 2.0f)) * phaseY) + rotationAngle;
                        float f36 = (f19 - f34) * phaseY;
                        if (f36 < 0.0f) {
                            f36 = 0.0f;
                        }
                        float f37 = f35 + f36;
                        if (i18 < 0 || f28 % 360.0f > Utils.FLOAT_EPSILON) {
                            double d14 = (double) (f37 * 0.017453292f);
                            f13 = phaseX;
                            f11 = phaseY;
                            this.mPathBuffer.lineTo(mPPointF.f19016x + (((float) Math.cos(d14)) * f18), mPPointF.f19017y + (f18 * ((float) Math.sin(d14))));
                            this.mPathBuffer.arcTo(this.mInnerRectBuffer, f37, -f36);
                        } else {
                            this.mPathBuffer.addCircle(mPPointF.f19016x, mPPointF.f19017y, f18, Path.Direction.CCW);
                            f13 = phaseX;
                            f11 = phaseY;
                        }
                    }
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                } else {
                    i11 = i14;
                    rectF = rectF2;
                    f12 = holeRadius;
                    fArr = drawAngles;
                    z11 = z12;
                    f13 = phaseX;
                    f11 = phaseY;
                    mPPointF = centerCircleBox;
                }
                i14 = i11 + 1;
                phaseX = f13;
                rectF2 = rectF;
                holeRadius = f12;
                centerCircleBox = mPPointF;
                phaseY = f11;
                drawAngles = fArr;
                z12 = z11;
                highlightArr2 = highlightArr;
            }
            MPPointF.recycleInstance(centerCircleBox);
        }
    }

    public void drawHole(Canvas canvas) {
        if (this.mChart.isDrawHoleEnabled() && this.mBitmapCanvas != null) {
            float radius = this.mChart.getRadius();
            float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
            MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
            if (Color.alpha(this.mHolePaint.getColor()) > 0) {
                this.mBitmapCanvas.drawCircle(centerCircleBox.f19016x, centerCircleBox.f19017y, holeRadius, this.mHolePaint);
            }
            if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
                int alpha = this.mTransparentCirclePaint.getAlpha();
                float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
                this.mTransparentCirclePaint.setAlpha((int) (((float) alpha) * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
                this.mHoleCirclePath.reset();
                this.mHoleCirclePath.addCircle(centerCircleBox.f19016x, centerCircleBox.f19017y, transparentCircleRadius, Path.Direction.CW);
                this.mHoleCirclePath.addCircle(centerCircleBox.f19016x, centerCircleBox.f19017y, holeRadius, Path.Direction.CCW);
                this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
                this.mTransparentCirclePaint.setAlpha(alpha);
            }
            MPPointF.recycleInstance(centerCircleBox);
        }
    }

    public void drawRoundedSlices(Canvas canvas) {
        float f11;
        float f12;
        float[] fArr;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i11 = 0;
                while (i11 < dataSet.getEntryCount()) {
                    float f13 = drawAngles[i11];
                    if (Math.abs(dataSet.getEntryForIndex(i11).getY()) > Utils.FLOAT_EPSILON) {
                        double d11 = (double) (radius - holeRadius);
                        double d12 = (double) ((rotationAngle + f13) * phaseY);
                        f11 = phaseY;
                        fArr = drawAngles;
                        f12 = rotationAngle;
                        float cos = (float) (((double) centerCircleBox.f19016x) + (Math.cos(Math.toRadians(d12)) * d11));
                        float sin = (float) ((d11 * Math.sin(Math.toRadians(d12))) + ((double) centerCircleBox.f19017y));
                        this.mRenderPaint.setColor(dataSet.getColor(i11));
                        this.mBitmapCanvas.drawCircle(cos, sin, holeRadius, this.mRenderPaint);
                    } else {
                        f11 = phaseY;
                        fArr = drawAngles;
                        f12 = rotationAngle;
                    }
                    rotationAngle = f12 + (f13 * phaseX);
                    i11++;
                    phaseY = f11;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    public void drawValue(Canvas canvas, String str, float f11, float f12, int i11) {
        this.mValuePaint.setColor(i11);
        canvas.drawText(str, f11, f12, this.mValuePaint);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drawValues(android.graphics.Canvas r54) {
        /*
            r53 = this;
            r6 = r53
            r7 = r54
            com.huobi.view.chart.PieChart r0 = r6.mChart
            com.huobi.view.chart.utils.MPPointF r8 = r0.getCenterCircleBox()
            com.huobi.view.chart.PieChart r0 = r6.mChart
            float r9 = r0.getRadius()
            com.huobi.view.chart.PieChart r0 = r6.mChart
            float r0 = r0.getRotationAngle()
            com.huobi.view.chart.PieChart r1 = r6.mChart
            float[] r10 = r1.getDrawAngles()
            com.huobi.view.chart.PieChart r1 = r6.mChart
            float[] r11 = r1.getAbsoluteAngles()
            com.huobi.view.chart.animation.ChartAnimator r1 = r6.mAnimator
            float r12 = r1.getPhaseX()
            com.huobi.view.chart.animation.ChartAnimator r1 = r6.mAnimator
            float r13 = r1.getPhaseY()
            com.huobi.view.chart.PieChart r1 = r6.mChart
            float r1 = r1.getHoleRadius()
            float r1 = r1 * r9
            r14 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r14
            float r1 = r9 - r1
            r15 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r15
            com.huobi.view.chart.PieChart r2 = r6.mChart
            float r2 = r2.getHoleRadius()
            float r16 = r2 / r14
            r2 = 1092616192(0x41200000, float:10.0)
            float r2 = r9 / r2
            r3 = 1080452710(0x40666666, float:3.6)
            float r2 = r2 * r3
            com.huobi.view.chart.PieChart r3 = r6.mChart
            boolean r3 = r3.isDrawHoleEnabled()
            if (r3 == 0) goto L_0x007a
            float r2 = r9 * r16
            float r2 = r9 - r2
            float r2 = r2 / r15
            com.huobi.view.chart.PieChart r3 = r6.mChart
            boolean r3 = r3.isDrawSlicesUnderHoleEnabled()
            if (r3 != 0) goto L_0x007a
            com.huobi.view.chart.PieChart r3 = r6.mChart
            boolean r3 = r3.isDrawRoundedSlicesEnabled()
            if (r3 == 0) goto L_0x007a
            double r3 = (double) r0
            r0 = 1135869952(0x43b40000, float:360.0)
            float r1 = r1 * r0
            double r0 = (double) r1
            r17 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r14 = (double) r9
            double r14 = r14 * r17
            double r0 = r0 / r14
            double r3 = r3 + r0
            float r0 = (float) r3
        L_0x007a:
            r14 = r0
            float r15 = r9 - r2
            com.huobi.view.chart.PieChart r0 = r6.mChart
            com.huobi.view.chart.data.ChartData r0 = r0.getData()
            r17 = r0
            com.huobi.view.chart.data.PieData r17 = (com.huobi.view.chart.data.PieData) r17
            java.util.List r5 = r17.getDataSets()
            float r18 = r17.getYValueSum()
            com.huobi.view.chart.PieChart r0 = r6.mChart
            boolean r21 = r0.isDrawEntryLabelsEnabled()
            r54.save()
            r0 = 1084227584(0x40a00000, float:5.0)
            float r22 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r0)
            r23 = 0
            r0 = r23
            r4 = r0
        L_0x00a3:
            int r1 = r5.size()
            if (r4 >= r1) goto L_0x042e
            java.lang.Object r1 = r5.get(r4)
            r3 = r1
            com.huobi.view.chart.interfaces.datasets.IPieDataSet r3 = (com.huobi.view.chart.interfaces.datasets.IPieDataSet) r3
            boolean r24 = r3.isDrawValuesEnabled()
            if (r24 != 0) goto L_0x00d0
            if (r21 != 0) goto L_0x00d0
            r26 = r4
            r33 = r5
            r29 = r9
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r10 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r9 = r7
            r13 = r8
            goto L_0x041a
        L_0x00d0:
            com.huobi.view.chart.data.PieDataSet$ValuePosition r2 = r3.getXValuePosition()
            com.huobi.view.chart.data.PieDataSet$ValuePosition r1 = r3.getYValuePosition()
            r6.applyValueTextStyle(r3)
            r25 = r0
            android.graphics.Paint r0 = r6.mValuePaint
            r26 = r4
            java.lang.String r4 = "Q"
            int r0 = com.huobi.view.chart.utils.Utils.calcTextHeight(r0, r4)
            float r0 = (float) r0
            r4 = 1082130432(0x40800000, float:4.0)
            float r4 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r4)
            float r27 = r0 + r4
            com.huobi.view.chart.formatter.ValueFormatter r4 = r3.getValueFormatter()
            int r0 = r3.getEntryCount()
            r28 = r5
            android.graphics.Paint r5 = r6.mValueLinePaint
            int r7 = r3.getValueLineColor()
            r5.setColor(r7)
            android.graphics.Paint r5 = r6.mValueLinePaint
            float r7 = r3.getValueLineWidth()
            float r7 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r7)
            r5.setStrokeWidth(r7)
            float r7 = r6.getSliceSpace(r3)
            com.huobi.view.chart.utils.MPPointF r5 = r3.getIconsOffset()
            com.huobi.view.chart.utils.MPPointF r5 = com.huobi.view.chart.utils.MPPointF.getInstance(r5)
            r29 = r8
            float r8 = r5.f19016x
            float r8 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r8)
            r5.f19016x = r8
            float r8 = r5.f19017y
            float r8 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r8)
            r5.f19017y = r8
            r8 = r23
        L_0x0130:
            if (r8 >= r0) goto L_0x03fe
            com.huobi.view.chart.data.Entry r30 = r3.getEntryForIndex(r8)
            r31 = r5
            r5 = r30
            com.huobi.view.chart.data.PieEntry r5 = (com.huobi.view.chart.data.PieEntry) r5
            if (r25 != 0) goto L_0x0141
            r30 = 0
            goto L_0x0147
        L_0x0141:
            int r30 = r25 + -1
            r30 = r11[r30]
            float r30 = r30 * r12
        L_0x0147:
            r32 = r10[r25]
            r33 = 1016003125(0x3c8efa35, float:0.017453292)
            float r34 = r15 * r33
            float r34 = r7 / r34
            r20 = 1073741824(0x40000000, float:2.0)
            float r34 = r34 / r20
            float r32 = r32 - r34
            float r32 = r32 / r20
            float r30 = r30 + r32
            float r30 = r30 * r13
            r32 = r0
            float r0 = r14 + r30
            r30 = r7
            com.huobi.view.chart.PieChart r7 = r6.mChart
            boolean r7 = r7.isUsePercentValuesEnabled()
            if (r7 == 0) goto L_0x0175
            float r7 = r5.getY()
            float r7 = r7 / r18
            r19 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r19
            goto L_0x0179
        L_0x0175:
            float r7 = r5.getY()
        L_0x0179:
            java.lang.String r7 = r4.getPieLabel(r7, r5)
            r34 = r10
            java.lang.String r10 = r5.getLabel()
            r35 = r4
            float r4 = r0 * r33
            r33 = r5
            double r4 = (double) r4
            r36 = r11
            r37 = r12
            double r11 = java.lang.Math.cos(r4)
            float r11 = (float) r11
            r38 = r13
            double r12 = java.lang.Math.sin(r4)
            float r12 = (float) r12
            if (r21 == 0) goto L_0x01a2
            com.huobi.view.chart.data.PieDataSet$ValuePosition r13 = com.huobi.view.chart.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r2 != r13) goto L_0x01a2
            r13 = 1
            goto L_0x01a4
        L_0x01a2:
            r13 = r23
        L_0x01a4:
            r40 = r14
            if (r24 == 0) goto L_0x01ae
            com.huobi.view.chart.data.PieDataSet$ValuePosition r14 = com.huobi.view.chart.data.PieDataSet.ValuePosition.OUTSIDE_SLICE
            if (r1 != r14) goto L_0x01ae
            r14 = 1
            goto L_0x01b0
        L_0x01ae:
            r14 = r23
        L_0x01b0:
            r41 = r10
            if (r21 == 0) goto L_0x01ba
            com.huobi.view.chart.data.PieDataSet$ValuePosition r10 = com.huobi.view.chart.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r2 != r10) goto L_0x01ba
            r10 = 1
            goto L_0x01bc
        L_0x01ba:
            r10 = r23
        L_0x01bc:
            r42 = r2
            if (r24 == 0) goto L_0x01c7
            com.huobi.view.chart.data.PieDataSet$ValuePosition r2 = com.huobi.view.chart.data.PieDataSet.ValuePosition.INSIDE_SLICE
            if (r1 != r2) goto L_0x01c7
            r39 = 1
            goto L_0x01c9
        L_0x01c7:
            r39 = r23
        L_0x01c9:
            if (r13 != 0) goto L_0x01e9
            if (r14 == 0) goto L_0x01ce
            goto L_0x01e9
        L_0x01ce:
            r45 = r1
            r44 = r12
            r50 = r29
            r51 = r31
            r48 = r35
            r14 = r41
            r19 = 1120403456(0x42c80000, float:100.0)
            r12 = r3
            r29 = r9
            r9 = r54
            r52 = r33
            r33 = r28
            r28 = r52
            goto L_0x033b
        L_0x01e9:
            float r2 = r3.getValueLinePart1Length()
            float r43 = r3.getValueLinePart2Length()
            float r44 = r3.getValueLinePart1OffsetPercentage()
            r19 = 1120403456(0x42c80000, float:100.0)
            float r44 = r44 / r19
            r45 = r1
            com.huobi.view.chart.PieChart r1 = r6.mChart
            boolean r1 = r1.isDrawHoleEnabled()
            if (r1 == 0) goto L_0x020c
            float r1 = r9 * r16
            float r46 = r9 - r1
            float r46 = r46 * r44
            float r46 = r46 + r1
            goto L_0x020e
        L_0x020c:
            float r46 = r9 * r44
        L_0x020e:
            boolean r1 = r3.isValueLineVariableLength()
            if (r1 == 0) goto L_0x0222
            float r43 = r43 * r15
            double r4 = java.lang.Math.sin(r4)
            double r4 = java.lang.Math.abs(r4)
            float r1 = (float) r4
            float r43 = r43 * r1
            goto L_0x0224
        L_0x0222:
            float r43 = r43 * r15
        L_0x0224:
            float r1 = r46 * r11
            r5 = r29
            float r4 = r5.f19016x
            float r1 = r1 + r4
            float r46 = r46 * r12
            r29 = r9
            float r9 = r5.f19017y
            float r44 = r46 + r9
            r46 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 + r46
            float r2 = r2 * r15
            float r46 = r2 * r11
            float r46 = r46 + r4
            float r2 = r2 * r12
            float r9 = r9 + r2
            r47 = r5
            double r4 = (double) r0
            r48 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r4 = r4 % r48
            r48 = 4636033603912859648(0x4056800000000000, double:90.0)
            int r0 = (r4 > r48 ? 1 : (r4 == r48 ? 0 : -1))
            if (r0 < 0) goto L_0x0272
            r48 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r0 = (r4 > r48 ? 1 : (r4 == r48 ? 0 : -1))
            if (r0 > 0) goto L_0x0272
            float r0 = r46 - r43
            android.graphics.Paint r2 = r6.mValuePaint
            android.graphics.Paint$Align r4 = android.graphics.Paint.Align.RIGHT
            r2.setTextAlign(r4)
            if (r13 == 0) goto L_0x026c
            android.graphics.Paint r2 = r6.mEntryLabelsPaint
            android.graphics.Paint$Align r4 = android.graphics.Paint.Align.RIGHT
            r2.setTextAlign(r4)
        L_0x026c:
            float r2 = r0 - r22
            r43 = r0
            r5 = r2
            goto L_0x0287
        L_0x0272:
            float r43 = r46 + r43
            android.graphics.Paint r0 = r6.mValuePaint
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r2)
            if (r13 == 0) goto L_0x0284
            android.graphics.Paint r0 = r6.mEntryLabelsPaint
            android.graphics.Paint$Align r2 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r2)
        L_0x0284:
            float r0 = r43 + r22
            r5 = r0
        L_0x0287:
            int r0 = r3.getValueLineColor()
            r2 = 1122867(0x112233, float:1.573472E-39)
            if (r0 == r2) goto L_0x02cb
            boolean r0 = r3.isUsingSliceColorAsValueLineColor()
            if (r0 == 0) goto L_0x029f
            android.graphics.Paint r0 = r6.mValueLinePaint
            int r2 = r3.getColor(r8)
            r0.setColor(r2)
        L_0x029f:
            android.graphics.Paint r4 = r6.mValueLinePaint
            r0 = r54
            r2 = r44
            r44 = r12
            r12 = r3
            r3 = r46
            r48 = r35
            r35 = r4
            r4 = r9
            r51 = r31
            r50 = r47
            r31 = r5
            r52 = r33
            r33 = r28
            r28 = r52
            r5 = r35
            r0.drawLine(r1, r2, r3, r4, r5)
            android.graphics.Paint r5 = r6.mValueLinePaint
            r1 = r46
            r2 = r9
            r3 = r43
            r0.drawLine(r1, r2, r3, r4, r5)
            goto L_0x02dc
        L_0x02cb:
            r44 = r12
            r51 = r31
            r48 = r35
            r50 = r47
            r12 = r3
            r31 = r5
            r52 = r33
            r33 = r28
            r28 = r52
        L_0x02dc:
            if (r13 == 0) goto L_0x0308
            if (r14 == 0) goto L_0x0308
            int r5 = r12.getValueTextColor(r8)
            r0 = r53
            r1 = r54
            r2 = r7
            r3 = r31
            r4 = r9
            r0.drawValue(r1, r2, r3, r4, r5)
            int r0 = r17.getEntryCount()
            if (r8 >= r0) goto L_0x0303
            if (r41 == 0) goto L_0x0303
            float r9 = r9 + r27
            r5 = r54
            r3 = r31
            r4 = r41
            r6.drawEntryLabel(r5, r4, r3, r9)
            goto L_0x0339
        L_0x0303:
            r9 = r54
            r14 = r41
            goto L_0x033b
        L_0x0308:
            r5 = r54
            r3 = r31
            r4 = r41
            if (r13 == 0) goto L_0x0321
            int r0 = r17.getEntryCount()
            if (r8 >= r0) goto L_0x0339
            if (r4 == 0) goto L_0x0339
            r0 = 1073741824(0x40000000, float:2.0)
            float r1 = r27 / r0
            float r9 = r9 + r1
            r6.drawEntryLabel(r5, r4, r3, r9)
            goto L_0x0339
        L_0x0321:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r14 == 0) goto L_0x0339
            float r1 = r27 / r0
            float r9 = r9 + r1
            int r13 = r12.getValueTextColor(r8)
            r0 = r53
            r1 = r54
            r2 = r7
            r14 = r4
            r4 = r9
            r9 = r5
            r5 = r13
            r0.drawValue(r1, r2, r3, r4, r5)
            goto L_0x033b
        L_0x0339:
            r14 = r4
            r9 = r5
        L_0x033b:
            if (r10 != 0) goto L_0x0346
            if (r39 == 0) goto L_0x0340
            goto L_0x0346
        L_0x0340:
            r13 = r50
        L_0x0342:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x03a7
        L_0x0346:
            float r0 = r15 * r11
            r13 = r50
            float r1 = r13.f19016x
            float r5 = r0 + r1
            float r0 = r15 * r44
            float r1 = r13.f19017y
            float r31 = r0 + r1
            android.graphics.Paint r0 = r6.mValuePaint
            android.graphics.Paint$Align r1 = android.graphics.Paint.Align.CENTER
            r0.setTextAlign(r1)
            if (r10 == 0) goto L_0x037e
            if (r39 == 0) goto L_0x037e
            int r10 = r12.getValueTextColor(r8)
            r0 = r53
            r1 = r54
            r2 = r7
            r3 = r5
            r4 = r31
            r7 = r5
            r5 = r10
            r0.drawValue(r1, r2, r3, r4, r5)
            int r0 = r17.getEntryCount()
            if (r8 >= r0) goto L_0x0342
            if (r14 == 0) goto L_0x0342
            float r0 = r31 + r27
            r6.drawEntryLabel(r9, r14, r7, r0)
            goto L_0x0342
        L_0x037e:
            r3 = r5
            if (r10 == 0) goto L_0x0393
            int r0 = r17.getEntryCount()
            if (r8 >= r0) goto L_0x0342
            if (r14 == 0) goto L_0x0342
            r10 = 1073741824(0x40000000, float:2.0)
            float r0 = r27 / r10
            float r0 = r31 + r0
            r6.drawEntryLabel(r9, r14, r3, r0)
            goto L_0x03a7
        L_0x0393:
            r10 = 1073741824(0x40000000, float:2.0)
            if (r39 == 0) goto L_0x03a7
            float r0 = r27 / r10
            float r4 = r31 + r0
            int r5 = r12.getValueTextColor(r8)
            r0 = r53
            r1 = r54
            r2 = r7
            r0.drawValue(r1, r2, r3, r4, r5)
        L_0x03a7:
            android.graphics.drawable.Drawable r0 = r28.getIcon()
            if (r0 == 0) goto L_0x03da
            boolean r0 = r12.isDrawIconsEnabled()
            if (r0 == 0) goto L_0x03da
            android.graphics.drawable.Drawable r1 = r28.getIcon()
            r7 = r51
            float r0 = r7.f19017y
            float r2 = r15 + r0
            float r2 = r2 * r11
            float r3 = r13.f19016x
            float r2 = r2 + r3
            float r0 = r0 + r15
            float r0 = r0 * r44
            float r3 = r13.f19017y
            float r0 = r0 + r3
            float r3 = r7.f19016x
            float r0 = r0 + r3
            int r2 = (int) r2
            int r3 = (int) r0
            int r4 = r1.getIntrinsicWidth()
            int r5 = r1.getIntrinsicHeight()
            r0 = r54
            com.huobi.view.chart.utils.Utils.drawImage(r0, r1, r2, r3, r4, r5)
            goto L_0x03dc
        L_0x03da:
            r7 = r51
        L_0x03dc:
            int r25 = r25 + 1
            int r8 = r8 + 1
            r5 = r7
            r3 = r12
            r9 = r29
            r7 = r30
            r0 = r32
            r28 = r33
            r10 = r34
            r11 = r36
            r12 = r37
            r14 = r40
            r2 = r42
            r1 = r45
            r4 = r48
            r29 = r13
            r13 = r38
            goto L_0x0130
        L_0x03fe:
            r7 = r5
            r34 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r40 = r14
            r33 = r28
            r13 = r29
            r10 = 1073741824(0x40000000, float:2.0)
            r19 = 1120403456(0x42c80000, float:100.0)
            r29 = r9
            r9 = r54
            com.huobi.view.chart.utils.MPPointF.recycleInstance(r7)
            r0 = r25
        L_0x041a:
            int r4 = r26 + 1
            r7 = r9
            r8 = r13
            r9 = r29
            r5 = r33
            r10 = r34
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r40
            goto L_0x00a3
        L_0x042e:
            r9 = r7
            r13 = r8
            com.huobi.view.chart.utils.MPPointF.recycleInstance(r13)
            r54.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.renderer.PieChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    public void initBuffers() {
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
