package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Navigator.b("dialog")
public final class b extends Navigator<C0051b> {

    /* renamed from: h  reason: collision with root package name */
    public static final a f10417h = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public final Context f10418c;

    /* renamed from: d  reason: collision with root package name */
    public final FragmentManager f10419d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f10420e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public final c f10421f = new c(this);

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, DialogFragment> f10422g = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* renamed from: androidx.navigation.fragment.b$b  reason: collision with other inner class name */
    public static class C0051b extends NavDestination implements androidx.navigation.a {

        /* renamed from: m  reason: collision with root package name */
        public String f10423m;

        public C0051b(Navigator<? extends C0051b> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
        }

        public final String A() {
            String str = this.f10423m;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set".toString());
        }

        public final C0051b B(String str) {
            this.f10423m = str;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C0051b) || !super.equals(obj) || !x.b(this.f10423m, ((C0051b) obj).f10423m)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this.f10423m;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public void u(Context context, AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                B(string);
            }
            obtainAttributes.recycle();
        }
    }

    public static final class c implements androidx.lifecycle.r {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f10424b;

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f10425a;

            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            static {
                /*
                    androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    f10425a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.b.c.a.<clinit>():void");
            }
        }

        public c(b bVar) {
            this.f10424b = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: androidx.navigation.NavBackStackEntry} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onStateChanged(androidx.lifecycle.LifecycleOwner r7, androidx.lifecycle.Lifecycle.Event r8) {
            /*
                r6 = this;
                int[] r0 = androidx.navigation.fragment.b.c.a.f10425a
                int r8 = r8.ordinal()
                r8 = r0[r8]
                r0 = 1
                r1 = 0
                if (r8 == r0) goto L_0x0116
                r0 = 2
                r2 = 0
                if (r8 == r0) goto L_0x00d5
                r0 = 3
                if (r8 == r0) goto L_0x0061
                r0 = 4
                if (r8 == r0) goto L_0x0018
                goto L_0x015a
            L_0x0018:
                androidx.fragment.app.DialogFragment r7 = (androidx.fragment.app.DialogFragment) r7
                androidx.navigation.fragment.b r8 = r6.f10424b
                androidx.navigation.NavigatorState r8 = r8.b()
                kotlinx.coroutines.flow.j1 r8 = r8.c()
                java.lang.Object r8 = r8.getValue()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r8 = r8.iterator()
            L_0x002e:
                boolean r0 = r8.hasNext()
                if (r0 == 0) goto L_0x004b
                java.lang.Object r0 = r8.next()
                r1 = r0
                androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
                java.lang.String r1 = r1.f()
                java.lang.String r3 = r7.getTag()
                boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
                if (r1 == 0) goto L_0x002e
                r2 = r0
                goto L_0x002e
            L_0x004b:
                androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
                if (r2 == 0) goto L_0x0058
                androidx.navigation.fragment.b r8 = r6.f10424b
                androidx.navigation.NavigatorState r8 = r8.b()
                r8.e(r2)
            L_0x0058:
                androidx.lifecycle.Lifecycle r7 = r7.getLifecycle()
                r7.d(r6)
                goto L_0x015a
            L_0x0061:
                androidx.fragment.app.DialogFragment r7 = (androidx.fragment.app.DialogFragment) r7
                android.app.Dialog r8 = r7.requireDialog()
                boolean r8 = r8.isShowing()
                if (r8 != 0) goto L_0x015a
                androidx.navigation.fragment.b r8 = r6.f10424b
                androidx.navigation.NavigatorState r8 = r8.b()
                kotlinx.coroutines.flow.j1 r8 = r8.b()
                java.lang.Object r8 = r8.getValue()
                java.util.List r8 = (java.util.List) r8
                int r0 = r8.size()
                java.util.ListIterator r0 = r8.listIterator(r0)
            L_0x0085:
                boolean r3 = r0.hasPrevious()
                if (r3 == 0) goto L_0x00a1
                java.lang.Object r3 = r0.previous()
                r4 = r3
                androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
                java.lang.String r4 = r4.f()
                java.lang.String r5 = r7.getTag()
                boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
                if (r4 == 0) goto L_0x0085
                r2 = r3
            L_0x00a1:
                androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
                java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r8)
                boolean r8 = kotlin.jvm.internal.x.b(r8, r2)
                if (r8 != 0) goto L_0x00c8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "Dialog "
                r8.append(r0)
                r8.append(r7)
                java.lang.String r7 = " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                java.lang.String r8 = "DialogFragmentNavigator"
                android.util.Log.i(r8, r7)
            L_0x00c8:
                if (r2 == 0) goto L_0x015a
                androidx.navigation.fragment.b r7 = r6.f10424b
                androidx.navigation.NavigatorState r7 = r7.b()
                r7.i(r2, r1)
                goto L_0x015a
            L_0x00d5:
                androidx.fragment.app.DialogFragment r7 = (androidx.fragment.app.DialogFragment) r7
                androidx.navigation.fragment.b r8 = r6.f10424b
                androidx.navigation.NavigatorState r8 = r8.b()
                kotlinx.coroutines.flow.j1 r8 = r8.c()
                java.lang.Object r8 = r8.getValue()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r8 = r8.iterator()
            L_0x00eb:
                boolean r0 = r8.hasNext()
                if (r0 == 0) goto L_0x0108
                java.lang.Object r0 = r8.next()
                r1 = r0
                androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
                java.lang.String r1 = r1.f()
                java.lang.String r3 = r7.getTag()
                boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
                if (r1 == 0) goto L_0x00eb
                r2 = r0
                goto L_0x00eb
            L_0x0108:
                androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
                if (r2 == 0) goto L_0x015a
                androidx.navigation.fragment.b r7 = r6.f10424b
                androidx.navigation.NavigatorState r7 = r7.b()
                r7.e(r2)
                goto L_0x015a
            L_0x0116:
                androidx.fragment.app.DialogFragment r7 = (androidx.fragment.app.DialogFragment) r7
                androidx.navigation.fragment.b r8 = r6.f10424b
                androidx.navigation.NavigatorState r8 = r8.b()
                kotlinx.coroutines.flow.j1 r8 = r8.b()
                java.lang.Object r8 = r8.getValue()
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                boolean r2 = r8 instanceof java.util.Collection
                if (r2 == 0) goto L_0x0137
                r2 = r8
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0137
            L_0x0135:
                r0 = r1
                goto L_0x0155
            L_0x0137:
                java.util.Iterator r8 = r8.iterator()
            L_0x013b:
                boolean r2 = r8.hasNext()
                if (r2 == 0) goto L_0x0135
                java.lang.Object r2 = r8.next()
                androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
                java.lang.String r2 = r2.f()
                java.lang.String r3 = r7.getTag()
                boolean r2 = kotlin.jvm.internal.x.b(r2, r3)
                if (r2 == 0) goto L_0x013b
            L_0x0155:
                if (r0 != 0) goto L_0x015a
                r7.dismiss()
            L_0x015a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.b.c.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
        }
    }

    public b(Context context, FragmentManager fragmentManager) {
        this.f10418c = context;
        this.f10419d = fragmentManager;
    }

    public static final void q(b bVar, FragmentManager fragmentManager, Fragment fragment) {
        Set<String> set = bVar.f10420e;
        if (TypeIntrinsics.a(set).remove(fragment.getTag())) {
            fragment.getLifecycle().a(bVar.f10421f);
        }
        Map<String, DialogFragment> map = bVar.f10422g;
        TypeIntrinsics.d(map).remove(fragment.getTag());
    }

    public void e(List<NavBackStackEntry> list, NavOptions navOptions, Navigator.a aVar) {
        if (this.f10419d.W0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry p11 : list) {
            p(p11);
        }
    }

    public void f(NavigatorState navigatorState) {
        Lifecycle lifecycle;
        super.f(navigatorState);
        for (NavBackStackEntry navBackStackEntry : navigatorState.b().getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.f10419d.m0(navBackStackEntry.f());
            if (dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null) {
                this.f10420e.add(navBackStackEntry.f());
            } else {
                lifecycle.a(this.f10421f);
            }
        }
        this.f10419d.k(new a(this));
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        if (this.f10419d.W0()) {
            Log.i("DialogFragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        DialogFragment dialogFragment = this.f10422g.get(navBackStackEntry.f());
        if (dialogFragment == null) {
            Fragment m02 = this.f10419d.m0(navBackStackEntry.f());
            dialogFragment = m02 instanceof DialogFragment ? (DialogFragment) m02 : null;
        }
        if (dialogFragment != null) {
            dialogFragment.getLifecycle().d(this.f10421f);
            dialogFragment.dismiss();
        }
        o(navBackStackEntry).show(this.f10419d, navBackStackEntry.f());
        b().g(navBackStackEntry);
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z11) {
        if (this.f10419d.W0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List value = b().b().getValue();
        for (NavBackStackEntry f11 : CollectionsKt___CollectionsKt.u0(value.subList(value.indexOf(navBackStackEntry), value.size()))) {
            Fragment m02 = this.f10419d.m0(f11.f());
            if (m02 != null) {
                ((DialogFragment) m02).dismiss();
            }
        }
        b().i(navBackStackEntry, z11);
    }

    /* renamed from: n */
    public C0051b a() {
        return new C0051b(this);
    }

    public final DialogFragment o(NavBackStackEntry navBackStackEntry) {
        C0051b bVar = (C0051b) navBackStackEntry.e();
        String A = bVar.A();
        if (A.charAt(0) == '.') {
            A = this.f10418c.getPackageName() + A;
        }
        Fragment a11 = this.f10419d.z0().a(this.f10418c.getClassLoader(), A);
        if (DialogFragment.class.isAssignableFrom(a11.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) a11;
            dialogFragment.setArguments(navBackStackEntry.c());
            dialogFragment.getLifecycle().a(this.f10421f);
            this.f10422g.put(navBackStackEntry.f(), dialogFragment);
            return dialogFragment;
        }
        throw new IllegalArgumentException(("Dialog destination " + bVar.A() + " is not an instance of DialogFragment").toString());
    }

    public final void p(NavBackStackEntry navBackStackEntry) {
        o(navBackStackEntry).show(this.f10419d, navBackStackEntry.f());
        b().l(navBackStackEntry);
    }
}
