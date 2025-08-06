package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.u;
import androidx.core.view.f;
import androidx.core.view.h0;
import java.util.ArrayList;
import java.util.List;

public final class b extends h.c implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = R$layout.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4085c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4086d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4087e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4088f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4089g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f4090h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f4091i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List<d> f4092j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f4093k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f4094l = new C0002b();

    /* renamed from: m  reason: collision with root package name */
    public final u f4095m = new c();

    /* renamed from: n  reason: collision with root package name */
    public int f4096n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f4097o = 0;

    /* renamed from: p  reason: collision with root package name */
    public View f4098p;

    /* renamed from: q  reason: collision with root package name */
    public View f4099q;

    /* renamed from: r  reason: collision with root package name */
    public int f4100r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4101s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4102t;

    /* renamed from: u  reason: collision with root package name */
    public int f4103u;

    /* renamed from: v  reason: collision with root package name */
    public int f4104v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4105w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4106x;

    /* renamed from: y  reason: collision with root package name */
    public i.a f4107y;

    /* renamed from: z  reason: collision with root package name */
    public ViewTreeObserver f4108z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (b.this.isShowing() && b.this.f4092j.size() > 0 && !b.this.f4092j.get(0).f4116a.y()) {
                View view = b.this.f4099q;
                if (view == null || !view.isShown()) {
                    b.this.dismiss();
                    return;
                }
                for (d dVar : b.this.f4092j) {
                    dVar.f4116a.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    public class C0002b implements View.OnAttachStateChangeListener {
        public C0002b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f4108z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f4108z = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f4108z.removeGlobalOnLayoutListener(bVar.f4093k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements u {

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f4112b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ MenuItem f4113c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ e f4114d;

            public a(d dVar, MenuItem menuItem, e eVar) {
                this.f4112b = dVar;
                this.f4113c = menuItem;
                this.f4114d = eVar;
            }

            public void run() {
                d dVar = this.f4112b;
                if (dVar != null) {
                    b.this.B = true;
                    dVar.f4117b.close(false);
                    b.this.B = false;
                }
                if (this.f4113c.isEnabled() && this.f4113c.hasSubMenu()) {
                    this.f4114d.performItemAction(this.f4113c, 4);
                }
            }
        }

        public c() {
        }

        public void a(e eVar, MenuItem menuItem) {
            d dVar = null;
            b.this.f4090h.removeCallbacksAndMessages((Object) null);
            int size = b.this.f4092j.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (eVar == b.this.f4092j.get(i11).f4117b) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 != -1) {
                int i12 = i11 + 1;
                if (i12 < b.this.f4092j.size()) {
                    dVar = b.this.f4092j.get(i12);
                }
                b.this.f4090h.postAtTime(new a(dVar, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void g(e eVar, MenuItem menuItem) {
            b.this.f4090h.removeCallbacksAndMessages(eVar);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f4116a;

        /* renamed from: b  reason: collision with root package name */
        public final e f4117b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4118c;

        public d(MenuPopupWindow menuPopupWindow, e eVar, int i11) {
            this.f4116a = menuPopupWindow;
            this.f4117b = eVar;
            this.f4118c = i11;
        }

        public ListView a() {
            return this.f4116a.h();
        }
    }

    public b(Context context, View view, int i11, int i12, boolean z11) {
        this.f4085c = context;
        this.f4098p = view;
        this.f4087e = i11;
        this.f4088f = i12;
        this.f4089g = z11;
        this.f4105w = false;
        this.f4100r = t();
        Resources resources = context.getResources();
        this.f4086d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f4090h = new Handler();
    }

    public void a(e eVar) {
        eVar.addMenuPresenter(this, this.f4085c);
        if (isShowing()) {
            v(eVar);
        } else {
            this.f4091i.add(eVar);
        }
    }

    public boolean b() {
        return false;
    }

    public void dismiss() {
        int size = this.f4092j.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f4092j.toArray(new d[size]);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                d dVar = dVarArr[i11];
                if (dVar.f4116a.isShowing()) {
                    dVar.f4116a.dismiss();
                }
            }
        }
    }

    public void e(View view) {
        if (this.f4098p != view) {
            this.f4098p = view;
            this.f4097o = f.b(this.f4096n, h0.F(view));
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z11) {
        this.f4105w = z11;
    }

    public ListView h() {
        if (this.f4092j.isEmpty()) {
            return null;
        }
        List<d> list = this.f4092j;
        return list.get(list.size() - 1).a();
    }

    public void i(int i11) {
        if (this.f4096n != i11) {
            this.f4096n = i11;
            this.f4097o = f.b(i11, h0.F(this.f4098p));
        }
    }

    public boolean isShowing() {
        return this.f4092j.size() > 0 && this.f4092j.get(0).f4116a.isShowing();
    }

    public void j(int i11) {
        this.f4101s = true;
        this.f4103u = i11;
    }

    public void k(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    public void l(boolean z11) {
        this.f4106x = z11;
    }

    public void m(int i11) {
        this.f4102t = true;
        this.f4104v = i11;
    }

    public void onCloseMenu(e eVar, boolean z11) {
        int q11 = q(eVar);
        if (q11 >= 0) {
            int i11 = q11 + 1;
            if (i11 < this.f4092j.size()) {
                this.f4092j.get(i11).f4117b.close(false);
            }
            d remove = this.f4092j.remove(q11);
            remove.f4117b.removeMenuPresenter(this);
            if (this.B) {
                remove.f4116a.P((Object) null);
                remove.f4116a.B(0);
            }
            remove.f4116a.dismiss();
            int size = this.f4092j.size();
            if (size > 0) {
                this.f4100r = this.f4092j.get(size - 1).f4118c;
            } else {
                this.f4100r = t();
            }
            if (size == 0) {
                dismiss();
                i.a aVar = this.f4107y;
                if (aVar != null) {
                    aVar.onCloseMenu(eVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f4108z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f4108z.removeGlobalOnLayoutListener(this.f4093k);
                    }
                    this.f4108z = null;
                }
                this.f4099q.removeOnAttachStateChangeListener(this.f4094l);
                this.A.onDismiss();
            } else if (z11) {
                this.f4092j.get(0).f4117b.close(false);
            }
        }
    }

    public void onDismiss() {
        d dVar;
        int size = this.f4092j.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f4092j.get(i11);
            if (!dVar.f4116a.isShowing()) {
                break;
            }
            i11++;
        }
        if (dVar != null) {
            dVar.f4117b.close(false);
        }
    }

    public boolean onKey(View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(l lVar) {
        for (d next : this.f4092j) {
            if (lVar == next.f4117b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        a(lVar);
        i.a aVar = this.f4107y;
        if (aVar != null) {
            aVar.a(lVar);
        }
        return true;
    }

    public final MenuPopupWindow p() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f4085c, (AttributeSet) null, this.f4087e, this.f4088f);
        menuPopupWindow.Q(this.f4095m);
        menuPopupWindow.I(this);
        menuPopupWindow.H(this);
        menuPopupWindow.A(this.f4098p);
        menuPopupWindow.D(this.f4097o);
        menuPopupWindow.G(true);
        menuPopupWindow.F(2);
        return menuPopupWindow;
    }

    public final int q(e eVar) {
        int size = this.f4092j.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (eVar == this.f4092j.get(i11).f4117b) {
                return i11;
            }
        }
        return -1;
    }

    public final MenuItem r(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = eVar.getItem(i11);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View s(d dVar, e eVar) {
        int i11;
        d dVar2;
        int firstVisiblePosition;
        MenuItem r11 = r(dVar.f4117b, eVar);
        if (r11 == null) {
            return null;
        }
        ListView a11 = dVar.a();
        ListAdapter adapter = a11.getAdapter();
        int i12 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i11 = headerViewListAdapter.getHeadersCount();
            dVar2 = (d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (d) adapter;
            i11 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i12 >= count) {
                i12 = -1;
                break;
            } else if (r11 == dVar2.getItem(i12)) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 != -1 && (firstVisiblePosition = (i12 + i11) - a11.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a11.getChildCount()) {
            return a11.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    public void setCallback(i.a aVar) {
        this.f4107y = aVar;
    }

    public void show() {
        if (!isShowing()) {
            for (e v11 : this.f4091i) {
                v(v11);
            }
            this.f4091i.clear();
            View view = this.f4098p;
            this.f4099q = view;
            if (view != null) {
                boolean z11 = this.f4108z == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f4108z = viewTreeObserver;
                if (z11) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f4093k);
                }
                this.f4099q.addOnAttachStateChangeListener(this.f4094l);
            }
        }
    }

    public final int t() {
        return h0.F(this.f4098p) == 1 ? 0 : 1;
    }

    public final int u(int i11) {
        List<d> list = this.f4092j;
        ListView a11 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a11.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f4099q.getWindowVisibleDisplayFrame(rect);
        if (this.f4100r == 1) {
            if (iArr[0] + a11.getWidth() + i11 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i11 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void updateMenuView(boolean z11) {
        for (d a11 : this.f4092j) {
            h.c.o(a11.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public final void v(e eVar) {
        View view;
        d dVar;
        int i11;
        int i12;
        int i13;
        LayoutInflater from = LayoutInflater.from(this.f4085c);
        d dVar2 = new d(eVar, from, this.f4089g, C);
        if (!isShowing() && this.f4105w) {
            dVar2.d(true);
        } else if (isShowing()) {
            dVar2.d(h.c.n(eVar));
        }
        int d11 = h.c.d(dVar2, (ViewGroup) null, this.f4085c, this.f4086d);
        MenuPopupWindow p11 = p();
        p11.m(dVar2);
        p11.C(d11);
        p11.D(this.f4097o);
        if (this.f4092j.size() > 0) {
            List<d> list = this.f4092j;
            dVar = list.get(list.size() - 1);
            view = s(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            p11.R(false);
            p11.O((Object) null);
            int u11 = u(d11);
            boolean z11 = u11 == 1;
            this.f4100r = u11;
            if (Build.VERSION.SDK_INT >= 26) {
                p11.A(view);
                i12 = 0;
                i11 = 0;
            } else {
                int[] iArr = new int[2];
                this.f4098p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f4097o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f4098p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i11 = iArr2[0] - iArr[0];
                i12 = iArr2[1] - iArr[1];
            }
            if ((this.f4097o & 5) != 5) {
                if (z11) {
                    d11 = view.getWidth();
                }
                i13 = i11 - d11;
                p11.j(i13);
                p11.J(true);
                p11.c(i12);
            } else if (!z11) {
                d11 = view.getWidth();
                i13 = i11 - d11;
                p11.j(i13);
                p11.J(true);
                p11.c(i12);
            }
            i13 = i11 + d11;
            p11.j(i13);
            p11.J(true);
            p11.c(i12);
        } else {
            if (this.f4101s) {
                p11.j(this.f4103u);
            }
            if (this.f4102t) {
                p11.c(this.f4104v);
            }
            p11.E(c());
        }
        this.f4092j.add(new d(p11, eVar, this.f4100r));
        p11.show();
        ListView h11 = p11.h();
        h11.setOnKeyListener(this);
        if (dVar == null && this.f4106x && eVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, h11, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(eVar.getHeaderTitle());
            h11.addHeaderView(frameLayout, (Object) null, false);
            p11.show();
        }
    }
}
