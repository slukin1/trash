package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4690a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4691b;

    /* renamed from: c  reason: collision with root package name */
    public final View f4692c;

    /* renamed from: d  reason: collision with root package name */
    public final h f4693d;

    /* renamed from: e  reason: collision with root package name */
    public d f4694e;

    /* renamed from: f  reason: collision with root package name */
    public c f4695f;

    public class a implements e.a {
        public a() {
        }

        public boolean onMenuItemSelected(e eVar, MenuItem menuItem) {
            d dVar = v.this.f4694e;
            if (dVar != null) {
                return dVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        public void onMenuModeChange(e eVar) {
        }
    }

    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        public void onDismiss() {
            v vVar = v.this;
            c cVar = vVar.f4695f;
            if (cVar != null) {
                cVar.a(vVar);
            }
        }
    }

    public interface c {
        void a(v vVar);
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public v(Context context, View view) {
        this(context, view, 0);
    }

    public Menu a() {
        return this.f4691b;
    }

    public MenuInflater b() {
        return new g.c(this.f4690a);
    }

    public void c(int i11) {
        b().inflate(i11, this.f4691b);
    }

    public void d(int i11) {
        this.f4693d.h(i11);
    }

    public void e(d dVar) {
        this.f4694e = dVar;
    }

    public void f() {
        this.f4693d.k();
    }

    public v(Context context, View view, int i11) {
        this(context, view, i11, R$attr.popupMenuStyle, 0);
    }

    public v(Context context, View view, int i11, int i12, int i13) {
        this.f4690a = context;
        this.f4692c = view;
        e eVar = new e(context);
        this.f4691b = eVar;
        eVar.setCallback(new a());
        h hVar = new h(context, eVar, view, false, i12, i13);
        this.f4693d = hVar;
        hVar.h(i11);
        hVar.i(new b());
    }
}
