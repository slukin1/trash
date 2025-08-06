package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f8669a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f8670b;

    /* renamed from: c  reason: collision with root package name */
    public final View f8671c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8672d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f8673e;

    public q(View view) {
        this.f8671c = view;
    }

    public boolean a(float f11, float f12, boolean z11) {
        ViewParent i11;
        if (!m() || (i11 = i(0)) == null) {
            return false;
        }
        return l0.a(i11, this.f8671c, f11, f12, z11);
    }

    public boolean b(float f11, float f12) {
        ViewParent i11;
        if (!m() || (i11 = i(0)) == null) {
            return false;
        }
        return l0.b(i11, this.f8671c, f11, f12);
    }

    public boolean c(int i11, int i12, int[] iArr, int[] iArr2) {
        return d(i11, i12, iArr, iArr2, 0);
    }

    public boolean d(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        ViewParent i14;
        int i15;
        int i16;
        if (!m() || (i14 = i(i13)) == null) {
            return false;
        }
        if (i11 != 0 || i12 != 0) {
            if (iArr2 != null) {
                this.f8671c.getLocationInWindow(iArr2);
                i16 = iArr2[0];
                i15 = iArr2[1];
            } else {
                i16 = 0;
                i15 = 0;
            }
            if (iArr == null) {
                iArr = j();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            l0.c(i14, this.f8671c, i11, i12, iArr, i13);
            if (iArr2 != null) {
                this.f8671c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i16;
                iArr2[1] = iArr2[1] - i15;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void e(int i11, int i12, int i13, int i14, int[] iArr, int i15, int[] iArr2) {
        h(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    public boolean f(int i11, int i12, int i13, int i14, int[] iArr) {
        return h(i11, i12, i13, i14, iArr, 0, (int[]) null);
    }

    public boolean g(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return h(i11, i12, i13, i14, iArr, i15, (int[]) null);
    }

    public final boolean h(int i11, int i12, int i13, int i14, int[] iArr, int i15, int[] iArr2) {
        ViewParent i16;
        int i17;
        int i18;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!m() || (i16 = i(i15)) == null) {
            return false;
        }
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f8671c.getLocationInWindow(iArr4);
            i18 = iArr4[0];
            i17 = iArr4[1];
        } else {
            i18 = 0;
            i17 = 0;
        }
        if (iArr2 == null) {
            int[] j11 = j();
            j11[0] = 0;
            j11[1] = 0;
            iArr3 = j11;
        } else {
            iArr3 = iArr2;
        }
        l0.d(i16, this.f8671c, i11, i12, i13, i14, i15, iArr3);
        if (iArr4 != null) {
            this.f8671c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i18;
            iArr4[1] = iArr4[1] - i17;
        }
        return true;
    }

    public final ViewParent i(int i11) {
        if (i11 == 0) {
            return this.f8669a;
        }
        if (i11 != 1) {
            return null;
        }
        return this.f8670b;
    }

    public final int[] j() {
        if (this.f8673e == null) {
            this.f8673e = new int[2];
        }
        return this.f8673e;
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i11) {
        return i(i11) != null;
    }

    public boolean m() {
        return this.f8672d;
    }

    public void n(boolean z11) {
        if (this.f8672d) {
            h0.Y0(this.f8671c);
        }
        this.f8672d = z11;
    }

    public final void o(int i11, ViewParent viewParent) {
        if (i11 == 0) {
            this.f8669a = viewParent;
        } else if (i11 == 1) {
            this.f8670b = viewParent;
        }
    }

    public boolean p(int i11) {
        return q(i11, 0);
    }

    public boolean q(int i11, int i12) {
        if (l(i12)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f8671c;
        for (ViewParent parent = this.f8671c.getParent(); parent != null; parent = parent.getParent()) {
            if (l0.f(parent, view, this.f8671c, i11, i12)) {
                o(i12, parent);
                l0.e(parent, view, this.f8671c, i11, i12);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void r() {
        s(0);
    }

    public void s(int i11) {
        ViewParent i12 = i(i11);
        if (i12 != null) {
            l0.g(i12, this.f8671c, i11);
            o(i11, (ViewParent) null);
        }
    }
}
