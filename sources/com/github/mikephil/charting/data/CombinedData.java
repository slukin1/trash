package com.github.mikephil.charting.data;

import e5.d;
import g5.b;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<b<? extends Entry>> {

    /* renamed from: j  reason: collision with root package name */
    public LineData f65483j;

    /* renamed from: k  reason: collision with root package name */
    public BarData f65484k;

    /* renamed from: l  reason: collision with root package name */
    public ScatterData f65485l;

    /* renamed from: m  reason: collision with root package name */
    public CandleData f65486m;

    /* renamed from: n  reason: collision with root package name */
    public BubbleData f65487n;

    public b<? extends Entry> A(d dVar) {
        if (dVar.c() >= v().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData z11 = z(dVar.c());
        if (dVar.d() >= z11.f()) {
            return null;
        }
        return (b) z11.g().get(dVar.d());
    }

    public LineData B() {
        return this.f65483j;
    }

    public ScatterData C() {
        return this.f65485l;
    }

    public void b() {
        if (this.f65482i == null) {
            this.f65482i = new ArrayList();
        }
        this.f65482i.clear();
        this.f65474a = -3.4028235E38f;
        this.f65475b = Float.MAX_VALUE;
        this.f65476c = -3.4028235E38f;
        this.f65477d = Float.MAX_VALUE;
        this.f65478e = -3.4028235E38f;
        this.f65479f = Float.MAX_VALUE;
        this.f65480g = -3.4028235E38f;
        this.f65481h = Float.MAX_VALUE;
        for (ChartData next : v()) {
            next.b();
            this.f65482i.addAll(next.g());
            if (next.o() > this.f65474a) {
                this.f65474a = next.o();
            }
            if (next.q() < this.f65475b) {
                this.f65475b = next.q();
            }
            if (next.m() > this.f65476c) {
                this.f65476c = next.m();
            }
            if (next.n() < this.f65477d) {
                this.f65477d = next.n();
            }
            float f11 = next.f65478e;
            if (f11 > this.f65478e) {
                this.f65478e = f11;
            }
            float f12 = next.f65479f;
            if (f12 < this.f65479f) {
                this.f65479f = f12;
            }
            float f13 = next.f65480g;
            if (f13 > this.f65480g) {
                this.f65480g = f13;
            }
            float f14 = next.f65481h;
            if (f14 < this.f65481h) {
                this.f65481h = f14;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.mikephil.charting.data.Entry i(e5.d r6) {
        /*
            r5 = this;
            int r0 = r6.c()
            java.util.List r1 = r5.v()
            int r1 = r1.size()
            r2 = 0
            if (r0 < r1) goto L_0x0010
            return r2
        L_0x0010:
            int r0 = r6.c()
            com.github.mikephil.charting.data.BarLineScatterCandleBubbleData r0 = r5.z(r0)
            int r1 = r6.d()
            int r3 = r0.f()
            if (r1 < r3) goto L_0x0023
            return r2
        L_0x0023:
            int r1 = r6.d()
            g5.e r0 = r0.e(r1)
            float r1 = r6.h()
            java.util.List r0 = r0.getEntriesForXValue(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r3 = r1.getY()
            float r4 = r6.j()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0059
            float r3 = r6.j()
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.i(e5.d):com.github.mikephil.charting.data.Entry");
    }

    public void s() {
        LineData lineData = this.f65483j;
        if (lineData != null) {
            lineData.s();
        }
        BarData barData = this.f65484k;
        if (barData != null) {
            barData.s();
        }
        CandleData candleData = this.f65486m;
        if (candleData != null) {
            candleData.s();
        }
        ScatterData scatterData = this.f65485l;
        if (scatterData != null) {
            scatterData.s();
        }
        BubbleData bubbleData = this.f65487n;
        if (bubbleData != null) {
            bubbleData.s();
        }
        b();
    }

    public List<BarLineScatterCandleBubbleData> v() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.f65483j;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.f65484k;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.f65485l;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.f65486m;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.f65487n;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData w() {
        return this.f65484k;
    }

    public BubbleData x() {
        return this.f65487n;
    }

    public CandleData y() {
        return this.f65486m;
    }

    public BarLineScatterCandleBubbleData z(int i11) {
        return v().get(i11);
    }
}
