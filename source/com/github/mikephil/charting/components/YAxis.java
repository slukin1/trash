package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public float N;
    public float O;
    public float P;
    public YAxisLabelPosition Q;
    public AxisDependency R;
    public float S;
    public float T;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = -7829368;
        this.N = 1.0f;
        this.O = 10.0f;
        this.P = 10.0f;
        this.Q = YAxisLabelPosition.OUTSIDE_CHART;
        this.S = 0.0f;
        this.T = Float.POSITIVE_INFINITY;
        this.R = AxisDependency.LEFT;
        this.f65414c = 0.0f;
    }

    public AxisDependency O() {
        return this.R;
    }

    public YAxisLabelPosition P() {
        return this.Q;
    }

    public float Q() {
        return this.T;
    }

    public float R() {
        return this.S;
    }

    public float S(Paint paint) {
        paint.setTextSize(this.f65416e);
        return ((float) Utils.a(paint, v())) + (e() * 2.0f);
    }

    public float T(Paint paint) {
        paint.setTextSize(this.f65416e);
        float d11 = ((float) Utils.d(paint, v())) + (d() * 2.0f);
        float R2 = R();
        float Q2 = Q();
        if (R2 > 0.0f) {
            R2 = Utils.e(R2);
        }
        if (Q2 > 0.0f && Q2 != Float.POSITIVE_INFINITY) {
            Q2 = Utils.e(Q2);
        }
        if (((double) Q2) <= 0.0d) {
            Q2 = d11;
        }
        return Math.max(R2, Math.min(d11, Q2));
    }

    public float U() {
        return this.P;
    }

    public float V() {
        return this.O;
    }

    public int W() {
        return this.M;
    }

    public float X() {
        return this.N;
    }

    public boolean Y() {
        return this.I;
    }

    public boolean Z() {
        return this.J;
    }

    public boolean a0() {
        return this.L;
    }

    public boolean b0() {
        return this.K;
    }

    public boolean c0() {
        return f() && A() && P() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void d0(boolean z11) {
        this.L = z11;
    }

    public void e0(YAxisLabelPosition yAxisLabelPosition) {
        this.Q = yAxisLabelPosition;
    }

    public void f0(float f11) {
        this.P = f11;
    }

    public void g0(float f11) {
        this.O = f11;
    }

    public void j(float f11, float f12) {
        if (this.D) {
            f11 = this.G;
        }
        if (this.E) {
            f12 = this.F;
        }
        float abs = Math.abs(f12 - f11);
        if (abs == 0.0f) {
            f12 += 1.0f;
            f11 -= 1.0f;
        }
        if (!this.D) {
            this.G = f11 - ((abs / 100.0f) * U());
        }
        if (!this.E) {
            this.F = f12 + ((abs / 100.0f) * V());
        }
        this.H = Math.abs(this.F - this.G);
    }

    public YAxis(AxisDependency axisDependency) {
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = -7829368;
        this.N = 1.0f;
        this.O = 10.0f;
        this.P = 10.0f;
        this.Q = YAxisLabelPosition.OUTSIDE_CHART;
        this.S = 0.0f;
        this.T = Float.POSITIVE_INFINITY;
        this.R = axisDependency;
        this.f65414c = 0.0f;
    }
}
