package h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.collection.SimpleArrayMap;
import v0.c;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f15861a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleArrayMap<v0.b, MenuItem> f15862b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleArrayMap<c, SubMenu> f15863c;

    public b(Context context) {
        this.f15861a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof v0.b)) {
            return menuItem;
        }
        v0.b bVar = (v0.b) menuItem;
        if (this.f15862b == null) {
            this.f15862b = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.f15862b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f15861a, bVar);
        this.f15862b.put(bVar, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f15863c == null) {
            this.f15863c = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.f15863c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        f fVar = new f(this.f15861a, cVar);
        this.f15863c.put(cVar, fVar);
        return fVar;
    }

    public final void e() {
        SimpleArrayMap<v0.b, MenuItem> simpleArrayMap = this.f15862b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<c, SubMenu> simpleArrayMap2 = this.f15863c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    public final void f(int i11) {
        if (this.f15862b != null) {
            int i12 = 0;
            while (i12 < this.f15862b.size()) {
                if (this.f15862b.l(i12).getGroupId() == i11) {
                    this.f15862b.n(i12);
                    i12--;
                }
                i12++;
            }
        }
    }

    public final void g(int i11) {
        if (this.f15862b != null) {
            for (int i12 = 0; i12 < this.f15862b.size(); i12++) {
                if (this.f15862b.l(i12).getItemId() == i11) {
                    this.f15862b.n(i12);
                    return;
                }
            }
        }
    }
}
