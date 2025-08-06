package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDeepLink;
import androidx.navigation.common.R$styleable;
import androidx.navigation.e;
import i0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;

public class NavDestination {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f10313k = new Companion((r) null);

    /* renamed from: l  reason: collision with root package name */
    public static final Map<String, Class<?>> f10314l = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final String f10315b;

    /* renamed from: c  reason: collision with root package name */
    public NavGraph f10316c;

    /* renamed from: d  reason: collision with root package name */
    public String f10317d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f10318e;

    /* renamed from: f  reason: collision with root package name */
    public final List<NavDeepLink> f10319f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArrayCompat<b> f10320g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, NavArgument> f10321h;

    /* renamed from: i  reason: collision with root package name */
    public int f10322i;

    /* renamed from: j  reason: collision with root package name */
    public String f10323j;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final String a(String str) {
            if (str == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + str;
        }

        public final String b(Context context, int i11) {
            if (i11 <= 16777215) {
                return String.valueOf(i11);
            }
            try {
                return context.getResources().getResourceName(i11);
            } catch (Resources.NotFoundException unused) {
                return String.valueOf(i11);
            }
        }

        public final g<NavDestination> c(NavDestination navDestination) {
            return SequencesKt__SequencesKt.g(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }
    }

    public static final class a implements Comparable<a> {

        /* renamed from: b  reason: collision with root package name */
        public final NavDestination f10324b;

        /* renamed from: c  reason: collision with root package name */
        public final Bundle f10325c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f10326d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10327e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f10328f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10329g;

        public a(NavDestination navDestination, Bundle bundle, boolean z11, int i11, boolean z12, int i12) {
            this.f10324b = navDestination;
            this.f10325c = bundle;
            this.f10326d = z11;
            this.f10327e = i11;
            this.f10328f = z12;
            this.f10329g = i12;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z11 = this.f10326d;
            if (z11 && !aVar.f10326d) {
                return 1;
            }
            if (!z11 && aVar.f10326d) {
                return -1;
            }
            int i11 = this.f10327e - aVar.f10327e;
            if (i11 > 0) {
                return 1;
            }
            if (i11 < 0) {
                return -1;
            }
            Bundle bundle = this.f10325c;
            if (bundle != null && aVar.f10325c == null) {
                return 1;
            }
            if (bundle == null && aVar.f10325c != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.f10325c.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z12 = this.f10328f;
            if (z12 && !aVar.f10328f) {
                return 1;
            }
            if (z12 || !aVar.f10328f) {
                return this.f10329g - aVar.f10329g;
            }
            return -1;
        }

        public final NavDestination b() {
            return this.f10324b;
        }

        public final Bundle c() {
            return this.f10325c;
        }

        public final boolean e(Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || (bundle2 = this.f10325c) == null) {
                return false;
            }
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    return false;
                }
                NavArgument navArgument = this.f10324b.j().get(str);
                Object obj = null;
                k<Object> a11 = navArgument != null ? navArgument.a() : null;
                Object a12 = a11 != null ? a11.a(this.f10325c, str) : null;
                if (a11 != null) {
                    obj = a11.a(bundle, str);
                }
                if (!x.b(a12, obj)) {
                    return false;
                }
            }
            return true;
        }
    }

    public NavDestination(String str) {
        this.f10315b = str;
        this.f10319f = new ArrayList();
        this.f10320g = new SparseArrayCompat<>();
        this.f10321h = new LinkedHashMap();
    }

    public static /* synthetic */ int[] h(NavDestination navDestination, NavDestination navDestination2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                navDestination2 = null;
            }
            return navDestination.g(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    public final void a(String str, NavArgument navArgument) {
        this.f10321h.put(str, navArgument);
    }

    public final void b(NavDeepLink navDeepLink) {
        List<String> a11 = c.a(j(), new NavDestination$addDeepLink$missingRequiredArguments$1(navDeepLink));
        if (a11.isEmpty()) {
            this.f10319f.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.y() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + a11).toString());
    }

    public final void c(String str) {
        b(new NavDeepLink.Builder().d(str).a());
    }

    public final Bundle d(Bundle bundle) {
        if (bundle == null) {
            Map<String, NavArgument> map = this.f10321h;
            if (map == null || map.isEmpty()) {
                return null;
            }
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry next : this.f10321h.entrySet()) {
            ((NavArgument) next.getValue()).d((String) next.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry next2 : this.f10321h.entrySet()) {
                String str = (String) next2.getKey();
                NavArgument navArgument = (NavArgument) next2.getValue();
                if (!navArgument.e(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + navArgument.a().b() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0133 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x013a
            boolean r1 = r9 instanceof androidx.navigation.NavDestination
            if (r1 != 0) goto L_0x0009
            goto L_0x013a
        L_0x0009:
            java.util.List<androidx.navigation.NavDeepLink> r1 = r8.f10319f
            androidx.navigation.NavDestination r9 = (androidx.navigation.NavDestination) r9
            java.util.List<androidx.navigation.NavDeepLink> r2 = r9.f10319f
            java.util.Set r1 = kotlin.collections.CollectionsKt___CollectionsKt.g0(r1, r2)
            int r1 = r1.size()
            java.util.List<androidx.navigation.NavDeepLink> r2 = r8.f10319f
            int r2 = r2.size()
            r3 = 1
            if (r1 != r2) goto L_0x0022
            r1 = r3
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r2 = r8.f10320g
            int r2 = r2.p()
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r4 = r9.f10320g
            int r4 = r4.p()
            if (r2 != r4) goto L_0x0081
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r2 = r8.f10320g
            java.util.Iterator r2 = i0.d.a(r2)
            kotlin.sequences.g r2 = kotlin.sequences.SequencesKt__SequencesKt.c(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0055
            java.lang.Object r4 = r2.next()
            androidx.navigation.b r4 = (androidx.navigation.b) r4
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r5 = r9.f10320g
            boolean r4 = r5.e(r4)
            if (r4 != 0) goto L_0x003f
            r2 = r0
            goto L_0x0056
        L_0x0055:
            r2 = r3
        L_0x0056:
            if (r2 == 0) goto L_0x0081
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r2 = r9.f10320g
            java.util.Iterator r2 = i0.d.a(r2)
            kotlin.sequences.g r2 = kotlin.sequences.SequencesKt__SequencesKt.c(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x0066:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r2.next()
            androidx.navigation.b r4 = (androidx.navigation.b) r4
            androidx.collection.SparseArrayCompat<androidx.navigation.b> r5 = r8.f10320g
            boolean r4 = r5.e(r4)
            if (r4 != 0) goto L_0x0066
            r2 = r0
            goto L_0x007d
        L_0x007c:
            r2 = r3
        L_0x007d:
            if (r2 == 0) goto L_0x0081
            r2 = r3
            goto L_0x0082
        L_0x0081:
            r2 = r0
        L_0x0082:
            java.util.Map r4 = r8.j()
            int r4 = r4.size()
            java.util.Map r5 = r9.j()
            int r5 = r5.size()
            if (r4 != r5) goto L_0x0122
            java.util.Map r4 = r8.j()
            kotlin.sequences.g r4 = kotlin.collections.MapsKt___MapsKt.A(r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x00a0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d7
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.util.Map r6 = r9.j()
            java.lang.Object r7 = r5.getKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x00d2
            java.util.Map r6 = r9.j()
            java.lang.Object r7 = r5.getKey()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Object r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.x.b(r6, r5)
            if (r5 == 0) goto L_0x00d2
            r5 = r3
            goto L_0x00d3
        L_0x00d2:
            r5 = r0
        L_0x00d3:
            if (r5 != 0) goto L_0x00a0
            r4 = r0
            goto L_0x00d8
        L_0x00d7:
            r4 = r3
        L_0x00d8:
            if (r4 == 0) goto L_0x0122
            java.util.Map r4 = r9.j()
            kotlin.sequences.g r4 = kotlin.collections.MapsKt___MapsKt.A(r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x00e6:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x011d
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.util.Map r6 = r8.j()
            java.lang.Object r7 = r5.getKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto L_0x0118
            java.util.Map r6 = r8.j()
            java.lang.Object r7 = r5.getKey()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Object r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.x.b(r6, r5)
            if (r5 == 0) goto L_0x0118
            r5 = r3
            goto L_0x0119
        L_0x0118:
            r5 = r0
        L_0x0119:
            if (r5 != 0) goto L_0x00e6
            r4 = r0
            goto L_0x011e
        L_0x011d:
            r4 = r3
        L_0x011e:
            if (r4 == 0) goto L_0x0122
            r4 = r3
            goto L_0x0123
        L_0x0122:
            r4 = r0
        L_0x0123:
            int r5 = r8.f10322i
            int r6 = r9.f10322i
            if (r5 != r6) goto L_0x013a
            java.lang.String r5 = r8.f10323j
            java.lang.String r9 = r9.f10323j
            boolean r9 = kotlin.jvm.internal.x.b(r5, r9)
            if (r9 == 0) goto L_0x013a
            if (r1 == 0) goto L_0x013a
            if (r2 == 0) goto L_0x013a
            if (r4 == 0) goto L_0x013a
            r0 = r3
        L_0x013a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.equals(java.lang.Object):boolean");
    }

    public final int[] g(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this;
        while (true) {
            NavGraph navGraph2 = navGraph.f10316c;
            if ((navDestination != null ? navDestination.f10316c : null) != null && navDestination.f10316c.B(navGraph.f10322i) == navGraph) {
                arrayDeque.addFirst(navGraph);
                break;
            }
            if (navGraph2 == null || navGraph2.H() != navGraph.f10322i) {
                arrayDeque.addFirst(navGraph);
            }
            if (x.b(navGraph2, navDestination) || navGraph2 == null) {
                break;
            }
            navGraph = navGraph2;
        }
        List<NavDestination> I0 = CollectionsKt___CollectionsKt.I0(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(I0, 10));
        for (NavDestination navDestination2 : I0) {
            arrayList.add(Integer.valueOf(navDestination2.f10322i));
        }
        return CollectionsKt___CollectionsKt.H0(arrayList);
    }

    public int hashCode() {
        int i11;
        Set<String> keySet;
        int i12 = this.f10322i * 31;
        String str = this.f10323j;
        int hashCode = i12 + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.f10319f) {
            int i13 = i11 * 31;
            String y11 = navDeepLink.y();
            int hashCode2 = (i13 + (y11 != null ? y11.hashCode() : 0)) * 31;
            String i14 = navDeepLink.i();
            int hashCode3 = (hashCode2 + (i14 != null ? i14.hashCode() : 0)) * 31;
            String t11 = navDeepLink.t();
            hashCode = hashCode3 + (t11 != null ? t11.hashCode() : 0);
        }
        Iterator<T> a11 = d.a(this.f10320g);
        while (a11.hasNext()) {
            b bVar = (b) a11.next();
            int b11 = ((i11 * 31) + bVar.b()) * 31;
            NavOptions c11 = bVar.c();
            i11 = b11 + (c11 != null ? c11.hashCode() : 0);
            Bundle a12 = bVar.a();
            if (!(a12 == null || (keySet = a12.keySet()) == null)) {
                for (String str2 : keySet) {
                    int i15 = i11 * 31;
                    Object obj = bVar.a().get(str2);
                    i11 = i15 + (obj != null ? obj.hashCode() : 0);
                }
            }
        }
        for (String str3 : j().keySet()) {
            int hashCode4 = ((i11 * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = j().get(str3);
            i11 = hashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return i11;
    }

    public final b i(int i11) {
        b g11 = this.f10320g.k() ? null : this.f10320g.g(i11);
        if (g11 != null) {
            return g11;
        }
        NavGraph navGraph = this.f10316c;
        if (navGraph != null) {
            return navGraph.i(i11);
        }
        return null;
    }

    public final Map<String, NavArgument> j() {
        return MapsKt__MapsKt.u(this.f10321h);
    }

    public String k() {
        String str = this.f10317d;
        return str == null ? String.valueOf(this.f10322i) : str;
    }

    public final int l() {
        return this.f10322i;
    }

    public final CharSequence m() {
        return this.f10318e;
    }

    public final String n() {
        return this.f10315b;
    }

    public final NavGraph o() {
        return this.f10316c;
    }

    public final String p() {
        return this.f10323j;
    }

    public final boolean q(NavDeepLink navDeepLink, Uri uri, Map<String, NavArgument> map) {
        return c.a(map, new NavDestination$hasRequiredArguments$missingRequiredArguments$1(navDeepLink.p(uri, map))).isEmpty();
    }

    public final boolean r(String str, Bundle bundle) {
        if (x.b(this.f10323j, str)) {
            return true;
        }
        a t11 = t(str);
        if (!x.b(this, t11 != null ? t11.b() : null)) {
            return false;
        }
        return t11.e(bundle);
    }

    public a s(e eVar) {
        if (this.f10319f.isEmpty()) {
            return null;
        }
        a aVar = null;
        for (NavDeepLink next : this.f10319f) {
            Uri c11 = eVar.c();
            Bundle o11 = c11 != null ? next.o(c11, j()) : null;
            int h11 = next.h(c11);
            String a11 = eVar.a();
            boolean z11 = a11 != null && x.b(a11, next.i());
            String b11 = eVar.b();
            int u11 = b11 != null ? next.u(b11) : -1;
            if (o11 != null || ((z11 || u11 > -1) && q(next, c11, j()))) {
                a aVar2 = new a(this, o11, next.z(), h11, z11, u11);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public final a t(String str) {
        e a11 = e.a.f10386d.a(Uri.parse(f10313k.a(str))).a();
        if (this instanceof NavGraph) {
            return ((NavGraph) this).J(a11);
        }
        return s(a11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.f10317d;
        if (str == null) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.f10322i));
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        String str2 = this.f10323j;
        if (!(str2 == null || StringsKt__StringsJVMKt.z(str2))) {
            sb2.append(" route=");
            sb2.append(this.f10323j);
        }
        if (this.f10318e != null) {
            sb2.append(" label=");
            sb2.append(this.f10318e);
        }
        return sb2.toString();
    }

    public void u(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.Navigator);
        y(obtainAttributes.getString(R$styleable.Navigator_route));
        int i11 = R$styleable.Navigator_android_id;
        if (obtainAttributes.hasValue(i11)) {
            w(obtainAttributes.getResourceId(i11, 0));
            this.f10317d = f10313k.b(context, this.f10322i);
        }
        this.f10318e = obtainAttributes.getText(R$styleable.Navigator_android_label);
        Unit unit = Unit.f56620a;
        obtainAttributes.recycle();
    }

    public final void v(int i11, b bVar) {
        if (z()) {
            if (i11 != 0) {
                this.f10320g.m(i11, bVar);
                return;
            }
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
        throw new UnsupportedOperationException("Cannot add action " + i11 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    public final void w(int i11) {
        this.f10322i = i11;
        this.f10317d = null;
    }

    public final void x(NavGraph navGraph) {
        this.f10316c = navGraph;
    }

    public final void y(String str) {
        T t11;
        if (str == null) {
            w(0);
        } else if (!StringsKt__StringsJVMKt.z(str)) {
            String a11 = f10313k.a(str);
            w(a11.hashCode());
            c(a11);
        } else {
            throw new IllegalArgumentException("Cannot have an empty route".toString());
        }
        List<NavDeepLink> list = this.f10319f;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((NavDeepLink) t11).y(), f10313k.a(this.f10323j))) {
                break;
            }
        }
        TypeIntrinsics.a(list).remove(t11);
        this.f10323j = str;
    }

    public boolean z() {
        return true;
    }

    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.f10368b.a(navigator.getClass()));
    }
}
