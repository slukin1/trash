package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.collection.SimpleArrayMap;
import h.d;
import java.util.ArrayList;

public class b extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4026a;

    /* renamed from: b  reason: collision with root package name */
    public final ActionMode f4027b;

    public static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f4028a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f4029b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<b> f4030c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final SimpleArrayMap<Menu, Menu> f4031d = new SimpleArrayMap<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f4029b = context;
            this.f4028a = callback;
        }

        public boolean a(ActionMode actionMode, Menu menu) {
            return this.f4028a.onCreateActionMode(e(actionMode), f(menu));
        }

        public boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f4028a.onActionItemClicked(e(actionMode), new MenuItemWrapperICS(this.f4029b, (v0.b) menuItem));
        }

        public boolean c(ActionMode actionMode, Menu menu) {
            return this.f4028a.onPrepareActionMode(e(actionMode), f(menu));
        }

        public void d(ActionMode actionMode) {
            this.f4028a.onDestroyActionMode(e(actionMode));
        }

        public android.view.ActionMode e(ActionMode actionMode) {
            int size = this.f4030c.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = this.f4030c.get(i11);
                if (bVar != null && bVar.f4027b == actionMode) {
                    return bVar;
                }
            }
            b bVar2 = new b(this.f4029b, actionMode);
            this.f4030c.add(bVar2);
            return bVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f4031d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            d dVar = new d(this.f4029b, (v0.a) menu);
            this.f4031d.put(menu, dVar);
            return dVar;
        }
    }

    public b(Context context, ActionMode actionMode) {
        this.f4026a = context;
        this.f4027b = actionMode;
    }

    public void finish() {
        this.f4027b.a();
    }

    public View getCustomView() {
        return this.f4027b.b();
    }

    public Menu getMenu() {
        return new d(this.f4026a, (v0.a) this.f4027b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f4027b.d();
    }

    public CharSequence getSubtitle() {
        return this.f4027b.e();
    }

    public Object getTag() {
        return this.f4027b.f();
    }

    public CharSequence getTitle() {
        return this.f4027b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.f4027b.h();
    }

    public void invalidate() {
        this.f4027b.i();
    }

    public boolean isTitleOptional() {
        return this.f4027b.j();
    }

    public void setCustomView(View view) {
        this.f4027b.k(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f4027b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.f4027b.n(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f4027b.p(charSequence);
    }

    public void setTitleOptionalHint(boolean z11) {
        this.f4027b.q(z11);
    }

    public void setSubtitle(int i11) {
        this.f4027b.l(i11);
    }

    public void setTitle(int i11) {
        this.f4027b.o(i11);
    }
}
