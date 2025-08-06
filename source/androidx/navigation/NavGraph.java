package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.common.R$styleable;
import i0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public class NavGraph extends NavDestination implements Iterable<NavDestination>, e10.a {

    /* renamed from: q  reason: collision with root package name */
    public static final Companion f10330q = new Companion((r) null);

    /* renamed from: m  reason: collision with root package name */
    public final SparseArrayCompat<NavDestination> f10331m = new SparseArrayCompat<>();

    /* renamed from: n  reason: collision with root package name */
    public int f10332n;

    /* renamed from: o  reason: collision with root package name */
    public String f10333o;

    /* renamed from: p  reason: collision with root package name */
    public String f10334p;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final NavDestination a(NavGraph navGraph) {
            return (NavDestination) SequencesKt___SequencesKt.r(SequencesKt__SequencesKt.g(navGraph.B(navGraph.H()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }
    }

    public static final class a implements Iterator<NavDestination>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f10335b = -1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10336c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NavGraph f10337d;

        public a(NavGraph navGraph) {
            this.f10337d = navGraph;
        }

        /* renamed from: a */
        public NavDestination next() {
            if (hasNext()) {
                this.f10336c = true;
                SparseArrayCompat<NavDestination> F = this.f10337d.F();
                int i11 = this.f10335b + 1;
                this.f10335b = i11;
                return F.q(i11);
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f10335b + 1 < this.f10337d.F().p();
        }

        public void remove() {
            if (this.f10336c) {
                SparseArrayCompat<NavDestination> F = this.f10337d.F();
                F.q(this.f10335b).x((NavGraph) null);
                F.n(this.f10335b);
                this.f10335b--;
                this.f10336c = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element".toString());
        }
    }

    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super((Navigator<? extends NavDestination>) navigator);
    }

    public final void A(NavDestination navDestination) {
        int l11 = navDestination.l();
        String p11 = navDestination.p();
        boolean z11 = false;
        if (!((l11 == 0 && p11 == null) ? false : true)) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        } else if (p() == null || (!x.b(p11, p()))) {
            if (l11 != l()) {
                NavDestination g11 = this.f10331m.g(l11);
                if (g11 != navDestination) {
                    if (navDestination.o() == null) {
                        z11 = true;
                    }
                    if (z11) {
                        if (g11 != null) {
                            g11.x((NavGraph) null);
                        }
                        navDestination.x(this);
                        this.f10331m.m(navDestination.l(), navDestination);
                        return;
                    }
                    throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
                }
                return;
            }
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same id as graph " + this).toString());
        } else {
            throw new IllegalArgumentException(("Destination " + navDestination + " cannot have the same route as graph " + this).toString());
        }
    }

    public final NavDestination B(int i11) {
        return C(i11, true);
    }

    public final NavDestination C(int i11, boolean z11) {
        NavDestination g11 = this.f10331m.g(i11);
        if (g11 != null) {
            return g11;
        }
        if (!z11 || o() == null) {
            return null;
        }
        return o().B(i11);
    }

    public final NavDestination D(String str) {
        if (!(str == null || StringsKt__StringsJVMKt.z(str))) {
            return E(str, true);
        }
        return null;
    }

    public final NavDestination E(String str, boolean z11) {
        Object obj;
        boolean z12;
        NavDestination g11 = this.f10331m.g(NavDestination.f10313k.a(str).hashCode());
        if (g11 == null) {
            Iterator it2 = SequencesKt__SequencesKt.c(d.a(this.f10331m)).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((NavDestination) obj).t(str) != null) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            g11 = (NavDestination) obj;
        }
        if (g11 != null) {
            return g11;
        }
        if (!z11 || o() == null) {
            return null;
        }
        return o().D(str);
    }

    public final SparseArrayCompat<NavDestination> F() {
        return this.f10331m;
    }

    public final String G() {
        if (this.f10333o == null) {
            String str = this.f10334p;
            if (str == null) {
                str = String.valueOf(this.f10332n);
            }
            this.f10333o = str;
        }
        return this.f10333o;
    }

    public final int H() {
        return this.f10332n;
    }

    public final String I() {
        return this.f10334p;
    }

    public final NavDestination.a J(e eVar) {
        return super.s(eVar);
    }

    public final void K(int i11) {
        if (i11 != l()) {
            if (this.f10334p != null) {
                L((String) null);
            }
            this.f10332n = i11;
            this.f10333o = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i11 + " cannot use the same id as the graph " + this).toString());
    }

    public final void L(String str) {
        int i11;
        if (str == null) {
            i11 = 0;
        } else if (!(!x.b(str, p()))) {
            throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
        } else if (!StringsKt__StringsJVMKt.z(str)) {
            i11 = NavDestination.f10313k.a(str).hashCode();
        } else {
            throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
        }
        this.f10332n = i11;
        this.f10334p = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavGraph)) {
            return false;
        }
        List x11 = SequencesKt___SequencesKt.x(SequencesKt__SequencesKt.c(d.a(this.f10331m)));
        NavGraph navGraph = (NavGraph) obj;
        Iterator<T> a11 = d.a(navGraph.f10331m);
        while (a11.hasNext()) {
            x11.remove((NavDestination) a11.next());
        }
        if (!super.equals(obj) || this.f10331m.p() != navGraph.f10331m.p() || H() != navGraph.H() || !x11.isEmpty()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int H = H();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.f10331m;
        int p11 = sparseArrayCompat.p();
        for (int i11 = 0; i11 < p11; i11++) {
            H = (((H * 31) + sparseArrayCompat.l(i11)) * 31) + sparseArrayCompat.q(i11).hashCode();
        }
        return H;
    }

    public final Iterator<NavDestination> iterator() {
        return new a(this);
    }

    public String k() {
        return l() != 0 ? super.k() : "the root navigation";
    }

    public NavDestination.a s(e eVar) {
        NavDestination.a s11 = super.s(eVar);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            NavDestination.a s12 = ((NavDestination) it2.next()).s(eVar);
            if (s12 != null) {
                arrayList.add(s12);
            }
        }
        return (NavDestination.a) CollectionsKt___CollectionsKt.o0(CollectionsKt__CollectionsKt.o(s11, (NavDestination.a) CollectionsKt___CollectionsKt.o0(arrayList)));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        NavDestination D = D(this.f10334p);
        if (D == null) {
            D = B(H());
        }
        sb2.append(" startDestination=");
        if (D == null) {
            String str = this.f10334p;
            if (str != null) {
                sb2.append(str);
            } else {
                String str2 = this.f10333o;
                if (str2 != null) {
                    sb2.append(str2);
                } else {
                    sb2.append("0x" + Integer.toHexString(this.f10332n));
                }
            }
        } else {
            sb2.append("{");
            sb2.append(D.toString());
            sb2.append("}");
        }
        return sb2.toString();
    }

    public void u(Context context, AttributeSet attributeSet) {
        super.u(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.NavGraphNavigator);
        K(obtainAttributes.getResourceId(R$styleable.NavGraphNavigator_startDestination, 0));
        this.f10333o = NavDestination.f10313k.b(context, this.f10332n);
        Unit unit = Unit.f56620a;
        obtainAttributes.recycle();
    }
}
