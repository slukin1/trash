package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.a;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;

public abstract class AbstractDecoder implements c, a {
    public boolean A() {
        return ((Boolean) J()).booleanValue();
    }

    public final byte B(f fVar, int i11) {
        return H();
    }

    public final boolean C(f fVar, int i11) {
        return A();
    }

    public boolean D() {
        return true;
    }

    public final short E(f fVar, int i11) {
        return m();
    }

    public final double F(f fVar, int i11) {
        return n();
    }

    public <T> T G(a<? extends T> aVar) {
        return c.a.a(this, aVar);
    }

    public byte H() {
        return ((Byte) J()).byteValue();
    }

    public <T> T I(a<? extends T> aVar, T t11) {
        return G(aVar);
    }

    public Object J() {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    public a b(f fVar) {
        return this;
    }

    public void c(f fVar) {
    }

    public final long e(f fVar, int i11) {
        return h();
    }

    public final int f(f fVar, int i11) {
        return u();
    }

    public Void g() {
        return null;
    }

    public long h() {
        return ((Long) J()).longValue();
    }

    public final String i(f fVar, int i11) {
        return q();
    }

    public final <T> T j(f fVar, int i11, a<? extends T> aVar, T t11) {
        return (aVar.getDescriptor().b() || D()) ? I(aVar, t11) : g();
    }

    public boolean k() {
        return a.C0670a.b(this);
    }

    public c l(f fVar, int i11) {
        return x(fVar.d(i11));
    }

    public short m() {
        return ((Short) J()).shortValue();
    }

    public double n() {
        return ((Double) J()).doubleValue();
    }

    public char o() {
        return ((Character) J()).charValue();
    }

    public <T> T p(f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11) {
        return I(aVar, t11);
    }

    public String q() {
        return (String) J();
    }

    public final char r(f fVar, int i11) {
        return o();
    }

    public int s(f fVar) {
        return ((Integer) J()).intValue();
    }

    public int u() {
        return ((Integer) J()).intValue();
    }

    public int v(f fVar) {
        return a.C0670a.a(this, fVar);
    }

    public c x(f fVar) {
        return this;
    }

    public float y() {
        return ((Float) J()).floatValue();
    }

    public final float z(f fVar, int i11) {
        return y();
    }
}
