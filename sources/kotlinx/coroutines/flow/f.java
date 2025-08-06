package kotlinx.coroutines.flow;

import d10.l;
import d10.p;
import d10.q;
import d10.r;
import d10.s;
import d10.t;
import java.util.Collection;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.h0;

public final class f {
    public static final <T> Object A(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.b(dVar, cVar);
    }

    public static final <T> Object B(d<? extends T> dVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.c(dVar, pVar, cVar);
    }

    public static final <T> Object C(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.d(dVar, cVar);
    }

    public static final ReceiveChannel<Unit> D(h0 h0Var, long j11, long j12) {
        return FlowKt__DelayKt.c(h0Var, j11, j12);
    }

    public static final <T> d<T> F(p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return q.b(pVar);
    }

    public static final <T1, T2, R> d<R> G(d<? extends T1> dVar, d<? extends T2> dVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.g(dVar, dVar2, qVar);
    }

    public static final <T> d<T> H(T t11) {
        return q.c(t11);
    }

    public static final <T> d<T> I(d<? extends T> dVar, CoroutineContext coroutineContext) {
        return u.e(dVar, coroutineContext);
    }

    public static final <T> Object J(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.f(dVar, cVar);
    }

    public static final <T> Object K(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.g(dVar, cVar);
    }

    public static final <T, R> d<R> L(d<? extends T> dVar, p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(dVar, pVar);
    }

    public static final <T> d<T> M(Iterable<? extends d<? extends T>> iterable) {
        return FlowKt__MergeKt.b(iterable);
    }

    public static final <T> d<T> N(d<? extends T>... dVarArr) {
        return FlowKt__MergeKt.c(dVarArr);
    }

    public static final <T> d<T> O(d<? extends T> dVar, q<? super e<? super T>, ? super Throwable, ? super c<? super Unit>, ? extends Object> qVar) {
        return FlowKt__EmittersKt.d(dVar, qVar);
    }

    public static final <T> d<T> P(d<? extends T> dVar, p<? super T, ? super c<? super Unit>, ? extends Object> pVar) {
        return FlowKt__TransformKt.b(dVar, pVar);
    }

    public static final <T> d<T> Q(d<? extends T> dVar, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return FlowKt__EmittersKt.e(dVar, pVar);
    }

    public static final <T> f1<T> R(f1<? extends T> f1Var, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return FlowKt__ShareKt.f(f1Var, pVar);
    }

    public static final <T> ReceiveChannel<T> S(d<? extends T> dVar, h0 h0Var) {
        return FlowKt__ChannelsKt.d(dVar, h0Var);
    }

    public static final <T> d<T> T(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.e(receiveChannel);
    }

    public static final <S, T extends S> Object U(d<? extends T> dVar, q<? super S, ? super T, ? super c<? super S>, ? extends Object> qVar, c<? super S> cVar) {
        return FlowKt__ReduceKt.h(dVar, qVar, cVar);
    }

    public static final <T> f1<T> V(d<? extends T> dVar, h0 h0Var, i1 i1Var, int i11) {
        return FlowKt__ShareKt.g(dVar, h0Var, i1Var, i11);
    }

    public static final <T> Object X(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.i(dVar, cVar);
    }

    public static final <T> Object Y(d<? extends T> dVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.j(dVar, cVar);
    }

    public static final <T> Object Z(d<? extends T> dVar, h0 h0Var, c<? super j1<? extends T>> cVar) {
        return FlowKt__ShareKt.i(dVar, h0Var, cVar);
    }

    public static final <T> f1<T> a(a1<T> a1Var) {
        return FlowKt__ShareKt.a(a1Var);
    }

    public static final <T> j1<T> a0(d<? extends T> dVar, h0 h0Var, i1 i1Var, T t11) {
        return FlowKt__ShareKt.j(dVar, h0Var, i1Var, t11);
    }

    public static final <T> j1<T> b(b1<T> b1Var) {
        return FlowKt__ShareKt.b(b1Var);
    }

    public static final <T, C extends Collection<? super T>> Object b0(d<? extends T> dVar, C c11, c<? super C> cVar) {
        return FlowKt__CollectionKt.a(dVar, c11, cVar);
    }

    public static final <T> d<T> c(d<? extends T> dVar, int i11, BufferOverflow bufferOverflow) {
        return u.a(dVar, i11, bufferOverflow);
    }

    public static final <T, R> d<R> c0(d<? extends T> dVar, q<? super e<? super R>, ? super T, ? super c<? super Unit>, ? extends Object> qVar) {
        return FlowKt__MergeKt.d(dVar, qVar);
    }

    public static final <T> d<T> e(p<? super k<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return q.a(pVar);
    }

    public static final <T> d<T> f(d<? extends T> dVar, q<? super e<? super T>, ? super Throwable, ? super c<? super Unit>, ? extends Object> qVar) {
        return FlowKt__ErrorsKt.a(dVar, qVar);
    }

    public static final <T> Object g(d<? extends T> dVar, e<? super T> eVar, c<? super Throwable> cVar) {
        return FlowKt__ErrorsKt.b(dVar, eVar, cVar);
    }

    public static final Object h(d<?> dVar, c<? super Unit> cVar) {
        return t.a(dVar, cVar);
    }

    public static final <T> Object i(d<? extends T> dVar, p<? super T, ? super c<? super Unit>, ? extends Object> pVar, c<? super Unit> cVar) {
        return t.b(dVar, pVar, cVar);
    }

    public static final <T1, T2, R> d<R> j(d<? extends T1> dVar, d<? extends T2> dVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return FlowKt__ZipKt.b(dVar, dVar2, qVar);
    }

    public static final <T1, T2, T3, R> d<R> k(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, r<? super T1, ? super T2, ? super T3, ? super c<? super R>, ? extends Object> rVar) {
        return FlowKt__ZipKt.c(dVar, dVar2, dVar3, rVar);
    }

    public static final <T1, T2, T3, T4, R> d<R> l(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> sVar) {
        return FlowKt__ZipKt.d(dVar, dVar2, dVar3, dVar4, sVar);
    }

    public static final <T1, T2, T3, T4, T5, R> d<R> m(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super c<? super R>, ? extends Object> tVar) {
        return FlowKt__ZipKt.e(dVar, dVar2, dVar3, dVar4, dVar5, tVar);
    }

    public static final <T1, T2, T3, R> d<R> n(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, s<? super e<? super R>, ? super T1, ? super T2, ? super T3, ? super c<? super Unit>, ? extends Object> sVar) {
        return FlowKt__ZipKt.f(dVar, dVar2, dVar3, sVar);
    }

    public static final <T> d<T> o(d<? extends T> dVar) {
        return u.d(dVar);
    }

    public static final <T> Object p(d<? extends T> dVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar, c<? super Integer> cVar) {
        return FlowKt__CountKt.a(dVar, pVar, cVar);
    }

    public static final <T> Object q(d<? extends T> dVar, c<? super Integer> cVar) {
        return FlowKt__CountKt.b(dVar, cVar);
    }

    public static final <T> d<T> r(d<? extends T> dVar, l<? super T, Long> lVar) {
        return FlowKt__DelayKt.a(dVar, lVar);
    }

    public static final <T> d<T> s(d<? extends T> dVar) {
        return FlowKt__DistinctKt.a(dVar);
    }

    public static final <T> d<T> t(d<? extends T> dVar, p<? super T, ? super T, Boolean> pVar) {
        return FlowKt__DistinctKt.b(dVar, pVar);
    }

    public static final <T> d<T> u(d<? extends T> dVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return FlowKt__LimitKt.c(dVar, pVar);
    }

    public static final <T> Object v(e<? super T> eVar, ReceiveChannel<? extends T> receiveChannel, c<? super Unit> cVar) {
        return FlowKt__ChannelsKt.b(eVar, receiveChannel, cVar);
    }

    public static final <T> Object w(e<? super T> eVar, d<? extends T> dVar, c<? super Unit> cVar) {
        return t.c(eVar, dVar, cVar);
    }

    public static final void x(e<?> eVar) {
        FlowKt__EmittersKt.b(eVar);
    }

    public static final <T> d<T> y(d<? extends T> dVar) {
        return FlowKt__TransformKt.a(dVar);
    }

    public static final <T> Object z(d<? extends T> dVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar, c<? super T> cVar) {
        return FlowKt__ReduceKt.a(dVar, pVar, cVar);
    }
}
