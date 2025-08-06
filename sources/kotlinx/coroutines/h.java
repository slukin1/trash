package kotlinx.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;

public final /* synthetic */ class h {
    public static final <T> T a(CoroutineContext coroutineContext, p<? super h0, ? super c<? super T>, ? extends Object> pVar) throws InterruptedException {
        CoroutineContext coroutineContext2;
        EventLoop eventLoop;
        Thread currentThread = Thread.currentThread();
        d dVar = (d) coroutineContext.get(d.f56672p0);
        if (dVar == null) {
            eventLoop = g2.f57278a.b();
            coroutineContext2 = CoroutineContextKt.e(g1.f57277b, coroutineContext.plus(eventLoop));
        } else {
            EventLoop eventLoop2 = null;
            EventLoop eventLoop3 = dVar instanceof EventLoop ? (EventLoop) dVar : null;
            if (eventLoop3 != null) {
                if (eventLoop3.T()) {
                    eventLoop2 = eventLoop3;
                }
                if (eventLoop2 != null) {
                    eventLoop = eventLoop2;
                    coroutineContext2 = CoroutineContextKt.e(g1.f57277b, coroutineContext);
                }
            }
            eventLoop = g2.f57278a.a();
            coroutineContext2 = CoroutineContextKt.e(g1.f57277b, coroutineContext);
        }
        e eVar = new e(coroutineContext2, currentThread, eventLoop);
        eVar.e1(CoroutineStart.DEFAULT, eVar, pVar);
        return eVar.f1();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, p pVar, int i11, Object obj) throws InterruptedException {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return g.e(coroutineContext, pVar);
    }
}
