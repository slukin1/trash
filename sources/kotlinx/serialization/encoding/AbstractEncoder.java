package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.b;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.g;
import kotlinx.serialization.internal.a1;

public abstract class AbstractEncoder implements d, b {
    public void A(long j11) {
        J(Long.valueOf(j11));
    }

    public void B() {
        throw new SerializationException("'null' is not supported by default");
    }

    public final void C(f fVar, int i11, float f11) {
        if (H(fVar, i11)) {
            m(f11);
        }
    }

    public void D(char c11) {
        J(Character.valueOf(c11));
    }

    public void E() {
        d.a.b(this);
    }

    public <T> void F(f fVar, int i11, g<? super T> gVar, T t11) {
        if (H(fVar, i11)) {
            e(gVar, t11);
        }
    }

    public final void G(f fVar, int i11, double d11) {
        if (H(fVar, i11)) {
            x(d11);
        }
    }

    public boolean H(f fVar, int i11) {
        return true;
    }

    public <T> void I(g<? super T> gVar, T t11) {
        d.a.c(this, gVar, t11);
    }

    public void J(Object obj) {
        throw new SerializationException("Non-serializable " + Reflection.b(obj.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    public b b(f fVar) {
        return this;
    }

    public void c(f fVar) {
    }

    public <T> void e(g<? super T> gVar, T t11) {
        d.a.d(this, gVar, t11);
    }

    public void f(byte b11) {
        J(Byte.valueOf(b11));
    }

    public void g(f fVar, int i11) {
        J(Integer.valueOf(i11));
    }

    public d h(f fVar) {
        return this;
    }

    public final void i(f fVar, int i11, char c11) {
        if (H(fVar, i11)) {
            D(c11);
        }
    }

    public final void j(f fVar, int i11, byte b11) {
        if (H(fVar, i11)) {
            f(b11);
        }
    }

    public void k(short s11) {
        J(Short.valueOf(s11));
    }

    public void l(boolean z11) {
        J(Boolean.valueOf(z11));
    }

    public void m(float f11) {
        J(Float.valueOf(f11));
    }

    public final void n(f fVar, int i11, int i12) {
        if (H(fVar, i11)) {
            s(i12);
        }
    }

    public final void o(f fVar, int i11, boolean z11) {
        if (H(fVar, i11)) {
            l(z11);
        }
    }

    public final void p(f fVar, int i11, String str) {
        if (H(fVar, i11)) {
            v(str);
        }
    }

    public boolean q(f fVar, int i11) {
        return b.a.a(this, fVar, i11);
    }

    public void s(int i11) {
        J(Integer.valueOf(i11));
    }

    public final void t(f fVar, int i11, short s11) {
        if (H(fVar, i11)) {
            k(s11);
        }
    }

    public final void u(f fVar, int i11, long j11) {
        if (H(fVar, i11)) {
            A(j11);
        }
    }

    public void v(String str) {
        J(str);
    }

    public final d w(f fVar, int i11) {
        return H(fVar, i11) ? h(fVar.d(i11)) : a1.f57690a;
    }

    public void x(double d11) {
        J(Double.valueOf(d11));
    }

    public <T> void y(f fVar, int i11, g<? super T> gVar, T t11) {
        if (H(fVar, i11)) {
            I(gVar, t11);
        }
    }

    public b z(f fVar, int i11) {
        return d.a.a(this, fVar, i11);
    }
}
