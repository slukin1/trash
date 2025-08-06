package h10;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.z;
import kotlin.m;
import kotlin.o;
import kotlin.q;
import kotlin.r;
import kotlin.reflect.c;
import kotlin.t;
import kotlin.time.b;
import kotlin.u;
import kotlinx.serialization.b;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.c0;
import kotlinx.serialization.internal.c1;
import kotlinx.serialization.internal.c2;
import kotlinx.serialization.internal.d1;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.e2;
import kotlinx.serialization.internal.f2;
import kotlinx.serialization.internal.g;
import kotlinx.serialization.internal.h;
import kotlinx.serialization.internal.h2;
import kotlinx.serialization.internal.i2;
import kotlinx.serialization.internal.j;
import kotlinx.serialization.internal.j2;
import kotlinx.serialization.internal.k;
import kotlinx.serialization.internal.l0;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.o1;
import kotlinx.serialization.internal.p;
import kotlinx.serialization.internal.q;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.t0;
import kotlinx.serialization.internal.t1;
import kotlinx.serialization.internal.u1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.w0;
import kotlinx.serialization.internal.x;
import kotlinx.serialization.internal.x0;
import kotlinx.serialization.internal.y;
import kotlinx.serialization.internal.y1;
import kotlinx.serialization.internal.z1;

public final class a {
    public static final b<Boolean> A(l lVar) {
        return h.f57720a;
    }

    public static final b<Byte> B(m mVar) {
        return k.f57734a;
    }

    public static final b<Character> C(n nVar) {
        return q.f57759a;
    }

    public static final b<Double> D(s sVar) {
        return x.f57784a;
    }

    public static final b<Float> E(t tVar) {
        return c0.f57699a;
    }

    public static final b<Integer> F(w wVar) {
        return m0.f57742a;
    }

    public static final b<Long> G(z zVar) {
        return x0.f57786a;
    }

    public static final b<Short> H(b0 b0Var) {
        return u1.f57773a;
    }

    public static final b<String> I(d0 d0Var) {
        return v1.f57779a;
    }

    public static final b<kotlin.time.b> J(b.a aVar) {
        return y.f57790a;
    }

    public static final <T, E extends T> kotlinx.serialization.b<E[]> a(c<T> cVar, kotlinx.serialization.b<E> bVar) {
        return new o1(cVar, bVar);
    }

    public static final kotlinx.serialization.b<boolean[]> b() {
        return g.f57716c;
    }

    public static final kotlinx.serialization.b<byte[]> c() {
        return j.f57729c;
    }

    public static final kotlinx.serialization.b<char[]> d() {
        return p.f57753c;
    }

    public static final kotlinx.serialization.b<double[]> e() {
        return kotlinx.serialization.internal.w.f57781c;
    }

    public static final kotlinx.serialization.b<float[]> f() {
        return kotlinx.serialization.internal.b0.f57694c;
    }

    public static final kotlinx.serialization.b<int[]> g() {
        return l0.f57740c;
    }

    public static final <T> kotlinx.serialization.b<List<T>> h(kotlinx.serialization.b<T> bVar) {
        return new e(bVar);
    }

    public static final kotlinx.serialization.b<long[]> i() {
        return w0.f57782c;
    }

    public static final <K, V> kotlinx.serialization.b<Map.Entry<K, V>> j(kotlinx.serialization.b<K> bVar, kotlinx.serialization.b<V> bVar2) {
        return new MapEntrySerializer(bVar, bVar2);
    }

    public static final <K, V> kotlinx.serialization.b<Map<K, V>> k(kotlinx.serialization.b<K> bVar, kotlinx.serialization.b<V> bVar2) {
        return new r0(bVar, bVar2);
    }

    public static final kotlinx.serialization.b l() {
        return c1.f57701a;
    }

    public static final <K, V> kotlinx.serialization.b<Pair<K, V>> m(kotlinx.serialization.b<K> bVar, kotlinx.serialization.b<V> bVar2) {
        return new PairSerializer(bVar, bVar2);
    }

    public static final <T> kotlinx.serialization.b<Set<T>> n(kotlinx.serialization.b<T> bVar) {
        return new t0(bVar);
    }

    public static final kotlinx.serialization.b<short[]> o() {
        return t1.f57768c;
    }

    public static final <A, B, C> kotlinx.serialization.b<Triple<A, B, C>> p(kotlinx.serialization.b<A> bVar, kotlinx.serialization.b<B> bVar2, kotlinx.serialization.b<C> bVar3) {
        return new TripleSerializer(bVar, bVar2, bVar3);
    }

    public static final kotlinx.serialization.b<kotlin.n> q() {
        return y1.f57796c;
    }

    public static final kotlinx.serialization.b<kotlin.p> r() {
        return b2.f57698c;
    }

    public static final kotlinx.serialization.b<r> s() {
        return e2.f57710c;
    }

    public static final kotlinx.serialization.b<u> t() {
        return h2.f57723c;
    }

    public static final <T> kotlinx.serialization.b<T> u(kotlinx.serialization.b<T> bVar) {
        return bVar.getDescriptor().b() ? bVar : new d1(bVar);
    }

    public static final kotlinx.serialization.b<kotlin.m> v(m.a aVar) {
        return z1.f57805a;
    }

    public static final kotlinx.serialization.b<o> w(o.a aVar) {
        return c2.f57703a;
    }

    public static final kotlinx.serialization.b<kotlin.q> x(q.a aVar) {
        return f2.f57714a;
    }

    public static final kotlinx.serialization.b<kotlin.t> y(t.a aVar) {
        return i2.f57727a;
    }

    public static final kotlinx.serialization.b<Unit> z(Unit unit) {
        return j2.f57732b;
    }
}
