package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8527a;

    /* renamed from: b  reason: collision with root package name */
    public C0026a f8528b;

    /* renamed from: c  reason: collision with root package name */
    public b f8529c;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    public interface C0026a {
        void a(boolean z11);
    }

    public interface b {
        void onActionProviderVisibilityChanged(boolean z11);
    }

    public a(Context context) {
        this.f8527a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f8529c = null;
        this.f8528b = null;
    }

    public void i(C0026a aVar) {
        this.f8528b = aVar;
    }

    public void j(b bVar) {
        if (!(this.f8529c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f8529c = bVar;
    }

    public void k(boolean z11) {
        C0026a aVar = this.f8528b;
        if (aVar != null) {
            aVar.a(z11);
        }
    }
}
