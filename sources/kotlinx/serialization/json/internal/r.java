package kotlinx.serialization.json.internal;

import kotlin.m;
import kotlin.o;
import kotlin.q;
import kotlin.t;

public final class r extends j {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57935c;

    public r(g0 g0Var, boolean z11) {
        super(g0Var);
        this.f57935c = z11;
    }

    public void d(byte b11) {
        boolean z11 = this.f57935c;
        String f11 = m.f(m.b(b11));
        if (z11) {
            m(f11);
        } else {
            j(f11);
        }
    }

    public void h(int i11) {
        boolean z11 = this.f57935c;
        int b11 = o.b(i11);
        if (z11) {
            m(Long.toString(((long) b11) & 4294967295L, 10));
        } else {
            j(Long.toString(((long) b11) & 4294967295L, 10));
        }
    }

    public void i(long j11) {
        boolean z11 = this.f57935c;
        long b11 = q.b(j11);
        if (z11) {
            m(p.a(b11, 10));
        } else {
            j(q.a(b11, 10));
        }
    }

    public void k(short s11) {
        boolean z11 = this.f57935c;
        String f11 = t.f(t.b(s11));
        if (z11) {
            m(f11);
        } else {
            j(f11);
        }
    }
}
