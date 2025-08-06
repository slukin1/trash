package kotlinx.coroutines.channels;

import d10.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.selects.k;

public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements b<E> {

    /* renamed from: n  reason: collision with root package name */
    public final int f56994n;

    /* renamed from: o  reason: collision with root package name */
    public final ReentrantLock f56995o;

    /* renamed from: p  reason: collision with root package name */
    public List<? extends BufferedChannel<E>> f56996p;

    /* renamed from: q  reason: collision with root package name */
    public Object f56997q;

    /* renamed from: r  reason: collision with root package name */
    public final HashMap<k<?>, Object> f56998r;

    public final class a extends BufferedChannel<E> {
        public a() {
            super(BroadcastChannelImpl.this.j1(), (l) null, 2, (r) null);
        }

        /* renamed from: g1 */
        public boolean E(Throwable th2) {
            ReentrantLock g12 = BroadcastChannelImpl.this.f56995o;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            g12.lock();
            try {
                broadcastChannelImpl.l1(this);
                return super.E(th2);
            } finally {
                g12.unlock();
            }
        }
    }

    public final class b extends i<E> {
        public b() {
            super(1, BufferOverflow.DROP_OLDEST, (l) null, 4, (r) null);
        }

        /* renamed from: l1 */
        public boolean E(Throwable th2) {
            BroadcastChannelImpl.this.l1(this);
            return super.E(th2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl(int i11) {
        super(0, (l) null);
        boolean z11 = false;
        this.f56994n = i11;
        if ((i11 >= 1 || i11 == -1) ? true : z11) {
            this.f56995o = new ReentrantLock();
            this.f56996p = CollectionsKt__CollectionsKt.k();
            this.f56997q = c.f57044a;
            this.f56998r = new HashMap<>();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i11 + " was specified").toString());
    }

    public boolean E(Throwable th2) {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            for (BufferedChannel E : this.f56996p) {
                E.E(th2);
            }
            this.f56997q = c.f57044a;
            return super.E(th2);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean K(Throwable th2) {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            for (BufferedChannel K : this.f56996p) {
                K.K(th2);
            }
            List<? extends BufferedChannel<E>> list = this.f56996p;
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (((BufferedChannel) next).a0()) {
                    arrayList.add(next);
                }
            }
            this.f56996p = arrayList;
            return super.K(th2);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void K0(k<?> kVar, Object obj) {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            Object remove = this.f56998r.remove(kVar);
            if (remove != null) {
                kVar.d(remove);
                return;
            }
            Unit unit = Unit.f56620a;
            reentrantLock.unlock();
            n1 unused = i.d(i0.a(kVar.getContext()), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, kVar, (c<? super BroadcastChannelImpl$registerSelectForSend$2>) null), 1, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public ReceiveChannel<E> i() {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            BufferedChannel bVar = this.f56994n == -1 ? new b() : new a();
            if (!u() || this.f56997q != c.f57044a) {
                if (this.f56997q != c.f57044a) {
                    bVar.q(k1());
                }
                this.f56996p = CollectionsKt___CollectionsKt.r0(this.f56996p, bVar);
                reentrantLock.unlock();
                return bVar;
            }
            bVar.K(V());
            return bVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int j1() {
        return this.f56994n;
    }

    public final E k1() {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            if (u()) {
                Throwable V = V();
                if (V == null) {
                    V = new IllegalStateException("This broadcast channel is closed");
                }
                throw V;
            } else if (this.f56997q != c.f57044a) {
                return this.f56997q;
            } else {
                throw new IllegalStateException("No value".toString());
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void l1(ReceiveChannel<? extends E> receiveChannel) {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.f56996p;
            ArrayList arrayList = new ArrayList();
            for (T next : list) {
                if (((BufferedChannel) next) != receiveChannel) {
                    arrayList.add(next);
                }
            }
            this.f56996p = arrayList;
            Unit unit = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Object q(E e11) {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            if (u()) {
                return super.q(e11);
            }
            List<? extends BufferedChannel<E>> list = this.f56996p;
            boolean z11 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((BufferedChannel) it2.next()).U0()) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z11) {
                Object b11 = ChannelResult.f57037b.b();
                reentrantLock.unlock();
                return b11;
            }
            if (this.f56994n == -1) {
                this.f56997q = e11;
            }
            for (BufferedChannel q11 : this.f56996p) {
                q11.q(e11);
            }
            Object c11 = ChannelResult.f57037b.c(Unit.f56620a);
            reentrantLock.unlock();
            return c11;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object send(E r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.k.b(r8)
            goto L_0x007b
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            kotlin.k.b(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f56995o
            r8.lock()
            boolean r2 = r6.u()     // Catch:{ all -> 0x0099 }
            if (r2 != 0) goto L_0x0094
            int r2 = r6.f56994n     // Catch:{ all -> 0x0099 }
            r4 = -1
            if (r2 != r4) goto L_0x0050
            r6.f56997q = r7     // Catch:{ all -> 0x0099 }
        L_0x0050:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.f56996p     // Catch:{ all -> 0x0099 }
            r8.unlock()
            java.util.Iterator r8 = r2.iterator()
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x005d:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r2 = r2.Q0(r8, r0)
            if (r2 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r5 = r2
            r2 = r8
            r8 = r5
        L_0x007b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x008f
            boolean r8 = r4.u()
            if (r8 != 0) goto L_0x008a
            goto L_0x008f
        L_0x008a:
            java.lang.Throwable r7 = r4.Y()
            throw r7
        L_0x008f:
            r8 = r2
            goto L_0x005d
        L_0x0091:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        L_0x0094:
            java.lang.Throwable r7 = r6.Y()     // Catch:{ all -> 0x0099 }
            throw r7     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r7 = move-exception
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.send(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (this.f56997q != c.f57044a) {
            str = "CONFLATED_ELEMENT=" + this.f56997q + "; ";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append("BROADCAST=<");
        sb2.append(super.toString());
        sb2.append(">; SUBSCRIBERS=");
        sb2.append(CollectionsKt___CollectionsKt.k0(this.f56996p, ";", "<", ">", 0, (CharSequence) null, (l) null, 56, (Object) null));
        return sb2.toString();
    }

    public boolean u() {
        ReentrantLock reentrantLock = this.f56995o;
        reentrantLock.lock();
        try {
            return super.u();
        } finally {
            reentrantLock.unlock();
        }
    }
}
