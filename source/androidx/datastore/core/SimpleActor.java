package androidx.datastore.core;

import d10.l;
import d10.p;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bh\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0013\u0012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0016\u0012\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/datastore/core/SimpleActor;", "T", "", "msg", "", "e", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/h0;", "a", "Lkotlinx/coroutines/h0;", "scope", "Lkotlinx/coroutines/channels/d;", "c", "Lkotlinx/coroutines/channels/d;", "messageQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingMessages", "Lkotlin/Function1;", "", "onComplete", "Lkotlin/Function2;", "onUndeliveredElement", "Lkotlin/coroutines/c;", "consumeMessage", "<init>", "(Lkotlinx/coroutines/h0;Ld10/l;Ld10/p;Ld10/p;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SimpleActor<T> {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f8917a;

    /* renamed from: b  reason: collision with root package name */
    public final p<T, c<? super Unit>, Object> f8918b;

    /* renamed from: c  reason: collision with root package name */
    public final d<T> f8919c = f.b(Integer.MAX_VALUE, (BufferOverflow) null, (l) null, 6, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f8920d = new AtomicInteger(0);

    public SimpleActor(h0 h0Var, final l<? super Throwable, Unit> lVar, final p<? super T, ? super Throwable, Unit> pVar, p<? super T, ? super c<? super Unit>, ? extends Object> pVar2) {
        this.f8917a = h0Var;
        this.f8918b = pVar2;
        n1 n1Var = (n1) h0Var.getCoroutineContext().get(n1.f57382r0);
        if (n1Var != null) {
            n1Var.L(new l<Throwable, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f56620a;
                }

                public final void invoke(Throwable th2) {
                    Unit unit;
                    lVar.invoke(th2);
                    this.f8919c.K(th2);
                    do {
                        Object f11 = ChannelResult.f(this.f8919c.s());
                        if (f11 == null) {
                            unit = null;
                            continue;
                        } else {
                            pVar.invoke(f11, th2);
                            unit = Unit.f56620a;
                            continue;
                        }
                    } while (unit != null);
                }
            });
        }
    }

    public final void e(T t11) {
        Object q11 = this.f8919c.q(t11);
        if (q11 instanceof ChannelResult.a) {
            Throwable e11 = ChannelResult.e(q11);
            if (e11 == null) {
                e11 = new ClosedSendChannelException("Channel was closed normally");
            }
            throw e11;
        } else if (!ChannelResult.j(q11)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.f8920d.getAndIncrement() == 0) {
            n1 unused = i.d(this.f8917a, (CoroutineContext) null, (CoroutineStart) null, new SimpleActor$offer$2(this, (c<? super SimpleActor$offer$2>) null), 3, (Object) null);
        }
    }
}
