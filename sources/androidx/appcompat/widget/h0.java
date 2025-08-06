package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.n0;
import com.google.android.material.badge.BadgeDrawable;

public class h0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f4571a;

    /* renamed from: b  reason: collision with root package name */
    public int f4572b;

    /* renamed from: c  reason: collision with root package name */
    public View f4573c;

    /* renamed from: d  reason: collision with root package name */
    public Spinner f4574d;

    /* renamed from: e  reason: collision with root package name */
    public View f4575e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f4576f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f4577g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f4578h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4579i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f4580j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f4581k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f4582l;

    /* renamed from: m  reason: collision with root package name */
    public Window.Callback f4583m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4584n;

    /* renamed from: o  reason: collision with root package name */
    public ActionMenuPresenter f4585o;

    /* renamed from: p  reason: collision with root package name */
    public int f4586p;

    /* renamed from: q  reason: collision with root package name */
    public int f4587q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f4588r;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final h.a f4589b;

        public a() {
            this.f4589b = new h.a(h0.this.f4571a.getContext(), 0, 16908332, 0, 0, h0.this.f4580j);
        }

        public void onClick(View view) {
            h0 h0Var = h0.this;
            Window.Callback callback = h0Var.f4583m;
            if (callback != null && h0Var.f4584n) {
                callback.onMenuItemSelected(0, this.f4589b);
            }
        }
    }

    public class b extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4591a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4592b;

        public b(int i11) {
            this.f4592b = i11;
        }

        public void a(View view) {
            this.f4591a = true;
        }

        public void b(View view) {
            if (!this.f4591a) {
                h0.this.f4571a.setVisibility(this.f4592b);
            }
        }

        public void c(View view) {
            h0.this.f4571a.setVisibility(0);
        }
    }

    public h0(Toolbar toolbar, boolean z11) {
        this(toolbar, z11, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public void A(int i11) {
        Spinner spinner = this.f4574d;
        if (spinner != null) {
            spinner.setSelection(i11);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public Menu B() {
        return this.f4571a.getMenu();
    }

    public n0 C(int i11, long j11) {
        return androidx.core.view.h0.e(this.f4571a).b(i11 == 0 ? 1.0f : 0.0f).h(j11).j(new b(i11));
    }

    public boolean D() {
        return this.f4576f != null;
    }

    public ViewGroup E() {
        return this.f4571a;
    }

    public void F(boolean z11) {
    }

    public void G(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f4573c;
        if (view != null && view.getParent() == (toolbar = this.f4571a)) {
            toolbar.removeView(this.f4573c);
        }
        this.f4573c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f4586p == 2) {
            this.f4571a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f4573c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f3729a = BadgeDrawable.BOTTOM_START;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void H(int i11) {
        u(i11 != 0 ? c.a.b(getContext(), i11) : null);
    }

    public void I(int i11) {
        y(i11 != 0 ? c.a.b(getContext(), i11) : null);
    }

    public void J(i.a aVar, e.a aVar2) {
        this.f4571a.setMenuCallbacks(aVar, aVar2);
    }

    public void K(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        O();
        this.f4574d.setAdapter(spinnerAdapter);
        this.f4574d.setOnItemSelectedListener(onItemSelectedListener);
    }

    public boolean L() {
        return this.f4577g != null;
    }

    public CharSequence M() {
        return this.f4571a.getSubtitle();
    }

    public final int N() {
        if (this.f4571a.getNavigationIcon() == null) {
            return 11;
        }
        this.f4588r = this.f4571a.getNavigationIcon();
        return 15;
    }

    public final void O() {
        if (this.f4574d == null) {
            this.f4574d = new AppCompatSpinner(getContext(), (AttributeSet) null, R$attr.actionDropDownStyle);
            this.f4574d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    public void P(int i11) {
        if (i11 != this.f4587q) {
            this.f4587q = i11;
            if (TextUtils.isEmpty(this.f4571a.getNavigationContentDescription())) {
                o(this.f4587q);
            }
        }
    }

    public final void Q(CharSequence charSequence) {
        this.f4580j = charSequence;
        if ((this.f4572b & 8) != 0) {
            this.f4571a.setTitle(charSequence);
            if (this.f4579i) {
                androidx.core.view.h0.A0(this.f4571a.getRootView(), charSequence);
            }
        }
    }

    public final void R() {
        if ((this.f4572b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f4582l)) {
            this.f4571a.setNavigationContentDescription(this.f4587q);
        } else {
            this.f4571a.setNavigationContentDescription(this.f4582l);
        }
    }

    public final void S() {
        if ((this.f4572b & 4) != 0) {
            Toolbar toolbar = this.f4571a;
            Drawable drawable = this.f4578h;
            if (drawable == null) {
                drawable = this.f4588r;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f4571a.setNavigationIcon((Drawable) null);
    }

    public final void T() {
        Drawable drawable;
        int i11 = this.f4572b;
        if ((i11 & 2) == 0) {
            drawable = null;
        } else if ((i11 & 1) != 0) {
            drawable = this.f4577g;
            if (drawable == null) {
                drawable = this.f4576f;
            }
        } else {
            drawable = this.f4576f;
        }
        this.f4571a.setLogo(drawable);
    }

    public boolean a() {
        return this.f4571a.canShowOverflowMenu();
    }

    public boolean b() {
        return this.f4571a.showOverflowMenu();
    }

    public boolean c() {
        return this.f4571a.isOverflowMenuShowing();
    }

    public void collapseActionView() {
        this.f4571a.collapseActionView();
    }

    public boolean d() {
        return this.f4571a.hideOverflowMenu();
    }

    public void e(Menu menu, i.a aVar) {
        if (this.f4585o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f4571a.getContext());
            this.f4585o = actionMenuPresenter;
            actionMenuPresenter.i(R$id.action_menu_presenter);
        }
        this.f4585o.setCallback(aVar);
        this.f4571a.setMenu((e) menu, this.f4585o);
    }

    public void f() {
        this.f4584n = true;
    }

    public boolean g() {
        return this.f4571a.isOverflowMenuShowPending();
    }

    public Context getContext() {
        return this.f4571a.getContext();
    }

    public int getHeight() {
        return this.f4571a.getHeight();
    }

    public CharSequence getTitle() {
        return this.f4571a.getTitle();
    }

    public int getVisibility() {
        return this.f4571a.getVisibility();
    }

    public boolean h() {
        return this.f4571a.hasExpandedActionView();
    }

    public boolean i() {
        return this.f4571a.isTitleTruncated();
    }

    public void j(int i11) {
        View view;
        int i12 = this.f4572b ^ i11;
        this.f4572b = i11;
        if (i12 != 0) {
            if ((i12 & 4) != 0) {
                if ((i11 & 4) != 0) {
                    R();
                }
                S();
            }
            if ((i12 & 3) != 0) {
                T();
            }
            if ((i12 & 8) != 0) {
                if ((i11 & 8) != 0) {
                    this.f4571a.setTitle(this.f4580j);
                    this.f4571a.setSubtitle(this.f4581k);
                } else {
                    this.f4571a.setTitle((CharSequence) null);
                    this.f4571a.setSubtitle((CharSequence) null);
                }
            }
            if ((i12 & 16) != 0 && (view = this.f4575e) != null) {
                if ((i11 & 16) != 0) {
                    this.f4571a.addView(view);
                } else {
                    this.f4571a.removeView(view);
                }
            }
        }
    }

    public void k(CharSequence charSequence) {
        this.f4582l = charSequence;
        R();
    }

    public int l() {
        return this.f4586p;
    }

    public void m(int i11) {
        Toolbar toolbar;
        View view;
        Toolbar toolbar2;
        int i12 = this.f4586p;
        if (i11 != i12) {
            if (i12 == 1) {
                Spinner spinner = this.f4574d;
                if (spinner != null && spinner.getParent() == (toolbar = this.f4571a)) {
                    toolbar.removeView(this.f4574d);
                }
            } else if (i12 == 2 && (view = this.f4573c) != null && view.getParent() == (toolbar2 = this.f4571a)) {
                toolbar2.removeView(this.f4573c);
            }
            this.f4586p = i11;
            if (i11 == 0) {
                return;
            }
            if (i11 == 1) {
                O();
                this.f4571a.addView(this.f4574d, 0);
            } else if (i11 == 2) {
                View view2 = this.f4573c;
                if (view2 != null) {
                    this.f4571a.addView(view2, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f4573c.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.f3729a = BadgeDrawable.BOTTOM_START;
                }
            } else {
                throw new IllegalArgumentException("Invalid navigation mode " + i11);
            }
        }
    }

    public int n() {
        Spinner spinner = this.f4574d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public void o(int i11) {
        k(i11 == 0 ? null : getContext().getString(i11));
    }

    public void p() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public int q() {
        Spinner spinner = this.f4574d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public void r(boolean z11) {
        this.f4571a.setCollapsible(z11);
    }

    public void s() {
        this.f4571a.dismissPopupMenus();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        androidx.core.view.h0.B0(this.f4571a, drawable);
    }

    public void setIcon(int i11) {
        setIcon(i11 != 0 ? c.a.b(getContext(), i11) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f4579i = true;
        Q(charSequence);
    }

    public void setVisibility(int i11) {
        this.f4571a.setVisibility(i11);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f4583m = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f4579i) {
            Q(charSequence);
        }
    }

    public View t() {
        return this.f4575e;
    }

    public void u(Drawable drawable) {
        this.f4577g = drawable;
        T();
    }

    public int v() {
        return this.f4572b;
    }

    public void w(View view) {
        View view2 = this.f4575e;
        if (!(view2 == null || (this.f4572b & 16) == 0)) {
            this.f4571a.removeView(view2);
        }
        this.f4575e = view;
        if (view != null && (this.f4572b & 16) != 0) {
            this.f4571a.addView(view);
        }
    }

    public void x() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void y(Drawable drawable) {
        this.f4578h = drawable;
        S();
    }

    public void z(CharSequence charSequence) {
        this.f4581k = charSequence;
        if ((this.f4572b & 8) != 0) {
            this.f4571a.setSubtitle(charSequence);
        }
    }

    public h0(Toolbar toolbar, boolean z11, int i11, int i12) {
        Drawable drawable;
        this.f4586p = 0;
        this.f4587q = 0;
        this.f4571a = toolbar;
        this.f4580j = toolbar.getTitle();
        this.f4581k = toolbar.getSubtitle();
        this.f4579i = this.f4580j != null;
        this.f4578h = toolbar.getNavigationIcon();
        d0 v11 = d0.v(toolbar.getContext(), (AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f4588r = v11.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z11) {
            CharSequence p11 = v11.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p11)) {
                setTitle(p11);
            }
            CharSequence p12 = v11.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p12)) {
                z(p12);
            }
            Drawable g11 = v11.g(R$styleable.ActionBar_logo);
            if (g11 != null) {
                u(g11);
            }
            Drawable g12 = v11.g(R$styleable.ActionBar_icon);
            if (g12 != null) {
                setIcon(g12);
            }
            if (this.f4578h == null && (drawable = this.f4588r) != null) {
                y(drawable);
            }
            j(v11.k(R$styleable.ActionBar_displayOptions, 0));
            int n11 = v11.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (n11 != 0) {
                w(LayoutInflater.from(this.f4571a.getContext()).inflate(n11, this.f4571a, false));
                j(this.f4572b | 16);
            }
            int m11 = v11.m(R$styleable.ActionBar_height, 0);
            if (m11 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f4571a.getLayoutParams();
                layoutParams.height = m11;
                this.f4571a.setLayoutParams(layoutParams);
            }
            int e11 = v11.e(R$styleable.ActionBar_contentInsetStart, -1);
            int e12 = v11.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (e11 >= 0 || e12 >= 0) {
                this.f4571a.setContentInsetsRelative(Math.max(e11, 0), Math.max(e12, 0));
            }
            int n12 = v11.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar2 = this.f4571a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n12);
            }
            int n13 = v11.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (n13 != 0) {
                Toolbar toolbar3 = this.f4571a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n13);
            }
            int n14 = v11.n(R$styleable.ActionBar_popupTheme, 0);
            if (n14 != 0) {
                this.f4571a.setPopupTheme(n14);
            }
        } else {
            this.f4572b = N();
        }
        v11.w();
        P(i11);
        this.f4582l = this.f4571a.getNavigationContentDescription();
        this.f4571a.setNavigationOnClickListener(new a());
    }

    public void setIcon(Drawable drawable) {
        this.f4576f = drawable;
        T();
    }
}
