package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0003\n\u000b\u001fB\u0013\b\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Landroidx/window/layout/l;", "Landroidx/window/layout/n;", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/s;", "callback", "", "a", "b", "", "i", "f", "Landroidx/window/layout/g;", "Landroidx/window/layout/g;", "g", "()Landroidx/window/layout/g;", "setWindowExtension", "(Landroidx/window/layout/g;)V", "windowExtension", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/l$c;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "h", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getWindowLayoutChangeCallbacks$annotations", "()V", "windowLayoutChangeCallbacks", "<init>", "c", "window_release"}, k = 1, mv = {1, 6, 0})
public final class l implements n {

    /* renamed from: c  reason: collision with root package name */
    public static final a f12139c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static volatile l f12140d;

    /* renamed from: e  reason: collision with root package name */
    public static final ReentrantLock f12141e = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    public g f12142a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f12143b = new CopyOnWriteArrayList<>();

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\f\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/window/layout/l$a;", "", "Landroid/content/Context;", "context", "Landroidx/window/layout/l;", "a", "Landroidx/window/layout/g;", "b", "Landroidx/window/core/Version;", "sidecarVersion", "", "c", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "globalInstance", "Landroidx/window/layout/l;", "Ljava/util/concurrent/locks/ReentrantLock;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final l a(Context context) {
            if (l.f12140d == null) {
                ReentrantLock d11 = l.f12141e;
                d11.lock();
                try {
                    if (l.f12140d == null) {
                        l.f12140d = new l(l.f12139c.b(context));
                    }
                    Unit unit = Unit.f56620a;
                } finally {
                    d11.unlock();
                }
            }
            return l.f12140d;
        }

        public final g b(Context context) {
            try {
                if (!c(SidecarCompat.f12083f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (!sidecarCompat.l()) {
                    return null;
                }
                return sidecarCompat;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f12043g.a()) >= 0;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¨\u0006\n"}, d2 = {"Landroidx/window/layout/l$b;", "Landroidx/window/layout/g$a;", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/s;", "newLayout", "", "a", "<init>", "(Landroidx/window/layout/l;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public final class b implements g.a {
        public b() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void a(Activity activity, s sVar) {
            Iterator<c> it2 = l.this.h().iterator();
            while (it2.hasNext()) {
                c next = it2.next();
                if (x.b(next.d(), activity)) {
                    next.b(sVar);
                }
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Landroidx/window/layout/l$c;", "", "Landroidx/window/layout/s;", "newLayoutInfo", "", "b", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "d", "()Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/core/util/Consumer;", "c", "Landroidx/core/util/Consumer;", "e", "()Landroidx/core/util/Consumer;", "callback", "Landroidx/window/layout/s;", "f", "()Landroidx/window/layout/s;", "setLastInfo", "(Landroidx/window/layout/s;)V", "lastInfo", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f12145a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f12146b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<s> f12147c;

        /* renamed from: d  reason: collision with root package name */
        public s f12148d;

        public c(Activity activity, Executor executor, Consumer<s> consumer) {
            this.f12145a = activity;
            this.f12146b = executor;
            this.f12147c = consumer;
        }

        public static final void c(c cVar, s sVar) {
            cVar.f12147c.accept(sVar);
        }

        public final void b(s sVar) {
            this.f12148d = sVar;
            this.f12146b.execute(new m(this, sVar));
        }

        public final Activity d() {
            return this.f12145a;
        }

        public final Consumer<s> e() {
            return this.f12147c;
        }

        public final s f() {
            return this.f12148d;
        }
    }

    public l(g gVar) {
        this.f12142a = gVar;
        g gVar2 = this.f12142a;
        if (gVar2 != null) {
            gVar2.a(new b());
        }
    }

    public void a(Activity activity, Executor executor, Consumer<s> consumer) {
        s sVar;
        T t11;
        ReentrantLock reentrantLock = f12141e;
        reentrantLock.lock();
        try {
            g g11 = g();
            if (g11 == null) {
                consumer.accept(new s(CollectionsKt__CollectionsKt.k()));
                return;
            }
            boolean i11 = i(activity);
            c cVar = new c(activity, executor, consumer);
            h().add(cVar);
            if (!i11) {
                g11.b(activity);
            } else {
                Iterator<T> it2 = h().iterator();
                while (true) {
                    sVar = null;
                    if (!it2.hasNext()) {
                        t11 = null;
                        break;
                    }
                    t11 = it2.next();
                    if (x.b(activity, ((c) t11).d())) {
                        break;
                    }
                }
                c cVar2 = (c) t11;
                if (cVar2 != null) {
                    sVar = cVar2.f();
                }
                if (sVar != null) {
                    cVar.b(sVar);
                }
            }
            Unit unit = Unit.f56620a;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(Consumer<s> consumer) {
        synchronized (f12141e) {
            if (g() != null) {
                ArrayList<c> arrayList = new ArrayList<>();
                Iterator<c> it2 = h().iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (next.e() == consumer) {
                        arrayList.add(next);
                    }
                }
                h().removeAll(arrayList);
                for (c d11 : arrayList) {
                    f(d11.d());
                }
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final void f(Activity activity) {
        g gVar;
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f12143b;
        boolean z11 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it2 = copyOnWriteArrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (x.b(((c) it2.next()).d(), activity)) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!z11 && (gVar = this.f12142a) != null) {
            gVar.c(activity);
        }
    }

    public final g g() {
        return this.f12142a;
    }

    public final CopyOnWriteArrayList<c> h() {
        return this.f12143b;
    }

    public final boolean i(Activity activity) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f12143b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (c d11 : copyOnWriteArrayList) {
            if (x.b(d11.d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
