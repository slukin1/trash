package kotlin;

import kotlin.jvm.internal.r;
import kotlin.ranges.h;

public final class g implements Comparable<g> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f56690f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final g f56691g = h.a();

    /* renamed from: b  reason: collision with root package name */
    public final int f56692b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56693c;

    /* renamed from: d  reason: collision with root package name */
    public final int f56694d;

    /* renamed from: e  reason: collision with root package name */
    public final int f56695e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public g(int i11, int i12, int i13) {
        this.f56692b = i11;
        this.f56693c = i12;
        this.f56694d = i13;
        this.f56695e = b(i11, i12, i13);
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        return this.f56695e - gVar.f56695e;
    }

    public final int b(int i11, int i12, int i13) {
        boolean z11 = false;
        if (new h(0, 255).h(i11) && new h(0, 255).h(i12) && new h(0, 255).h(i13)) {
            z11 = true;
        }
        if (z11) {
            return (i11 << 16) + (i12 << 8) + i13;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i11 + '.' + i12 + '.' + i13).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        g gVar = obj instanceof g ? (g) obj : null;
        if (gVar == null) {
            return false;
        }
        if (this.f56695e == gVar.f56695e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f56695e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f56692b);
        sb2.append('.');
        sb2.append(this.f56693c);
        sb2.append('.');
        sb2.append(this.f56694d);
        return sb2.toString();
    }
}
