package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

public abstract class a implements i {

    /* renamed from: b  reason: collision with root package name */
    public Context f4075b;

    /* renamed from: c  reason: collision with root package name */
    public Context f4076c;

    /* renamed from: d  reason: collision with root package name */
    public e f4077d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f4078e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f4079f;

    /* renamed from: g  reason: collision with root package name */
    public i.a f4080g;

    /* renamed from: h  reason: collision with root package name */
    public int f4081h;

    /* renamed from: i  reason: collision with root package name */
    public int f4082i;

    /* renamed from: j  reason: collision with root package name */
    public j f4083j;

    /* renamed from: k  reason: collision with root package name */
    public int f4084k;

    public a(Context context, int i11, int i12) {
        this.f4075b = context;
        this.f4078e = LayoutInflater.from(context);
        this.f4081h = i11;
        this.f4082i = i12;
    }

    public void b(View view, int i11) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f4083j).addView(view, i11);
    }

    public abstract void c(g gVar, j.a aVar);

    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    public j.a d(ViewGroup viewGroup) {
        return (j.a) this.f4078e.inflate(this.f4082i, viewGroup, false);
    }

    public boolean e(ViewGroup viewGroup, int i11) {
        viewGroup.removeViewAt(i11);
        return true;
    }

    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    public i.a f() {
        return this.f4080g;
    }

    public View g(g gVar, View view, ViewGroup viewGroup) {
        j.a aVar;
        if (view instanceof j.a) {
            aVar = (j.a) view;
        } else {
            aVar = d(viewGroup);
        }
        c(gVar, aVar);
        return (View) aVar;
    }

    public int getId() {
        return this.f4084k;
    }

    public j h(ViewGroup viewGroup) {
        if (this.f4083j == null) {
            j jVar = (j) this.f4078e.inflate(this.f4081h, viewGroup, false);
            this.f4083j = jVar;
            jVar.initialize(this.f4077d);
            updateMenuView(true);
        }
        return this.f4083j;
    }

    public void i(int i11) {
        this.f4084k = i11;
    }

    public void initForMenu(Context context, e eVar) {
        this.f4076c = context;
        this.f4079f = LayoutInflater.from(context);
        this.f4077d = eVar;
    }

    public abstract boolean j(int i11, g gVar);

    public void onCloseMenu(e eVar, boolean z11) {
        i.a aVar = this.f4080g;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.l r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.i$a r0 = r1.f4080g
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.e r2 = r1.f4077d
        L_0x0009:
            boolean r2 = r0.a(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.a.onSubMenuSelected(androidx.appcompat.view.menu.l):boolean");
    }

    public void setCallback(i.a aVar) {
        this.f4080g = aVar;
    }

    public void updateMenuView(boolean z11) {
        ViewGroup viewGroup = (ViewGroup) this.f4083j;
        if (viewGroup != null) {
            e eVar = this.f4077d;
            int i11 = 0;
            if (eVar != null) {
                eVar.flagActionItems();
                ArrayList<g> visibleItems = this.f4077d.getVisibleItems();
                int size = visibleItems.size();
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    g gVar = visibleItems.get(i13);
                    if (j(i12, gVar)) {
                        View childAt = viewGroup.getChildAt(i12);
                        g itemData = childAt instanceof j.a ? ((j.a) childAt).getItemData() : null;
                        View g11 = g(gVar, childAt, viewGroup);
                        if (gVar != itemData) {
                            g11.setPressed(false);
                            g11.jumpDrawablesToCurrentState();
                        }
                        if (g11 != childAt) {
                            b(g11, i12);
                        }
                        i12++;
                    }
                }
                i11 = i12;
            }
            while (i11 < viewGroup.getChildCount()) {
                if (!e(viewGroup, i11)) {
                    i11++;
                }
            }
        }
    }
}
