package com.huobi.view.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.huobi.view.chart.components.XAxis;
import com.huobi.view.chart.data.PieData;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.highlight.PieHighlighter;
import com.huobi.view.chart.interfaces.datasets.IPieDataSet;
import com.huobi.view.chart.renderer.DataRenderer;
import com.huobi.view.chart.renderer.PieChartRenderer;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Utils;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles = new float[1];
    private CharSequence mCenterText = "";
    private MPPointF mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
    private float mCenterTextRadiusPercent = 100.0f;
    private RectF mCircleBox = new RectF();
    private float[] mDrawAngles = new float[1];
    private boolean mDrawCenterText = true;
    private boolean mDrawEntryLabels = true;
    private boolean mDrawHole = true;
    private boolean mDrawRoundedSlices = false;
    private boolean mDrawSlicesUnderHole = false;
    private float mHoleRadiusPercent = 50.0f;
    public float mMaxAngle = 360.0f;
    private float mMinAngleForSlices = 0.0f;
    public float mTransparentCircleRadiusPercent = 55.0f;
    private boolean mUsePercentValues = false;

    public PieChart(Context context) {
        super(context);
    }

    private float calcAngle(float f11) {
        return calcAngle(f11, ((PieData) this.mData).getYValueSum());
    }

    private void calcAngles() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.mDrawAngles.length != entryCount) {
            this.mDrawAngles = new float[entryCount];
        } else {
            for (int i11 = 0; i11 < entryCount; i11++) {
                this.mDrawAngles[i11] = 0.0f;
            }
        }
        if (this.mAbsoluteAngles.length != entryCount) {
            this.mAbsoluteAngles = new float[entryCount];
        } else {
            for (int i12 = 0; i12 < entryCount; i12++) {
                this.mAbsoluteAngles[i12] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List dataSets = ((PieData) this.mData).getDataSets();
        float f11 = this.mMinAngleForSlices;
        boolean z11 = f11 != 0.0f && ((float) entryCount) * f11 <= this.mMaxAngle;
        float[] fArr = new float[entryCount];
        float f12 = 0.0f;
        float f13 = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < ((PieData) this.mData).getDataSetCount(); i14++) {
            IPieDataSet iPieDataSet = (IPieDataSet) dataSets.get(i14);
            for (int i15 = 0; i15 < iPieDataSet.getEntryCount(); i15++) {
                float calcAngle = calcAngle(Math.abs(((PieEntry) iPieDataSet.getEntryForIndex(i15)).getY()), yValueSum);
                if (z11) {
                    float f14 = this.mMinAngleForSlices;
                    float f15 = calcAngle - f14;
                    if (f15 <= 0.0f) {
                        fArr[i13] = f14;
                        f12 += -f15;
                    } else {
                        fArr[i13] = calcAngle;
                        f13 += f15;
                    }
                }
                float[] fArr2 = this.mDrawAngles;
                fArr2[i13] = calcAngle;
                if (i13 == 0) {
                    this.mAbsoluteAngles[i13] = fArr2[i13];
                } else {
                    float[] fArr3 = this.mAbsoluteAngles;
                    fArr3[i13] = fArr3[i13 - 1] + fArr2[i13];
                }
                i13++;
            }
        }
        if (z11) {
            for (int i16 = 0; i16 < entryCount; i16++) {
                fArr[i16] = fArr[i16] - (((fArr[i16] - this.mMinAngleForSlices) / f13) * f12);
                if (i16 == 0) {
                    this.mAbsoluteAngles[0] = fArr[0];
                } else {
                    float[] fArr4 = this.mAbsoluteAngles;
                    fArr4[i16] = fArr4[i16 - 1] + fArr[i16];
                }
            }
            this.mDrawAngles = fArr;
        }
    }

    public void calcMinMax() {
        calcAngles();
    }

    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData != null) {
            float diameter = getDiameter() / 2.0f;
            MPPointF centerOffsets = getCenterOffsets();
            float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
            RectF rectF = this.mCircleBox;
            float f11 = centerOffsets.f19016x;
            float f12 = centerOffsets.f19017y;
            rectF.set((f11 - diameter) + selectionShift, (f12 - diameter) + selectionShift, (f11 + diameter) - selectionShift, (f12 + diameter) - selectionShift);
            MPPointF.recycleInstance(centerOffsets);
        }
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.mCenterTextOffset;
        return MPPointF.getInstance(mPPointF.f19016x, mPPointF.f19017y);
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i11) {
        List dataSets = ((PieData) this.mData).getDataSets();
        for (int i12 = 0; i12 < dataSets.size(); i12++) {
            if (((IPieDataSet) dataSets.get(i12)).getEntryForXValue((float) i11, Float.NaN) != null) {
                return i12;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    public int getIndexForAngle(float f11) {
        float normalizedAngle = Utils.getNormalizedAngle(f11 - getRotationAngle());
        int i11 = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i11 >= fArr.length) {
                return -1;
            }
            if (fArr[i11] > normalizedAngle) {
                return i11;
            }
            i11++;
        }
    }

    public float[] getMarkerPosition(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f11 = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f11 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f12 = radius - f11;
        float rotationAngle = getRotationAngle();
        int x11 = (int) highlight.getX();
        float f13 = this.mDrawAngles[x11] / 2.0f;
        double d11 = (double) f12;
        float cos = (float) ((Math.cos(Math.toRadians((double) (((this.mAbsoluteAngles[x11] + rotationAngle) - f13) * this.mAnimator.getPhaseY()))) * d11) + ((double) centerCircleBox.f19016x));
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{cos, (float) ((d11 * Math.sin(Math.toRadians((double) (((rotationAngle + this.mAbsoluteAngles[x11]) - f13) * this.mAnimator.getPhaseY())))) + ((double) centerCircleBox.f19017y))};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getMinAngleForSlices() {
        return this.mMinAngleForSlices;
    }

    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public boolean needsHighlight(int i11) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i12 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i12 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i12].getX()) == i11) {
                return true;
            }
            i12++;
        }
    }

    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData != null) {
            this.mRenderer.drawData(canvas);
            if (valuesToHighlight()) {
                this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
            }
            this.mRenderer.drawExtras(canvas);
            this.mRenderer.drawValues(canvas);
            this.mLegendRenderer.renderLegend(canvas);
            drawDescription(canvas);
            drawMarkers(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = "";
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i11) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i11);
    }

    public void setCenterTextOffset(float f11, float f12) {
        this.mCenterTextOffset.f19016x = Utils.convertDpToPixel(f11);
        this.mCenterTextOffset.f19017y = Utils.convertDpToPixel(f12);
    }

    public void setCenterTextRadiusPercent(float f11) {
        this.mCenterTextRadiusPercent = f11;
    }

    public void setCenterTextSize(float f11) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f11));
    }

    public void setCenterTextSizePixels(float f11) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f11);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z11) {
        this.mDrawCenterText = z11;
    }

    public void setDrawEntryLabels(boolean z11) {
        this.mDrawEntryLabels = z11;
    }

    public void setDrawHoleEnabled(boolean z11) {
        this.mDrawHole = z11;
    }

    public void setDrawRoundedSlices(boolean z11) {
        this.mDrawRoundedSlices = z11;
    }

    @Deprecated
    public void setDrawSliceText(boolean z11) {
        this.mDrawEntryLabels = z11;
    }

    public void setDrawSlicesUnderHole(boolean z11) {
        this.mDrawSlicesUnderHole = z11;
    }

    public void setEntryLabelColor(int i11) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i11);
    }

    public void setEntryLabelTextSize(float f11) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f11));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setHoleColor(int i11) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i11);
    }

    public void setHoleRadius(float f11) {
        this.mHoleRadiusPercent = f11;
    }

    public void setMaxAngle(float f11) {
        if (f11 > 360.0f) {
            f11 = 360.0f;
        }
        if (f11 < 90.0f) {
            f11 = 90.0f;
        }
        this.mMaxAngle = f11;
    }

    public void setMinAngleForSlices(float f11) {
        float f12 = this.mMaxAngle;
        if (f11 > f12 / 2.0f) {
            f11 = f12 / 2.0f;
        } else if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.mMinAngleForSlices = f11;
    }

    public void setTransparentCircleAlpha(int i11) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i11);
    }

    public void setTransparentCircleColor(int i11) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i11);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f11) {
        this.mTransparentCircleRadiusPercent = f11;
    }

    public void setUsePercentValues(boolean z11) {
        this.mUsePercentValues = z11;
    }

    private float calcAngle(float f11, float f12) {
        return (f11 / f12) * this.mMaxAngle;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
