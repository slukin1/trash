package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import c5.c;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import d5.d;
import g5.f;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends c<Entry> implements f {
    public Mode F = Mode.LINEAR;
    public List<Integer> G = null;
    public int H = -1;
    public float I = 8.0f;
    public float J = 4.0f;
    public float K = 0.2f;
    public DashPathEffect L = null;
    public d M = new DefaultFillFormatter();
    public boolean N = true;
    public boolean O = true;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.clear();
        this.G.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public float F() {
        return this.K;
    }

    @Deprecated
    public boolean K() {
        return this.F == Mode.STEPPED;
    }

    public float T() {
        return this.I;
    }

    public boolean c() {
        return this.L != null;
    }

    public boolean c0() {
        return this.O;
    }

    public int d() {
        return this.H;
    }

    public Mode getMode() {
        return this.F;
    }

    public int m() {
        return this.G.size();
    }

    public d p() {
        return this.M;
    }

    public DashPathEffect r() {
        return this.L;
    }

    public void r0(float f11) {
        if (f11 > 1.0f) {
            f11 = 1.0f;
        }
        if (f11 < 0.05f) {
            f11 = 0.05f;
        }
        this.K = f11;
    }

    public void s0(boolean z11) {
        this.N = z11;
    }

    public void t0(d dVar) {
        if (dVar == null) {
            this.M = new DefaultFillFormatter();
        } else {
            this.M = dVar;
        }
    }

    public void u0(Mode mode) {
        this.F = mode;
    }

    public int w(int i11) {
        return this.G.get(i11).intValue();
    }

    public boolean x() {
        return this.N;
    }

    public float y() {
        return this.J;
    }
}
