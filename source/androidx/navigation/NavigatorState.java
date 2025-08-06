package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;

public abstract class NavigatorState {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f10371a = new ReentrantLock(true);

    /* renamed from: b  reason: collision with root package name */
    public final b1<List<NavBackStackEntry>> f10372b;

    /* renamed from: c  reason: collision with root package name */
    public final b1<Set<NavBackStackEntry>> f10373c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10374d;

    /* renamed from: e  reason: collision with root package name */
    public final j1<List<NavBackStackEntry>> f10375e;

    /* renamed from: f  reason: collision with root package name */
    public final j1<Set<NavBackStackEntry>> f10376f;

    public NavigatorState() {
        b1<List<NavBackStackEntry>> a11 = k1.a(CollectionsKt__CollectionsKt.k());
        this.f10372b = a11;
        b1<Set<NavBackStackEntry>> a12 = k1.a(SetsKt__SetsKt.d());
        this.f10373c = a12;
        this.f10375e = f.b(a11);
        this.f10376f = f.b(a12);
    }

    public abstract NavBackStackEntry a(NavDestination navDestination, Bundle bundle);

    public final j1<List<NavBackStackEntry>> b() {
        return this.f10375e;
    }

    public final j1<Set<NavBackStackEntry>> c() {
        return this.f10376f;
    }

    public final boolean d() {
        return this.f10374d;
    }

    public void e(NavBackStackEntry navBackStackEntry) {
        b1<Set<NavBackStackEntry>> b1Var = this.f10373c;
        b1Var.setValue(SetsKt___SetsKt.h(b1Var.getValue(), navBackStackEntry));
    }

    public void f(NavBackStackEntry navBackStackEntry) {
        int i11;
        ReentrantLock reentrantLock = this.f10371a;
        reentrantLock.lock();
        try {
            List L0 = CollectionsKt___CollectionsKt.L0(this.f10375e.getValue());
            ListIterator listIterator = L0.listIterator(L0.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (x.b(((NavBackStackEntry) listIterator.previous()).f(), navBackStackEntry.f())) {
                        i11 = listIterator.nextIndex();
                        break;
                    }
                } else {
                    i11 = -1;
                    break;
                }
            }
            L0.set(i11, navBackStackEntry);
            this.f10372b.setValue(L0);
            Unit unit = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        List value = this.f10375e.getValue();
        ListIterator listIterator = value.listIterator(value.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (x.b(navBackStackEntry2.f(), navBackStackEntry.f())) {
                b1<Set<NavBackStackEntry>> b1Var = this.f10373c;
                b1Var.setValue(SetsKt___SetsKt.j(SetsKt___SetsKt.j(b1Var.getValue(), navBackStackEntry2), navBackStackEntry));
                f(navBackStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    public void h(NavBackStackEntry navBackStackEntry, boolean z11) {
        ReentrantLock reentrantLock = this.f10371a;
        reentrantLock.lock();
        try {
            b1<List<NavBackStackEntry>> b1Var = this.f10372b;
            ArrayList arrayList = new ArrayList();
            Iterator it2 = b1Var.getValue().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (!(!x.b((NavBackStackEntry) next, navBackStackEntry))) {
                    break;
                }
                arrayList.add(next);
            }
            b1Var.setValue(arrayList);
            Unit unit = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(androidx.navigation.NavBackStackEntry r7, boolean r8) {
        /*
            r6 = this;
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r0 = r6.f10373c
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0019
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0019
        L_0x0017:
            r0 = r3
            goto L_0x0031
        L_0x0019:
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0017
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != r7) goto L_0x002d
            r1 = r2
            goto L_0x002e
        L_0x002d:
            r1 = r3
        L_0x002e:
            if (r1 == 0) goto L_0x001d
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0065
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r0 = r6.f10375e
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x004a
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004a
        L_0x0048:
            r0 = r2
            goto L_0x0062
        L_0x004a:
            java.util.Iterator r0 = r0.iterator()
        L_0x004e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != r7) goto L_0x005e
            r1 = r2
            goto L_0x005f
        L_0x005e:
            r1 = r3
        L_0x005f:
            if (r1 == 0) goto L_0x004e
            r0 = r3
        L_0x0062:
            if (r0 == 0) goto L_0x0065
            return
        L_0x0065:
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r0 = r6.f10373c
            java.lang.Object r1 = r0.getValue()
            java.util.Set r1 = (java.util.Set) r1
            java.util.Set r1 = kotlin.collections.SetsKt___SetsKt.j(r1, r7)
            r0.setValue(r1)
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r0 = r6.f10375e
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x0084:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x00b7
            java.lang.Object r1 = r0.previous()
            r4 = r1
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            boolean r5 = kotlin.jvm.internal.x.b(r4, r7)
            if (r5 != 0) goto L_0x00b3
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r5 = r6.f10375e
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            int r4 = r5.lastIndexOf(r4)
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r5 = r6.f10375e
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            int r5 = r5.lastIndexOf(r7)
            if (r4 >= r5) goto L_0x00b3
            r4 = r2
            goto L_0x00b4
        L_0x00b3:
            r4 = r3
        L_0x00b4:
            if (r4 == 0) goto L_0x0084
            goto L_0x00b8
        L_0x00b7:
            r1 = 0
        L_0x00b8:
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 == 0) goto L_0x00cb
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r0 = r6.f10373c
            java.lang.Object r2 = r0.getValue()
            java.util.Set r2 = (java.util.Set) r2
            java.util.Set r1 = kotlin.collections.SetsKt___SetsKt.j(r2, r1)
            r0.setValue(r1)
        L_0x00cb:
            r6.h(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavigatorState.i(androidx.navigation.NavBackStackEntry, boolean):void");
    }

    public void j(NavBackStackEntry navBackStackEntry) {
        b1<Set<NavBackStackEntry>> b1Var = this.f10373c;
        b1Var.setValue(SetsKt___SetsKt.j(b1Var.getValue(), navBackStackEntry));
    }

    public void k(NavBackStackEntry navBackStackEntry) {
        ReentrantLock reentrantLock = this.f10371a;
        reentrantLock.lock();
        try {
            b1<List<NavBackStackEntry>> b1Var = this.f10372b;
            b1Var.setValue(CollectionsKt___CollectionsKt.r0(b1Var.getValue(), navBackStackEntry));
            Unit unit = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(androidx.navigation.NavBackStackEntry r5) {
        /*
            r4 = this;
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r0 = r4.f10373c
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0019
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0019
        L_0x0017:
            r0 = r3
            goto L_0x0031
        L_0x0019:
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0017
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != r5) goto L_0x002d
            r1 = r2
            goto L_0x002e
        L_0x002d:
            r1 = r3
        L_0x002e:
            if (r1 == 0) goto L_0x001d
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0064
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r0 = r4.f10375e
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x004a
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004a
        L_0x0048:
            r2 = r3
            goto L_0x0061
        L_0x004a:
            java.util.Iterator r0 = r0.iterator()
        L_0x004e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            if (r1 != r5) goto L_0x005e
            r1 = r2
            goto L_0x005f
        L_0x005e:
            r1 = r3
        L_0x005f:
            if (r1 == 0) goto L_0x004e
        L_0x0061:
            if (r2 == 0) goto L_0x0064
            return
        L_0x0064:
            kotlinx.coroutines.flow.j1<java.util.List<androidx.navigation.NavBackStackEntry>> r0 = r4.f10375e
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r0)
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            if (r0 == 0) goto L_0x0083
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r1 = r4.f10373c
            java.lang.Object r2 = r1.getValue()
            java.util.Set r2 = (java.util.Set) r2
            java.util.Set r0 = kotlin.collections.SetsKt___SetsKt.j(r2, r0)
            r1.setValue(r0)
        L_0x0083:
            kotlinx.coroutines.flow.b1<java.util.Set<androidx.navigation.NavBackStackEntry>> r0 = r4.f10373c
            java.lang.Object r1 = r0.getValue()
            java.util.Set r1 = (java.util.Set) r1
            java.util.Set r1 = kotlin.collections.SetsKt___SetsKt.j(r1, r5)
            r0.setValue(r1)
            r4.k(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavigatorState.l(androidx.navigation.NavBackStackEntry):void");
    }

    public final void m(boolean z11) {
        this.f10374d = z11;
    }
}
