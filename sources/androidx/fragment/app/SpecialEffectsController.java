package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.h0;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class SpecialEffectsController {

    /* renamed from: f  reason: collision with root package name */
    public static final a f9675f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f9676a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Operation> f9677b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<Operation> f9678c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f9679d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9680e;

    public static class Operation {

        /* renamed from: a  reason: collision with root package name */
        public State f9681a;

        /* renamed from: b  reason: collision with root package name */
        public LifecycleImpact f9682b;

        /* renamed from: c  reason: collision with root package name */
        public final Fragment f9683c;

        /* renamed from: d  reason: collision with root package name */
        public final List<Runnable> f9684d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final Set<CancellationSignal> f9685e = new LinkedHashSet();

        /* renamed from: f  reason: collision with root package name */
        public boolean f9686f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9687g;

        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;
            
            public static final a Companion = null;

            public static final class a {
                public a() {
                }

                public /* synthetic */ a(r rVar) {
                    this();
                }

                public final State a(View view) {
                    if (!(view.getAlpha() == 0.0f) || view.getVisibility() != 0) {
                        return b(view.getVisibility());
                    }
                    return State.INVISIBLE;
                }

                public final State b(int i11) {
                    if (i11 == 0) {
                        return State.VISIBLE;
                    }
                    if (i11 == 4) {
                        return State.INVISIBLE;
                    }
                    if (i11 == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i11);
                }
            }

            public /* synthetic */ class b {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f9688a = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
                static {
                    /*
                        androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r2 = 4
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        f9688a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.State.b.<clinit>():void");
                }
            }

            /* access modifiers changed from: public */
            static {
                Companion = new a((r) null);
            }

            public static final State from(int i11) {
                return Companion.b(i11);
            }

            public final void applyState(View view) {
                int i11 = b.f9688a[ordinal()];
                if (i11 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.P0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i11 == 2) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i11 == 3) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (i11 == 4) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f9689a;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r1 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    f9689a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.Operation.a.<clinit>():void");
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
            this.f9681a = state;
            this.f9682b = lifecycleImpact;
            this.f9683c = fragment;
            cancellationSignal.c(new l0(this));
        }

        public static final void b(Operation operation) {
            operation.d();
        }

        public final void c(Runnable runnable) {
            this.f9684d.add(runnable);
        }

        public final void d() {
            if (!this.f9686f) {
                this.f9686f = true;
                if (this.f9685e.isEmpty()) {
                    e();
                    return;
                }
                for (CancellationSignal a11 : CollectionsKt___CollectionsKt.M0(this.f9685e)) {
                    a11.a();
                }
            }
        }

        public void e() {
            if (!this.f9687g) {
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f9687g = true;
                for (Runnable run : this.f9684d) {
                    run.run();
                }
            }
        }

        public final void f(CancellationSignal cancellationSignal) {
            if (this.f9685e.remove(cancellationSignal) && this.f9685e.isEmpty()) {
                e();
            }
        }

        public final State g() {
            return this.f9681a;
        }

        public final Fragment h() {
            return this.f9683c;
        }

        public final LifecycleImpact i() {
            return this.f9682b;
        }

        public final boolean j() {
            return this.f9686f;
        }

        public final boolean k() {
            return this.f9687g;
        }

        public final void l(CancellationSignal cancellationSignal) {
            n();
            this.f9685e.add(cancellationSignal);
        }

        public final void m(State state, LifecycleImpact lifecycleImpact) {
            int i11 = a.f9689a[lifecycleImpact.ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9683c + " mFinalState = " + this.f9681a + " -> REMOVED. mLifecycleImpact  = " + this.f9682b + " to REMOVING.");
                    }
                    this.f9681a = State.REMOVED;
                    this.f9682b = LifecycleImpact.REMOVING;
                } else if (i11 == 3 && this.f9681a != State.REMOVED) {
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9683c + " mFinalState = " + this.f9681a + " -> " + state + '.');
                    }
                    this.f9681a = state;
                }
            } else if (this.f9681a == State.REMOVED) {
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f9683c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f9682b + " to ADDING.");
                }
                this.f9681a = State.VISIBLE;
                this.f9682b = LifecycleImpact.ADDING;
            }
        }

        public void n() {
        }

        public String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            return "Operation {" + hexString + "} {finalState = " + this.f9681a + " lifecycleImpact = " + this.f9682b + " fragment = " + this.f9683c + '}';
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup viewGroup, FragmentManager fragmentManager) {
            return b(viewGroup, fragmentManager.H0());
        }

        public final SpecialEffectsController b(ViewGroup viewGroup, m0 m0Var) {
            int i11 = R$id.special_effects_controller_view_tag;
            Object tag = viewGroup.getTag(i11);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController a11 = m0Var.a(viewGroup);
            viewGroup.setTag(i11, a11);
            return a11;
        }
    }

    public static final class b extends Operation {

        /* renamed from: h  reason: collision with root package name */
        public final d0 f9690h;

        public b(Operation.State state, Operation.LifecycleImpact lifecycleImpact, d0 d0Var, CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, d0Var.k(), cancellationSignal);
            this.f9690h = d0Var;
        }

        public void e() {
            super.e();
            this.f9690h.m();
        }

        public void n() {
            if (i() == Operation.LifecycleImpact.ADDING) {
                Fragment k11 = this.f9690h.k();
                View findFocus = k11.mView.findFocus();
                if (findFocus != null) {
                    k11.setFocusedView(findFocus);
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k11);
                    }
                }
                View requireView = h().requireView();
                if (requireView.getParent() == null) {
                    this.f9690h.b();
                    requireView.setAlpha(0.0f);
                }
                if ((requireView.getAlpha() == 0.0f) && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k11.getPostOnViewCreatedAlpha());
            } else if (i() == Operation.LifecycleImpact.REMOVING) {
                Fragment k12 = this.f9690h.k();
                View requireView2 = k12.requireView();
                if (FragmentManager.P0(2)) {
                    Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + k12);
                }
                requireView2.clearFocus();
            }
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9691a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f9691a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup viewGroup) {
        this.f9676a = viewGroup;
    }

    public static final void d(SpecialEffectsController specialEffectsController, b bVar) {
        if (specialEffectsController.f9677b.contains(bVar)) {
            bVar.g().applyState(bVar.h().mView);
        }
    }

    public static final void e(SpecialEffectsController specialEffectsController, b bVar) {
        specialEffectsController.f9677b.remove(bVar);
        specialEffectsController.f9678c.remove(bVar);
    }

    public static final SpecialEffectsController r(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return f9675f.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController s(ViewGroup viewGroup, m0 m0Var) {
        return f9675f.b(viewGroup, m0Var);
    }

    public final void c(Operation.State state, Operation.LifecycleImpact lifecycleImpact, d0 d0Var) {
        synchronized (this.f9677b) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation l11 = l(d0Var.k());
            if (l11 != null) {
                l11.m(state, lifecycleImpact);
                return;
            }
            b bVar = new b(state, lifecycleImpact, d0Var, cancellationSignal);
            this.f9677b.add(bVar);
            bVar.c(new k0(this, bVar));
            bVar.c(new j0(this, bVar));
            Unit unit = Unit.f56620a;
        }
    }

    public final void f(Operation.State state, d0 d0Var) {
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + d0Var.k());
        }
        c(state, Operation.LifecycleImpact.ADDING, d0Var);
    }

    public final void g(d0 d0Var) {
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + d0Var.k());
        }
        c(Operation.State.GONE, Operation.LifecycleImpact.NONE, d0Var);
    }

    public final void h(d0 d0Var) {
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + d0Var.k());
        }
        c(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, d0Var);
    }

    public final void i(d0 d0Var) {
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + d0Var.k());
        }
        c(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, d0Var);
    }

    public abstract void j(List<Operation> list, boolean z11);

    public final void k() {
        if (!this.f9680e) {
            if (!h0.Z(this.f9676a)) {
                n();
                this.f9679d = false;
                return;
            }
            synchronized (this.f9677b) {
                if (!this.f9677b.isEmpty()) {
                    List<Operation> L0 = CollectionsKt___CollectionsKt.L0(this.f9678c);
                    this.f9678c.clear();
                    for (Operation operation : L0) {
                        if (FragmentManager.P0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.d();
                        if (!operation.k()) {
                            this.f9678c.add(operation);
                        }
                    }
                    u();
                    List<Operation> L02 = CollectionsKt___CollectionsKt.L0(this.f9677b);
                    this.f9677b.clear();
                    this.f9678c.addAll(L02);
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    for (Operation n11 : L02) {
                        n11.n();
                    }
                    j(L02, this.f9679d);
                    this.f9679d = false;
                    if (FragmentManager.P0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final Operation l(Fragment fragment) {
        T t11;
        boolean z11;
        Iterator<T> it2 = this.f9677b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            Operation operation = (Operation) t11;
            if (!x.b(operation.h(), fragment) || operation.j()) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (Operation) t11;
    }

    public final Operation m(Fragment fragment) {
        T t11;
        boolean z11;
        Iterator<T> it2 = this.f9678c.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            Operation operation = (Operation) t11;
            if (!x.b(operation.h(), fragment) || operation.j()) {
                z11 = false;
                continue;
            } else {
                z11 = true;
                continue;
            }
            if (z11) {
                break;
            }
        }
        return (Operation) t11;
    }

    public final void n() {
        String str;
        String str2;
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean Z = h0.Z(this.f9676a);
        synchronized (this.f9677b) {
            u();
            for (Operation n11 : this.f9677b) {
                n11.n();
            }
            for (Operation operation : CollectionsKt___CollectionsKt.L0(this.f9678c)) {
                if (FragmentManager.P0(2)) {
                    if (Z) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f9676a + " is not attached to window. ";
                    }
                    Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + operation);
                }
                operation.d();
            }
            for (Operation operation2 : CollectionsKt___CollectionsKt.L0(this.f9677b)) {
                if (FragmentManager.P0(2)) {
                    if (Z) {
                        str = "";
                    } else {
                        str = "Container " + this.f9676a + " is not attached to window. ";
                    }
                    Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + operation2);
                }
                operation2.d();
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void o() {
        if (this.f9680e) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f9680e = false;
            k();
        }
    }

    public final Operation.LifecycleImpact p(d0 d0Var) {
        int i11;
        Fragment k11 = d0Var.k();
        Operation l11 = l(k11);
        Operation.LifecycleImpact lifecycleImpact = null;
        Operation.LifecycleImpact i12 = l11 != null ? l11.i() : null;
        Operation m11 = m(k11);
        if (m11 != null) {
            lifecycleImpact = m11.i();
        }
        if (i12 == null) {
            i11 = -1;
        } else {
            i11 = c.f9691a[i12.ordinal()];
        }
        return (i11 == -1 || i11 == 1) ? lifecycleImpact : i12;
    }

    public final ViewGroup q() {
        return this.f9676a;
    }

    public final void t() {
        boolean z11;
        Fragment fragment;
        Operation operation;
        boolean z12;
        synchronized (this.f9677b) {
            u();
            List<Operation> list = this.f9677b;
            ListIterator<Operation> listIterator = list.listIterator(list.size());
            while (true) {
                z11 = false;
                fragment = null;
                if (!listIterator.hasPrevious()) {
                    operation = null;
                    break;
                }
                operation = listIterator.previous();
                Operation operation2 = operation;
                Operation.State a11 = Operation.State.Companion.a(operation2.h().mView);
                Operation.State g11 = operation2.g();
                Operation.State state = Operation.State.VISIBLE;
                if (g11 != state || a11 == state) {
                    z12 = false;
                    continue;
                } else {
                    z12 = true;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            Operation operation3 = operation;
            if (operation3 != null) {
                fragment = operation3.h();
            }
            if (fragment != null) {
                z11 = fragment.isPostponed();
            }
            this.f9680e = z11;
            Unit unit = Unit.f56620a;
        }
    }

    public final void u() {
        for (Operation next : this.f9677b) {
            if (next.i() == Operation.LifecycleImpact.ADDING) {
                next.m(Operation.State.Companion.b(next.h().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void v(boolean z11) {
        this.f9679d = z11;
    }
}
