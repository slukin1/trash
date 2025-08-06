package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.k1;

public class LifecycleRegistry extends Lifecycle {

    /* renamed from: k  reason: collision with root package name */
    public static final a f9903k = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final boolean f9904b;

    /* renamed from: c  reason: collision with root package name */
    public FastSafeIterableMap<u, b> f9905c;

    /* renamed from: d  reason: collision with root package name */
    public Lifecycle.State f9906d;

    /* renamed from: e  reason: collision with root package name */
    public final WeakReference<LifecycleOwner> f9907e;

    /* renamed from: f  reason: collision with root package name */
    public int f9908f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9909g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9910h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Lifecycle.State> f9911i;

    /* renamed from: j  reason: collision with root package name */
    public final b1<Lifecycle.State> f9912j;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Lifecycle.State f9913a;

        /* renamed from: b  reason: collision with root package name */
        public r f9914b;

        public b(u uVar, Lifecycle.State state) {
            this.f9914b = x.f(uVar);
            this.f9913a = state;
        }

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.f9913a = LifecycleRegistry.f9903k.a(this.f9913a, targetState);
            this.f9914b.onStateChanged(lifecycleOwner, event);
            this.f9913a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f9913a;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z11) {
        this.f9904b = z11;
        this.f9905c = new FastSafeIterableMap<>();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.f9906d = state;
        this.f9911i = new ArrayList<>();
        this.f9907e = new WeakReference<>(lifecycleOwner);
        this.f9912j = k1.a(state);
    }

    public void a(u uVar) {
        LifecycleOwner lifecycleOwner;
        g("addObserver");
        Lifecycle.State state = this.f9906d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(uVar, state2);
        if (this.f9905c.g(uVar, bVar) == null && (lifecycleOwner = (LifecycleOwner) this.f9907e.get()) != null) {
            boolean z11 = this.f9908f != 0 || this.f9909g;
            Lifecycle.State f11 = f(uVar);
            this.f9908f++;
            while (bVar.b().compareTo(f11) < 0 && this.f9905c.contains(uVar)) {
                n(bVar.b());
                Lifecycle.Event c11 = Lifecycle.Event.Companion.c(bVar.b());
                if (c11 != null) {
                    bVar.a(lifecycleOwner, c11);
                    m();
                    f11 = f(uVar);
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
            if (!z11) {
                p();
            }
            this.f9908f--;
        }
    }

    public Lifecycle.State b() {
        return this.f9906d;
    }

    public void d(u uVar) {
        g("removeObserver");
        this.f9905c.h(uVar);
    }

    public final void e(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<u, b>> descendingIterator = this.f9905c.descendingIterator();
        while (descendingIterator.hasNext() && !this.f9910h) {
            Map.Entry next = descendingIterator.next();
            u uVar = (u) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f9906d) > 0 && !this.f9910h && this.f9905c.contains(uVar)) {
                Lifecycle.Event a11 = Lifecycle.Event.Companion.a(bVar.b());
                if (a11 != null) {
                    n(a11.getTargetState());
                    bVar.a(lifecycleOwner, a11);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = r4.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.Lifecycle.State f(androidx.lifecycle.u r4) {
        /*
            r3 = this;
            androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.u, androidx.lifecycle.LifecycleRegistry$b> r0 = r3.f9905c
            java.util.Map$Entry r4 = r0.i(r4)
            r0 = 0
            if (r4 == 0) goto L_0x0016
            java.lang.Object r4 = r4.getValue()
            androidx.lifecycle.LifecycleRegistry$b r4 = (androidx.lifecycle.LifecycleRegistry.b) r4
            if (r4 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle$State r4 = r4.b()
            goto L_0x0017
        L_0x0016:
            r4 = r0
        L_0x0017:
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r1 = r3.f9911i
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x002f
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r0 = r3.f9911i
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
        L_0x002f:
            androidx.lifecycle.LifecycleRegistry$a r1 = f9903k
            androidx.lifecycle.Lifecycle$State r2 = r3.f9906d
            androidx.lifecycle.Lifecycle$State r4 = r1.a(r2, r4)
            androidx.lifecycle.Lifecycle$State r4 = r1.a(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.f(androidx.lifecycle.u):androidx.lifecycle.Lifecycle$State");
    }

    @SuppressLint({"RestrictedApi"})
    public final void g(String str) {
        if (this.f9904b && !i.a.e().b()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    public final void h(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<K, V>.d c11 = this.f9905c.c();
        while (c11.hasNext() && !this.f9910h) {
            Map.Entry entry = (Map.Entry) c11.next();
            u uVar = (u) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f9906d) < 0 && !this.f9910h && this.f9905c.contains(uVar)) {
                n(bVar.b());
                Lifecycle.Event c12 = Lifecycle.Event.Companion.c(bVar.b());
                if (c12 != null) {
                    bVar.a(lifecycleOwner, c12);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
        }
    }

    public void i(Lifecycle.Event event) {
        g("handleLifecycleEvent");
        l(event.getTargetState());
    }

    public final boolean j() {
        if (this.f9905c.size() == 0) {
            return true;
        }
        Lifecycle.State b11 = this.f9905c.a().getValue().b();
        Lifecycle.State b12 = this.f9905c.d().getValue().b();
        if (b11 == b12 && this.f9906d == b12) {
            return true;
        }
        return false;
    }

    public void k(Lifecycle.State state) {
        g("markState");
        o(state);
    }

    public final void l(Lifecycle.State state) {
        Lifecycle.State state2 = this.f9906d;
        if (state2 != state) {
            if ((state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) ? false : true) {
                this.f9906d = state;
                if (this.f9909g || this.f9908f != 0) {
                    this.f9910h = true;
                    return;
                }
                this.f9909g = true;
                p();
                this.f9909g = false;
                if (this.f9906d == Lifecycle.State.DESTROYED) {
                    this.f9905c = new FastSafeIterableMap<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.f9906d + " in component " + this.f9907e.get()).toString());
        }
    }

    public final void m() {
        ArrayList<Lifecycle.State> arrayList = this.f9911i;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void n(Lifecycle.State state) {
        this.f9911i.add(state);
    }

    public void o(Lifecycle.State state) {
        g("setCurrentState");
        l(state);
    }

    public final void p() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.f9907e.get();
        if (lifecycleOwner != null) {
            while (!j()) {
                this.f9910h = false;
                if (this.f9906d.compareTo(this.f9905c.a().getValue().b()) < 0) {
                    e(lifecycleOwner);
                }
                Map.Entry<u, b> d11 = this.f9905c.d();
                if (!this.f9910h && d11 != null && this.f9906d.compareTo(d11.getValue().b()) > 0) {
                    h(lifecycleOwner);
                }
            }
            this.f9910h = false;
            this.f9912j.setValue(b());
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
    }
}
