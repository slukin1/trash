package com.huobi.view.chart;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.huobi.view.chart.animation.Easing;
import com.huobi.view.chart.data.ChartData;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.interfaces.datasets.IDataSet;
import com.huobi.view.chart.listener.ChartTouchListener;
import com.huobi.view.chart.listener.PieRadarChartTouchListener;
import com.huobi.view.chart.utils.MPPointF;
import com.huobi.view.chart.utils.Utils;

public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    public float mMinOffset = 0.0f;
    private float mRawRotationAngle = 270.0f;
    public boolean mRotateEnabled = true;
    private float mRotationAngle = 270.0f;

    /* renamed from: com.huobi.view.chart.PieRadarChartBase$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment;
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation;
        public static final /* synthetic */ int[] $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.huobi.view.chart.components.Legend$LegendOrientation[] r0 = com.huobi.view.chart.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation = r0
                r1 = 1
                com.huobi.view.chart.components.Legend$LegendOrientation r2 = com.huobi.view.chart.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.view.chart.components.Legend$LegendOrientation r3 = com.huobi.view.chart.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment[] r2 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment = r2
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r3 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r3 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r3 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment[] r2 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment = r2
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment r3 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = $SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment     // Catch:{ NoSuchFieldError -> 0x005e }
                com.huobi.view.chart.components.Legend$LegendVerticalAlignment r2 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.PieRadarChartBase.AnonymousClass2.<clinit>():void");
        }
    }

    public PieRadarChartBase(Context context) {
        super(context);
    }

    public void calcMinMax() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        if (r2 != 2) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculateOffsets() {
        /*
            r12 = this;
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            r1 = 0
            if (r0 == 0) goto L_0x0199
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x0199
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            boolean r0 = r0.isDrawInsideEnabled()
            if (r0 != 0) goto L_0x0199
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            float r0 = r0.mNeededWidth
            com.huobi.view.chart.utils.ViewPortHandler r2 = r12.mViewPortHandler
            float r2 = r2.getChartWidth()
            com.huobi.view.chart.components.Legend r3 = r12.mLegend
            float r3 = r3.getMaxSizePercent()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            int[] r2 = com.huobi.view.chart.PieRadarChartBase.AnonymousClass2.$SwitchMap$com$huobi$view$chart$components$Legend$LegendOrientation
            com.huobi.view.chart.components.Legend r3 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendOrientation r3 = r3.getOrientation()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x008c
            if (r2 == r3) goto L_0x003d
            goto L_0x007d
        L_0x003d:
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r0 = r0.getVerticalAlignment()
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r2 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.TOP
            if (r0 == r2) goto L_0x0051
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r0 = r0.getVerticalAlignment()
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r2 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.BOTTOM
            if (r0 != r2) goto L_0x007d
        L_0x0051:
            float r0 = r12.getRequiredLegendOffset()
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            float r2 = r2.mNeededHeight
            float r2 = r2 + r0
            com.huobi.view.chart.utils.ViewPortHandler r0 = r12.mViewPortHandler
            float r0 = r0.getChartHeight()
            com.huobi.view.chart.components.Legend r5 = r12.mLegend
            float r5 = r5.getMaxSizePercent()
            float r0 = r0 * r5
            float r0 = java.lang.Math.min(r2, r0)
            int[] r2 = com.huobi.view.chart.PieRadarChartBase.AnonymousClass2.$SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment
            com.huobi.view.chart.components.Legend r5 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r5 = r5.getVerticalAlignment()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x0087
            if (r2 == r3) goto L_0x0082
        L_0x007d:
            r0 = r1
            r2 = r0
        L_0x007f:
            r3 = r2
            goto L_0x0181
        L_0x0082:
            r2 = r0
            r0 = r1
            r3 = r0
            goto L_0x0181
        L_0x0087:
            r3 = r0
            r0 = r1
            r2 = r0
            goto L_0x0181
        L_0x008c:
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r2 = r2.getHorizontalAlignment()
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r5 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.LEFT
            if (r2 == r5) goto L_0x00a4
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r2 = r2.getHorizontalAlignment()
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r5 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.RIGHT
            if (r2 != r5) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r0 = r1
            goto L_0x0122
        L_0x00a4:
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r2 = r2.getVerticalAlignment()
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r5 = com.huobi.view.chart.components.Legend.LegendVerticalAlignment.CENTER
            if (r2 != r5) goto L_0x00b6
            r2 = 1095761920(0x41500000, float:13.0)
            float r2 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r2)
            float r0 = r0 + r2
            goto L_0x0122
        L_0x00b6:
            r2 = 1090519040(0x41000000, float:8.0)
            float r2 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r2)
            float r0 = r0 + r2
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            float r5 = r2.mNeededHeight
            float r2 = r2.mTextHeightMax
            float r5 = r5 + r2
            com.huobi.view.chart.utils.MPPointF r2 = r12.getCenter()
            com.huobi.view.chart.components.Legend r6 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r6 = r6.getHorizontalAlignment()
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r7 = com.huobi.view.chart.components.Legend.LegendHorizontalAlignment.RIGHT
            r8 = 1097859072(0x41700000, float:15.0)
            if (r6 != r7) goto L_0x00dc
            int r6 = r12.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 + r8
            goto L_0x00de
        L_0x00dc:
            float r6 = r0 - r8
        L_0x00de:
            float r5 = r5 + r8
            float r7 = r12.distanceToCenter(r6, r5)
            float r8 = r12.getRadius()
            float r6 = r12.getAngleForPoint(r6, r5)
            com.huobi.view.chart.utils.MPPointF r6 = r12.getPosition(r2, r8, r6)
            float r8 = r6.f19016x
            float r9 = r6.f19017y
            float r8 = r12.distanceToCenter(r8, r9)
            r9 = 1084227584(0x40a00000, float:5.0)
            float r9 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r9)
            float r10 = r2.f19017y
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x0113
            int r5 = r12.getHeight()
            float r5 = (float) r5
            float r5 = r5 - r0
            int r10 = r12.getWidth()
            float r10 = (float) r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0113
            goto L_0x011c
        L_0x0113:
            int r0 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x011b
            float r8 = r8 - r7
            float r9 = r9 + r8
            r0 = r9
            goto L_0x011c
        L_0x011b:
            r0 = r1
        L_0x011c:
            com.huobi.view.chart.utils.MPPointF.recycleInstance(r2)
            com.huobi.view.chart.utils.MPPointF.recycleInstance(r6)
        L_0x0122:
            int[] r2 = com.huobi.view.chart.PieRadarChartBase.AnonymousClass2.$SwitchMap$com$huobi$view$chart$components$Legend$LegendHorizontalAlignment
            com.huobi.view.chart.components.Legend r5 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendHorizontalAlignment r5 = r5.getHorizontalAlignment()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x017d
            if (r2 == r3) goto L_0x017a
            r0 = 3
            if (r2 == r0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            int[] r0 = com.huobi.view.chart.PieRadarChartBase.AnonymousClass2.$SwitchMap$com$huobi$view$chart$components$Legend$LegendVerticalAlignment
            com.huobi.view.chart.components.Legend r2 = r12.mLegend
            com.huobi.view.chart.components.Legend$LegendVerticalAlignment r2 = r2.getVerticalAlignment()
            int r2 = r2.ordinal()
            r0 = r0[r2]
            if (r0 == r4) goto L_0x0163
            if (r0 == r3) goto L_0x014c
        L_0x014a:
            goto L_0x007d
        L_0x014c:
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            float r0 = r0.mNeededHeight
            com.huobi.view.chart.utils.ViewPortHandler r2 = r12.mViewPortHandler
            float r2 = r2.getChartHeight()
            com.huobi.view.chart.components.Legend r3 = r12.mLegend
            float r3 = r3.getMaxSizePercent()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0082
        L_0x0163:
            com.huobi.view.chart.components.Legend r0 = r12.mLegend
            float r0 = r0.mNeededHeight
            com.huobi.view.chart.utils.ViewPortHandler r2 = r12.mViewPortHandler
            float r2 = r2.getChartHeight()
            com.huobi.view.chart.components.Legend r3 = r12.mLegend
            float r3 = r3.getMaxSizePercent()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0087
        L_0x017a:
            r2 = r1
            goto L_0x007f
        L_0x017d:
            r2 = r1
            r3 = r2
            r1 = r0
            r0 = r3
        L_0x0181:
            float r4 = r12.getRequiredBaseOffset()
            float r1 = r1 + r4
            float r4 = r12.getRequiredBaseOffset()
            float r0 = r0 + r4
            float r4 = r12.getRequiredBaseOffset()
            float r3 = r3 + r4
            float r4 = r12.getRequiredBaseOffset()
            float r2 = r2 + r4
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x019c
        L_0x0199:
            r0 = r1
            r2 = r0
            r3 = r2
        L_0x019c:
            float r4 = r12.mMinOffset
            float r4 = com.huobi.view.chart.utils.Utils.convertDpToPixel(r4)
            float r5 = r12.getExtraTopOffset()
            float r1 = r1 + r5
            float r5 = r12.getExtraRightOffset()
            float r0 = r0 + r5
            float r5 = r12.getExtraBottomOffset()
            float r2 = r2 + r5
            float r5 = r12.getExtraLeftOffset()
            float r3 = r3 + r5
            float r3 = java.lang.Math.max(r4, r3)
            float r1 = java.lang.Math.max(r4, r1)
            float r0 = java.lang.Math.max(r4, r0)
            float r5 = r12.getRequiredBaseOffset()
            float r2 = java.lang.Math.max(r5, r2)
            float r2 = java.lang.Math.max(r4, r2)
            com.huobi.view.chart.utils.ViewPortHandler r4 = r12.mViewPortHandler
            r4.restrainViewPort(r3, r1, r0, r2)
            boolean r4 = r12.mLogEnabled
            if (r4 == 0) goto L_0x0205
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = ", offsetTop: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "MPAndroidChart"
            android.util.Log.i(r1, r0)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.chart.PieRadarChartBase.calculateOffsets():void");
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) chartTouchListener).computeScroll();
        }
    }

    public float distanceToCenter(float f11, float f12) {
        MPPointF centerOffsets = getCenterOffsets();
        float f13 = centerOffsets.f19016x;
        float f14 = f11 > f13 ? f11 - f13 : f13 - f11;
        float f15 = centerOffsets.f19017y;
        float sqrt = (float) Math.sqrt(Math.pow((double) f14, 2.0d) + Math.pow((double) (f12 > f15 ? f12 - f15 : f15 - f12), 2.0d));
        MPPointF.recycleInstance(centerOffsets);
        return sqrt;
    }

    public float getAngleForPoint(float f11, float f12) {
        MPPointF centerOffsets = getCenterOffsets();
        double d11 = (double) (f11 - centerOffsets.f19016x);
        double d12 = (double) (f12 - centerOffsets.f19017y);
        float degrees = (float) Math.toDegrees(Math.acos(d12 / Math.sqrt((d11 * d11) + (d12 * d12))));
        if (f11 > centerOffsets.f19016x) {
            degrees = 360.0f - degrees;
        }
        float f13 = degrees + 90.0f;
        if (f13 > 360.0f) {
            f13 -= 360.0f;
        }
        MPPointF.recycleInstance(centerOffsets);
        return f13;
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        contentRect.left += getExtraLeftOffset();
        contentRect.top += getExtraTopOffset();
        contentRect.right -= getExtraRightOffset();
        contentRect.bottom -= getExtraBottomOffset();
        return Math.min(contentRect.width(), contentRect.height());
    }

    public abstract int getIndexForAngle(float f11);

    public int getMaxVisibleCount() {
        return this.mData.getEntryCount();
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public MPPointF getPosition(MPPointF mPPointF, float f11, float f12) {
        MPPointF instance = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f11, f12, instance);
        return instance;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    public void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public void notifyDataSetChanged() {
        if (this.mData != null) {
            calcMinMax();
            if (this.mLegend != null) {
                this.mLegendRenderer.computeLegend(this.mData);
            }
            calculateOffsets();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        if (!this.mTouchEnabled || (chartTouchListener = this.mChartTouchListener) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f11) {
        this.mMinOffset = f11;
    }

    public void setRotationAngle(float f11) {
        this.mRawRotationAngle = f11;
        this.mRotationAngle = Utils.getNormalizedAngle(f11);
    }

    public void setRotationEnabled(boolean z11) {
        this.mRotateEnabled = z11;
    }

    @SuppressLint({"NewApi"})
    public void spin(int i11, float f11, float f12, Easing.EasingFunction easingFunction) {
        setRotationAngle(f11);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationAngle", new float[]{f11, f12});
        ofFloat.setDuration((long) i11);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        ofFloat.start();
    }

    public void getPosition(MPPointF mPPointF, float f11, float f12, MPPointF mPPointF2) {
        double d11 = (double) f11;
        double d12 = (double) f12;
        mPPointF2.f19016x = (float) (((double) mPPointF.f19016x) + (Math.cos(Math.toRadians(d12)) * d11));
        mPPointF2.f19017y = (float) (((double) mPPointF.f19017y) + (d11 * Math.sin(Math.toRadians(d12))));
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
