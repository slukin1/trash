package t0;

import android.graphics.Insets;
import android.graphics.Rect;

public final class d {

    /* renamed from: e  reason: collision with root package name */
    public static final d f16511e = new d(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f16512a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16513b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16514c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16515d;

    public static class a {
        public static Insets a(int i11, int i12, int i13, int i14) {
            return Insets.of(i11, i12, i13, i14);
        }
    }

    public d(int i11, int i12, int i13, int i14) {
        this.f16512a = i11;
        this.f16513b = i12;
        this.f16514c = i13;
        this.f16515d = i14;
    }

    public static d a(d dVar, d dVar2) {
        return b(Math.max(dVar.f16512a, dVar2.f16512a), Math.max(dVar.f16513b, dVar2.f16513b), Math.max(dVar.f16514c, dVar2.f16514c), Math.max(dVar.f16515d, dVar2.f16515d));
    }

    public static d b(int i11, int i12, int i13, int i14) {
        if (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) {
            return f16511e;
        }
        return new d(i11, i12, i13, i14);
    }

    public static d c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static d d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f16512a, this.f16513b, this.f16514c, this.f16515d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f16515d == dVar.f16515d && this.f16512a == dVar.f16512a && this.f16514c == dVar.f16514c && this.f16513b == dVar.f16513b;
    }

    public int hashCode() {
        return (((((this.f16512a * 31) + this.f16513b) * 31) + this.f16514c) * 31) + this.f16515d;
    }

    public String toString() {
        return "Insets{left=" + this.f16512a + ", top=" + this.f16513b + ", right=" + this.f16514c + ", bottom=" + this.f16515d + '}';
    }
}
