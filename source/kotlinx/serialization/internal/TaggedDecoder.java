package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.e;

public abstract class TaggedDecoder<Tag> implements c, a {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Tag> f57681a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f57682b;

    public final boolean A() {
        return J(Y());
    }

    public final byte B(f fVar, int i11) {
        return K(X(fVar, i11));
    }

    public final boolean C(f fVar, int i11) {
        return J(X(fVar, i11));
    }

    public boolean D() {
        Object W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    public final short E(f fVar, int i11) {
        return T(X(fVar, i11));
    }

    public final double F(f fVar, int i11) {
        return M(X(fVar, i11));
    }

    public <T> T G(kotlinx.serialization.a<? extends T> aVar) {
        return c.a.a(this, aVar);
    }

    public final byte H() {
        return K(Y());
    }

    public <T> T I(kotlinx.serialization.a<? extends T> aVar, T t11) {
        return G(aVar);
    }

    public boolean J(Tag tag) {
        return ((Boolean) V(tag)).booleanValue();
    }

    public byte K(Tag tag) {
        return ((Byte) V(tag)).byteValue();
    }

    public char L(Tag tag) {
        return ((Character) V(tag)).charValue();
    }

    public double M(Tag tag) {
        return ((Double) V(tag)).doubleValue();
    }

    public int N(Tag tag, f fVar) {
        return ((Integer) V(tag)).intValue();
    }

    public float O(Tag tag) {
        return ((Float) V(tag)).floatValue();
    }

    public c P(Tag tag, f fVar) {
        Z(tag);
        return this;
    }

    public int Q(Tag tag) {
        return ((Integer) V(tag)).intValue();
    }

    public long R(Tag tag) {
        return ((Long) V(tag)).longValue();
    }

    public boolean S(Tag tag) {
        return true;
    }

    public short T(Tag tag) {
        return ((Short) V(tag)).shortValue();
    }

    public String U(Tag tag) {
        return (String) V(tag);
    }

    public Object V(Tag tag) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    public final Tag W() {
        return CollectionsKt___CollectionsKt.n0(this.f57681a);
    }

    public abstract Tag X(f fVar, int i11);

    public final Tag Y() {
        ArrayList<Tag> arrayList = this.f57681a;
        Tag remove = arrayList.remove(CollectionsKt__CollectionsKt.m(arrayList));
        this.f57682b = true;
        return remove;
    }

    public final void Z(Tag tag) {
        this.f57681a.add(tag);
    }

    public d a() {
        return e.a();
    }

    public final <E> E a0(Tag tag, d10.a<? extends E> aVar) {
        Z(tag);
        E invoke = aVar.invoke();
        if (!this.f57682b) {
            Y();
        }
        this.f57682b = false;
        return invoke;
    }

    public a b(f fVar) {
        return this;
    }

    public void c(f fVar) {
    }

    public final long e(f fVar, int i11) {
        return R(X(fVar, i11));
    }

    public final int f(f fVar, int i11) {
        return Q(X(fVar, i11));
    }

    public final Void g() {
        return null;
    }

    public final long h() {
        return R(Y());
    }

    public final String i(f fVar, int i11) {
        return U(X(fVar, i11));
    }

    public final <T> T j(f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11) {
        return a0(X(fVar, i11), new TaggedDecoder$decodeNullableSerializableElement$1(this, aVar, t11));
    }

    public boolean k() {
        return a.C0670a.b(this);
    }

    public final c l(f fVar, int i11) {
        return P(X(fVar, i11), fVar.d(i11));
    }

    public final short m() {
        return T(Y());
    }

    public final double n() {
        return M(Y());
    }

    public final char o() {
        return L(Y());
    }

    public final <T> T p(f fVar, int i11, kotlinx.serialization.a<? extends T> aVar, T t11) {
        return a0(X(fVar, i11), new TaggedDecoder$decodeSerializableElement$1(this, aVar, t11));
    }

    public final String q() {
        return U(Y());
    }

    public final char r(f fVar, int i11) {
        return L(X(fVar, i11));
    }

    public final int s(f fVar) {
        return N(Y(), fVar);
    }

    public final int u() {
        return Q(Y());
    }

    public int v(f fVar) {
        return a.C0670a.a(this, fVar);
    }

    public final c x(f fVar) {
        return P(Y(), fVar);
    }

    public final float y() {
        return O(Y());
    }

    public final float z(f fVar, int i11) {
        return O(X(fVar, i11));
    }
}
