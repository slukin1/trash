package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f8486a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList<MenuProvider> f8487b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final Map<MenuProvider, a> f8488c = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Lifecycle f8489a;

        /* renamed from: b  reason: collision with root package name */
        public r f8490b;

        public a(Lifecycle lifecycle, r rVar) {
            this.f8489a = lifecycle;
            this.f8490b = rVar;
            lifecycle.a(rVar);
        }

        public void a() {
            this.f8489a.d(this.f8490b);
            this.f8490b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.f8486a = runnable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.f8487b.remove(menuProvider);
            this.f8486a.run();
        }
    }

    public void c(MenuProvider menuProvider) {
        this.f8487b.add(menuProvider);
        this.f8486a.run();
    }

    public void d(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a remove = this.f8488c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f8488c.put(menuProvider, new a(lifecycle, new k(this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public void e(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        a remove = this.f8488c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f8488c.put(menuProvider, new a(lifecycle, new l(this, state, menuProvider)));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it2 = this.f8487b.iterator();
        while (it2.hasNext()) {
            it2.next().a(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator<MenuProvider> it2 = this.f8487b.iterator();
        while (it2.hasNext()) {
            it2.next().b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator<MenuProvider> it2 = this.f8487b.iterator();
        while (it2.hasNext()) {
            if (it2.next().d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator<MenuProvider> it2 = this.f8487b.iterator();
        while (it2.hasNext()) {
            it2.next().c(menu);
        }
    }

    public void l(MenuProvider menuProvider) {
        this.f8487b.remove(menuProvider);
        a remove = this.f8488c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f8486a.run();
    }
}
