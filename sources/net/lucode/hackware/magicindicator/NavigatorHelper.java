package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public class NavigatorHelper {

    /* renamed from: a  reason: collision with root package name */
    public SparseBooleanArray f58463a = new SparseBooleanArray();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Float> f58464b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public int f58465c;

    /* renamed from: d  reason: collision with root package name */
    public int f58466d;

    /* renamed from: e  reason: collision with root package name */
    public int f58467e;

    /* renamed from: f  reason: collision with root package name */
    public float f58468f;

    /* renamed from: g  reason: collision with root package name */
    public int f58469g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58470h;

    /* renamed from: i  reason: collision with root package name */
    public a f58471i;

    public interface a {
        void onDeselected(int i11, int i12);

        void onEnter(int i11, int i12, float f11, boolean z11);

        void onLeave(int i11, int i12, float f11, boolean z11);

        void onSelected(int i11, int i12);
    }

    public final void a(int i11) {
        a aVar = this.f58471i;
        if (aVar != null) {
            aVar.onDeselected(i11, this.f58465c);
        }
        this.f58463a.put(i11, true);
    }

    public final void b(int i11, float f11, boolean z11, boolean z12) {
        if (this.f58470h || i11 == this.f58466d || this.f58469g == 1 || z12) {
            a aVar = this.f58471i;
            if (aVar != null) {
                aVar.onEnter(i11, this.f58465c, f11, z11);
            }
            this.f58464b.put(i11, Float.valueOf(1.0f - f11));
        }
    }

    public final void c(int i11, float f11, boolean z11, boolean z12) {
        if (!(this.f58470h || i11 == this.f58467e || this.f58469g == 1)) {
            int i12 = this.f58466d;
            if ((!(i11 == i12 - 1 || i11 == i12 + 1) || this.f58464b.get(i11, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z12) {
                return;
            }
        }
        a aVar = this.f58471i;
        if (aVar != null) {
            aVar.onLeave(i11, this.f58465c, f11, z11);
        }
        this.f58464b.put(i11, Float.valueOf(f11));
    }

    public final void d(int i11) {
        a aVar = this.f58471i;
        if (aVar != null) {
            aVar.onSelected(i11, this.f58465c);
        }
        this.f58463a.put(i11, false);
    }

    public int e() {
        return this.f58466d;
    }

    public int f() {
        return this.f58469g;
    }

    public int g() {
        return this.f58465c;
    }

    public void h(int i11) {
        this.f58469g = i11;
    }

    public void i(int i11, float f11, int i12) {
        boolean z11;
        float f12 = ((float) i11) + f11;
        float f13 = this.f58468f;
        boolean z12 = f13 <= f12;
        if (this.f58469g == 0) {
            for (int i13 = 0; i13 < this.f58465c; i13++) {
                if (i13 != this.f58466d) {
                    if (!this.f58463a.get(i13)) {
                        a(i13);
                    }
                    if (this.f58464b.get(i13, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        c(i13, 1.0f, false, true);
                    }
                }
            }
            b(this.f58466d, 1.0f, false, true);
            d(this.f58466d);
        } else if (f12 != f13) {
            int i14 = i11 + 1;
            if (f11 != 0.0f || !z12) {
                z11 = true;
            } else {
                i14 = i11 - 1;
                z11 = false;
            }
            for (int i15 = 0; i15 < this.f58465c; i15++) {
                if (!(i15 == i11 || i15 == i14 || this.f58464b.get(i15, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    c(i15, 1.0f, z12, true);
                }
            }
            if (!z11) {
                float f14 = 1.0f - f11;
                c(i14, f14, true, false);
                b(i11, f14, true, false);
            } else if (z12) {
                c(i11, f11, true, false);
                b(i14, f11, true, false);
            } else {
                float f15 = 1.0f - f11;
                c(i14, f15, false, false);
                b(i11, f15, false, false);
            }
        } else {
            return;
        }
        this.f58468f = f12;
    }

    public void j(int i11) {
        this.f58467e = this.f58466d;
        this.f58466d = i11;
        d(i11);
        for (int i12 = 0; i12 < this.f58465c; i12++) {
            if (i12 != this.f58466d && !this.f58463a.get(i12)) {
                a(i12);
            }
        }
    }

    public void k(a aVar) {
        this.f58471i = aVar;
    }

    public void l(boolean z11) {
        this.f58470h = z11;
    }

    public void m(int i11) {
        this.f58465c = i11;
        this.f58463a.clear();
        this.f58464b.clear();
    }
}
