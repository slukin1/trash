package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f9778a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final FragmentManager f9779b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final FragmentManager.FragmentLifecycleCallbacks f9780a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9781b;

        public a(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z11) {
            this.f9780a = fragmentLifecycleCallbacks;
            this.f9781b = z11;
        }
    }

    public r(FragmentManager fragmentManager) {
        this.f9779b = fragmentManager;
    }

    public void a(Fragment fragment, Bundle bundle, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().a(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentActivityCreated(this.f9779b, fragment, bundle);
            }
        }
    }

    public void b(Fragment fragment, boolean z11) {
        Context f11 = this.f9779b.C0().f();
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().b(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentAttached(this.f9779b, fragment, f11);
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().c(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentCreated(this.f9779b, fragment, bundle);
            }
        }
    }

    public void d(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().d(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentDestroyed(this.f9779b, fragment);
            }
        }
    }

    public void e(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().e(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentDetached(this.f9779b, fragment);
            }
        }
    }

    public void f(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().f(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentPaused(this.f9779b, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z11) {
        Context f11 = this.f9779b.C0().f();
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().g(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentPreAttached(this.f9779b, fragment, f11);
            }
        }
    }

    public void h(Fragment fragment, Bundle bundle, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().h(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentPreCreated(this.f9779b, fragment, bundle);
            }
        }
    }

    public void i(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().i(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentResumed(this.f9779b, fragment);
            }
        }
    }

    public void j(Fragment fragment, Bundle bundle, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().j(fragment, bundle, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentSaveInstanceState(this.f9779b, fragment, bundle);
            }
        }
    }

    public void k(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().k(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentStarted(this.f9779b, fragment);
            }
        }
    }

    public void l(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().l(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentStopped(this.f9779b, fragment);
            }
        }
    }

    public void m(Fragment fragment, View view, Bundle bundle, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().m(fragment, view, bundle, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentViewCreated(this.f9779b, fragment, view, bundle);
            }
        }
    }

    public void n(Fragment fragment, boolean z11) {
        Fragment F0 = this.f9779b.F0();
        if (F0 != null) {
            F0.getParentFragmentManager().E0().n(fragment, true);
        }
        Iterator<a> it2 = this.f9778a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z11 || next.f9781b) {
                next.f9780a.onFragmentViewDestroyed(this.f9779b, fragment);
            }
        }
    }

    public void o(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z11) {
        this.f9778a.add(new a(fragmentLifecycleCallbacks, z11));
    }

    public void p(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f9778a) {
            int i11 = 0;
            int size = this.f9778a.size();
            while (true) {
                if (i11 >= size) {
                    break;
                } else if (this.f9778a.get(i11).f9780a == fragmentLifecycleCallbacks) {
                    this.f9778a.remove(i11);
                    break;
                } else {
                    i11++;
                }
            }
        }
    }
}
