package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.k0;

public class LockFreeLinkedListNode {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57284b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57285c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57286d;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends AtomicOp<LockFreeLinkedListNode> {

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f57287b;

        /* renamed from: c  reason: collision with root package name */
        public LockFreeLinkedListNode f57288c;

        public a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f57287b = lockFreeLinkedListNode;
        }

        /* renamed from: e */
        public void b(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z11 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z11 ? this.f57287b : this.f57288c;
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f57284b, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z11) {
                this.f57287b.h(this.f57288c);
            }
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<LockFreeLinkedListNode> cls2 = LockFreeLinkedListNode.class;
        f57284b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f57285c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        f57286d = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    public final boolean e(LockFreeLinkedListNode lockFreeLinkedListNode) {
        f57285c.lazySet(lockFreeLinkedListNode, this);
        f57284b.lazySet(lockFreeLinkedListNode, this);
        while (i() == this) {
            if (androidx.concurrent.futures.a.a(f57284b, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.h(this);
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((kotlinx.coroutines.internal.w) r5).f57350a) != false) goto L_0x0045;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode f(kotlinx.coroutines.internal.OpDescriptor r9) {
        /*
            r8 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57285c
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x000a:
            r3 = r1
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f57284b
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L_0x0020
            if (r0 != r2) goto L_0x0016
            return r2
        L_0x0016:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f57285c
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L_0x001f
            goto L_0x0000
        L_0x001f:
            return r2
        L_0x0020:
            boolean r6 = r8.l()
            if (r6 == 0) goto L_0x0027
            return r1
        L_0x0027:
            if (r5 != r9) goto L_0x002a
            return r2
        L_0x002a:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r6 == 0) goto L_0x0034
            kotlinx.coroutines.internal.OpDescriptor r5 = (kotlinx.coroutines.internal.OpDescriptor) r5
            r5.a(r2)
            goto L_0x0000
        L_0x0034:
            boolean r6 = r5 instanceof kotlinx.coroutines.internal.w
            if (r6 == 0) goto L_0x0050
            if (r3 == 0) goto L_0x0047
            kotlinx.coroutines.internal.w r5 = (kotlinx.coroutines.internal.w) r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = r5.f57350a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L_0x0045
            goto L_0x0000
        L_0x0045:
            r2 = r3
            goto L_0x000a
        L_0x0047:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f57285c
            java.lang.Object r2 = r4.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x000b
        L_0x0050:
            r3 = r5
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.f(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final LockFreeLinkedListNode g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.l()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) f57285c.get(lockFreeLinkedListNode);
        }
        return lockFreeLinkedListNode;
    }

    public final void h(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57285c;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (i() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f57285c, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (l()) {
            lockFreeLinkedListNode.f((OpDescriptor) null);
        }
    }

    public final Object i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57284b;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode j() {
        return p.b(i());
    }

    public final LockFreeLinkedListNode k() {
        LockFreeLinkedListNode f11 = f((OpDescriptor) null);
        return f11 == null ? g((LockFreeLinkedListNode) f57285c.get(this)) : f11;
    }

    public boolean l() {
        return i() instanceof w;
    }

    public boolean m() {
        return n() == null;
    }

    public final LockFreeLinkedListNode n() {
        Object i11;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            i11 = i();
            if (i11 instanceof w) {
                return ((w) i11).f57350a;
            }
            if (i11 == this) {
                return (LockFreeLinkedListNode) i11;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) i11;
        } while (!androidx.concurrent.futures.a.a(f57284b, this, i11, lockFreeLinkedListNode.o()));
        lockFreeLinkedListNode.f((OpDescriptor) null);
        return null;
    }

    public final w o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57286d;
        w wVar = (w) atomicReferenceFieldUpdater.get(this);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this);
        atomicReferenceFieldUpdater.lazySet(this, wVar2);
        return wVar2;
    }

    public final int p(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
        f57285c.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57284b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.f57288c = lockFreeLinkedListNode2;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, aVar)) {
            return 0;
        }
        return aVar.a(this) == null ? 1 : 2;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + k0.b(this);
    }
}
