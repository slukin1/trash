package kotlin.ranges;

import kotlin.jvm.internal.r;

public final class h extends f {

    /* renamed from: f  reason: collision with root package name */
    public static final a f56844f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final h f56845g = new h(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final h a() {
            return h.f56845g;
        }
    }

    public h(int i11, int i12) {
        super(i11, i12, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!(a() == hVar.a() && b() == hVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean h(int i11) {
        return a() <= i11 && i11 <= b();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public Integer i() {
        return Integer.valueOf(b());
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public Integer j() {
        return Integer.valueOf(a());
    }

    public String toString() {
        return a() + ".." + b();
    }
}
