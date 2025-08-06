package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ActionMode {

    /* renamed from: b  reason: collision with root package name */
    public Object f4008b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4009c;

    public interface Callback {
        boolean a(ActionMode actionMode, Menu menu);

        boolean b(ActionMode actionMode, MenuItem menuItem);

        boolean c(ActionMode actionMode, Menu menu);

        void d(ActionMode actionMode);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f4008b;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f4009c;
    }

    public abstract void i();

    public boolean j() {
        return false;
    }

    public abstract void k(View view);

    public abstract void l(int i11);

    public abstract void m(CharSequence charSequence);

    public void n(Object obj) {
        this.f4008b = obj;
    }

    public abstract void o(int i11);

    public abstract void p(CharSequence charSequence);

    public void q(boolean z11) {
        this.f4009c = z11;
    }
}
