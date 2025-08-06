package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.h0;
import h.c;

public final class k extends c implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: w  reason: collision with root package name */
    public static final int f4181w = R$layout.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4182c;

    /* renamed from: d  reason: collision with root package name */
    public final e f4183d;

    /* renamed from: e  reason: collision with root package name */
    public final d f4184e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f4185f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4186g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4187h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4188i;

    /* renamed from: j  reason: collision with root package name */
    public final MenuPopupWindow f4189j;

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f4190k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f4191l = new b();

    /* renamed from: m  reason: collision with root package name */
    public PopupWindow.OnDismissListener f4192m;

    /* renamed from: n  reason: collision with root package name */
    public View f4193n;

    /* renamed from: o  reason: collision with root package name */
    public View f4194o;

    /* renamed from: p  reason: collision with root package name */
    public i.a f4195p;

    /* renamed from: q  reason: collision with root package name */
    public ViewTreeObserver f4196q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4197r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f4198s;

    /* renamed from: t  reason: collision with root package name */
    public int f4199t;

    /* renamed from: u  reason: collision with root package name */
    public int f4200u = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4201v;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (k.this.isShowing() && !k.this.f4189j.y()) {
                View view = k.this.f4194o;
                if (view == null || !view.isShown()) {
                    k.this.dismiss();
                } else {
                    k.this.f4189j.show();
                }
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = k.this.f4196q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    k.this.f4196q = view.getViewTreeObserver();
                }
                k kVar = k.this;
                kVar.f4196q.removeGlobalOnLayoutListener(kVar.f4190k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public k(Context context, e eVar, View view, int i11, int i12, boolean z11) {
        this.f4182c = context;
        this.f4183d = eVar;
        this.f4185f = z11;
        this.f4184e = new d(eVar, LayoutInflater.from(context), z11, f4181w);
        this.f4187h = i11;
        this.f4188i = i12;
        Resources resources = context.getResources();
        this.f4186g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f4193n = view;
        this.f4189j = new MenuPopupWindow(context, (AttributeSet) null, i11, i12);
        eVar.addMenuPresenter(this, context);
    }

    public void a(e eVar) {
    }

    public void dismiss() {
        if (isShowing()) {
            this.f4189j.dismiss();
        }
    }

    public void e(View view) {
        this.f4193n = view;
    }

    public boolean flagActionItems() {
        return false;
    }

    public void g(boolean z11) {
        this.f4184e.d(z11);
    }

    public ListView h() {
        return this.f4189j.h();
    }

    public void i(int i11) {
        this.f4200u = i11;
    }

    public boolean isShowing() {
        return !this.f4197r && this.f4189j.isShowing();
    }

    public void j(int i11) {
        this.f4189j.j(i11);
    }

    public void k(PopupWindow.OnDismissListener onDismissListener) {
        this.f4192m = onDismissListener;
    }

    public void l(boolean z11) {
        this.f4201v = z11;
    }

    public void m(int i11) {
        this.f4189j.c(i11);
    }

    public void onCloseMenu(e eVar, boolean z11) {
        if (eVar == this.f4183d) {
            dismiss();
            i.a aVar = this.f4195p;
            if (aVar != null) {
                aVar.onCloseMenu(eVar, z11);
            }
        }
    }

    public void onDismiss() {
        this.f4197r = true;
        this.f4183d.close();
        ViewTreeObserver viewTreeObserver = this.f4196q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f4196q = this.f4194o.getViewTreeObserver();
            }
            this.f4196q.removeGlobalOnLayoutListener(this.f4190k);
            this.f4196q = null;
        }
        this.f4194o.removeOnAttachStateChangeListener(this.f4191l);
        PopupWindow.OnDismissListener onDismissListener = this.f4192m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (lVar.hasVisibleItems()) {
            h hVar = new h(this.f4182c, lVar, this.f4194o, this.f4185f, this.f4187h, this.f4188i);
            hVar.j(this.f4195p);
            hVar.g(c.n(lVar));
            hVar.i(this.f4192m);
            this.f4192m = null;
            this.f4183d.close(false);
            int i11 = this.f4189j.i();
            int f11 = this.f4189j.f();
            if ((Gravity.getAbsoluteGravity(this.f4200u, h0.F(this.f4193n)) & 7) == 5) {
                i11 += this.f4193n.getWidth();
            }
            if (hVar.n(i11, f11)) {
                i.a aVar = this.f4195p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(lVar);
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.f4197r || (view = this.f4193n) == null) {
            return false;
        }
        this.f4194o = view;
        this.f4189j.H(this);
        this.f4189j.I(this);
        this.f4189j.G(true);
        View view2 = this.f4194o;
        boolean z11 = this.f4196q == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f4196q = viewTreeObserver;
        if (z11) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f4190k);
        }
        view2.addOnAttachStateChangeListener(this.f4191l);
        this.f4189j.A(view2);
        this.f4189j.D(this.f4200u);
        if (!this.f4198s) {
            this.f4199t = c.d(this.f4184e, (ViewGroup) null, this.f4182c, this.f4186g);
            this.f4198s = true;
        }
        this.f4189j.C(this.f4199t);
        this.f4189j.F(2);
        this.f4189j.E(c());
        this.f4189j.show();
        ListView h11 = this.f4189j.h();
        h11.setOnKeyListener(this);
        if (this.f4201v && this.f4183d.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f4182c).inflate(R$layout.abc_popup_menu_header_item_layout, h11, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f4183d.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            h11.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f4189j.m(this.f4184e);
        this.f4189j.show();
        return true;
    }

    public void setCallback(i.a aVar) {
        this.f4195p = aVar;
    }

    public void show() {
        if (!p()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z11) {
        this.f4198s = false;
        d dVar = this.f4184e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }
}
