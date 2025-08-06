package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.i;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.t;
import androidx.core.view.u;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements p, t, r, s {
    public static final int[] G = {R$attr.actionBarSize, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final u F;

    /* renamed from: b  reason: collision with root package name */
    public int f4239b;

    /* renamed from: c  reason: collision with root package name */
    public int f4240c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ContentFrameLayout f4241d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContainer f4242e;

    /* renamed from: f  reason: collision with root package name */
    public q f4243f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f4244g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4245h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4246i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4247j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4248k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f4249l;

    /* renamed from: m  reason: collision with root package name */
    public int f4250m;

    /* renamed from: n  reason: collision with root package name */
    public int f4251n;

    /* renamed from: o  reason: collision with root package name */
    public final Rect f4252o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    public final Rect f4253p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    public final Rect f4254q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    public final Rect f4255r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    public final Rect f4256s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public final Rect f4257t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    public final Rect f4258u = new Rect();

    /* renamed from: v  reason: collision with root package name */
    public WindowInsetsCompat f4259v;

    /* renamed from: w  reason: collision with root package name */
    public WindowInsetsCompat f4260w;

    /* renamed from: x  reason: collision with root package name */
    public WindowInsetsCompat f4261x;

    /* renamed from: y  reason: collision with root package name */
    public WindowInsetsCompat f4262y;

    /* renamed from: z  reason: collision with root package name */
    public d f4263z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f4249l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f4249l = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f4242e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f4242e.animate().translationY((float) (-ActionBarOverlayLayout.this.f4242e.getHeight())).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
        void enableContentAnimations(boolean z11);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i11);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f8494b;
        this.f4259v = windowInsetsCompat;
        this.f4260w = windowInsetsCompat;
        this.f4261x = windowInsetsCompat;
        this.f4262y = windowInsetsCompat;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        p(context);
        this.F = new u(this);
    }

    public boolean a() {
        u();
        return this.f4243f.a();
    }

    public boolean b() {
        u();
        return this.f4243f.b();
    }

    public boolean c() {
        u();
        return this.f4243f.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean d() {
        u();
        return this.f4243f.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f4244g != null && !this.f4245h) {
            int bottom = this.f4242e.getVisibility() == 0 ? (int) (((float) this.f4242e.getBottom()) + this.f4242e.getTranslationY() + 0.5f) : 0;
            this.f4244g.setBounds(0, bottom, getWidth(), this.f4244g.getIntrinsicHeight() + bottom);
            this.f4244g.draw(canvas);
        }
    }

    public void e(Menu menu, i.a aVar) {
        u();
        this.f4243f.e(menu, aVar);
    }

    public void f() {
        u();
        this.f4243f.f();
    }

    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        u();
        boolean k11 = k(this.f4242e, rect, true, true, false, true);
        this.f4255r.set(rect);
        o0.a(this, this.f4255r, this.f4252o);
        if (!this.f4256s.equals(this.f4255r)) {
            this.f4256s.set(this.f4255r);
            k11 = true;
        }
        if (!this.f4253p.equals(this.f4252o)) {
            this.f4253p.set(this.f4252o);
            k11 = true;
        }
        if (k11) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        u();
        return this.f4243f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f4242e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        u();
        return this.f4243f.getTitle();
    }

    public void h(int i11) {
        u();
        if (i11 == 2) {
            this.f4243f.p();
        } else if (i11 == 5) {
            this.f4243f.x();
        } else if (i11 == 109) {
            setOverlayMode(true);
        }
    }

    public void i() {
        u();
        this.f4243f.s();
    }

    public final void j() {
        o();
        this.E.run();
    }

    public final boolean k(View view, Rect rect, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        int i11;
        int i12;
        int i13;
        int i14;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z11 || layoutParams.leftMargin == (i14 = rect.left)) {
            z15 = false;
        } else {
            layoutParams.leftMargin = i14;
            z15 = true;
        }
        if (z12 && layoutParams.topMargin != (i13 = rect.top)) {
            layoutParams.topMargin = i13;
            z15 = true;
        }
        if (z14 && layoutParams.rightMargin != (i12 = rect.right)) {
            layoutParams.rightMargin = i12;
            z15 = true;
        }
        if (!z13 || layoutParams.bottomMargin == (i11 = rect.bottom)) {
            return z15;
        }
        layoutParams.bottomMargin = i11;
        return true;
    }

    /* renamed from: l */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: m */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final q n(View view) {
        if (view instanceof q) {
            return (q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void o() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        u();
        WindowInsetsCompat y11 = WindowInsetsCompat.y(windowInsets, this);
        boolean k11 = k(this.f4242e, new Rect(y11.k(), y11.m(), y11.l(), y11.j()), true, true, false, true);
        h0.i(this, y11, this.f4252o);
        Rect rect = this.f4252o;
        WindowInsetsCompat o11 = y11.o(rect.left, rect.top, rect.right, rect.bottom);
        this.f4259v = o11;
        boolean z11 = true;
        if (!this.f4260w.equals(o11)) {
            this.f4260w = this.f4259v;
            k11 = true;
        }
        if (!this.f4253p.equals(this.f4252o)) {
            this.f4253p.set(this.f4252o);
        } else {
            z11 = k11;
        }
        if (z11) {
            requestLayout();
        }
        return y11.a().c().b().w();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p(getContext());
        h0.u0(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i16 = layoutParams.leftMargin + paddingLeft;
                int i17 = layoutParams.topMargin + paddingTop;
                childAt.layout(i16, i17, measuredWidth + i16, measuredHeight + i17);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        u();
        measureChildWithMargins(this.f4242e, i11, 0, i12, 0);
        LayoutParams layoutParams = (LayoutParams) this.f4242e.getLayoutParams();
        int max = Math.max(0, this.f4242e.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f4242e.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f4242e.getMeasuredState());
        boolean z11 = (h0.T(this) & 256) != 0;
        if (z11) {
            i13 = this.f4239b;
            if (this.f4247j && this.f4242e.getTabContainer() != null) {
                i13 += this.f4239b;
            }
        } else {
            i13 = this.f4242e.getVisibility() != 8 ? this.f4242e.getMeasuredHeight() : 0;
        }
        this.f4254q.set(this.f4252o);
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 21) {
            this.f4261x = this.f4259v;
        } else {
            this.f4257t.set(this.f4255r);
        }
        if (!this.f4246i && !z11) {
            Rect rect = this.f4254q;
            rect.top += i13;
            rect.bottom += 0;
            if (i14 >= 21) {
                this.f4261x = this.f4261x.o(0, i13, 0, 0);
            }
        } else if (i14 >= 21) {
            this.f4261x = new WindowInsetsCompat.Builder(this.f4261x).c(t0.d.b(this.f4261x.k(), this.f4261x.m() + i13, this.f4261x.l(), this.f4261x.j() + 0)).a();
        } else {
            Rect rect2 = this.f4257t;
            rect2.top += i13;
            rect2.bottom += 0;
        }
        k(this.f4241d, this.f4254q, true, true, true, true);
        if (i14 >= 21 && !this.f4262y.equals(this.f4261x)) {
            WindowInsetsCompat windowInsetsCompat = this.f4261x;
            this.f4262y = windowInsetsCompat;
            h0.j(this.f4241d, windowInsetsCompat);
        } else if (i14 < 21 && !this.f4258u.equals(this.f4257t)) {
            this.f4258u.set(this.f4257t);
            this.f4241d.a(this.f4257t);
        }
        measureChildWithMargins(this.f4241d, i11, 0, i12, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f4241d.getLayoutParams();
        int max3 = Math.max(max, this.f4241d.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.f4241d.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f4241d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i11, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i12, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f11, float f12, boolean z11) {
        if (!this.f4248k || !z11) {
            return false;
        }
        if (w(f12)) {
            j();
        } else {
            v();
        }
        this.f4249l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f11, float f12) {
        return false;
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr) {
    }

    public void onNestedPreScroll(View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 0) {
            onNestedPreScroll(view, i11, i12, iArr);
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        onNestedScroll(view, i11, i12, i13, i14, i15);
    }

    public void onNestedScrollAccepted(View view, View view2, int i11, int i12) {
        if (i12 == 0) {
            onNestedScrollAccepted(view, view2, i11);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11, int i12) {
        return i12 == 0 && onStartNestedScroll(view, view2, i11);
    }

    public void onStopNestedScroll(View view, int i11) {
        if (i11 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i11) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i11);
        }
        u();
        int i12 = this.f4251n ^ i11;
        this.f4251n = i11;
        boolean z11 = false;
        boolean z12 = (i11 & 4) == 0;
        if ((i11 & 256) != 0) {
            z11 = true;
        }
        d dVar = this.f4263z;
        if (dVar != null) {
            dVar.enableContentAnimations(!z11);
            if (z12 || !z11) {
                this.f4263z.showForSystem();
            } else {
                this.f4263z.hideForSystem();
            }
        }
        if ((i12 & 256) != 0 && this.f4263z != null) {
            h0.u0(this);
        }
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        this.f4240c = i11;
        d dVar = this.f4263z;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i11);
        }
    }

    public final void p(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z11 = false;
        this.f4239b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f4244g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z11 = true;
        }
        this.f4245h = z11;
        this.A = new OverScroller(context);
    }

    public boolean q() {
        return this.f4248k;
    }

    public boolean r() {
        return this.f4246i;
    }

    public final void s() {
        o();
        postDelayed(this.E, 600);
    }

    public void setActionBarHideOffset(int i11) {
        o();
        this.f4242e.setTranslationY((float) (-Math.max(0, Math.min(i11, this.f4242e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f4263z = dVar;
        if (getWindowToken() != null) {
            this.f4263z.onWindowVisibilityChanged(this.f4240c);
            int i11 = this.f4251n;
            if (i11 != 0) {
                onWindowSystemUiVisibilityChanged(i11);
                h0.u0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z11) {
        this.f4247j = z11;
    }

    public void setHideOnContentScrollEnabled(boolean z11) {
        if (z11 != this.f4248k) {
            this.f4248k = z11;
            if (!z11) {
                o();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i11) {
        u();
        this.f4243f.setIcon(i11);
    }

    public void setLogo(int i11) {
        u();
        this.f4243f.H(i11);
    }

    public void setOverlayMode(boolean z11) {
        this.f4246i = z11;
        this.f4245h = z11 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z11) {
    }

    public void setUiOptions(int i11) {
    }

    public void setWindowCallback(Window.Callback callback) {
        u();
        this.f4243f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        u();
        this.f4243f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t() {
        o();
        postDelayed(this.D, 600);
    }

    public void u() {
        if (this.f4241d == null) {
            this.f4241d = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f4242e = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f4243f = n(findViewById(R$id.action_bar));
        }
    }

    public final void v() {
        o();
        this.D.run();
    }

    public final boolean w(float f11) {
        this.A.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.f4242e.getHeight();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            onNestedScroll(view, i11, i12, i13, i14);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i11) {
        this.F.b(view, view2, i11);
        this.f4250m = getActionBarHideOffset();
        o();
        d dVar = this.f4263z;
        if (dVar != null) {
            dVar.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i11) {
        if ((i11 & 2) == 0 || this.f4242e.getVisibility() != 0) {
            return false;
        }
        return this.f4248k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f4248k && !this.f4249l) {
            if (this.f4250m <= this.f4242e.getHeight()) {
                t();
            } else {
                s();
            }
        }
        d dVar = this.f4263z;
        if (dVar != null) {
            dVar.onContentScrollStopped();
        }
    }

    public void onNestedScroll(View view, int i11, int i12, int i13, int i14) {
        int i15 = this.f4250m + i12;
        this.f4250m = i15;
        setActionBarHideOffset(i15);
    }

    public void setIcon(Drawable drawable) {
        u();
        this.f4243f.setIcon(drawable);
    }
}
