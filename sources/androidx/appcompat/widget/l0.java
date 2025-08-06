package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.h0;
import androidx.core.view.j0;

public class l0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: l  reason: collision with root package name */
    public static l0 f4610l;

    /* renamed from: m  reason: collision with root package name */
    public static l0 f4611m;

    /* renamed from: b  reason: collision with root package name */
    public final View f4612b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f4613c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4614d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f4615e = new k0(this);

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f4616f = new j0(this);

    /* renamed from: g  reason: collision with root package name */
    public int f4617g;

    /* renamed from: h  reason: collision with root package name */
    public int f4618h;

    /* renamed from: i  reason: collision with root package name */
    public m0 f4619i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4620j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4621k;

    public l0(View view, CharSequence charSequence) {
        this.f4612b = view;
        this.f4613c = charSequence;
        this.f4614d = j0.d(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    public static void g(l0 l0Var) {
        l0 l0Var2 = f4610l;
        if (l0Var2 != null) {
            l0Var2.b();
        }
        f4610l = l0Var;
        if (l0Var != null) {
            l0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        l0 l0Var = f4610l;
        if (l0Var != null && l0Var.f4612b == view) {
            g((l0) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            l0 l0Var2 = f4611m;
            if (l0Var2 != null && l0Var2.f4612b == view) {
                l0Var2.d();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new l0(view, charSequence);
    }

    public final void b() {
        this.f4612b.removeCallbacks(this.f4615e);
    }

    public final void c() {
        this.f4621k = true;
    }

    public void d() {
        if (f4611m == this) {
            f4611m = null;
            m0 m0Var = this.f4619i;
            if (m0Var != null) {
                m0Var.c();
                this.f4619i = null;
                c();
                this.f4612b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f4610l == this) {
            g((l0) null);
        }
        this.f4612b.removeCallbacks(this.f4616f);
    }

    public final void f() {
        this.f4612b.postDelayed(this.f4615e, (long) ViewConfiguration.getLongPressTimeout());
    }

    public void i(boolean z11) {
        long j11;
        int i11;
        long j12;
        if (h0.Z(this.f4612b)) {
            g((l0) null);
            l0 l0Var = f4611m;
            if (l0Var != null) {
                l0Var.d();
            }
            f4611m = this;
            this.f4620j = z11;
            m0 m0Var = new m0(this.f4612b.getContext());
            this.f4619i = m0Var;
            m0Var.e(this.f4612b, this.f4617g, this.f4618h, this.f4620j, this.f4613c);
            this.f4612b.addOnAttachStateChangeListener(this);
            if (this.f4620j) {
                j11 = 2500;
            } else {
                if ((h0.T(this.f4612b) & 1) == 1) {
                    j12 = 3000;
                    i11 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j12 = 15000;
                    i11 = ViewConfiguration.getLongPressTimeout();
                }
                j11 = j12 - ((long) i11);
            }
            this.f4612b.removeCallbacks(this.f4616f);
            this.f4612b.postDelayed(this.f4616f, j11);
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        int x11 = (int) motionEvent.getX();
        int y11 = (int) motionEvent.getY();
        if (!this.f4621k && Math.abs(x11 - this.f4617g) <= this.f4614d && Math.abs(y11 - this.f4618h) <= this.f4614d) {
            return false;
        }
        this.f4617g = x11;
        this.f4618h = y11;
        this.f4621k = false;
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f4619i != null && this.f4620j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f4612b.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f4612b.isEnabled() && this.f4619i == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f4617g = view.getWidth() / 2;
        this.f4618h = view.getHeight() / 2;
        i(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
