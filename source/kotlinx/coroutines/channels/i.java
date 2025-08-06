package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.selects.k;

public class i<E> extends BufferedChannel<E> {

    /* renamed from: n  reason: collision with root package name */
    public final int f57051n;

    /* renamed from: o  reason: collision with root package name */
    public final BufferOverflow f57052o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i11, BufferOverflow bufferOverflow, l lVar, int i12, r rVar) {
        this(i11, bufferOverflow, (i12 & 4) != 0 ? null : lVar);
    }

    public static /* synthetic */ <E> Object g1(i<E> iVar, E e11, c<? super Unit> cVar) {
        UndeliveredElementException d11;
        Object k12 = iVar.k1(e11, true);
        if (!(k12 instanceof ChannelResult.a)) {
            return Unit.f56620a;
        }
        ChannelResult.e(k12);
        l<E, Unit> lVar = iVar.f57011c;
        if (lVar == null || (d11 = OnUndeliveredElementKt.d(lVar, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            throw iVar.Y();
        }
        ExceptionsKt__ExceptionsKt.a(d11, iVar.Y());
        throw d11;
    }

    public static /* synthetic */ <E> Object h1(i<E> iVar, E e11, c<? super Boolean> cVar) {
        Object k12 = iVar.k1(e11, true);
        if (k12 instanceof ChannelResult.Failed) {
            return a.a(false);
        }
        Unit unit = (Unit) k12;
        return a.a(true);
    }

    public void K0(k<?> kVar, Object obj) {
        Object q11 = q(obj);
        if (!(q11 instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) q11;
            kVar.d(Unit.f56620a);
        } else if (q11 instanceof ChannelResult.a) {
            ChannelResult.e(q11);
            kVar.d(BufferedChannelKt.z());
        } else {
            throw new IllegalStateException("unreachable".toString());
        }
    }

    public Object Q0(E e11, c<? super Boolean> cVar) {
        return h1(this, e11, cVar);
    }

    public boolean U0() {
        return false;
    }

    public final Object i1(E e11, boolean z11) {
        l<E, Unit> lVar;
        UndeliveredElementException d11;
        Object q11 = super.q(e11);
        if (ChannelResult.j(q11) || ChannelResult.h(q11)) {
            return q11;
        }
        if (!z11 || (lVar = this.f57011c) == null || (d11 = OnUndeliveredElementKt.d(lVar, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            return ChannelResult.f57037b.c(Unit.f56620a);
        }
        throw d11;
    }

    public boolean j0() {
        return this.f57052o == BufferOverflow.DROP_OLDEST;
    }

    public final Object j1(E e11) {
        g gVar;
        c0 c0Var = BufferedChannelKt.f57021d;
        g gVar2 = (g) BufferedChannel.f57005i.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f57001e.getAndIncrement(this);
            long j11 = andIncrement & 1152921504606846975L;
            boolean k11 = i0(andIncrement);
            int i11 = BufferedChannelKt.f57019b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (gVar2.f57353d != j12) {
                g c11 = T(j12, gVar2);
                if (c11 != null) {
                    gVar = c11;
                } else if (k11) {
                    return ChannelResult.f57037b.a(Y());
                }
            } else {
                gVar = gVar2;
            }
            int C = b1(gVar, i12, e11, j11, c0Var, k11);
            if (C == 0) {
                gVar.b();
                return ChannelResult.f57037b.c(Unit.f56620a);
            } else if (C == 1) {
                return ChannelResult.f57037b.c(Unit.f56620a);
            } else {
                if (C != 2) {
                    if (C == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (C != 4) {
                        if (C == 5) {
                            gVar.b();
                        }
                        gVar2 = gVar;
                    } else {
                        if (j11 < X()) {
                            gVar.b();
                        }
                        return ChannelResult.f57037b.a(Y());
                    }
                } else if (k11) {
                    gVar.p();
                    return ChannelResult.f57037b.a(Y());
                } else {
                    q2 q2Var = c0Var instanceof q2 ? (q2) c0Var : null;
                    if (q2Var != null) {
                        A0(q2Var, gVar, i12);
                    }
                    P((gVar.f57353d * ((long) i11)) + ((long) i12));
                    return ChannelResult.f57037b.c(Unit.f56620a);
                }
            }
        }
    }

    public final Object k1(E e11, boolean z11) {
        if (this.f57052o == BufferOverflow.DROP_LATEST) {
            return i1(e11, z11);
        }
        return j1(e11);
    }

    public Object q(E e11) {
        return k1(e11, false);
    }

    public Object send(E e11, c<? super Unit> cVar) {
        return g1(this, e11, cVar);
    }

    public i(int i11, BufferOverflow bufferOverflow, l<? super E, Unit> lVar) {
        super(i11, lVar);
        this.f57051n = i11;
        this.f57052o = bufferOverflow;
        boolean z11 = false;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (!(i11 >= 1 ? true : z11)) {
                throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i11 + " was specified").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.b(BufferedChannel.class).f() + " instead").toString());
    }
}
