package com.hbg.module.libkt.custom.indicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import kotlin.jvm.internal.x;
import oe.b;

public final class NavigatorHelper {

    /* renamed from: a  reason: collision with root package name */
    public final SparseBooleanArray f24778a = new SparseBooleanArray();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<Float> f24779b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public int f24780c;

    /* renamed from: d  reason: collision with root package name */
    public int f24781d;

    /* renamed from: e  reason: collision with root package name */
    public int f24782e;

    /* renamed from: f  reason: collision with root package name */
    public int f24783f;

    /* renamed from: g  reason: collision with root package name */
    public float f24784g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24785h;

    /* renamed from: i  reason: collision with root package name */
    public b f24786i;

    public final void a(int i11) {
        b bVar = this.f24786i;
        if (bVar != null) {
            bVar.onDeselected(i11, this.f24780c);
        }
        this.f24778a.put(i11, true);
    }

    public final void b(int i11, float f11, boolean z11, boolean z12) {
        if (this.f24785h || i11 == this.f24781d || this.f24783f == 1 || z12) {
            b bVar = this.f24786i;
            if (bVar != null) {
                bVar.onEnter(i11, this.f24780c, f11, z11);
            }
            this.f24779b.put(i11, Float.valueOf(1.0f - f11));
        }
    }

    public final void c(int i11, float f11, boolean z11, boolean z12) {
        if (!(this.f24785h || i11 == this.f24782e || this.f24783f == 1)) {
            int i12 = this.f24781d;
            if ((!(i11 == i12 - 1 || i11 == i12 + 1) || x.a(this.f24779b.get(i11, Float.valueOf(0.0f)), 1.0f)) && !z12) {
                return;
            }
        }
        b bVar = this.f24786i;
        if (bVar != null) {
            bVar.onLeave(i11, this.f24780c, f11, z11);
        }
        this.f24779b.put(i11, Float.valueOf(f11));
    }

    public final void d(int i11) {
        b bVar = this.f24786i;
        if (bVar != null) {
            bVar.onSelected(i11, this.f24780c);
        }
        this.f24778a.put(i11, false);
    }

    public final int e() {
        return this.f24781d;
    }

    public final int f() {
        return this.f24783f;
    }

    public final int g() {
        return this.f24780c;
    }

    public final void h(int i11) {
        this.f24783f = i11;
    }

    public final void i(int i11, float f11) {
        boolean z11;
        float f12 = ((float) i11) + f11;
        float f13 = this.f24784g;
        boolean z12 = f13 <= f12;
        if (this.f24783f != 0) {
            if (!(f12 == f13)) {
                int i12 = i11 + 1;
                if (!(f11 == 0.0f) || !z12) {
                    z11 = true;
                } else {
                    i12 = i11 - 1;
                    z11 = false;
                }
                int i13 = this.f24780c;
                for (int i14 = 0; i14 < i13; i14++) {
                    if (!(i14 == i11 || i14 == i12)) {
                        if (!(this.f24779b.get(i14, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                            c(i14, 1.0f, z12, true);
                        }
                    }
                }
                if (!z11) {
                    float f14 = 1.0f - f11;
                    c(i12, f14, true, false);
                    b(i11, f14, true, false);
                } else if (z12) {
                    c(i11, f11, true, false);
                    b(i12, f11, true, false);
                } else {
                    float f15 = 1.0f - f11;
                    c(i12, f15, false, false);
                    b(i11, f15, false, false);
                }
            } else {
                return;
            }
        } else {
            int i15 = this.f24780c;
            for (int i16 = 0; i16 < i15; i16++) {
                if (i16 != this.f24781d) {
                    if (!this.f24778a.get(i16)) {
                        a(i16);
                    }
                    if (!(this.f24779b.get(i16, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                        c(i16, 1.0f, false, true);
                    }
                }
            }
            b(this.f24781d, 1.0f, false, true);
            d(this.f24781d);
        }
        this.f24784g = f12;
    }

    public final void j(int i11) {
        this.f24782e = this.f24781d;
        this.f24781d = i11;
        d(i11);
        int i12 = this.f24780c;
        for (int i13 = 0; i13 < i12; i13++) {
            if (i13 != this.f24781d && !this.f24778a.get(i13)) {
                a(i13);
            }
        }
    }

    public final void k(b bVar) {
        this.f24786i = bVar;
    }

    public final void l(boolean z11) {
        this.f24785h = z11;
    }

    public final void m(int i11) {
        this.f24780c = i11;
        this.f24778a.clear();
        this.f24779b.clear();
    }
}
