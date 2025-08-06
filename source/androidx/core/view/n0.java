package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<View> f8660a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f8661b = null;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f8662c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f8663d = -1;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o0 f8664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f8665c;

        public a(o0 o0Var, View view) {
            this.f8664b = o0Var;
            this.f8665c = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f8664b.a(this.f8665c);
        }

        public void onAnimationEnd(Animator animator) {
            this.f8664b.b(this.f8665c);
        }

        public void onAnimationStart(Animator animator) {
            this.f8664b.c(this.f8665c);
        }
    }

    public static class b {
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    public static class c implements o0 {

        /* renamed from: a  reason: collision with root package name */
        public n0 f8667a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8668b;

        public c(n0 n0Var) {
            this.f8667a = n0Var;
        }

        public void a(View view) {
            Object tag = view.getTag(2113929216);
            o0 o0Var = tag instanceof o0 ? (o0) tag : null;
            if (o0Var != null) {
                o0Var.a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.view.o0} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.view.n0 r0 = r3.f8667a
                int r0 = r0.f8663d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.view.n0 r0 = r3.f8667a
                r0.f8663d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f8668b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.view.n0 r0 = r3.f8667a
                java.lang.Runnable r1 = r0.f8662c
                if (r1 == 0) goto L_0x0024
                r0.f8662c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.view.o0
                if (r1 == 0) goto L_0x0031
                r2 = r0
                androidx.core.view.o0 r2 = (androidx.core.view.o0) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.b(r4)
            L_0x0036:
                r4 = 1
                r3.f8668b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.n0.c.b(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.view.o0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f8668b = r0
                androidx.core.view.n0 r0 = r3.f8667a
                int r0 = r0.f8663d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.view.n0 r0 = r3.f8667a
                java.lang.Runnable r2 = r0.f8661b
                if (r2 == 0) goto L_0x001a
                r0.f8661b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.view.o0
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.view.o0 r1 = (androidx.core.view.o0) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.c(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.n0.c.c(android.view.View):void");
        }
    }

    public n0(View view) {
        this.f8660a = new WeakReference<>(view);
    }

    public n0 b(float f11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().alpha(f11);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.f8660a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public n0 f(float f11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().scaleX(f11);
        }
        return this;
    }

    public n0 g(float f11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().scaleY(f11);
        }
        return this;
    }

    public n0 h(long j11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().setDuration(j11);
        }
        return this;
    }

    public n0 i(Interpolator interpolator) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public n0 j(o0 o0Var) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                k(view, o0Var);
            } else {
                view.setTag(2113929216, o0Var);
                k(view, new c(this));
            }
        }
        return this;
    }

    public final void k(View view, o0 o0Var) {
        if (o0Var != null) {
            view.animate().setListener(new a(o0Var, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public n0 l(long j11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().setStartDelay(j11);
        }
        return this;
    }

    public n0 m(p0 p0Var) {
        View view = (View) this.f8660a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            m0 m0Var = null;
            if (p0Var != null) {
                m0Var = new m0(p0Var, view);
            }
            b.a(view.animate(), m0Var);
        }
        return this;
    }

    public void n() {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public n0 o(float f11) {
        View view = (View) this.f8660a.get();
        if (view != null) {
            view.animate().translationY(f11);
        }
        return this;
    }
}
