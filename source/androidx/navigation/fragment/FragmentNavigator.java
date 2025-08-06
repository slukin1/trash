package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.os.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.z;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorState;
import com.iproov.sdk.bridge.OptionsBridge;
import d10.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.f;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

@Navigator.b("fragment")
public class FragmentNavigator extends Navigator<b> {

    /* renamed from: i  reason: collision with root package name */
    public static final a f10397i = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public final Context f10398c;

    /* renamed from: d  reason: collision with root package name */
    public final FragmentManager f10399d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10400e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f10401f = new LinkedHashSet();

    /* renamed from: g  reason: collision with root package name */
    public final androidx.lifecycle.r f10402g = new e(this);

    /* renamed from: h  reason: collision with root package name */
    public final l<NavBackStackEntry, androidx.lifecycle.r> f10403h = new FragmentNavigator$fragmentViewObserver$1(this);

    public static final class ClearEntryStateViewModel extends ViewModel {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d10.a<Unit>> f10404a;

        public final WeakReference<d10.a<Unit>> h0() {
            WeakReference<d10.a<Unit>> weakReference = this.f10404a;
            if (weakReference != null) {
                return weakReference;
            }
            return null;
        }

        public final void i0(WeakReference<d10.a<Unit>> weakReference) {
            this.f10404a = weakReference;
        }

        public void onCleared() {
            super.onCleared();
            d10.a aVar = (d10.a) h0().get();
            if (aVar != null) {
                aVar.invoke();
            }
        }
    }

    public static final class Extras implements Navigator.a {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap<View, String> f10405a;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            public final LinkedHashMap<View, String> f10406a = new LinkedHashMap<>();
        }

        public final Map<View, String> a() {
            return MapsKt__MapsKt.u(this.f10405a);
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static class b extends NavDestination {

        /* renamed from: m  reason: collision with root package name */
        public String f10407m;

        public b(Navigator<? extends b> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
        }

        public final String A() {
            String str = this.f10407m;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set".toString());
        }

        public final b B(String str) {
            this.f10407m = str;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b) || !super.equals(obj) || !x.b(this.f10407m, ((b) obj).f10407m)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            String str = this.f10407m;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            sb2.append(" class=");
            String str = this.f10407m;
            if (str == null) {
                sb2.append(OptionsBridge.NULL_VALUE);
            } else {
                sb2.append(str);
            }
            return sb2.toString();
        }

        public void u(Context context, AttributeSet attributeSet) {
            super.u(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                B(string);
            }
            Unit unit = Unit.f56620a;
            obtainAttributes.recycle();
        }
    }

    public static final class c implements FragmentManager.m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NavigatorState f10408a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentNavigator f10409b;

        public c(NavigatorState navigatorState, FragmentNavigator fragmentNavigator) {
            this.f10408a = navigatorState;
            this.f10409b = fragmentNavigator;
        }

        public void onBackStackChangeCommitted(Fragment fragment, boolean z11) {
            Object obj;
            List q02 = CollectionsKt___CollectionsKt.q0(this.f10408a.b().getValue(), this.f10408a.c().getValue());
            ListIterator listIterator = q02.listIterator(q02.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    obj = null;
                    break;
                }
                obj = listIterator.previous();
                if (x.b(((NavBackStackEntry) obj).f(), fragment.getTag())) {
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (!z11 && navBackStackEntry == null) {
                throw new IllegalArgumentException(("The fragment " + fragment + " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.").toString());
            } else if (navBackStackEntry != null) {
                this.f10409b.p(fragment, navBackStackEntry, this.f10408a);
                if (z11 && this.f10409b.u().isEmpty() && fragment.isRemoving()) {
                    this.f10408a.i(navBackStackEntry, false);
                }
            }
        }

        public void onBackStackChangeStarted(Fragment fragment, boolean z11) {
            Object obj;
            if (z11) {
                List value = this.f10408a.b().getValue();
                ListIterator listIterator = value.listIterator(value.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    if (x.b(((NavBackStackEntry) obj).f(), fragment.getTag())) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (navBackStackEntry != null) {
                    this.f10408a.j(navBackStackEntry);
                }
            }
        }

        public void onBackStackChanged() {
        }
    }

    public static final class d implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f10410b;

        public d(l lVar) {
            this.f10410b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f10410b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f10410b.invoke(obj);
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i11) {
        this.f10398c = context;
        this.f10399d = fragmentManager;
        this.f10400e = i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: androidx.navigation.NavBackStackEntry} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void t(androidx.navigation.fragment.FragmentNavigator r4, androidx.lifecycle.LifecycleOwner r5, androidx.lifecycle.Lifecycle.Event r6) {
        /*
            androidx.lifecycle.Lifecycle$Event r0 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r6 != r0) goto L_0x0055
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            androidx.navigation.NavigatorState r6 = r4.b()
            kotlinx.coroutines.flow.j1 r6 = r6.c()
            java.lang.Object r6 = r6.getValue()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r0 = 0
            java.util.Iterator r6 = r6.iterator()
        L_0x0019:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r6.next()
            r2 = r1
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            java.lang.String r2 = r2.f()
            java.lang.String r3 = r5.getTag()
            boolean r2 = kotlin.jvm.internal.x.b(r2, r3)
            if (r2 == 0) goto L_0x0019
            r0 = r1
            goto L_0x0019
        L_0x0036:
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            if (r0 == 0) goto L_0x0055
            androidx.navigation.NavigatorState r5 = r4.b()
            kotlinx.coroutines.flow.j1 r5 = r5.b()
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            boolean r5 = r5.contains(r0)
            if (r5 != 0) goto L_0x0055
            androidx.navigation.NavigatorState r4 = r4.b()
            r4.e(r0)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.t(androidx.navigation.fragment.FragmentNavigator, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }

    public static final void w(NavigatorState navigatorState, FragmentNavigator fragmentNavigator, FragmentManager fragmentManager, Fragment fragment) {
        Object obj;
        List value = navigatorState.b().getValue();
        ListIterator listIterator = value.listIterator(value.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (x.b(((NavBackStackEntry) obj).f(), fragment.getTag())) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            fragmentNavigator.q(navBackStackEntry, fragment);
            fragmentNavigator.p(fragment, navBackStackEntry, navigatorState);
        }
    }

    public void e(List<NavBackStackEntry> list, NavOptions navOptions, Navigator.a aVar) {
        if (this.f10399d.W0()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry v11 : list) {
            v(v11, navOptions, aVar);
        }
    }

    public void f(NavigatorState navigatorState) {
        super.f(navigatorState);
        this.f10399d.k(new d(navigatorState, this));
        this.f10399d.l(new c(navigatorState, this));
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        if (this.f10399d.W0()) {
            Log.i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        FragmentTransaction s11 = s(navBackStackEntry, (NavOptions) null);
        if (b().b().getValue().size() > 1) {
            this.f10399d.l1(navBackStackEntry.f(), 1);
            s11.h(navBackStackEntry.f());
        }
        s11.j();
        b().f(navBackStackEntry);
    }

    public void h(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.f10401f.clear();
            boolean unused = CollectionsKt__MutableCollectionsKt.A(this.f10401f, stringArrayList);
        }
    }

    public Bundle i() {
        if (this.f10401f.isEmpty()) {
            return null;
        }
        return e.a(kotlin.l.a("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.f10401f)));
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z11) {
        if (this.f10399d.W0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List value = b().b().getValue();
        List subList = value.subList(value.indexOf(navBackStackEntry), value.size());
        if (z11) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt___CollectionsKt.a0(value);
            for (NavBackStackEntry navBackStackEntry3 : CollectionsKt___CollectionsKt.u0(subList)) {
                if (x.b(navBackStackEntry3, navBackStackEntry2)) {
                    Log.i("FragmentNavigator", "FragmentManager cannot save the state of the initial destination " + navBackStackEntry3);
                } else {
                    this.f10399d.B1(navBackStackEntry3.f());
                    this.f10401f.add(navBackStackEntry3.f());
                }
            }
        } else {
            this.f10399d.l1(navBackStackEntry.f(), 1);
        }
        b().i(navBackStackEntry, z11);
    }

    public final void p(Fragment fragment, NavBackStackEntry navBackStackEntry, NavigatorState navigatorState) {
        Class cls = ClearEntryStateViewModel.class;
        ViewModelStore viewModelStore = fragment.getViewModelStore();
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.a(Reflection.b(cls), FragmentNavigator$attachClearViewModel$viewModel$1$1.INSTANCE);
        ((ClearEntryStateViewModel) new ViewModelProvider(viewModelStore, initializerViewModelFactoryBuilder.b(), CreationExtras.a.f10040b).a(cls)).i0(new WeakReference(new FragmentNavigator$attachClearViewModel$1(navBackStackEntry, navigatorState)));
    }

    public final void q(NavBackStackEntry navBackStackEntry, Fragment fragment) {
        fragment.getViewLifecycleOwnerLiveData().observe(fragment, new d(new FragmentNavigator$attachObservers$1(this, fragment, navBackStackEntry)));
        fragment.getLifecycle().a(this.f10402g);
    }

    /* renamed from: r */
    public b a() {
        return new b(this);
    }

    public final FragmentTransaction s(NavBackStackEntry navBackStackEntry, NavOptions navOptions) {
        Bundle c11 = navBackStackEntry.c();
        String A = ((b) navBackStackEntry.e()).A();
        int i11 = 0;
        if (A.charAt(0) == '.') {
            A = this.f10398c.getPackageName() + A;
        }
        Fragment a11 = this.f10399d.z0().a(this.f10398c.getClassLoader(), A);
        a11.setArguments(c11);
        FragmentTransaction q11 = this.f10399d.q();
        int a12 = navOptions != null ? navOptions.a() : -1;
        int b11 = navOptions != null ? navOptions.b() : -1;
        int c12 = navOptions != null ? navOptions.c() : -1;
        int d11 = navOptions != null ? navOptions.d() : -1;
        if (!(a12 == -1 && b11 == -1 && c12 == -1 && d11 == -1)) {
            if (a12 == -1) {
                a12 = 0;
            }
            if (b11 == -1) {
                b11 = 0;
            }
            if (c12 == -1) {
                c12 = 0;
            }
            if (d11 != -1) {
                i11 = d11;
            }
            q11.w(a12, b11, c12, i11);
        }
        q11.u(this.f10400e, a11, navBackStackEntry.f());
        q11.y(a11);
        q11.z(true);
        return q11;
    }

    public final Set<String> u() {
        Set<NavBackStackEntry> g11 = SetsKt___SetsKt.g(b().c().getValue(), CollectionsKt___CollectionsKt.N0(b().b().getValue()));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
        for (NavBackStackEntry f11 : g11) {
            arrayList.add(f11.f());
        }
        return CollectionsKt___CollectionsKt.N0(arrayList);
    }

    public final void v(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.a aVar) {
        boolean isEmpty = b().b().getValue().isEmpty();
        if (navOptions != null && !isEmpty && navOptions.i() && this.f10401f.remove(navBackStackEntry.f())) {
            this.f10399d.w1(navBackStackEntry.f());
            b().l(navBackStackEntry);
            return;
        }
        FragmentTransaction s11 = s(navBackStackEntry, navOptions);
        if (!isEmpty) {
            s11.h(navBackStackEntry.f());
        }
        if (aVar instanceof Extras) {
            for (Map.Entry next : ((Extras) aVar).a().entrySet()) {
                s11.g((View) next.getKey(), (String) next.getValue());
            }
        }
        s11.j();
        b().l(navBackStackEntry);
    }
}
