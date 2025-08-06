package kotlin.ranges;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f56832f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final c f56833g = new c(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public c(char c11, char c12) {
        super(c11, c12, 1);
    }

    public boolean d(char c11) {
        return x.c(a(), c11) <= 0 && x.c(c11, b()) <= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
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
        return (a() * 31) + b();
    }

    public boolean isEmpty() {
        return x.c(a(), b()) > 0;
    }

    public String toString() {
        return a() + ".." + b();
    }
}
