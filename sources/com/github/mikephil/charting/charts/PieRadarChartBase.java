package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.c;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import g5.e;

public abstract class PieRadarChartBase<T extends ChartData<? extends e<? extends Entry>>> extends Chart<T> {
    public float H = 270.0f;
    public float I = 270.0f;
    public boolean J = true;
    public float K = 0.0f;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65389a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f65390b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f65391c;

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
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f65391c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f65391c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f65390b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f65390b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f65390b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f65389a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f65389a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.a.<clinit>():void");
        }
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MPPointF A(MPPointF mPPointF, float f11, float f12) {
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        B(mPPointF, f11, f12, c11);
        return c11;
    }

    public void B(MPPointF mPPointF, float f11, float f12, MPPointF mPPointF2) {
        double d11 = (double) f11;
        double d12 = (double) f12;
        mPPointF2.f65546c = (float) (((double) mPPointF.f65546c) + (Math.cos(Math.toRadians(d12)) * d11));
        mPPointF2.f65547d = (float) (((double) mPPointF.f65547d) + (d11 * Math.sin(Math.toRadians(d12))));
    }

    public boolean C() {
        return this.J;
    }

    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f65370o;
        if (chartTouchListener instanceof c) {
            ((c) chartTouchListener).g();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        if (r2 != 2) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r11 = this;
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            r1 = 0
            if (r0 == 0) goto L_0x0196
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x0196
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            boolean r0 = r0.E()
            if (r0 != 0) goto L_0x0196
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            float r0 = r0.f65438x
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.f65376u
            float r2 = r2.m()
            com.github.mikephil.charting.components.Legend r3 = r11.f65368m
            float r3 = r3.w()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.a.f65391c
            com.github.mikephil.charting.components.Legend r3 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendOrientation r3 = r3.z()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x008c
            if (r2 == r3) goto L_0x003d
            goto L_0x007d
        L_0x003d:
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.B()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP
            if (r0 == r2) goto L_0x0051
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.B()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM
            if (r0 != r2) goto L_0x007d
        L_0x0051:
            float r0 = r11.getRequiredLegendOffset()
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            float r2 = r2.f65439y
            float r2 = r2 + r0
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r11.f65376u
            float r0 = r0.l()
            com.github.mikephil.charting.components.Legend r5 = r11.f65368m
            float r5 = r5.w()
            float r0 = r0 * r5
            float r0 = java.lang.Math.min(r2, r0)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.a.f65389a
            com.github.mikephil.charting.components.Legend r5 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = r5.B()
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
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.v()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT
            if (r2 == r5) goto L_0x00a4
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.v()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            if (r2 != r5) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            r0 = r1
            goto L_0x0122
        L_0x00a4:
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.B()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER
            if (r2 != r5) goto L_0x00b6
            r2 = 1095761920(0x41500000, float:13.0)
            float r2 = com.github.mikephil.charting.utils.Utils.e(r2)
            float r0 = r0 + r2
            goto L_0x0122
        L_0x00b6:
            r2 = 1090519040(0x41000000, float:8.0)
            float r2 = com.github.mikephil.charting.utils.Utils.e(r2)
            float r0 = r0 + r2
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            float r5 = r2.f65439y
            float r2 = r2.f65440z
            float r5 = r5 + r2
            com.github.mikephil.charting.utils.MPPointF r2 = r11.getCenter()
            com.github.mikephil.charting.components.Legend r6 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r6 = r6.v()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r7 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            r8 = 1097859072(0x41700000, float:15.0)
            if (r6 != r7) goto L_0x00dc
            int r6 = r11.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 + r8
            goto L_0x00de
        L_0x00dc:
            float r6 = r0 - r8
        L_0x00de:
            float r5 = r5 + r8
            float r7 = r11.x(r6, r5)
            float r8 = r11.getRadius()
            float r6 = r11.y(r6, r5)
            com.github.mikephil.charting.utils.MPPointF r6 = r11.A(r2, r8, r6)
            float r8 = r6.f65546c
            float r9 = r6.f65547d
            float r8 = r11.x(r8, r9)
            r9 = 1084227584(0x40a00000, float:5.0)
            float r9 = com.github.mikephil.charting.utils.Utils.e(r9)
            float r10 = r2.f65547d
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x0113
            int r5 = r11.getHeight()
            float r5 = (float) r5
            float r5 = r5 - r0
            int r10 = r11.getWidth()
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
            com.github.mikephil.charting.utils.MPPointF.f(r2)
            com.github.mikephil.charting.utils.MPPointF.f(r6)
        L_0x0122:
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.a.f65390b
            com.github.mikephil.charting.components.Legend r5 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = r5.v()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x017d
            if (r2 == r3) goto L_0x017a
            r0 = 3
            if (r2 == r0) goto L_0x0138
            goto L_0x014a
        L_0x0138:
            int[] r0 = com.github.mikephil.charting.charts.PieRadarChartBase.a.f65389a
            com.github.mikephil.charting.components.Legend r2 = r11.f65368m
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.B()
            int r2 = r2.ordinal()
            r0 = r0[r2]
            if (r0 == r4) goto L_0x0163
            if (r0 == r3) goto L_0x014c
        L_0x014a:
            goto L_0x007d
        L_0x014c:
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            float r0 = r0.f65439y
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.f65376u
            float r2 = r2.l()
            com.github.mikephil.charting.components.Legend r3 = r11.f65368m
            float r3 = r3.w()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0082
        L_0x0163:
            com.github.mikephil.charting.components.Legend r0 = r11.f65368m
            float r0 = r0.f65439y
            com.github.mikephil.charting.utils.ViewPortHandler r2 = r11.f65376u
            float r2 = r2.l()
            com.github.mikephil.charting.components.Legend r3 = r11.f65368m
            float r3 = r3.w()
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
            float r4 = r11.getRequiredBaseOffset()
            float r1 = r1 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r0 = r0 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r3 = r3 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r2 = r2 + r4
            goto L_0x0199
        L_0x0196:
            r0 = r1
            r2 = r0
            r3 = r2
        L_0x0199:
            float r4 = r11.K
            float r4 = com.github.mikephil.charting.utils.Utils.e(r4)
            boolean r5 = r11 instanceof com.github.mikephil.charting.charts.RadarChart
            if (r5 == 0) goto L_0x01ba
            com.github.mikephil.charting.components.XAxis r5 = r11.getXAxis()
            boolean r6 = r5.f()
            if (r6 == 0) goto L_0x01ba
            boolean r6 = r5.A()
            if (r6 == 0) goto L_0x01ba
            int r5 = r5.K
            float r5 = (float) r5
            float r4 = java.lang.Math.max(r4, r5)
        L_0x01ba:
            float r5 = r11.getExtraTopOffset()
            float r3 = r3 + r5
            float r5 = r11.getExtraRightOffset()
            float r0 = r0 + r5
            float r5 = r11.getExtraBottomOffset()
            float r2 = r2 + r5
            float r5 = r11.getExtraLeftOffset()
            float r1 = r1 + r5
            float r1 = java.lang.Math.max(r4, r1)
            float r3 = java.lang.Math.max(r4, r3)
            float r0 = java.lang.Math.max(r4, r0)
            float r5 = r11.getRequiredBaseOffset()
            float r2 = java.lang.Math.max(r5, r2)
            float r2 = java.lang.Math.max(r4, r2)
            com.github.mikephil.charting.utils.ViewPortHandler r4 = r11.f65376u
            r4.K(r1, r3, r0, r2)
            boolean r4 = r11.f65357b
            if (r4 == 0) goto L_0x021d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", offsetTop: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "MPAndroidChart"
            android.util.Log.i(r1, r0)
        L_0x021d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.f():void");
    }

    public float getDiameter() {
        RectF o11 = this.f65376u.o();
        o11.left += getExtraLeftOffset();
        o11.top += getExtraTopOffset();
        o11.right -= getExtraRightOffset();
        o11.bottom -= getExtraBottomOffset();
        return Math.min(o11.width(), o11.height());
    }

    public int getMaxVisibleCount() {
        return this.f65358c.h();
    }

    public float getMinOffset() {
        return this.K;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.I;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.H;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    public void n() {
        super.n();
        this.f65370o = new c(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        if (!this.f65366k || (chartTouchListener = this.f65370o) == null) {
            return super.onTouchEvent(motionEvent);
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void s() {
        if (this.f65358c != null) {
            w();
            if (this.f65368m != null) {
                this.f65373r.a(this.f65358c);
            }
            f();
        }
    }

    public void setMinOffset(float f11) {
        this.K = f11;
    }

    public void setRotationAngle(float f11) {
        this.I = f11;
        this.H = Utils.q(f11);
    }

    public void setRotationEnabled(boolean z11) {
        this.J = z11;
    }

    public void w() {
    }

    public float x(float f11, float f12) {
        MPPointF centerOffsets = getCenterOffsets();
        float f13 = centerOffsets.f65546c;
        float f14 = f11 > f13 ? f11 - f13 : f13 - f11;
        float f15 = centerOffsets.f65547d;
        float sqrt = (float) Math.sqrt(Math.pow((double) f14, 2.0d) + Math.pow((double) (f12 > f15 ? f12 - f15 : f15 - f12), 2.0d));
        MPPointF.f(centerOffsets);
        return sqrt;
    }

    public float y(float f11, float f12) {
        MPPointF centerOffsets = getCenterOffsets();
        double d11 = (double) (f11 - centerOffsets.f65546c);
        double d12 = (double) (f12 - centerOffsets.f65547d);
        float degrees = (float) Math.toDegrees(Math.acos(d12 / Math.sqrt((d11 * d11) + (d12 * d12))));
        if (f11 > centerOffsets.f65546c) {
            degrees = 360.0f - degrees;
        }
        float f13 = degrees + 90.0f;
        if (f13 > 360.0f) {
            f13 -= 360.0f;
        }
        MPPointF.f(centerOffsets);
        return f13;
    }

    public abstract int z(float f11);

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
