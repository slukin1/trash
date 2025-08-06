package com.github.mikephil.charting.data;

import e5.d;
import g5.i;

public class PieData extends ChartData<i> {
    public Entry i(d dVar) {
        return v().getEntryForIndex((int) dVar.h());
    }

    public i v() {
        return (i) this.f65482i.get(0);
    }

    /* renamed from: w */
    public i e(int i11) {
        if (i11 == 0) {
            return v();
        }
        return null;
    }

    public float x() {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < v().getEntryCount(); i11++) {
            f11 += ((PieEntry) v().getEntryForIndex(i11)).getY();
        }
        return f11;
    }
}
