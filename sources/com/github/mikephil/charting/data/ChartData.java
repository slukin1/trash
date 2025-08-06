package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import e5.d;
import g5.e;
import java.util.ArrayList;
import java.util.List;

public abstract class ChartData<T extends e<? extends Entry>> {

    /* renamed from: a  reason: collision with root package name */
    public float f65474a;

    /* renamed from: b  reason: collision with root package name */
    public float f65475b;

    /* renamed from: c  reason: collision with root package name */
    public float f65476c;

    /* renamed from: d  reason: collision with root package name */
    public float f65477d;

    /* renamed from: e  reason: collision with root package name */
    public float f65478e;

    /* renamed from: f  reason: collision with root package name */
    public float f65479f;

    /* renamed from: g  reason: collision with root package name */
    public float f65480g;

    /* renamed from: h  reason: collision with root package name */
    public float f65481h;

    /* renamed from: i  reason: collision with root package name */
    public List<T> f65482i;

    public ChartData() {
        this.f65474a = -3.4028235E38f;
        this.f65475b = Float.MAX_VALUE;
        this.f65476c = -3.4028235E38f;
        this.f65477d = Float.MAX_VALUE;
        this.f65478e = -3.4028235E38f;
        this.f65479f = Float.MAX_VALUE;
        this.f65480g = -3.4028235E38f;
        this.f65481h = Float.MAX_VALUE;
        this.f65482i = new ArrayList();
    }

    public final List<T> a(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public void b() {
        List<T> list = this.f65482i;
        if (list != null) {
            this.f65474a = -3.4028235E38f;
            this.f65475b = Float.MAX_VALUE;
            this.f65476c = -3.4028235E38f;
            this.f65477d = Float.MAX_VALUE;
            for (T c11 : list) {
                c(c11);
            }
            this.f65478e = -3.4028235E38f;
            this.f65479f = Float.MAX_VALUE;
            this.f65480g = -3.4028235E38f;
            this.f65481h = Float.MAX_VALUE;
            e j11 = j(this.f65482i);
            if (j11 != null) {
                this.f65478e = j11.getYMax();
                this.f65479f = j11.getYMin();
                for (T t11 : this.f65482i) {
                    if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                        if (t11.getYMin() < this.f65479f) {
                            this.f65479f = t11.getYMin();
                        }
                        if (t11.getYMax() > this.f65478e) {
                            this.f65478e = t11.getYMax();
                        }
                    }
                }
            }
            e k11 = k(this.f65482i);
            if (k11 != null) {
                this.f65480g = k11.getYMax();
                this.f65481h = k11.getYMin();
                for (T t12 : this.f65482i) {
                    if (t12.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                        if (t12.getYMin() < this.f65481h) {
                            this.f65481h = t12.getYMin();
                        }
                        if (t12.getYMax() > this.f65480g) {
                            this.f65480g = t12.getYMax();
                        }
                    }
                }
            }
        }
    }

    public void c(T t11) {
        if (this.f65474a < t11.getYMax()) {
            this.f65474a = t11.getYMax();
        }
        if (this.f65475b > t11.getYMin()) {
            this.f65475b = t11.getYMin();
        }
        if (this.f65476c < t11.getXMax()) {
            this.f65476c = t11.getXMax();
        }
        if (this.f65477d > t11.getXMin()) {
            this.f65477d = t11.getXMin();
        }
        if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
            if (this.f65478e < t11.getYMax()) {
                this.f65478e = t11.getYMax();
            }
            if (this.f65479f > t11.getYMin()) {
                this.f65479f = t11.getYMin();
                return;
            }
            return;
        }
        if (this.f65480g < t11.getYMax()) {
            this.f65480g = t11.getYMax();
        }
        if (this.f65481h > t11.getYMin()) {
            this.f65481h = t11.getYMin();
        }
    }

    public void d(float f11, float f12) {
        for (T calcMinMaxY : this.f65482i) {
            calcMinMaxY.calcMinMaxY(f11, f12);
        }
        b();
    }

    public T e(int i11) {
        List<T> list = this.f65482i;
        if (list == null || i11 < 0 || i11 >= list.size()) {
            return null;
        }
        return (e) this.f65482i.get(i11);
    }

    public int f() {
        List<T> list = this.f65482i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> g() {
        return this.f65482i;
    }

    public int h() {
        int i11 = 0;
        for (T entryCount : this.f65482i) {
            i11 += entryCount.getEntryCount();
        }
        return i11;
    }

    public Entry i(d dVar) {
        if (dVar.d() >= this.f65482i.size()) {
            return null;
        }
        return ((e) this.f65482i.get(dVar.d())).getEntryForXValue(dVar.h(), dVar.j());
    }

    public T j(List<T> list) {
        for (T t11 : list) {
            if (t11.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                return t11;
            }
        }
        return null;
    }

    public T k(List<T> list) {
        for (T t11 : list) {
            if (t11.getAxisDependency() == YAxis.AxisDependency.RIGHT) {
                return t11;
            }
        }
        return null;
    }

    public T l() {
        List<T> list = this.f65482i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t11 = (e) this.f65482i.get(0);
        for (T t12 : this.f65482i) {
            if (t12.getEntryCount() > t11.getEntryCount()) {
                t11 = t12;
            }
        }
        return t11;
    }

    public float m() {
        return this.f65476c;
    }

    public float n() {
        return this.f65477d;
    }

    public float o() {
        return this.f65474a;
    }

    public float p(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f11 = this.f65478e;
            return f11 == -3.4028235E38f ? this.f65480g : f11;
        }
        float f12 = this.f65480g;
        return f12 == -3.4028235E38f ? this.f65478e : f12;
    }

    public float q() {
        return this.f65475b;
    }

    public float r(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f11 = this.f65479f;
            return f11 == Float.MAX_VALUE ? this.f65481h : f11;
        }
        float f12 = this.f65481h;
        return f12 == Float.MAX_VALUE ? this.f65479f : f12;
    }

    public void s() {
        b();
    }

    public void t(boolean z11) {
        for (T drawValues : this.f65482i) {
            drawValues.setDrawValues(z11);
        }
    }

    public void u(float f11) {
        for (T valueTextSize : this.f65482i) {
            valueTextSize.setValueTextSize(f11);
        }
    }

    public ChartData(T... tArr) {
        this.f65474a = -3.4028235E38f;
        this.f65475b = Float.MAX_VALUE;
        this.f65476c = -3.4028235E38f;
        this.f65477d = Float.MAX_VALUE;
        this.f65478e = -3.4028235E38f;
        this.f65479f = Float.MAX_VALUE;
        this.f65480g = -3.4028235E38f;
        this.f65481h = Float.MAX_VALUE;
        this.f65482i = a(tArr);
        s();
    }
}
