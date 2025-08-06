package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import g.c;
import java.lang.ref.WeakReference;

public class a extends ActionMode implements e.a {

    /* renamed from: d  reason: collision with root package name */
    public Context f4019d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f4020e;

    /* renamed from: f  reason: collision with root package name */
    public ActionMode.Callback f4021f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f4022g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4023h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4024i;

    /* renamed from: j  reason: collision with root package name */
    public e f4025j;

    public a(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z11) {
        this.f4019d = context;
        this.f4020e = actionBarContextView;
        this.f4021f = callback;
        e defaultShowAsAction = new e(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f4025j = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f4024i = z11;
    }

    public void a() {
        if (!this.f4023h) {
            this.f4023h = true;
            this.f4021f.d(this);
        }
    }

    public View b() {
        WeakReference<View> weakReference = this.f4022g;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu c() {
        return this.f4025j;
    }

    public MenuInflater d() {
        return new c(this.f4020e.getContext());
    }

    public CharSequence e() {
        return this.f4020e.getSubtitle();
    }

    public CharSequence g() {
        return this.f4020e.getTitle();
    }

    public void i() {
        this.f4021f.c(this, this.f4025j);
    }

    public boolean j() {
        return this.f4020e.j();
    }

    public void k(View view) {
        this.f4020e.setCustomView(view);
        this.f4022g = view != null ? new WeakReference<>(view) : null;
    }

    public void l(int i11) {
        m(this.f4019d.getString(i11));
    }

    public void m(CharSequence charSequence) {
        this.f4020e.setSubtitle(charSequence);
    }

    public void o(int i11) {
        p(this.f4019d.getString(i11));
    }

    public boolean onMenuItemSelected(e eVar, MenuItem menuItem) {
        return this.f4021f.b(this, menuItem);
    }

    public void onMenuModeChange(e eVar) {
        i();
        this.f4020e.l();
    }

    public void p(CharSequence charSequence) {
        this.f4020e.setTitle(charSequence);
    }

    public void q(boolean z11) {
        super.q(z11);
        this.f4020e.setTitleOptional(z11);
    }
}
