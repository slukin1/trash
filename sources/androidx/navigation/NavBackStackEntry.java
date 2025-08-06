package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.h0;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import java.util.Set;
import java.util.UUID;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class NavBackStackEntry implements LifecycleOwner, q0, o, androidx.savedstate.c {

    /* renamed from: p  reason: collision with root package name */
    public static final a f10235p = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final Context f10236b;

    /* renamed from: c  reason: collision with root package name */
    public NavDestination f10237c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f10238d;

    /* renamed from: e  reason: collision with root package name */
    public Lifecycle.State f10239e;

    /* renamed from: f  reason: collision with root package name */
    public final l f10240f;

    /* renamed from: g  reason: collision with root package name */
    public final String f10241g;

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f10242h;

    /* renamed from: i  reason: collision with root package name */
    public LifecycleRegistry f10243i;

    /* renamed from: j  reason: collision with root package name */
    public final SavedStateRegistryController f10244j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f10245k;

    /* renamed from: l  reason: collision with root package name */
    public final i f10246l;

    /* renamed from: m  reason: collision with root package name */
    public final i f10247m;

    /* renamed from: n  reason: collision with root package name */
    public Lifecycle.State f10248n;

    /* renamed from: o  reason: collision with root package name */
    public final ViewModelProvider.Factory f10249o;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(a aVar, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, l lVar, String str, Bundle bundle2, int i11, Object obj) {
            return aVar.a(context, navDestination, (i11 & 4) != 0 ? null : bundle, (i11 & 8) != 0 ? Lifecycle.State.CREATED : state, (i11 & 16) != 0 ? null : lVar, (i11 & 32) != 0 ? UUID.randomUUID().toString() : str, (i11 & 64) != 0 ? null : bundle2);
        }

        public final NavBackStackEntry a(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, l lVar, String str, Bundle bundle2) {
            return new NavBackStackEntry(context, navDestination, bundle, state, lVar, str, bundle2, (r) null);
        }
    }

    public static final class b extends AbstractSavedStateViewModelFactory {
        public b(androidx.savedstate.c cVar) {
            super(cVar, (Bundle) null);
        }

        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            return new c(savedStateHandle);
        }
    }

    public static final class c extends ViewModel {

        /* renamed from: a  reason: collision with root package name */
        public final SavedStateHandle f10250a;

        public c(SavedStateHandle savedStateHandle) {
            this.f10250a = savedStateHandle;
        }

        public final SavedStateHandle h0() {
            return this.f10250a;
        }
    }

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, l lVar, String str, Bundle bundle2) {
        this.f10236b = context;
        this.f10237c = navDestination;
        this.f10238d = bundle;
        this.f10239e = state;
        this.f10240f = lVar;
        this.f10241g = str;
        this.f10242h = bundle2;
        this.f10243i = new LifecycleRegistry(this);
        this.f10244j = SavedStateRegistryController.f10939d.a(this);
        this.f10246l = LazyKt__LazyJVMKt.a(new NavBackStackEntry$defaultFactory$2(this));
        this.f10247m = LazyKt__LazyJVMKt.a(new NavBackStackEntry$savedStateHandle$2(this));
        this.f10248n = Lifecycle.State.INITIALIZED;
        this.f10249o = d();
    }

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, l lVar, String str, Bundle bundle2, r rVar) {
        this(context, navDestination, bundle, state, lVar, str, bundle2);
    }

    public final Bundle c() {
        if (this.f10238d == null) {
            return null;
        }
        return new Bundle(this.f10238d);
    }

    public final SavedStateViewModelFactory d() {
        return (SavedStateViewModelFactory) this.f10246l.getValue();
    }

    public final NavDestination e() {
        return this.f10237c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0087
            boolean r1 = r7 instanceof androidx.navigation.NavBackStackEntry
            if (r1 != 0) goto L_0x0009
            goto L_0x0087
        L_0x0009:
            java.lang.String r1 = r6.f10241g
            androidx.navigation.NavBackStackEntry r7 = (androidx.navigation.NavBackStackEntry) r7
            java.lang.String r2 = r7.f10241g
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            r2 = 1
            if (r1 == 0) goto L_0x0087
            androidx.navigation.NavDestination r1 = r6.f10237c
            androidx.navigation.NavDestination r3 = r7.f10237c
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x0087
            androidx.lifecycle.Lifecycle r1 = r6.getLifecycle()
            androidx.lifecycle.Lifecycle r3 = r7.getLifecycle()
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x0087
            androidx.savedstate.SavedStateRegistry r1 = r6.getSavedStateRegistry()
            androidx.savedstate.SavedStateRegistry r3 = r7.getSavedStateRegistry()
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x0087
            android.os.Bundle r1 = r6.f10238d
            android.os.Bundle r3 = r7.f10238d
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 != 0) goto L_0x0086
            android.os.Bundle r1 = r6.f10238d
            if (r1 == 0) goto L_0x0083
            java.util.Set r1 = r1.keySet()
            if (r1 == 0) goto L_0x0083
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0058
        L_0x0056:
            r7 = r2
            goto L_0x007f
        L_0x0058:
            java.util.Iterator r1 = r1.iterator()
        L_0x005c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = r6.f10238d
            java.lang.Object r4 = r4.get(r3)
            android.os.Bundle r5 = r7.f10238d
            if (r5 == 0) goto L_0x0077
            java.lang.Object r3 = r5.get(r3)
            goto L_0x0078
        L_0x0077:
            r3 = 0
        L_0x0078:
            boolean r3 = kotlin.jvm.internal.x.b(r4, r3)
            if (r3 != 0) goto L_0x005c
            r7 = r0
        L_0x007f:
            if (r7 != r2) goto L_0x0083
            r7 = r2
            goto L_0x0084
        L_0x0083:
            r7 = r0
        L_0x0084:
            if (r7 == 0) goto L_0x0087
        L_0x0086:
            r0 = r2
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavBackStackEntry.equals(java.lang.Object):boolean");
    }

    public final String f() {
        return this.f10241g;
    }

    public final Lifecycle.State g() {
        return this.f10248n;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application = null;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) null, 1, (r) null);
        Context context = this.f10236b;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext instanceof Application) {
            application = (Application) applicationContext;
        }
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f9964h, application);
        }
        mutableCreationExtras.c(h0.f10007a, this);
        mutableCreationExtras.c(h0.f10008b, this);
        Bundle c11 = c();
        if (c11 != null) {
            mutableCreationExtras.c(h0.f10009c, c11);
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return this.f10249o;
    }

    public Lifecycle getLifecycle() {
        return this.f10243i;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.f10244j.b();
    }

    public ViewModelStore getViewModelStore() {
        if (this.f10245k) {
            if (getLifecycle().b() != Lifecycle.State.DESTROYED) {
                l lVar = this.f10240f;
                if (lVar != null) {
                    return lVar.g(this.f10241g);
                }
                throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
    }

    public final void h(Lifecycle.Event event) {
        this.f10239e = event.getTargetState();
        l();
    }

    public int hashCode() {
        Set<String> keySet;
        int hashCode = (this.f10241g.hashCode() * 31) + this.f10237c.hashCode();
        Bundle bundle = this.f10238d;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i11 = hashCode * 31;
                Object obj = this.f10238d.get(str);
                hashCode = i11 + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (((hashCode * 31) + getLifecycle().hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void i(Bundle bundle) {
        this.f10244j.e(bundle);
    }

    public final void j(NavDestination navDestination) {
        this.f10237c = navDestination;
    }

    public final void k(Lifecycle.State state) {
        this.f10248n = state;
        l();
    }

    public final void l() {
        if (!this.f10245k) {
            this.f10244j.c();
            this.f10245k = true;
            if (this.f10240f != null) {
                h0.c(this);
            }
            this.f10244j.d(this.f10242h);
        }
        if (this.f10239e.ordinal() < this.f10248n.ordinal()) {
            this.f10243i.o(this.f10239e);
        } else {
            this.f10243i.o(this.f10248n);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(NavBackStackEntry.class.getSimpleName());
        sb2.append('(' + this.f10241g + ')');
        sb2.append(" destination=");
        sb2.append(this.f10237c);
        return sb2.toString();
    }

    public NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle) {
        this(navBackStackEntry.f10236b, navBackStackEntry.f10237c, bundle, navBackStackEntry.f10239e, navBackStackEntry.f10240f, navBackStackEntry.f10241g, navBackStackEntry.f10242h);
        this.f10239e = navBackStackEntry.f10239e;
        k(navBackStackEntry.f10248n);
    }
}
