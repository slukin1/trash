package i5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import d5.e;
import e5.d;
import g5.j;

public class n extends k {

    /* renamed from: i  reason: collision with root package name */
    public RadarChart f66365i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f66366j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f66367k;

    /* renamed from: l  reason: collision with root package name */
    public Path f66368l = new Path();

    /* renamed from: m  reason: collision with root package name */
    public Path f66369m = new Path();

    public n(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f66365i = radarChart;
        Paint paint = new Paint(1);
        this.f66318d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f66318d.setStrokeWidth(2.0f);
        this.f66318d.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.f66366j = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f66367k = new Paint(1);
    }

    public void b(Canvas canvas) {
        RadarData radarData = (RadarData) this.f66365i.getData();
        int entryCount = ((j) radarData.l()).getEntryCount();
        for (j jVar : radarData.g()) {
            if (jVar.isVisible()) {
                o(canvas, jVar, entryCount);
            }
        }
    }

    public void c(Canvas canvas) {
        q(canvas);
    }

    public void d(Canvas canvas, d[] dVarArr) {
        int i11;
        int i12;
        d[] dVarArr2 = dVarArr;
        float sliceAngle = this.f66365i.getSliceAngle();
        float factor = this.f66365i.getFactor();
        MPPointF centerOffsets = this.f66365i.getCenterOffsets();
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        RadarData radarData = (RadarData) this.f66365i.getData();
        int length = dVarArr2.length;
        int i13 = 0;
        int i14 = 0;
        while (i14 < length) {
            d dVar = dVarArr2[i14];
            j jVar = (j) radarData.e(dVar.d());
            if (jVar != null && jVar.isHighlightEnabled()) {
                RadarEntry radarEntry = (RadarEntry) jVar.getEntryForIndex((int) dVar.h());
                if (i(radarEntry, jVar)) {
                    Utils.r(centerOffsets, (radarEntry.getY() - this.f66365i.getYChartMin()) * factor * this.f66316b.b(), (dVar.h() * sliceAngle * this.f66316b.a()) + this.f66365i.getRotationAngle(), c11);
                    dVar.m(c11.f65546c, c11.f65547d);
                    k(canvas, c11.f65546c, c11.f65547d, jVar);
                    if (jVar.P() && !Float.isNaN(c11.f65546c) && !Float.isNaN(c11.f65547d)) {
                        int B = jVar.B();
                        if (B == 1122867) {
                            B = jVar.getColor(i13);
                        }
                        if (jVar.o() < 255) {
                            B = ColorTemplate.a(B, jVar.o());
                        }
                        float N = jVar.N();
                        float E = jVar.E();
                        int a11 = jVar.a();
                        i11 = i14;
                        i12 = i13;
                        p(canvas, c11, N, E, a11, B, jVar.L());
                        i14 = i11 + 1;
                        i13 = i12;
                    }
                }
            }
            i11 = i14;
            i12 = i13;
            i14 = i11 + 1;
            i13 = i12;
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(c11);
    }

    public void f(Canvas canvas) {
        float f11;
        int i11;
        float f12;
        MPPointF mPPointF;
        j jVar;
        float f13;
        int i12;
        int i13;
        float f14;
        MPPointF mPPointF2;
        MPPointF mPPointF3;
        float a11 = this.f66316b.a();
        float b11 = this.f66316b.b();
        float sliceAngle = this.f66365i.getSliceAngle();
        float factor = this.f66365i.getFactor();
        MPPointF centerOffsets = this.f66365i.getCenterOffsets();
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        MPPointF c12 = MPPointF.c(0.0f, 0.0f);
        float e11 = Utils.e(5.0f);
        int i14 = 0;
        while (i14 < ((RadarData) this.f66365i.getData()).f()) {
            j jVar2 = (j) ((RadarData) this.f66365i.getData()).e(i14);
            if (!j(jVar2)) {
                i11 = i14;
                f11 = a11;
                f12 = sliceAngle;
                mPPointF = c12;
            } else {
                a(jVar2);
                MPPointF d11 = MPPointF.d(jVar2.getIconsOffset());
                d11.f65546c = Utils.e(d11.f65546c);
                d11.f65547d = Utils.e(d11.f65547d);
                int i15 = 0;
                while (i15 < jVar2.getEntryCount()) {
                    RadarEntry radarEntry = (RadarEntry) jVar2.getEntryForIndex(i15);
                    float f15 = ((float) i15) * sliceAngle * a11;
                    Utils.r(centerOffsets, (radarEntry.getY() - this.f66365i.getYChartMin()) * factor * b11, f15 + this.f66365i.getRotationAngle(), c11);
                    if (jVar2.isDrawValuesEnabled()) {
                        e valueFormatter = jVar2.getValueFormatter();
                        float y11 = radarEntry.getY();
                        float f16 = c11.f65546c;
                        float f17 = c11.f65547d - e11;
                        int valueTextColor = jVar2.getValueTextColor(i15);
                        i12 = i15;
                        f13 = a11;
                        mPPointF3 = d11;
                        jVar = jVar2;
                        i13 = i14;
                        float f18 = f17;
                        f14 = sliceAngle;
                        mPPointF2 = c12;
                        e(canvas, valueFormatter, y11, radarEntry, i14, f16, f18, valueTextColor);
                    } else {
                        i12 = i15;
                        jVar = jVar2;
                        i13 = i14;
                        f13 = a11;
                        f14 = sliceAngle;
                        mPPointF3 = d11;
                        mPPointF2 = c12;
                    }
                    if (radarEntry.getIcon() != null && jVar.isDrawIconsEnabled()) {
                        Drawable icon = radarEntry.getIcon();
                        Utils.r(centerOffsets, (radarEntry.getY() * factor * b11) + mPPointF3.f65547d, f15 + this.f66365i.getRotationAngle(), mPPointF2);
                        float f19 = mPPointF2.f65547d + mPPointF3.f65546c;
                        mPPointF2.f65547d = f19;
                        Utils.f(canvas, icon, (int) mPPointF2.f65546c, (int) f19, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i15 = i12 + 1;
                    d11 = mPPointF3;
                    c12 = mPPointF2;
                    sliceAngle = f14;
                    i14 = i13;
                    a11 = f13;
                    jVar2 = jVar;
                }
                i11 = i14;
                f11 = a11;
                f12 = sliceAngle;
                mPPointF = c12;
                MPPointF.f(d11);
            }
            i14 = i11 + 1;
            c12 = mPPointF;
            sliceAngle = f12;
            a11 = f11;
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(c11);
        MPPointF.f(c12);
    }

    public void g() {
    }

    public void o(Canvas canvas, j jVar, int i11) {
        float a11 = this.f66316b.a();
        float b11 = this.f66316b.b();
        float sliceAngle = this.f66365i.getSliceAngle();
        float factor = this.f66365i.getFactor();
        MPPointF centerOffsets = this.f66365i.getCenterOffsets();
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        Path path = this.f66368l;
        path.reset();
        boolean z11 = false;
        for (int i12 = 0; i12 < jVar.getEntryCount(); i12++) {
            this.f66317c.setColor(jVar.getColor(i12));
            Utils.r(centerOffsets, (((RadarEntry) jVar.getEntryForIndex(i12)).getY() - this.f66365i.getYChartMin()) * factor * b11, (((float) i12) * sliceAngle * a11) + this.f66365i.getRotationAngle(), c11);
            if (!Float.isNaN(c11.f65546c)) {
                if (!z11) {
                    path.moveTo(c11.f65546c, c11.f65547d);
                    z11 = true;
                } else {
                    path.lineTo(c11.f65546c, c11.f65547d);
                }
            }
        }
        if (jVar.getEntryCount() > i11) {
            path.lineTo(centerOffsets.f65546c, centerOffsets.f65547d);
        }
        path.close();
        if (jVar.U()) {
            Drawable e11 = jVar.e();
            if (e11 != null) {
                n(canvas, path, e11);
            } else {
                m(canvas, path, jVar.n(), jVar.A());
            }
        }
        this.f66317c.setStrokeWidth(jVar.C());
        this.f66317c.setStyle(Paint.Style.STROKE);
        if (!jVar.U() || jVar.A() < 255) {
            canvas.drawPath(path, this.f66317c);
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(c11);
    }

    public void p(Canvas canvas, MPPointF mPPointF, float f11, float f12, int i11, int i12, float f13) {
        canvas.save();
        float e11 = Utils.e(f12);
        float e12 = Utils.e(f11);
        if (i11 != 1122867) {
            Path path = this.f66369m;
            path.reset();
            path.addCircle(mPPointF.f65546c, mPPointF.f65547d, e11, Path.Direction.CW);
            if (e12 > 0.0f) {
                path.addCircle(mPPointF.f65546c, mPPointF.f65547d, e12, Path.Direction.CCW);
            }
            this.f66367k.setColor(i11);
            this.f66367k.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f66367k);
        }
        if (i12 != 1122867) {
            this.f66367k.setColor(i12);
            this.f66367k.setStyle(Paint.Style.STROKE);
            this.f66367k.setStrokeWidth(Utils.e(f13));
            canvas.drawCircle(mPPointF.f65546c, mPPointF.f65547d, e11, this.f66367k);
        }
        canvas.restore();
    }

    public void q(Canvas canvas) {
        float sliceAngle = this.f66365i.getSliceAngle();
        float factor = this.f66365i.getFactor();
        float rotationAngle = this.f66365i.getRotationAngle();
        MPPointF centerOffsets = this.f66365i.getCenterOffsets();
        this.f66366j.setStrokeWidth(this.f66365i.getWebLineWidth());
        this.f66366j.setColor(this.f66365i.getWebColor());
        this.f66366j.setAlpha(this.f66365i.getWebAlpha());
        int skipWebLineCount = this.f66365i.getSkipWebLineCount() + 1;
        int entryCount = ((j) ((RadarData) this.f66365i.getData()).l()).getEntryCount();
        MPPointF c11 = MPPointF.c(0.0f, 0.0f);
        for (int i11 = 0; i11 < entryCount; i11 += skipWebLineCount) {
            Utils.r(centerOffsets, this.f66365i.getYRange() * factor, (((float) i11) * sliceAngle) + rotationAngle, c11);
            canvas.drawLine(centerOffsets.f65546c, centerOffsets.f65547d, c11.f65546c, c11.f65547d, this.f66366j);
        }
        MPPointF.f(c11);
        this.f66366j.setStrokeWidth(this.f66365i.getWebLineWidthInner());
        this.f66366j.setColor(this.f66365i.getWebColorInner());
        this.f66366j.setAlpha(this.f66365i.getWebAlpha());
        int i12 = this.f66365i.getYAxis().f65399n;
        MPPointF c12 = MPPointF.c(0.0f, 0.0f);
        MPPointF c13 = MPPointF.c(0.0f, 0.0f);
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            while (i14 < ((RadarData) this.f66365i.getData()).h()) {
                float yChartMin = (this.f66365i.getYAxis().f65397l[i13] - this.f66365i.getYChartMin()) * factor;
                Utils.r(centerOffsets, yChartMin, (((float) i14) * sliceAngle) + rotationAngle, c12);
                i14++;
                Utils.r(centerOffsets, yChartMin, (((float) i14) * sliceAngle) + rotationAngle, c13);
                canvas.drawLine(c12.f65546c, c12.f65547d, c13.f65546c, c13.f65547d, this.f66366j);
            }
        }
        MPPointF.f(c12);
        MPPointF.f(c13);
    }
}
