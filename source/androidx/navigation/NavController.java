package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.u;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import d10.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.i;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;

public class NavController {
    public static final a H = new a((r) null);
    public static boolean I = true;
    public l<? super NavBackStackEntry, Unit> A;
    public final Map<NavBackStackEntry, Boolean> B;
    public int C;
    public final List<NavBackStackEntry> D;
    public final i E;
    public final a1<NavBackStackEntry> F;
    public final d<NavBackStackEntry> G;

    /* renamed from: a  reason: collision with root package name */
    public final Context f10252a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f10253b;

    /* renamed from: c  reason: collision with root package name */
    public i f10254c;

    /* renamed from: d  reason: collision with root package name */
    public NavGraph f10255d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f10256e;

    /* renamed from: f  reason: collision with root package name */
    public Parcelable[] f10257f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10258g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayDeque<NavBackStackEntry> f10259h;

    /* renamed from: i  reason: collision with root package name */
    public final b1<List<NavBackStackEntry>> f10260i;

    /* renamed from: j  reason: collision with root package name */
    public final j1<List<NavBackStackEntry>> f10261j;

    /* renamed from: k  reason: collision with root package name */
    public final b1<List<NavBackStackEntry>> f10262k;

    /* renamed from: l  reason: collision with root package name */
    public final j1<List<NavBackStackEntry>> f10263l;

    /* renamed from: m  reason: collision with root package name */
    public final Map<NavBackStackEntry, NavBackStackEntry> f10264m;

    /* renamed from: n  reason: collision with root package name */
    public final Map<NavBackStackEntry, AtomicInteger> f10265n;

    /* renamed from: o  reason: collision with root package name */
    public final Map<Integer, String> f10266o;

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, ArrayDeque<NavBackStackEntryState>> f10267p;

    /* renamed from: q  reason: collision with root package name */
    public LifecycleOwner f10268q;

    /* renamed from: r  reason: collision with root package name */
    public NavControllerViewModel f10269r;

    /* renamed from: s  reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f10270s;

    /* renamed from: t  reason: collision with root package name */
    public Lifecycle.State f10271t;

    /* renamed from: u  reason: collision with root package name */
    public final u f10272u;

    /* renamed from: v  reason: collision with root package name */
    public final o f10273v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10274w;

    /* renamed from: x  reason: collision with root package name */
    public NavigatorProvider f10275x;

    /* renamed from: y  reason: collision with root package name */
    public final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> f10276y;

    /* renamed from: z  reason: collision with root package name */
    public l<? super NavBackStackEntry, Unit> f10277z;

    public final class NavControllerNavigatorState extends NavigatorState {

        /* renamed from: g  reason: collision with root package name */
        public final Navigator<? extends NavDestination> f10278g;

        public NavControllerNavigatorState(Navigator<? extends NavDestination> navigator) {
            this.f10278g = navigator;
        }

        public NavBackStackEntry a(NavDestination navDestination, Bundle bundle) {
            return NavBackStackEntry.a.b(NavBackStackEntry.f10235p, NavController.this.B(), navDestination, bundle, NavController.this.G(), NavController.this.f10269r, (String) null, (Bundle) null, 96, (Object) null);
        }

        public void e(NavBackStackEntry navBackStackEntry) {
            NavControllerViewModel k11;
            boolean b11 = x.b(NavController.this.B.get(navBackStackEntry), Boolean.TRUE);
            super.e(navBackStackEntry);
            NavController.this.B.remove(navBackStackEntry);
            if (!NavController.this.f10259h.contains(navBackStackEntry)) {
                NavController.this.n0(navBackStackEntry);
                if (navBackStackEntry.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
                    navBackStackEntry.k(Lifecycle.State.DESTROYED);
                }
                ArrayDeque d11 = NavController.this.f10259h;
                boolean z11 = true;
                if (!(d11 instanceof Collection) || !d11.isEmpty()) {
                    Iterator it2 = d11.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (x.b(((NavBackStackEntry) it2.next()).f(), navBackStackEntry.f())) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z11 && !b11 && (k11 = NavController.this.f10269r) != null) {
                    k11.i0(navBackStackEntry.f());
                }
                NavController.this.o0();
                NavController.this.f10262k.d(NavController.this.e0());
            } else if (!d()) {
                NavController.this.o0();
                NavController.this.f10260i.d(CollectionsKt___CollectionsKt.L0(NavController.this.f10259h));
                NavController.this.f10262k.d(NavController.this.e0());
            }
        }

        public void h(NavBackStackEntry navBackStackEntry, boolean z11) {
            Navigator d11 = NavController.this.f10275x.d(navBackStackEntry.e().n());
            if (x.b(d11, this.f10278g)) {
                l j11 = NavController.this.A;
                if (j11 != null) {
                    j11.invoke(navBackStackEntry);
                    super.h(navBackStackEntry, z11);
                    return;
                }
                NavController.this.Y(navBackStackEntry, new NavController$NavControllerNavigatorState$pop$1(this, navBackStackEntry, z11));
                return;
            }
            ((NavControllerNavigatorState) NavController.this.f10276y.get(d11)).h(navBackStackEntry, z11);
        }

        public void i(NavBackStackEntry navBackStackEntry, boolean z11) {
            super.i(navBackStackEntry, z11);
            NavController.this.B.put(navBackStackEntry, Boolean.valueOf(z11));
        }

        public void j(NavBackStackEntry navBackStackEntry) {
            super.j(navBackStackEntry);
            if (NavController.this.f10259h.contains(navBackStackEntry)) {
                navBackStackEntry.k(Lifecycle.State.STARTED);
                return;
            }
            throw new IllegalStateException("Cannot transition entry that is not in the back stack");
        }

        public void k(NavBackStackEntry navBackStackEntry) {
            Navigator d11 = NavController.this.f10275x.d(navBackStackEntry.e().n());
            if (x.b(d11, this.f10278g)) {
                l c11 = NavController.this.f10277z;
                if (c11 != null) {
                    c11.invoke(navBackStackEntry);
                    o(navBackStackEntry);
                    return;
                }
                Log.i("NavController", "Ignoring add of destination " + navBackStackEntry.e() + " outside of the call to navigate(). ");
                return;
            }
            Object obj = NavController.this.f10276y.get(d11);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).k(navBackStackEntry);
                return;
            }
            throw new IllegalStateException(("NavigatorBackStack for " + navBackStackEntry.e().n() + " should already be created").toString());
        }

        public final void o(NavBackStackEntry navBackStackEntry) {
            super.k(navBackStackEntry);
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public interface b {
        void a(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public static final class c extends o {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NavController f10280a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(NavController navController) {
            super(false);
            this.f10280a = navController;
        }

        public void handleOnBackPressed() {
            this.f10280a.V();
        }
    }

    public NavController(Context context) {
        Object obj;
        this.f10252a = context;
        Iterator it2 = SequencesKt__SequencesKt.g(context, NavController$activity$1.INSTANCE).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.f10253b = (Activity) obj;
        this.f10259h = new ArrayDeque<>();
        b1<List<NavBackStackEntry>> a11 = k1.a(CollectionsKt__CollectionsKt.k());
        this.f10260i = a11;
        this.f10261j = f.b(a11);
        b1<List<NavBackStackEntry>> a12 = k1.a(CollectionsKt__CollectionsKt.k());
        this.f10262k = a12;
        this.f10263l = f.b(a12);
        this.f10264m = new LinkedHashMap();
        this.f10265n = new LinkedHashMap();
        this.f10266o = new LinkedHashMap();
        this.f10267p = new LinkedHashMap();
        this.f10270s = new CopyOnWriteArrayList<>();
        this.f10271t = Lifecycle.State.INITIALIZED;
        this.f10272u = new d(this);
        this.f10273v = new c(this);
        this.f10274w = true;
        this.f10275x = new NavigatorProvider();
        this.f10276y = new LinkedHashMap();
        this.B = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this.f10275x;
        navigatorProvider.b(new f(navigatorProvider));
        this.f10275x.b(new ActivityNavigator(this.f10252a));
        this.D = new ArrayList();
        this.E = LazyKt__LazyJVMKt.a(new NavController$navInflater$2(this));
        a1<NavBackStackEntry> b11 = g1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
        this.F = b11;
        this.G = f.a(b11);
    }

    public static final void M(NavController navController, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        navController.f10271t = event.getTargetState();
        if (navController.f10255d != null) {
            Iterator<NavBackStackEntry> it2 = navController.f10259h.iterator();
            while (it2.hasNext()) {
                it2.next().h(event);
            }
        }
    }

    public static /* synthetic */ boolean b0(NavController navController, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 4) != 0) {
                z12 = false;
            }
            return navController.a0(i11, z11, z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    public static /* synthetic */ void d0(NavController navController, NavBackStackEntry navBackStackEntry, boolean z11, ArrayDeque arrayDeque, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                arrayDeque = new ArrayDeque();
            }
            navController.c0(navBackStackEntry, z11, arrayDeque);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    public static /* synthetic */ void q(NavController navController, NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                list = CollectionsKt__CollectionsKt.k();
            }
            navController.p(navDestination, bundle, navBackStackEntry, list);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    public final NavBackStackEntry A(String str) {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.f10259h;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
            if (navBackStackEntry2.e().r(str, navBackStackEntry2.c())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = navBackStackEntry;
        if (navBackStackEntry3 != null) {
            return navBackStackEntry3;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + D()).toString());
    }

    public final Context B() {
        return this.f10252a;
    }

    public NavBackStackEntry C() {
        return this.f10259h.h();
    }

    public NavDestination D() {
        NavBackStackEntry C2 = C();
        if (C2 != null) {
            return C2.e();
        }
        return null;
    }

    public final int E() {
        ArrayDeque<NavBackStackEntry> arrayDeque = this.f10259h;
        int i11 = 0;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            for (NavBackStackEntry e11 : arrayDeque) {
                if ((!(e11.e() instanceof NavGraph)) && (i11 = i11 + 1) < 0) {
                    CollectionsKt__CollectionsKt.s();
                }
            }
        }
        return i11;
    }

    public NavGraph F() {
        NavGraph navGraph = this.f10255d;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    public final Lifecycle.State G() {
        if (this.f10268q == null) {
            return Lifecycle.State.CREATED;
        }
        return this.f10271t;
    }

    public i H() {
        return (i) this.E.getValue();
    }

    public NavigatorProvider I() {
        return this.f10275x;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if ((r0.length == 0) != false) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean J(android.content.Intent r20) {
        /*
            r19 = this;
            r7 = r19
            r1 = r20
            r8 = 0
            if (r1 != 0) goto L_0x0008
            return r8
        L_0x0008:
            android.os.Bundle r2 = r20.getExtras()
            java.lang.String r3 = "NavController"
            r9 = 0
            if (r2 == 0) goto L_0x002d
            java.lang.String r0 = "android-support-nav:controller:deepLinkIds"
            int[] r0 = r2.getIntArray(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x002e
        L_0x0018:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleDeepLink() could not extract deepLink from "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4, r0)
        L_0x002d:
            r0 = r9
        L_0x002e:
            if (r2 == 0) goto L_0x0037
            java.lang.String r4 = "android-support-nav:controller:deepLinkArgs"
            java.util.ArrayList r4 = r2.getParcelableArrayList(r4)
            goto L_0x0038
        L_0x0037:
            r4 = r9
        L_0x0038:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            if (r2 == 0) goto L_0x0046
            java.lang.String r6 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r2 = r2.getBundle(r6)
            goto L_0x0047
        L_0x0046:
            r2 = r9
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r5.putAll(r2)
        L_0x004c:
            r10 = 1
            if (r0 == 0) goto L_0x0057
            int r2 = r0.length
            if (r2 != 0) goto L_0x0054
            r2 = r10
            goto L_0x0055
        L_0x0054:
            r2 = r8
        L_0x0055:
            if (r2 == 0) goto L_0x007b
        L_0x0057:
            androidx.navigation.NavGraph r2 = r7.f10255d
            androidx.navigation.e r6 = new androidx.navigation.e
            r6.<init>(r1)
            androidx.navigation.NavDestination$a r2 = r2.s(r6)
            if (r2 == 0) goto L_0x007b
            androidx.navigation.NavDestination r0 = r2.b()
            int[] r4 = androidx.navigation.NavDestination.h(r0, r9, r10, r9)
            android.os.Bundle r2 = r2.c()
            android.os.Bundle r0 = r0.d(r2)
            if (r0 == 0) goto L_0x0079
            r5.putAll(r0)
        L_0x0079:
            r0 = r4
            r4 = r9
        L_0x007b:
            if (r0 == 0) goto L_0x01e4
            int r2 = r0.length
            if (r2 != 0) goto L_0x0082
            r2 = r10
            goto L_0x0083
        L_0x0082:
            r2 = r8
        L_0x0083:
            if (r2 == 0) goto L_0x0087
            goto L_0x01e4
        L_0x0087:
            java.lang.String r2 = r7.y(r0)
            if (r2 == 0) goto L_0x00aa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Could not find destination "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r2 = " in the navigation graph, ignoring the deep link from "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r3, r0)
            return r8
        L_0x00aa:
            java.lang.String r2 = "android-support-nav:controller:deepLinkIntent"
            r5.putParcelable(r2, r1)
            int r2 = r0.length
            android.os.Bundle[] r11 = new android.os.Bundle[r2]
            r3 = r8
        L_0x00b3:
            if (r3 >= r2) goto L_0x00cf
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r6.putAll(r5)
            if (r4 == 0) goto L_0x00ca
            java.lang.Object r12 = r4.get(r3)
            android.os.Bundle r12 = (android.os.Bundle) r12
            if (r12 == 0) goto L_0x00ca
            r6.putAll(r12)
        L_0x00ca:
            r11[r3] = r6
            int r3 = r3 + 1
            goto L_0x00b3
        L_0x00cf:
            int r2 = r20.getFlags()
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r2
            if (r3 == 0) goto L_0x00f9
            r4 = 32768(0x8000, float:4.5918E-41)
            r2 = r2 & r4
            if (r2 != 0) goto L_0x00f9
            r1.addFlags(r4)
            android.content.Context r0 = r7.f10252a
            androidx.core.app.TaskStackBuilder r0 = androidx.core.app.TaskStackBuilder.e(r0)
            androidx.core.app.TaskStackBuilder r0 = r0.b(r1)
            r0.g()
            android.app.Activity r0 = r7.f10253b
            if (r0 == 0) goto L_0x00f8
            r0.finish()
            r0.overridePendingTransition(r8, r8)
        L_0x00f8:
            return r10
        L_0x00f9:
            java.lang.String r12 = "Deep Linking failed: destination "
            if (r3 == 0) goto L_0x015b
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r1 = r7.f10259h
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0114
            androidx.navigation.NavGraph r1 = r7.f10255d
            int r2 = r1.l()
            r3 = 1
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r19
            b0(r1, r2, r3, r4, r5, r6)
        L_0x0114:
            int r1 = r0.length
            if (r8 >= r1) goto L_0x015a
            r1 = r0[r8]
            int r2 = r8 + 1
            r3 = r11[r8]
            androidx.navigation.NavDestination r4 = r7.w(r1)
            if (r4 == 0) goto L_0x0131
            androidx.navigation.NavController$handleDeepLink$2 r1 = new androidx.navigation.NavController$handleDeepLink$2
            r1.<init>(r4, r7)
            androidx.navigation.NavOptions r1 = androidx.navigation.j.a(r1)
            r7.S(r4, r3, r1, r9)
            r8 = r2
            goto L_0x0114
        L_0x0131:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.f10313k
            android.content.Context r2 = r7.f10252a
            java.lang.String r0 = r0.b(r2, r1)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r0)
            java.lang.String r0 = " cannot be found from the current destination "
            r2.append(r0)
            androidx.navigation.NavDestination r0 = r19.D()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x015a:
            return r10
        L_0x015b:
            androidx.navigation.NavGraph r1 = r7.f10255d
            int r2 = r0.length
            r3 = r8
        L_0x015f:
            if (r3 >= r2) goto L_0x01e1
            r4 = r0[r3]
            r5 = r11[r3]
            if (r3 != 0) goto L_0x016a
            androidx.navigation.NavGraph r6 = r7.f10255d
            goto L_0x016e
        L_0x016a:
            androidx.navigation.NavDestination r6 = r1.B(r4)
        L_0x016e:
            if (r6 == 0) goto L_0x01bc
            int r4 = r0.length
            int r4 = r4 - r10
            if (r3 == r4) goto L_0x0194
            boolean r4 = r6 instanceof androidx.navigation.NavGraph
            if (r4 == 0) goto L_0x01b9
            androidx.navigation.NavGraph r6 = (androidx.navigation.NavGraph) r6
        L_0x017a:
            int r1 = r6.H()
            androidx.navigation.NavDestination r1 = r6.B(r1)
            boolean r1 = r1 instanceof androidx.navigation.NavGraph
            if (r1 == 0) goto L_0x0192
            int r1 = r6.H()
            androidx.navigation.NavDestination r1 = r6.B(r1)
            r6 = r1
            androidx.navigation.NavGraph r6 = (androidx.navigation.NavGraph) r6
            goto L_0x017a
        L_0x0192:
            r1 = r6
            goto L_0x01b9
        L_0x0194:
            androidx.navigation.NavOptions$Builder r13 = new androidx.navigation.NavOptions$Builder
            r13.<init>()
            androidx.navigation.NavGraph r4 = r7.f10255d
            int r14 = r4.l()
            r15 = 1
            r16 = 0
            r17 = 4
            r18 = 0
            androidx.navigation.NavOptions$Builder r4 = androidx.navigation.NavOptions.Builder.i(r13, r14, r15, r16, r17, r18)
            androidx.navigation.NavOptions$Builder r4 = r4.b(r8)
            androidx.navigation.NavOptions$Builder r4 = r4.c(r8)
            androidx.navigation.NavOptions r4 = r4.a()
            r7.S(r6, r5, r4, r9)
        L_0x01b9:
            int r3 = r3 + 1
            goto L_0x015f
        L_0x01bc:
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.f10313k
            android.content.Context r2 = r7.f10252a
            java.lang.String r0 = r0.b(r2, r4)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r0)
            java.lang.String r0 = " cannot be found in graph "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01e1:
            r7.f10258g = r10
            return r10
        L_0x01e4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.J(android.content.Intent):boolean");
    }

    public final List<NavBackStackEntry> K(ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavDestination navDestination;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry h11 = this.f10259h.h();
        if (h11 == null || (navDestination = h11.e()) == null) {
            navDestination = F();
        }
        if (arrayDeque != null) {
            for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                NavDestination x11 = x(navDestination, navBackStackEntryState.getDestinationId());
                if (x11 != null) {
                    arrayList.add(navBackStackEntryState.instantiate(this.f10252a, x11, G(), this.f10269r));
                    navDestination = x11;
                } else {
                    String b11 = NavDestination.f10313k.b(this.f10252a, navBackStackEntryState.getDestinationId());
                    throw new IllegalStateException(("Restore State failed: destination " + b11 + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        return arrayList;
    }

    public final boolean L(NavDestination navDestination, Bundle bundle) {
        int i11;
        boolean z11;
        NavDestination e11;
        NavBackStackEntry C2 = C();
        if (!((C2 == null || (e11 = C2.e()) == null || (navDestination instanceof NavGraph ? NavGraph.f10330q.a((NavGraph) navDestination).l() : navDestination.l()) != e11.l()) ? false : true)) {
            return false;
        }
        ArrayDeque<NavBackStackEntry> arrayDeque = new ArrayDeque<>();
        ArrayDeque<NavBackStackEntry> arrayDeque2 = this.f10259h;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque2.listIterator(arrayDeque2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i11 = -1;
                break;
            }
            if (listIterator.previous().e() == navDestination) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                i11 = listIterator.nextIndex();
                break;
            }
        }
        while (CollectionsKt__CollectionsKt.m(this.f10259h) >= i11) {
            NavBackStackEntry removeLast = this.f10259h.removeLast();
            n0(removeLast);
            arrayDeque.addFirst(new NavBackStackEntry(removeLast, removeLast.e().d(bundle)));
        }
        for (NavBackStackEntry navBackStackEntry : arrayDeque) {
            NavGraph o11 = navBackStackEntry.e().o();
            if (o11 != null) {
                N(navBackStackEntry, z(o11.l()));
            }
            this.f10259h.add(navBackStackEntry);
        }
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque) {
            this.f10275x.d(navBackStackEntry2.e().n()).g(navBackStackEntry2);
        }
        return true;
    }

    public final void N(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.f10264m.put(navBackStackEntry, navBackStackEntry2);
        if (this.f10265n.get(navBackStackEntry2) == null) {
            this.f10265n.put(navBackStackEntry2, new AtomicInteger(0));
        }
        this.f10265n.get(navBackStackEntry2).incrementAndGet();
    }

    public void O(int i11) {
        P(i11, (Bundle) null);
    }

    public void P(int i11, Bundle bundle) {
        Q(i11, bundle, (NavOptions) null);
    }

    public void Q(int i11, Bundle bundle, NavOptions navOptions) {
        R(i11, bundle, navOptions, (Navigator.a) null);
    }

    public void R(int i11, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
        NavDestination navDestination;
        int i12;
        if (this.f10259h.isEmpty()) {
            navDestination = this.f10255d;
        } else {
            navDestination = this.f10259h.last().e();
        }
        if (navDestination != null) {
            b i13 = navDestination.i(i11);
            Bundle bundle2 = null;
            if (i13 != null) {
                if (navOptions == null) {
                    navOptions = i13.c();
                }
                i12 = i13.b();
                Bundle a11 = i13.a();
                if (a11 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(a11);
                }
            } else {
                i12 = i11;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i12 != 0 || navOptions == null || navOptions.e() == -1) {
                boolean z11 = true;
                if (i12 != 0) {
                    NavDestination w11 = w(i12);
                    if (w11 == null) {
                        NavDestination.Companion companion = NavDestination.f10313k;
                        String b11 = companion.b(this.f10252a, i12);
                        if (i13 != null) {
                            z11 = false;
                        }
                        if (!z11) {
                            throw new IllegalArgumentException(("Navigation destination " + b11 + " referenced from action " + companion.b(this.f10252a, i11) + " cannot be found from the current destination " + navDestination).toString());
                        }
                        throw new IllegalArgumentException("Navigation action/destination " + b11 + " cannot be found from the current destination " + navDestination);
                    }
                    S(w11, bundle2, navOptions, aVar);
                    return;
                }
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
            }
            W(navOptions.e(), navOptions.f());
            return;
        }
        throw new IllegalStateException("no current navigation node");
    }

    public final void S(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
        boolean z11;
        NavOptions navOptions2 = navOptions;
        for (NavControllerNavigatorState m11 : this.f10276y.values()) {
            m11.m(true);
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        boolean a02 = (navOptions2 == null || navOptions.e() == -1) ? false : a0(navOptions.e(), navOptions.f(), navOptions.h());
        Bundle d11 = navDestination.d(bundle);
        if (!(navOptions2 != null && navOptions.i()) || !this.f10266o.containsKey(Integer.valueOf(navDestination.l()))) {
            Navigator.a aVar2 = aVar;
            z11 = (navOptions2 != null && navOptions.g()) && L(navDestination, bundle);
            if (!z11) {
                T(this.f10275x.d(navDestination.n()), CollectionsKt__CollectionsJVMKt.e(NavBackStackEntry.a.b(NavBackStackEntry.f10235p, this.f10252a, navDestination, d11, G(), this.f10269r, (String) null, (Bundle) null, 96, (Object) null)), navOptions, aVar, new NavController$navigate$4(ref$BooleanRef, this, navDestination, d11));
            }
        } else {
            ref$BooleanRef.element = g0(navDestination.l(), d11, navOptions2, aVar);
            z11 = false;
        }
        p0();
        for (NavControllerNavigatorState m12 : this.f10276y.values()) {
            m12.m(false);
        }
        if (a02 || ref$BooleanRef.element || z11) {
            t();
        } else {
            o0();
        }
    }

    public final void T(Navigator<? extends NavDestination> navigator, List<NavBackStackEntry> list, NavOptions navOptions, Navigator.a aVar, l<? super NavBackStackEntry, Unit> lVar) {
        this.f10277z = lVar;
        navigator.e(list, navOptions, aVar);
        this.f10277z = null;
    }

    public final void U(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f10256e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Navigator d11 = this.f10275x.d(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    d11.h(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f10257f;
        boolean z11 = false;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i11 = 0;
            while (i11 < length) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i11];
                NavDestination w11 = w(navBackStackEntryState.getDestinationId());
                if (w11 != null) {
                    NavBackStackEntry instantiate = navBackStackEntryState.instantiate(this.f10252a, w11, G(), this.f10269r);
                    Navigator d12 = this.f10275x.d(w11.n());
                    Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map = this.f10276y;
                    NavControllerNavigatorState navControllerNavigatorState = map.get(d12);
                    if (navControllerNavigatorState == null) {
                        navControllerNavigatorState = new NavControllerNavigatorState(d12);
                        map.put(d12, navControllerNavigatorState);
                    }
                    this.f10259h.add(instantiate);
                    navControllerNavigatorState.o(instantiate);
                    NavGraph o11 = instantiate.e().o();
                    if (o11 != null) {
                        N(instantiate, z(o11.l()));
                    }
                    i11++;
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.f10313k.b(this.f10252a, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + D());
                }
            }
            p0();
            this.f10257f = null;
        }
        Collection<Navigator<? extends NavDestination>> values = this.f10275x.e().values();
        ArrayList<Navigator> arrayList = new ArrayList<>();
        for (T next2 : values) {
            if (!((Navigator) next2).c()) {
                arrayList.add(next2);
            }
        }
        for (Navigator navigator : arrayList) {
            Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> map2 = this.f10276y;
            NavControllerNavigatorState navControllerNavigatorState2 = map2.get(navigator);
            if (navControllerNavigatorState2 == null) {
                navControllerNavigatorState2 = new NavControllerNavigatorState(navigator);
                map2.put(navigator, navControllerNavigatorState2);
            }
            navigator.f(navControllerNavigatorState2);
        }
        if (this.f10255d == null || !this.f10259h.isEmpty()) {
            t();
            return;
        }
        if (!this.f10258g && (activity = this.f10253b) != null && J(activity.getIntent())) {
            z11 = true;
        }
        if (!z11) {
            S(this.f10255d, bundle, (NavOptions) null, (Navigator.a) null);
        }
    }

    public boolean V() {
        if (this.f10259h.isEmpty()) {
            return false;
        }
        return W(D().l(), true);
    }

    public boolean W(int i11, boolean z11) {
        return X(i11, z11, false);
    }

    public boolean X(int i11, boolean z11, boolean z12) {
        return a0(i11, z11, z12) && t();
    }

    public final void Y(NavBackStackEntry navBackStackEntry, d10.a<Unit> aVar) {
        int indexOf = this.f10259h.indexOf(navBackStackEntry);
        if (indexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack");
            return;
        }
        int i11 = indexOf + 1;
        if (i11 != this.f10259h.size()) {
            a0(this.f10259h.get(i11).e().l(), true, false);
        }
        d0(this, navBackStackEntry, false, (ArrayDeque) null, 6, (Object) null);
        aVar.invoke();
        p0();
        t();
    }

    public final void Z(Navigator<? extends NavDestination> navigator, NavBackStackEntry navBackStackEntry, boolean z11, l<? super NavBackStackEntry, Unit> lVar) {
        this.A = lVar;
        navigator.j(navBackStackEntry, z11);
        this.A = null;
    }

    public final boolean a0(int i11, boolean z11, boolean z12) {
        if (this.f10259h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = CollectionsKt___CollectionsKt.u0(this.f10259h).iterator();
        NavDestination navDestination = null;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            NavDestination e11 = ((NavBackStackEntry) it2.next()).e();
            Navigator d11 = this.f10275x.d(e11.n());
            if (z11 || e11.l() != i11) {
                arrayList.add(d11);
            }
            if (e11.l() == i11) {
                navDestination = e11;
                break;
            }
        }
        if (navDestination != null) {
            return u(arrayList, navDestination, z11, z12);
        }
        String b11 = NavDestination.f10313k.b(this.f10252a, i11);
        Log.i("NavController", "Ignoring popBackStack to destination " + b11 + " as it was not found on the current back stack");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0035, code lost:
        r4 = (r4 = r4.c()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c0(androidx.navigation.NavBackStackEntry r4, boolean r5, kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntryState> r6) {
        /*
            r3 = this;
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r0 = r3.f10259h
            java.lang.Object r0 = r0.last()
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            boolean r1 = kotlin.jvm.internal.x.b(r0, r4)
            if (r1 == 0) goto L_0x008d
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r4 = r3.f10259h
            r4.removeLast()
            androidx.navigation.NavigatorProvider r4 = r3.I()
            androidx.navigation.NavDestination r1 = r0.e()
            java.lang.String r1 = r1.n()
            androidx.navigation.Navigator r4 = r4.d(r1)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r1 = r3.f10276y
            java.lang.Object r4 = r1.get(r4)
            androidx.navigation.NavController$NavControllerNavigatorState r4 = (androidx.navigation.NavController.NavControllerNavigatorState) r4
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0045
            kotlinx.coroutines.flow.j1 r4 = r4.c()
            if (r4 == 0) goto L_0x0045
            java.lang.Object r4 = r4.getValue()
            java.util.Set r4 = (java.util.Set) r4
            if (r4 == 0) goto L_0x0045
            boolean r4 = r4.contains(r0)
            if (r4 != r1) goto L_0x0045
            r4 = r1
            goto L_0x0046
        L_0x0045:
            r4 = r2
        L_0x0046:
            if (r4 != 0) goto L_0x0052
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r4 = r3.f10265n
            boolean r4 = r4.containsKey(r0)
            if (r4 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r1 = r2
        L_0x0052:
            androidx.lifecycle.Lifecycle r4 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r4 = r4.b()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.CREATED
            boolean r4 = r4.isAtLeast(r2)
            if (r4 == 0) goto L_0x007d
            if (r5 == 0) goto L_0x006f
            r0.k(r2)
            androidx.navigation.NavBackStackEntryState r4 = new androidx.navigation.NavBackStackEntryState
            r4.<init>((androidx.navigation.NavBackStackEntry) r0)
            r6.addFirst(r4)
        L_0x006f:
            if (r1 != 0) goto L_0x007a
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.DESTROYED
            r0.k(r4)
            r3.n0(r0)
            goto L_0x007d
        L_0x007a:
            r0.k(r2)
        L_0x007d:
            if (r5 != 0) goto L_0x008c
            if (r1 != 0) goto L_0x008c
            androidx.navigation.NavControllerViewModel r4 = r3.f10269r
            if (r4 == 0) goto L_0x008c
            java.lang.String r5 = r0.f()
            r4.i0(r5)
        L_0x008c:
            return
        L_0x008d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Attempted to pop "
            r5.append(r6)
            androidx.navigation.NavDestination r4 = r4.e()
            r5.append(r4)
            java.lang.String r4 = ", which is not the top of the back stack ("
            r5.append(r4)
            androidx.navigation.NavDestination r4 = r0.e()
            r5.append(r4)
            r4 = 41
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.c0(androidx.navigation.NavBackStackEntry, boolean, kotlin.collections.ArrayDeque):void");
    }

    public final List<NavBackStackEntry> e0() {
        ArrayList arrayList = new ArrayList();
        for (NavControllerNavigatorState c11 : this.f10276y.values()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object next : c11.c().getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) next;
                if (!arrayList.contains(navBackStackEntry) && !navBackStackEntry.g().isAtLeast(Lifecycle.State.STARTED)) {
                    arrayList2.add(next);
                }
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList2);
        }
        ArrayDeque<NavBackStackEntry> arrayDeque = this.f10259h;
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next2;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.g().isAtLeast(Lifecycle.State.STARTED)) {
                arrayList3.add(next2);
            }
        }
        boolean unused2 = CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object next3 : arrayList) {
            if (!(((NavBackStackEntry) next3).e() instanceof NavGraph)) {
                arrayList4.add(next3);
            }
        }
        return arrayList4;
    }

    public void f0(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.f10252a.getClassLoader());
            this.f10256e = bundle.getBundle("android-support-nav:controller:navigatorState");
            this.f10257f = bundle.getParcelableArray("android-support-nav:controller:backStack");
            this.f10267p.clear();
            int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
            if (!(intArray == null || stringArrayList == null)) {
                int length = intArray.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length) {
                    this.f10266o.put(Integer.valueOf(intArray[i11]), stringArrayList.get(i12));
                    i11++;
                    i12++;
                }
            }
            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
            if (stringArrayList2 != null) {
                for (String str : stringArrayList2) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray("android-support-nav:controller:backStackStates:" + str);
                    if (parcelableArray != null) {
                        Map<String, ArrayDeque<NavBackStackEntryState>> map = this.f10267p;
                        ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                        Iterator a11 = h.a(parcelableArray);
                        while (a11.hasNext()) {
                            arrayDeque.add((NavBackStackEntryState) ((Parcelable) a11.next()));
                        }
                        map.put(str, arrayDeque);
                    }
                }
            }
            this.f10258g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
        }
    }

    public final boolean g0(int i11, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
        if (!this.f10266o.containsKey(Integer.valueOf(i11))) {
            return false;
        }
        String str = this.f10266o.get(Integer.valueOf(i11));
        boolean unused = CollectionsKt__MutableCollectionsKt.F(this.f10266o.values(), new NavController$restoreStateInternal$1(str));
        return v(K((ArrayDeque) TypeIntrinsics.d(this.f10267p).remove(str)), bundle, navOptions, aVar);
    }

    public Bundle h0() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this.f10275x.e().entrySet()) {
            String str = (String) next.getKey();
            Bundle i11 = ((Navigator) next.getValue()).i();
            if (i11 != null) {
                arrayList.add(str);
                bundle2.putBundle(str, i11);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.f10259h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f10259h.size()];
            Iterator<NavBackStackEntry> it2 = this.f10259h.iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                parcelableArr[i12] = new NavBackStackEntryState(it2.next());
                i12++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.f10266o.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.f10266o.size()];
            ArrayList arrayList2 = new ArrayList();
            int i13 = 0;
            for (Map.Entry next2 : this.f10266o.entrySet()) {
                iArr[i13] = ((Number) next2.getKey()).intValue();
                arrayList2.add((String) next2.getValue());
                i13++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.f10267p.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry next3 : this.f10267p.entrySet()) {
                String str2 = (String) next3.getKey();
                ArrayDeque arrayDeque = (ArrayDeque) next3.getValue();
                arrayList3.add(str2);
                Parcelable[] parcelableArr2 = new Parcelable[arrayDeque.size()];
                int i14 = 0;
                for (Object next4 : arrayDeque) {
                    int i15 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt__CollectionsKt.t();
                    }
                    parcelableArr2[i14] = (NavBackStackEntryState) next4;
                    i14 = i15;
                }
                bundle.putParcelableArray("android-support-nav:controller:backStackStates:" + str2, parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.f10258g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f10258g);
        }
        return bundle;
    }

    public void i0(int i11) {
        k0(H().b(i11), (Bundle) null);
    }

    public void j0(int i11, Bundle bundle) {
        k0(H().b(i11), bundle);
    }

    public void k0(NavGraph navGraph, Bundle bundle) {
        if (!x.b(this.f10255d, navGraph)) {
            NavGraph navGraph2 = this.f10255d;
            if (navGraph2 != null) {
                for (Integer intValue : new ArrayList(this.f10266o.keySet())) {
                    s(intValue.intValue());
                }
                b0(this, navGraph2.l(), true, false, 4, (Object) null);
            }
            this.f10255d = navGraph;
            U(bundle);
            return;
        }
        int p11 = navGraph.F().p();
        for (int i11 = 0; i11 < p11; i11++) {
            int l11 = this.f10255d.F().l(i11);
            this.f10255d.F().o(l11, navGraph.F().q(i11));
        }
        for (NavBackStackEntry navBackStackEntry : this.f10259h) {
            List<NavDestination> M = CollectionsKt__ReversedViewsKt.M(SequencesKt___SequencesKt.w(NavDestination.f10313k.c(navBackStackEntry.e())));
            NavDestination navDestination = this.f10255d;
            for (NavDestination navDestination2 : M) {
                if ((!x.b(navDestination2, this.f10255d) || !x.b(navDestination, navGraph)) && (navDestination instanceof NavGraph)) {
                    navDestination = ((NavGraph) navDestination).B(navDestination2.l());
                }
            }
            navBackStackEntry.j(navDestination);
        }
    }

    public void l0(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (!x.b(lifecycleOwner, this.f10268q)) {
            LifecycleOwner lifecycleOwner2 = this.f10268q;
            if (!(lifecycleOwner2 == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null)) {
                lifecycle.d(this.f10272u);
            }
            this.f10268q = lifecycleOwner;
            lifecycleOwner.getLifecycle().a(this.f10272u);
        }
    }

    public void m0(ViewModelStore viewModelStore) {
        NavControllerViewModel navControllerViewModel = this.f10269r;
        NavControllerViewModel.b bVar = NavControllerViewModel.f10281c;
        if (!x.b(navControllerViewModel, bVar.a(viewModelStore))) {
            if (this.f10259h.isEmpty()) {
                this.f10269r = bVar.a(viewModelStore);
                return;
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
    }

    public final NavBackStackEntry n0(NavBackStackEntry navBackStackEntry) {
        NavBackStackEntry remove = this.f10264m.remove(navBackStackEntry);
        Integer num = null;
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.f10265n.get(remove);
        if (atomicInteger != null) {
            num = Integer.valueOf(atomicInteger.decrementAndGet());
        }
        if (num != null && num.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.f10276y.get(this.f10275x.d(remove.e().n()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.e(remove);
            }
            this.f10265n.remove(remove);
        }
        return remove;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r7 = (r7 = r7.c()).getValue();
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o0() {
        /*
            r11 = this;
            kotlin.collections.ArrayDeque<androidx.navigation.NavBackStackEntry> r0 = r11.f10259h
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r0)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.NavDestination r1 = r1.e()
            boolean r2 = r1 instanceof androidx.navigation.a
            r3 = 0
            if (r2 == 0) goto L_0x003d
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.u0(r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x0024:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x003d
            java.lang.Object r4 = r2.next()
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.e()
            boolean r5 = r4 instanceof androidx.navigation.NavGraph
            if (r5 != 0) goto L_0x0024
            boolean r5 = r4 instanceof androidx.navigation.a
            if (r5 != 0) goto L_0x0024
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.u0(r0)
            java.util.Iterator r5 = r5.iterator()
        L_0x004b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00f5
            java.lang.Object r6 = r5.next()
            androidx.navigation.NavBackStackEntry r6 = (androidx.navigation.NavBackStackEntry) r6
            androidx.lifecycle.Lifecycle$State r7 = r6.g()
            androidx.navigation.NavDestination r8 = r6.e()
            if (r1 == 0) goto L_0x00cb
            int r9 = r8.l()
            int r10 = r1.l()
            if (r9 != r10) goto L_0x00cb
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 == r8) goto L_0x00c6
            androidx.navigation.NavigatorProvider r7 = r11.I()
            androidx.navigation.NavDestination r9 = r6.e()
            java.lang.String r9 = r9.n()
            androidx.navigation.Navigator r7 = r7.d(r9)
            java.util.Map<androidx.navigation.Navigator<? extends androidx.navigation.NavDestination>, androidx.navigation.NavController$NavControllerNavigatorState> r9 = r11.f10276y
            java.lang.Object r7 = r9.get(r7)
            androidx.navigation.NavController$NavControllerNavigatorState r7 = (androidx.navigation.NavController.NavControllerNavigatorState) r7
            if (r7 == 0) goto L_0x00a0
            kotlinx.coroutines.flow.j1 r7 = r7.c()
            if (r7 == 0) goto L_0x00a0
            java.lang.Object r7 = r7.getValue()
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L_0x00a0
            boolean r7 = r7.contains(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x00a1
        L_0x00a0:
            r7 = r3
        L_0x00a1:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.jvm.internal.x.b(r7, r9)
            if (r7 != 0) goto L_0x00c1
            java.util.Map<androidx.navigation.NavBackStackEntry, java.util.concurrent.atomic.AtomicInteger> r7 = r11.f10265n
            java.lang.Object r7 = r7.get(r6)
            java.util.concurrent.atomic.AtomicInteger r7 = (java.util.concurrent.atomic.AtomicInteger) r7
            r9 = 0
            if (r7 == 0) goto L_0x00bb
            int r7 = r7.get()
            if (r7 != 0) goto L_0x00bb
            r9 = 1
        L_0x00bb:
            if (r9 != 0) goto L_0x00c1
            r2.put(r6, r8)
            goto L_0x00c6
        L_0x00c1:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r2.put(r6, r7)
        L_0x00c6:
            androidx.navigation.NavGraph r1 = r1.o()
            goto L_0x004b
        L_0x00cb:
            if (r4 == 0) goto L_0x00ee
            int r8 = r8.l()
            int r9 = r4.l()
            if (r8 != r9) goto L_0x00ee
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.RESUMED
            if (r7 != r8) goto L_0x00e1
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.STARTED
            r6.k(r7)
            goto L_0x00e8
        L_0x00e1:
            androidx.lifecycle.Lifecycle$State r8 = androidx.lifecycle.Lifecycle.State.STARTED
            if (r7 == r8) goto L_0x00e8
            r2.put(r6, r8)
        L_0x00e8:
            androidx.navigation.NavGraph r4 = r4.o()
            goto L_0x004b
        L_0x00ee:
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.CREATED
            r6.k(r7)
            goto L_0x004b
        L_0x00f5:
            java.util.Iterator r0 = r0.iterator()
        L_0x00f9:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0115
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            java.lang.Object r3 = r2.get(r1)
            androidx.lifecycle.Lifecycle$State r3 = (androidx.lifecycle.Lifecycle.State) r3
            if (r3 == 0) goto L_0x0111
            r1.k(r3)
            goto L_0x00f9
        L_0x0111:
            r1.l()
            goto L_0x00f9
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.o0():void");
    }

    public final void p(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        NavDestination navDestination2;
        Bundle bundle2;
        ArrayDeque<NavBackStackEntry> arrayDeque;
        boolean z11;
        NavBackStackEntry navBackStackEntry2;
        NavDestination navDestination3;
        NavBackStackEntry navBackStackEntry3;
        NavGraph navGraph;
        NavBackStackEntry navBackStackEntry4;
        Bundle bundle3;
        List<NavBackStackEntry> list2;
        NavDestination navDestination4 = navDestination;
        Bundle bundle4 = bundle;
        NavBackStackEntry navBackStackEntry5 = navBackStackEntry;
        List<NavBackStackEntry> list3 = list;
        NavDestination e11 = navBackStackEntry.e();
        if (!(e11 instanceof a)) {
            while (!this.f10259h.isEmpty() && (this.f10259h.last().e() instanceof a)) {
                if (!b0(this, this.f10259h.last().e().l(), true, false, 4, (Object) null)) {
                    break;
                }
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        boolean z12 = true;
        NavBackStackEntry navBackStackEntry6 = null;
        if (navDestination4 instanceof NavGraph) {
            NavGraph navGraph2 = e11;
            while (true) {
                NavGraph o11 = navGraph2.o();
                if (o11 != null) {
                    ListIterator<NavBackStackEntry> listIterator = list3.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            navBackStackEntry4 = null;
                            break;
                        }
                        navBackStackEntry4 = listIterator.previous();
                        if (x.b(navBackStackEntry4.e(), o11)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry7 = navBackStackEntry4;
                    if (navBackStackEntry7 == null) {
                        navDestination2 = e11;
                        list2 = list3;
                        bundle3 = bundle4;
                        navBackStackEntry2 = navBackStackEntry5;
                        navBackStackEntry7 = NavBackStackEntry.a.b(NavBackStackEntry.f10235p, this.f10252a, o11, bundle, G(), this.f10269r, (String) null, (Bundle) null, 96, (Object) null);
                    } else {
                        navDestination2 = e11;
                        list2 = list3;
                        navBackStackEntry2 = navBackStackEntry5;
                        bundle3 = bundle4;
                    }
                    arrayDeque2.addFirst(navBackStackEntry7);
                    if (!(this.f10259h.isEmpty() ^ z12) || this.f10259h.last().e() != o11) {
                        list3 = list2;
                        bundle2 = bundle3;
                        navGraph = o11;
                        z11 = z12;
                        arrayDeque = arrayDeque2;
                    } else {
                        list3 = list2;
                        bundle2 = bundle3;
                        navGraph = o11;
                        z11 = z12;
                        arrayDeque = arrayDeque2;
                        d0(this, this.f10259h.last(), false, (ArrayDeque) null, 6, (Object) null);
                    }
                } else {
                    navGraph = o11;
                    z11 = z12;
                    arrayDeque = arrayDeque2;
                    navDestination2 = e11;
                    navBackStackEntry2 = navBackStackEntry5;
                    bundle2 = bundle4;
                }
                if (navGraph == null || navGraph == navDestination4) {
                    break;
                }
                navGraph2 = navGraph;
                z12 = z11;
                arrayDeque2 = arrayDeque;
                bundle4 = bundle2;
                e11 = navDestination2;
                navBackStackEntry5 = navBackStackEntry2;
            }
        } else {
            z11 = true;
            arrayDeque = arrayDeque2;
            navDestination2 = e11;
            navBackStackEntry2 = navBackStackEntry5;
            bundle2 = bundle4;
        }
        NavDestination e12 = arrayDeque.isEmpty() ? navDestination2 : ((NavBackStackEntry) arrayDeque.first()).e();
        while (e12 != null && w(e12.l()) != e12) {
            e12 = e12.o();
            if (e12 != null) {
                Bundle bundle5 = (bundle2 == null || bundle.isEmpty() != z11) ? false : z11 ? null : bundle2;
                ListIterator<NavBackStackEntry> listIterator2 = list3.listIterator(list.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        navBackStackEntry3 = null;
                        break;
                    }
                    navBackStackEntry3 = listIterator2.previous();
                    if (x.b(navBackStackEntry3.e(), e12)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry8 = navBackStackEntry3;
                if (navBackStackEntry8 == null) {
                    navBackStackEntry8 = NavBackStackEntry.a.b(NavBackStackEntry.f10235p, this.f10252a, e12, e12.d(bundle5), G(), this.f10269r, (String) null, (Bundle) null, 96, (Object) null);
                }
                arrayDeque.addFirst(navBackStackEntry8);
            }
        }
        if (arrayDeque.isEmpty()) {
            navDestination3 = navDestination2;
        } else {
            navDestination3 = ((NavBackStackEntry) arrayDeque.first()).e();
        }
        while (!this.f10259h.isEmpty() && (this.f10259h.last().e() instanceof NavGraph) && ((NavGraph) this.f10259h.last().e()).C(navDestination3.l(), false) == null) {
            d0(this, this.f10259h.last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry d11 = this.f10259h.d();
        if (d11 == null) {
            d11 = (NavBackStackEntry) arrayDeque.d();
        }
        if (!x.b(d11 != null ? d11.e() : null, this.f10255d)) {
            ListIterator<NavBackStackEntry> listIterator3 = list3.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                NavBackStackEntry previous = listIterator3.previous();
                if (x.b(previous.e(), this.f10255d)) {
                    navBackStackEntry6 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry9 = navBackStackEntry6;
            if (navBackStackEntry9 == null) {
                navBackStackEntry9 = NavBackStackEntry.a.b(NavBackStackEntry.f10235p, this.f10252a, this.f10255d, this.f10255d.d(bundle2), G(), this.f10269r, (String) null, (Bundle) null, 96, (Object) null);
            }
            arrayDeque.addFirst(navBackStackEntry9);
        }
        for (NavBackStackEntry navBackStackEntry10 : arrayDeque) {
            NavControllerNavigatorState navControllerNavigatorState = this.f10276y.get(this.f10275x.d(navBackStackEntry10.e().n()));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.o(navBackStackEntry10);
            } else {
                throw new IllegalStateException(("NavigatorBackStack for " + navDestination.n() + " should already be created").toString());
            }
        }
        this.f10259h.addAll(arrayDeque);
        this.f10259h.add(navBackStackEntry2);
        for (NavBackStackEntry navBackStackEntry11 : CollectionsKt___CollectionsKt.r0(arrayDeque, navBackStackEntry2)) {
            NavGraph o12 = navBackStackEntry11.e().o();
            if (o12 != null) {
                N(navBackStackEntry11, z(o12.l()));
            }
        }
    }

    public final void p0() {
        o oVar = this.f10273v;
        boolean z11 = true;
        if (!this.f10274w || E() <= 1) {
            z11 = false;
        }
        oVar.setEnabled(z11);
    }

    public void r(b bVar) {
        this.f10270s.add(bVar);
        if (!this.f10259h.isEmpty()) {
            NavBackStackEntry last = this.f10259h.last();
            bVar.a(this, last.e(), last.c());
        }
    }

    public final boolean s(int i11) {
        for (NavControllerNavigatorState m11 : this.f10276y.values()) {
            m11.m(true);
        }
        boolean g02 = g0(i11, (Bundle) null, j.a(NavController$clearBackStackInternal$restored$1.INSTANCE), (Navigator.a) null);
        for (NavControllerNavigatorState m12 : this.f10276y.values()) {
            m12.m(false);
        }
        if (!g02 || !a0(i11, true, false)) {
            return false;
        }
        return true;
    }

    public final boolean t() {
        while (!this.f10259h.isEmpty() && (this.f10259h.last().e() instanceof NavGraph)) {
            d0(this, this.f10259h.last(), false, (ArrayDeque) null, 6, (Object) null);
        }
        NavBackStackEntry h11 = this.f10259h.h();
        if (h11 != null) {
            this.D.add(h11);
        }
        this.C++;
        o0();
        int i11 = this.C - 1;
        this.C = i11;
        if (i11 == 0) {
            List<NavBackStackEntry> L0 = CollectionsKt___CollectionsKt.L0(this.D);
            this.D.clear();
            for (NavBackStackEntry navBackStackEntry : L0) {
                Iterator<b> it2 = this.f10270s.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, navBackStackEntry.e(), navBackStackEntry.c());
                }
                this.F.d(navBackStackEntry);
            }
            this.f10260i.d(CollectionsKt___CollectionsKt.L0(this.f10259h));
            this.f10262k.d(e0());
        }
        if (h11 != null) {
            return true;
        }
        return false;
    }

    public final boolean u(List<? extends Navigator<?>> list, NavDestination navDestination, boolean z11, boolean z12) {
        boolean z13 = z12;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Navigator Z : list) {
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            Z(Z, this.f10259h.last(), z13, new NavController$executePopOperations$1(ref$BooleanRef2, ref$BooleanRef, this, z12, arrayDeque));
            if (!ref$BooleanRef2.element) {
                break;
            }
        }
        if (z13) {
            if (!z11) {
                for (NavDestination l11 : SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.g(navDestination, NavController$executePopOperations$2.INSTANCE), new NavController$executePopOperations$3(this))) {
                    Map<Integer, String> map = this.f10266o;
                    Integer valueOf = Integer.valueOf(l11.l());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) arrayDeque.d();
                    map.put(valueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!arrayDeque.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) arrayDeque.first();
                for (NavDestination l12 : SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.g(w(navBackStackEntryState2.getDestinationId()), NavController$executePopOperations$5.INSTANCE), new NavController$executePopOperations$6(this))) {
                    this.f10266o.put(Integer.valueOf(l12.l()), navBackStackEntryState2.getId());
                }
                this.f10267p.put(navBackStackEntryState2.getId(), arrayDeque);
            }
        }
        p0();
        return ref$BooleanRef.element;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r4 = (r4 = (androidx.navigation.NavBackStackEntry) kotlin.collections.CollectionsKt___CollectionsKt.m0(r3)).e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean v(java.util.List<androidx.navigation.NavBackStackEntry> r12, android.os.Bundle r13, androidx.navigation.NavOptions r14, androidx.navigation.Navigator.a r15) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r12.iterator()
        L_0x000e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.e()
            boolean r4 = r4 instanceof androidx.navigation.NavGraph
            if (r4 != 0) goto L_0x000e
            r1.add(r3)
            goto L_0x000e
        L_0x0027:
            java.util.Iterator r1 = r1.iterator()
        L_0x002b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0073
            java.lang.Object r2 = r1.next()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r0)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0052
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r3)
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            if (r4 == 0) goto L_0x0052
            androidx.navigation.NavDestination r4 = r4.e()
            if (r4 == 0) goto L_0x0052
            java.lang.String r4 = r4.n()
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            androidx.navigation.NavDestination r5 = r2.e()
            java.lang.String r5 = r5.n()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
            if (r4 == 0) goto L_0x0065
            r3.add(r2)
            goto L_0x002b
        L_0x0065:
            r3 = 1
            androidx.navigation.NavBackStackEntry[] r3 = new androidx.navigation.NavBackStackEntry[r3]
            r4 = 0
            r3[r4] = r2
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.p(r3)
            r0.add(r2)
            goto L_0x002b
        L_0x0073:
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x007c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b5
            java.lang.Object r2 = r0.next()
            java.util.List r2 = (java.util.List) r2
            androidx.navigation.NavigatorProvider r3 = r11.f10275x
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r2)
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            androidx.navigation.NavDestination r4 = r4.e()
            java.lang.String r4 = r4.n()
            androidx.navigation.Navigator r9 = r3.d(r4)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            androidx.navigation.NavController$executeRestoreState$3 r10 = new androidx.navigation.NavController$executeRestoreState$3
            r3 = r10
            r4 = r1
            r5 = r12
            r7 = r11
            r8 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = r11
            r4 = r9
            r5 = r2
            r6 = r14
            r7 = r15
            r8 = r10
            r3.T(r4, r5, r6, r7, r8)
            goto L_0x007c
        L_0x00b5:
            boolean r12 = r1.element
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.v(java.util.List, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$a):boolean");
    }

    public final NavDestination w(int i11) {
        NavDestination navDestination;
        NavGraph navGraph = this.f10255d;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.l() == i11) {
            return this.f10255d;
        }
        NavBackStackEntry h11 = this.f10259h.h();
        if (h11 == null || (navDestination = h11.e()) == null) {
            navDestination = this.f10255d;
        }
        return x(navDestination, i11);
    }

    public final NavDestination x(NavDestination navDestination, int i11) {
        if (navDestination.l() == i11) {
            return navDestination;
        }
        return (navDestination instanceof NavGraph ? (NavGraph) navDestination : navDestination.o()).B(i11);
    }

    public final String y(int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.f10255d;
        int length = iArr.length;
        int i11 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i11 >= length) {
                return null;
            }
            int i12 = iArr[i11];
            if (i11 != 0) {
                navDestination = navGraph2.B(i12);
            } else if (this.f10255d.l() == i12) {
                navDestination = this.f10255d;
            }
            if (navDestination == null) {
                return NavDestination.f10313k.b(this.f10252a, i12);
            }
            if (i11 != iArr.length - 1 && (navDestination instanceof NavGraph)) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.B(navGraph.H()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.B(navGraph.H());
                }
                navGraph2 = navGraph;
            }
            i11++;
        }
    }

    public NavBackStackEntry z(int i11) {
        NavBackStackEntry navBackStackEntry;
        boolean z11;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.f10259h;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.e().l() == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        throw new IllegalArgumentException(("No destination with ID " + i11 + " is on the NavController's back stack. The current destination is " + D()).toString());
    }
}
