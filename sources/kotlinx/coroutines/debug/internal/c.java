package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.n1;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f57098a;

    /* renamed from: b  reason: collision with root package name */
    public static final StackTraceElement f57099b = new ArtificialStackFrames().b();

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f57100c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentWeakMap<a<?>, Boolean> f57101d = new ConcurrentWeakMap<>(false, 1, (r) null);

    /* renamed from: e  reason: collision with root package name */
    public static boolean f57102e = true;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f57103f = true;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f57104g = true;

    /* renamed from: h  reason: collision with root package name */
    public static final l<Boolean, Unit> f57105h;

    /* renamed from: i  reason: collision with root package name */
    public static final ConcurrentWeakMap<kotlin.coroutines.jvm.internal.c, DebugCoroutineInfoImpl> f57106i = new ConcurrentWeakMap<>(true);

    /* renamed from: j  reason: collision with root package name */
    public static final b f57107j = new b((r) null);

    /* renamed from: k  reason: collision with root package name */
    public static final C0667c f57108k = new C0667c((r) null);

    public static final class a<T> implements kotlin.coroutines.c<T>, kotlin.coroutines.jvm.internal.c {

        /* renamed from: b  reason: collision with root package name */
        public final kotlin.coroutines.c<T> f57109b;

        /* renamed from: c  reason: collision with root package name */
        public final DebugCoroutineInfoImpl f57110c;

        public final f b() {
            return this.f57110c.d();
        }

        public kotlin.coroutines.jvm.internal.c getCallerFrame() {
            b();
            return null;
        }

        public CoroutineContext getContext() {
            return this.f57109b.getContext();
        }

        public StackTraceElement getStackTraceElement() {
            b();
            return null;
        }

        public void resumeWith(Object obj) {
            c.f57098a.f(this);
            this.f57109b.resumeWith(obj);
        }

        public String toString() {
            return this.f57109b.toString();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f57111a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");
        private volatile int installations;

        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    /* renamed from: kotlinx.coroutines.debug.internal.c$c  reason: collision with other inner class name */
    public static final class C0667c {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicLongFieldUpdater f57112a = AtomicLongFieldUpdater.newUpdater(C0667c.class, "sequenceNumber");
        private volatile long sequenceNumber;

        public C0667c() {
        }

        public /* synthetic */ C0667c(r rVar) {
            this();
        }
    }

    static {
        c cVar = new c();
        f57098a = cVar;
        f57105h = cVar.d();
    }

    public final l<Boolean, Unit> d() {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl((l) TypeIntrinsics.e(Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]), 1));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        if (Result.m3078isFailureimpl(obj)) {
            obj = null;
        }
        return (l) obj;
    }

    public final boolean e(a<?> aVar) {
        n1 n1Var;
        CoroutineContext c11 = aVar.f57110c.c();
        if (c11 == null || (n1Var = (n1) c11.get(n1.f57382r0)) == null || !n1Var.a()) {
            return false;
        }
        f57101d.remove(aVar);
        return true;
    }

    public final void f(a<?> aVar) {
        kotlin.coroutines.jvm.internal.c g11;
        f57101d.remove(aVar);
        kotlin.coroutines.jvm.internal.c f11 = aVar.f57110c.f();
        if (f11 != null && (g11 = g(f11)) != null) {
            f57106i.remove(g11);
        }
    }

    public final kotlin.coroutines.jvm.internal.c g(kotlin.coroutines.jvm.internal.c cVar) {
        do {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return null;
            }
        } while (cVar.getStackTraceElement() == null);
        return cVar;
    }
}
