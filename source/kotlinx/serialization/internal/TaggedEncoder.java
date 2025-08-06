package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.b;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.g;
import kotlinx.serialization.modules.e;

public abstract class TaggedEncoder<Tag> implements d, b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Tag> f57683a = new ArrayList<>();

    private final boolean H(f fVar, int i11) {
        c0(a0(fVar, i11));
        return true;
    }

    public final void A(long j11) {
        R(b0(), j11);
    }

    public void B() {
        T(b0());
    }

    public final void C(f fVar, int i11, float f11) {
        O(a0(fVar, i11), f11);
    }

    public final void D(char c11) {
        L(b0(), c11);
    }

    public void E() {
        S(Y());
    }

    public <T> void F(f fVar, int i11, g<? super T> gVar, T t11) {
        if (H(fVar, i11)) {
            e(gVar, t11);
        }
    }

    public final void G(f fVar, int i11, double d11) {
        M(a0(fVar, i11), d11);
    }

    public <T> void I(g<? super T> gVar, T t11) {
        d.a.c(this, gVar, t11);
    }

    public void J(Tag tag, boolean z11) {
        W(tag, Boolean.valueOf(z11));
    }

    public void K(Tag tag, byte b11) {
        W(tag, Byte.valueOf(b11));
    }

    public void L(Tag tag, char c11) {
        W(tag, Character.valueOf(c11));
    }

    public void M(Tag tag, double d11) {
        W(tag, Double.valueOf(d11));
    }

    public void N(Tag tag, f fVar, int i11) {
        W(tag, Integer.valueOf(i11));
    }

    public void O(Tag tag, float f11) {
        W(tag, Float.valueOf(f11));
    }

    public d P(Tag tag, f fVar) {
        c0(tag);
        return this;
    }

    public void Q(Tag tag, int i11) {
        W(tag, Integer.valueOf(i11));
    }

    public void R(Tag tag, long j11) {
        W(tag, Long.valueOf(j11));
    }

    public void S(Tag tag) {
    }

    public void T(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    public void U(Tag tag, short s11) {
        W(tag, Short.valueOf(s11));
    }

    public void V(Tag tag, String str) {
        W(tag, str);
    }

    public void W(Tag tag, Object obj) {
        throw new SerializationException("Non-serializable " + Reflection.b(obj.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    public void X(f fVar) {
    }

    public final Tag Y() {
        return CollectionsKt___CollectionsKt.m0(this.f57683a);
    }

    public final Tag Z() {
        return CollectionsKt___CollectionsKt.n0(this.f57683a);
    }

    public kotlinx.serialization.modules.d a() {
        return e.a();
    }

    public abstract Tag a0(f fVar, int i11);

    public b b(f fVar) {
        return this;
    }

    public final Tag b0() {
        if (!this.f57683a.isEmpty()) {
            ArrayList<Tag> arrayList = this.f57683a;
            return arrayList.remove(CollectionsKt__CollectionsKt.m(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }

    public final void c(f fVar) {
        if (!this.f57683a.isEmpty()) {
            b0();
        }
        X(fVar);
    }

    public final void c0(Tag tag) {
        this.f57683a.add(tag);
    }

    public <T> void e(g<? super T> gVar, T t11) {
        d.a.d(this, gVar, t11);
    }

    public final void f(byte b11) {
        K(b0(), b11);
    }

    public final void g(f fVar, int i11) {
        N(b0(), fVar, i11);
    }

    public final d h(f fVar) {
        return P(b0(), fVar);
    }

    public final void i(f fVar, int i11, char c11) {
        L(a0(fVar, i11), c11);
    }

    public final void j(f fVar, int i11, byte b11) {
        K(a0(fVar, i11), b11);
    }

    public final void k(short s11) {
        U(b0(), s11);
    }

    public final void l(boolean z11) {
        J(b0(), z11);
    }

    public final void m(float f11) {
        O(b0(), f11);
    }

    public final void n(f fVar, int i11, int i12) {
        Q(a0(fVar, i11), i12);
    }

    public final void o(f fVar, int i11, boolean z11) {
        J(a0(fVar, i11), z11);
    }

    public final void p(f fVar, int i11, String str) {
        V(a0(fVar, i11), str);
    }

    public boolean q(f fVar, int i11) {
        return b.a.a(this, fVar, i11);
    }

    public final void s(int i11) {
        Q(b0(), i11);
    }

    public final void t(f fVar, int i11, short s11) {
        U(a0(fVar, i11), s11);
    }

    public final void u(f fVar, int i11, long j11) {
        R(a0(fVar, i11), j11);
    }

    public final void v(String str) {
        V(b0(), str);
    }

    public final d w(f fVar, int i11) {
        return P(a0(fVar, i11), fVar.d(i11));
    }

    public final void x(double d11) {
        M(b0(), d11);
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
