package kotlin.ranges;

import kotlin.jvm.internal.r;

public final class k extends i {

    /* renamed from: f  reason: collision with root package name */
    public static final a f56854f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final k f56855g = new k(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public k(long j11, long j12) {
        super(j11, j12, 1);
    }

    public boolean d(long j11) {
        return a() <= j11 && j11 <= b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (!(a() == kVar.a() && b() == kVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
