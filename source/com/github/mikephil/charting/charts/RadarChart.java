package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.Utils;
import e5.i;
import g5.j;
import i5.n;
import i5.s;
import i5.v;

public class RadarChart extends PieRadarChartBase<RadarData> {
    public float L = 2.5f;
    public float M = 1.5f;
    public int N = Color.rgb(122, 122, 122);
    public int O = Color.rgb(122, 122, 122);
    public int P = 150;
    public boolean Q = true;
    public int R = 0;
    public YAxis S;
    public v T;
    public s U;

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public float getFactor() {
        RectF o11 = this.f65376u.o();
        return Math.min(o11.width() / 2.0f, o11.height() / 2.0f) / this.S.H;
    }

    public float getRadius() {
        RectF o11 = this.f65376u.o();
        return Math.min(o11.width() / 2.0f, o11.height() / 2.0f);
    }

    public float getRequiredBaseOffset() {
        if (!this.f65365j.f() || !this.f65365j.A()) {
            return Utils.e(10.0f);
        }
        return (float) this.f65365j.K;
    }

    public float getRequiredLegendOffset() {
        return this.f65373r.d().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.R;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((j) ((RadarData) this.f65358c).l()).getEntryCount());
    }

    public int getWebAlpha() {
        return this.P;
    }

    public int getWebColor() {
        return this.N;
    }

    public int getWebColorInner() {
        return this.O;
    }

    public float getWebLineWidth() {
        return this.L;
    }

    public float getWebLineWidthInner() {
        return this.M;
    }

    public YAxis getYAxis() {
        return this.S;
    }

    public float getYChartMax() {
        return this.S.F;
    }

    public float getYChartMin() {
        return this.S.G;
    }

    public float getYRange() {
        return this.S.H;
    }

    public void n() {
        super.n();
        this.S = new YAxis(YAxis.AxisDependency.LEFT);
        this.L = Utils.e(1.5f);
        this.M = Utils.e(0.75f);
        this.f65374s = new n(this, this.f65377v, this.f65376u);
        this.T = new v(this.f65376u, this.S, this);
        this.U = new s(this.f65376u, this.f65365j, this);
        this.f65375t = new i(this);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f65358c != null) {
            if (this.f65365j.f()) {
                s sVar = this.U;
                XAxis xAxis = this.f65365j;
                sVar.a(xAxis.G, xAxis.F, false);
            }
            this.U.i(canvas);
            if (this.Q) {
                this.f65374s.c(canvas);
            }
            if (this.S.f() && this.S.B()) {
                this.T.l(canvas);
            }
            this.f65374s.b(canvas);
            if (v()) {
                this.f65374s.d(canvas, this.B);
            }
            if (this.S.f() && !this.S.B()) {
                this.T.l(canvas);
            }
            this.T.i(canvas);
            this.f65374s.f(canvas);
            this.f65373r.e(canvas);
            h(canvas);
            i(canvas);
        }
    }

    public void s() {
        if (this.f65358c != null) {
            w();
            v vVar = this.T;
            YAxis yAxis = this.S;
            vVar.a(yAxis.G, yAxis.F, yAxis.b0());
            s sVar = this.U;
            XAxis xAxis = this.f65365j;
            sVar.a(xAxis.G, xAxis.F, false);
            Legend legend = this.f65368m;
            if (legend != null && !legend.F()) {
                this.f65373r.a(this.f65358c);
            }
            f();
        }
    }

    public void setDrawWeb(boolean z11) {
        this.Q = z11;
    }

    public void setSkipWebLineCount(int i11) {
        this.R = Math.max(0, i11);
    }

    public void setWebAlpha(int i11) {
        this.P = i11;
    }

    public void setWebColor(int i11) {
        this.N = i11;
    }

    public void setWebColorInner(int i11) {
        this.O = i11;
    }

    public void setWebLineWidth(float f11) {
        this.L = Utils.e(f11);
    }

    public void setWebLineWidthInner(float f11) {
        this.M = Utils.e(f11);
    }

    public void w() {
        super.w();
        YAxis yAxis = this.S;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.j(((RadarData) this.f65358c).r(axisDependency), ((RadarData) this.f65358c).p(axisDependency));
        this.f65365j.j(0.0f, (float) ((j) ((RadarData) this.f65358c).l()).getEntryCount());
    }

    public int z(float f11) {
        float q11 = Utils.q(f11 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int entryCount = ((j) ((RadarData) this.f65358c).l()).getEntryCount();
        int i11 = 0;
        while (i11 < entryCount) {
            int i12 = i11 + 1;
            if ((((float) i12) * sliceAngle) - (sliceAngle / 2.0f) > q11) {
                return i11;
            }
            i11 = i12;
        }
        return 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
