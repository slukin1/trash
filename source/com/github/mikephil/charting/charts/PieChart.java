package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import e5.d;
import e5.g;
import g5.i;
import i5.m;
import java.util.List;

public class PieChart extends PieRadarChartBase<PieData> {
    public RectF L = new RectF();
    public boolean M = true;
    public float[] N = new float[1];
    public float[] O = new float[1];
    public boolean P = true;
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;
    public CharSequence T = "";
    public MPPointF U = MPPointF.c(0.0f, 0.0f);
    public float V = 50.0f;
    public float W = 55.0f;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f65386a0 = true;

    /* renamed from: b0  reason: collision with root package name */
    public float f65387b0 = 100.0f;

    /* renamed from: c0  reason: collision with root package name */
    public float f65388c0 = 360.0f;

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final float D(float f11, float f12) {
        return (f11 / f12) * this.f65388c0;
    }

    public final void E() {
        int h11 = ((PieData) this.f65358c).h();
        if (this.N.length != h11) {
            this.N = new float[h11];
        } else {
            for (int i11 = 0; i11 < h11; i11++) {
                this.N[i11] = 0.0f;
            }
        }
        if (this.O.length != h11) {
            this.O = new float[h11];
        } else {
            for (int i12 = 0; i12 < h11; i12++) {
                this.O[i12] = 0.0f;
            }
        }
        float x11 = ((PieData) this.f65358c).x();
        List g11 = ((PieData) this.f65358c).g();
        int i13 = 0;
        for (int i14 = 0; i14 < ((PieData) this.f65358c).f(); i14++) {
            i iVar = (i) g11.get(i14);
            for (int i15 = 0; i15 < iVar.getEntryCount(); i15++) {
                this.N[i13] = D(Math.abs(((PieEntry) iVar.getEntryForIndex(i15)).getY()), x11);
                if (i13 == 0) {
                    this.O[i13] = this.N[i13];
                } else {
                    float[] fArr = this.O;
                    fArr[i13] = fArr[i13 - 1] + this.N[i13];
                }
                i13++;
            }
        }
    }

    public boolean F() {
        return this.f65386a0;
    }

    public boolean G() {
        return this.M;
    }

    public boolean H() {
        return this.P;
    }

    public boolean I() {
        return this.Q;
    }

    public boolean J() {
        return this.R;
    }

    public boolean K(int i11) {
        if (!v()) {
            return false;
        }
        int i12 = 0;
        while (true) {
            d[] dVarArr = this.B;
            if (i12 >= dVarArr.length) {
                return false;
            }
            if (((int) dVarArr[i12].h()) == i11) {
                return true;
            }
            i12++;
        }
    }

    public void f() {
        super.f();
        if (this.f65358c != null) {
            float diameter = getDiameter() / 2.0f;
            MPPointF centerOffsets = getCenterOffsets();
            float selectionShift = ((PieData) this.f65358c).v().getSelectionShift();
            RectF rectF = this.L;
            float f11 = centerOffsets.f65546c;
            float f12 = centerOffsets.f65547d;
            rectF.set((f11 - diameter) + selectionShift, (f12 - diameter) + selectionShift, (f11 + diameter) - selectionShift, (f12 + diameter) - selectionShift);
            MPPointF.f(centerOffsets);
        }
    }

    public float[] getAbsoluteAngles() {
        return this.O;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.c(this.L.centerX(), this.L.centerY());
    }

    public CharSequence getCenterText() {
        return this.T;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.U;
        return MPPointF.c(mPPointF.f65546c, mPPointF.f65547d);
    }

    public float getCenterTextRadiusPercent() {
        return this.f65387b0;
    }

    public RectF getCircleBox() {
        return this.L;
    }

    public float[] getDrawAngles() {
        return this.N;
    }

    public float getHoleRadius() {
        return this.V;
    }

    public float getMaxAngle() {
        return this.f65388c0;
    }

    public float getRadius() {
        RectF rectF = this.L;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.L.height() / 2.0f);
    }

    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    public float getRequiredLegendOffset() {
        return this.f65373r.d().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.W;
    }

    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    public float[] l(d dVar) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f11 = (radius / 10.0f) * 3.6f;
        if (H()) {
            f11 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f12 = radius - f11;
        float rotationAngle = getRotationAngle();
        int h11 = (int) dVar.h();
        float f13 = this.N[h11] / 2.0f;
        double d11 = (double) f12;
        float cos = (float) ((Math.cos(Math.toRadians((double) (((this.O[h11] + rotationAngle) - f13) * this.f65377v.b()))) * d11) + ((double) centerCircleBox.f65546c));
        MPPointF.f(centerCircleBox);
        return new float[]{cos, (float) ((d11 * Math.sin(Math.toRadians((double) (((rotationAngle + this.O[h11]) - f13) * this.f65377v.b())))) + ((double) centerCircleBox.f65547d))};
    }

    public void n() {
        super.n();
        this.f65374s = new m(this, this.f65377v, this.f65376u);
        this.f65365j = null;
        this.f65375t = new g(this);
    }

    public void onDetachedFromWindow() {
        i5.g gVar = this.f65374s;
        if (gVar != null && (gVar instanceof m)) {
            ((m) gVar).s();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f65358c != null) {
            this.f65374s.b(canvas);
            if (v()) {
                this.f65374s.d(canvas, this.B);
            }
            this.f65374s.c(canvas);
            this.f65374s.f(canvas);
            this.f65373r.e(canvas);
            h(canvas);
            i(canvas);
        }
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.T = "";
        } else {
            this.T = charSequence;
        }
    }

    public void setCenterTextColor(int i11) {
        ((m) this.f65374s).n().setColor(i11);
    }

    public void setCenterTextRadiusPercent(float f11) {
        this.f65387b0 = f11;
    }

    public void setCenterTextSize(float f11) {
        ((m) this.f65374s).n().setTextSize(Utils.e(f11));
    }

    public void setCenterTextSizePixels(float f11) {
        ((m) this.f65374s).n().setTextSize(f11);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((m) this.f65374s).n().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z11) {
        this.f65386a0 = z11;
    }

    public void setDrawEntryLabels(boolean z11) {
        this.M = z11;
    }

    public void setDrawHoleEnabled(boolean z11) {
        this.P = z11;
    }

    @Deprecated
    public void setDrawSliceText(boolean z11) {
        this.M = z11;
    }

    public void setDrawSlicesUnderHole(boolean z11) {
        this.Q = z11;
    }

    public void setEntryLabelColor(int i11) {
        ((m) this.f65374s).o().setColor(i11);
    }

    public void setEntryLabelTextSize(float f11) {
        ((m) this.f65374s).o().setTextSize(Utils.e(f11));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((m) this.f65374s).o().setTypeface(typeface);
    }

    public void setHoleColor(int i11) {
        ((m) this.f65374s).p().setColor(i11);
    }

    public void setHoleRadius(float f11) {
        this.V = f11;
    }

    public void setMaxAngle(float f11) {
        if (f11 > 360.0f) {
            f11 = 360.0f;
        }
        if (f11 < 90.0f) {
            f11 = 90.0f;
        }
        this.f65388c0 = f11;
    }

    public void setTransparentCircleAlpha(int i11) {
        ((m) this.f65374s).q().setAlpha(i11);
    }

    public void setTransparentCircleColor(int i11) {
        Paint q11 = ((m) this.f65374s).q();
        int alpha = q11.getAlpha();
        q11.setColor(i11);
        q11.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f11) {
        this.W = f11;
    }

    public void setUsePercentValues(boolean z11) {
        this.R = z11;
    }

    public void w() {
        E();
    }

    public int z(float f11) {
        float q11 = Utils.q(f11 - getRotationAngle());
        int i11 = 0;
        while (true) {
            float[] fArr = this.O;
            if (i11 >= fArr.length) {
                return -1;
            }
            if (fArr[i11] > q11) {
                return i11;
            }
            i11++;
        }
    }

    public PieChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
