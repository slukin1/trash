package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final WindowInsetsCompat f8494b;

    /* renamed from: a  reason: collision with root package name */
    public final k f8495a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Field f8497a;

        /* renamed from: b  reason: collision with root package name */
        public static Field f8498b;

        /* renamed from: c  reason: collision with root package name */
        public static Field f8499c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f8500d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f8497a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f8498b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f8499c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e11.getMessage(), e11);
            }
        }

        public static WindowInsetsCompat a(View view) {
            if (f8500d && view.isAttachedToWindow()) {
                try {
                    Object obj = f8497a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f8498b.get(obj);
                        Rect rect2 = (Rect) f8499c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat a11 = new Builder().b(t0.d.c(rect)).c(t0.d.c(rect2)).a();
                            a11.u(a11);
                            a11.d(view.getRootView());
                            return a11;
                        }
                    }
                } catch (IllegalAccessException e11) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e11.getMessage(), e11);
                }
            }
            return null;
        }
    }

    public static class d extends c {
        public d() {
        }

        public d(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsCompat f8508a;

        /* renamed from: b  reason: collision with root package name */
        public t0.d[] f8509b;

        public e() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void a() {
            t0.d[] dVarArr = this.f8509b;
            if (dVarArr != null) {
                t0.d dVar = dVarArr[l.a(1)];
                t0.d dVar2 = this.f8509b[l.a(2)];
                if (dVar2 == null) {
                    dVar2 = this.f8508a.f(2);
                }
                if (dVar == null) {
                    dVar = this.f8508a.f(1);
                }
                f(t0.d.a(dVar, dVar2));
                t0.d dVar3 = this.f8509b[l.a(16)];
                if (dVar3 != null) {
                    e(dVar3);
                }
                t0.d dVar4 = this.f8509b[l.a(32)];
                if (dVar4 != null) {
                    c(dVar4);
                }
                t0.d dVar5 = this.f8509b[l.a(64)];
                if (dVar5 != null) {
                    g(dVar5);
                }
            }
        }

        public WindowInsetsCompat b() {
            a();
            return this.f8508a;
        }

        public void c(t0.d dVar) {
        }

        public void d(t0.d dVar) {
        }

        public void e(t0.d dVar) {
        }

        public void f(t0.d dVar) {
        }

        public void g(t0.d dVar) {
        }

        public e(WindowInsetsCompat windowInsetsCompat) {
            this.f8508a = windowInsetsCompat;
        }
    }

    public static class h extends g {
        public h(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat a() {
            return WindowInsetsCompat.x(this.f8515c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!Objects.equals(this.f8515c, hVar.f8515c) || !Objects.equals(this.f8519g, hVar.f8519g)) {
                return false;
            }
            return true;
        }

        public c f() {
            return c.e(this.f8515c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f8515c.hashCode();
        }

        public h(WindowInsetsCompat windowInsetsCompat, h hVar) {
            super(windowInsetsCompat, (g) hVar);
        }
    }

    public static class j extends i {

        /* renamed from: q  reason: collision with root package name */
        public static final WindowInsetsCompat f8524q = WindowInsetsCompat.x(WindowInsets.CONSUMED);

        public j(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public final void d(View view) {
        }

        public t0.d g(int i11) {
            return t0.d.d(this.f8515c.getInsets(m.a(i11)));
        }

        public j(WindowInsetsCompat windowInsetsCompat, j jVar) {
            super(windowInsetsCompat, (i) jVar);
        }
    }

    public static class k {

        /* renamed from: b  reason: collision with root package name */
        public static final WindowInsetsCompat f8525b = new Builder().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsCompat f8526a;

        public k(WindowInsetsCompat windowInsetsCompat) {
            this.f8526a = windowInsetsCompat;
        }

        public WindowInsetsCompat a() {
            return this.f8526a;
        }

        public WindowInsetsCompat b() {
            return this.f8526a;
        }

        public WindowInsetsCompat c() {
            return this.f8526a;
        }

        public void d(View view) {
        }

        public void e(WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (o() != kVar.o() || n() != kVar.n() || !androidx.core.util.b.a(k(), kVar.k()) || !androidx.core.util.b.a(i(), kVar.i()) || !androidx.core.util.b.a(f(), kVar.f())) {
                return false;
            }
            return true;
        }

        public c f() {
            return null;
        }

        public t0.d g(int i11) {
            return t0.d.f16511e;
        }

        public t0.d h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.b.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public t0.d i() {
            return t0.d.f16511e;
        }

        public t0.d j() {
            return k();
        }

        public t0.d k() {
            return t0.d.f16511e;
        }

        public t0.d l() {
            return k();
        }

        public WindowInsetsCompat m(int i11, int i12, int i13, int i14) {
            return f8525b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void p(t0.d[] dVarArr) {
        }

        public void q(t0.d dVar) {
        }

        public void r(WindowInsetsCompat windowInsetsCompat) {
        }

        public void s(t0.d dVar) {
        }
    }

    public static final class l {
        public static int a(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 2) {
                return 1;
            }
            if (i11 == 4) {
                return 2;
            }
            if (i11 == 8) {
                return 3;
            }
            if (i11 == 16) {
                return 4;
            }
            if (i11 == 32) {
                return 5;
            }
            if (i11 == 64) {
                return 6;
            }
            if (i11 == 128) {
                return 7;
            }
            if (i11 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i11);
        }

        public static int b() {
            return 7;
        }
    }

    public static final class m {
        public static int a(int i11) {
            int i12;
            int i13 = 0;
            for (int i14 = 1; i14 <= 256; i14 <<= 1) {
                if ((i11 & i14) != 0) {
                    if (i14 == 1) {
                        i12 = WindowInsets.Type.statusBars();
                    } else if (i14 == 2) {
                        i12 = WindowInsets.Type.navigationBars();
                    } else if (i14 == 4) {
                        i12 = WindowInsets.Type.captionBar();
                    } else if (i14 == 8) {
                        i12 = WindowInsets.Type.ime();
                    } else if (i14 == 16) {
                        i12 = WindowInsets.Type.systemGestures();
                    } else if (i14 == 32) {
                        i12 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i14 == 64) {
                        i12 = WindowInsets.Type.tappableElement();
                    } else if (i14 == 128) {
                        i12 = WindowInsets.Type.displayCutout();
                    }
                    i13 |= i12;
                }
            }
            return i13;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f8494b = j.f8524q;
        } else {
            f8494b = k.f8525b;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            this.f8495a = new j(this, windowInsets);
        } else if (i11 >= 29) {
            this.f8495a = new i(this, windowInsets);
        } else if (i11 >= 28) {
            this.f8495a = new h(this, windowInsets);
        } else if (i11 >= 21) {
            this.f8495a = new g(this, windowInsets);
        } else if (i11 >= 20) {
            this.f8495a = new f(this, windowInsets);
        } else {
            this.f8495a = new k(this);
        }
    }

    public static t0.d p(t0.d dVar, int i11, int i12, int i13, int i14) {
        int max = Math.max(0, dVar.f16512a - i11);
        int max2 = Math.max(0, dVar.f16513b - i12);
        int max3 = Math.max(0, dVar.f16514c - i13);
        int max4 = Math.max(0, dVar.f16515d - i14);
        if (max == i11 && max2 == i12 && max3 == i13 && max4 == i14) {
            return dVar;
        }
        return t0.d.b(max, max2, max3, max4);
    }

    public static WindowInsetsCompat x(WindowInsets windowInsets) {
        return y(windowInsets, (View) null);
    }

    public static WindowInsetsCompat y(WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) androidx.core.util.h.g(windowInsets));
        if (view != null && h0.Z(view)) {
            windowInsetsCompat.u(h0.N(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public WindowInsetsCompat a() {
        return this.f8495a.a();
    }

    @Deprecated
    public WindowInsetsCompat b() {
        return this.f8495a.b();
    }

    @Deprecated
    public WindowInsetsCompat c() {
        return this.f8495a.c();
    }

    public void d(View view) {
        this.f8495a.d(view);
    }

    public c e() {
        return this.f8495a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return androidx.core.util.b.a(this.f8495a, ((WindowInsetsCompat) obj).f8495a);
    }

    public t0.d f(int i11) {
        return this.f8495a.g(i11);
    }

    @Deprecated
    public t0.d g() {
        return this.f8495a.h();
    }

    @Deprecated
    public t0.d h() {
        return this.f8495a.i();
    }

    public int hashCode() {
        k kVar = this.f8495a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @Deprecated
    public t0.d i() {
        return this.f8495a.j();
    }

    @Deprecated
    public int j() {
        return this.f8495a.k().f16515d;
    }

    @Deprecated
    public int k() {
        return this.f8495a.k().f16512a;
    }

    @Deprecated
    public int l() {
        return this.f8495a.k().f16514c;
    }

    @Deprecated
    public int m() {
        return this.f8495a.k().f16513b;
    }

    @Deprecated
    public boolean n() {
        return !this.f8495a.k().equals(t0.d.f16511e);
    }

    public WindowInsetsCompat o(int i11, int i12, int i13, int i14) {
        return this.f8495a.m(i11, i12, i13, i14);
    }

    public boolean q() {
        return this.f8495a.n();
    }

    @Deprecated
    public WindowInsetsCompat r(int i11, int i12, int i13, int i14) {
        return new Builder(this).c(t0.d.b(i11, i12, i13, i14)).a();
    }

    public void s(t0.d[] dVarArr) {
        this.f8495a.p(dVarArr);
    }

    public void t(t0.d dVar) {
        this.f8495a.q(dVar);
    }

    public void u(WindowInsetsCompat windowInsetsCompat) {
        this.f8495a.r(windowInsetsCompat);
    }

    public void v(t0.d dVar) {
        this.f8495a.s(dVar);
    }

    public WindowInsets w() {
        k kVar = this.f8495a;
        if (kVar instanceof f) {
            return ((f) kVar).f8515c;
        }
        return null;
    }

    public static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        public static Field f8501e = null;

        /* renamed from: f  reason: collision with root package name */
        public static boolean f8502f = false;

        /* renamed from: g  reason: collision with root package name */
        public static Constructor<WindowInsets> f8503g = null;

        /* renamed from: h  reason: collision with root package name */
        public static boolean f8504h = false;

        /* renamed from: c  reason: collision with root package name */
        public WindowInsets f8505c;

        /* renamed from: d  reason: collision with root package name */
        public t0.d f8506d;

        public b() {
            this.f8505c = h();
        }

        private static WindowInsets h() {
            if (!f8502f) {
                try {
                    f8501e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e11);
                }
                f8502f = true;
            }
            Field field = f8501e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e12);
                }
            }
            if (!f8504h) {
                try {
                    f8503g = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e13);
                }
                f8504h = true;
            }
            Constructor<WindowInsets> constructor = f8503g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e14) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e14);
                }
            }
            return null;
        }

        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat x11 = WindowInsetsCompat.x(this.f8505c);
            x11.s(this.f8509b);
            x11.v(this.f8506d);
            return x11;
        }

        public void d(t0.d dVar) {
            this.f8506d = dVar;
        }

        public void f(t0.d dVar) {
            WindowInsets windowInsets = this.f8505c;
            if (windowInsets != null) {
                this.f8505c = windowInsets.replaceSystemWindowInsets(dVar.f16512a, dVar.f16513b, dVar.f16514c, dVar.f16515d);
            }
        }

        public b(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f8505c = windowInsetsCompat.w();
        }
    }

    public static class c extends e {

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets.Builder f8507c;

        public c() {
            this.f8507c = new WindowInsets.Builder();
        }

        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat x11 = WindowInsetsCompat.x(this.f8507c.build());
            x11.s(this.f8509b);
            return x11;
        }

        public void c(t0.d dVar) {
            this.f8507c.setMandatorySystemGestureInsets(dVar.e());
        }

        public void d(t0.d dVar) {
            this.f8507c.setStableInsets(dVar.e());
        }

        public void e(t0.d dVar) {
            this.f8507c.setSystemGestureInsets(dVar.e());
        }

        public void f(t0.d dVar) {
            this.f8507c.setSystemWindowInsets(dVar.e());
        }

        public void g(t0.d dVar) {
            this.f8507c.setTappableElementInsets(dVar.e());
        }

        public c(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets w11 = windowInsetsCompat.w();
            if (w11 != null) {
                builder = new WindowInsets.Builder(w11);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f8507c = builder;
        }
    }

    public static class g extends f {

        /* renamed from: m  reason: collision with root package name */
        public t0.d f8520m = null;

        public g(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat b() {
            return WindowInsetsCompat.x(this.f8515c.consumeStableInsets());
        }

        public WindowInsetsCompat c() {
            return WindowInsetsCompat.x(this.f8515c.consumeSystemWindowInsets());
        }

        public final t0.d i() {
            if (this.f8520m == null) {
                this.f8520m = t0.d.b(this.f8515c.getStableInsetLeft(), this.f8515c.getStableInsetTop(), this.f8515c.getStableInsetRight(), this.f8515c.getStableInsetBottom());
            }
            return this.f8520m;
        }

        public boolean n() {
            return this.f8515c.isConsumed();
        }

        public void s(t0.d dVar) {
            this.f8520m = dVar;
        }

        public g(WindowInsetsCompat windowInsetsCompat, g gVar) {
            super(windowInsetsCompat, (f) gVar);
            this.f8520m = gVar.f8520m;
        }
    }

    public static class f extends k {

        /* renamed from: h  reason: collision with root package name */
        public static boolean f8510h = false;

        /* renamed from: i  reason: collision with root package name */
        public static Method f8511i;

        /* renamed from: j  reason: collision with root package name */
        public static Class<?> f8512j;

        /* renamed from: k  reason: collision with root package name */
        public static Field f8513k;

        /* renamed from: l  reason: collision with root package name */
        public static Field f8514l;

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets f8515c;

        /* renamed from: d  reason: collision with root package name */
        public t0.d[] f8516d;

        /* renamed from: e  reason: collision with root package name */
        public t0.d f8517e;

        /* renamed from: f  reason: collision with root package name */
        public WindowInsetsCompat f8518f;

        /* renamed from: g  reason: collision with root package name */
        public t0.d f8519g;

        public f(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f8517e = null;
            this.f8515c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private t0.d t(int i11, boolean z11) {
            t0.d dVar = t0.d.f16511e;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i11 & i12) != 0) {
                    dVar = t0.d.a(dVar, u(i12, z11));
                }
            }
            return dVar;
        }

        private t0.d v() {
            WindowInsetsCompat windowInsetsCompat = this.f8518f;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.h();
            }
            return t0.d.f16511e;
        }

        private t0.d w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f8510h) {
                    x();
                }
                Method method = f8511i;
                if (!(method == null || f8512j == null || f8513k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f8513k.get(f8514l.get(invoke));
                        if (rect != null) {
                            return t0.d.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e11) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f8511i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f8512j = cls;
                f8513k = cls.getDeclaredField("mVisibleInsets");
                f8514l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f8513k.setAccessible(true);
                f8514l.setAccessible(true);
            } catch (ReflectiveOperationException e11) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e11.getMessage(), e11);
            }
            f8510h = true;
        }

        public void d(View view) {
            t0.d w11 = w(view);
            if (w11 == null) {
                w11 = t0.d.f16511e;
            }
            q(w11);
        }

        public void e(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.u(this.f8518f);
            windowInsetsCompat.t(this.f8519g);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f8519g, ((f) obj).f8519g);
        }

        public t0.d g(int i11) {
            return t(i11, false);
        }

        public final t0.d k() {
            if (this.f8517e == null) {
                this.f8517e = t0.d.b(this.f8515c.getSystemWindowInsetLeft(), this.f8515c.getSystemWindowInsetTop(), this.f8515c.getSystemWindowInsetRight(), this.f8515c.getSystemWindowInsetBottom());
            }
            return this.f8517e;
        }

        public WindowInsetsCompat m(int i11, int i12, int i13, int i14) {
            Builder builder = new Builder(WindowInsetsCompat.x(this.f8515c));
            builder.c(WindowInsetsCompat.p(k(), i11, i12, i13, i14));
            builder.b(WindowInsetsCompat.p(i(), i11, i12, i13, i14));
            return builder.a();
        }

        public boolean o() {
            return this.f8515c.isRound();
        }

        public void p(t0.d[] dVarArr) {
            this.f8516d = dVarArr;
        }

        public void q(t0.d dVar) {
            this.f8519g = dVar;
        }

        public void r(WindowInsetsCompat windowInsetsCompat) {
            this.f8518f = windowInsetsCompat;
        }

        public t0.d u(int i11, boolean z11) {
            int i12;
            c cVar;
            if (i11 != 1) {
                t0.d dVar = null;
                if (i11 != 2) {
                    if (i11 == 8) {
                        t0.d[] dVarArr = this.f8516d;
                        if (dVarArr != null) {
                            dVar = dVarArr[l.a(8)];
                        }
                        if (dVar != null) {
                            return dVar;
                        }
                        t0.d k11 = k();
                        t0.d v11 = v();
                        int i13 = k11.f16515d;
                        if (i13 > v11.f16515d) {
                            return t0.d.b(0, 0, 0, i13);
                        }
                        t0.d dVar2 = this.f8519g;
                        if (dVar2 == null || dVar2.equals(t0.d.f16511e) || (i12 = this.f8519g.f16515d) <= v11.f16515d) {
                            return t0.d.f16511e;
                        }
                        return t0.d.b(0, 0, 0, i12);
                    } else if (i11 == 16) {
                        return j();
                    } else {
                        if (i11 == 32) {
                            return h();
                        }
                        if (i11 == 64) {
                            return l();
                        }
                        if (i11 != 128) {
                            return t0.d.f16511e;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.f8518f;
                        if (windowInsetsCompat != null) {
                            cVar = windowInsetsCompat.e();
                        } else {
                            cVar = f();
                        }
                        if (cVar != null) {
                            return t0.d.b(cVar.b(), cVar.d(), cVar.c(), cVar.a());
                        }
                        return t0.d.f16511e;
                    }
                } else if (z11) {
                    t0.d v12 = v();
                    t0.d i14 = i();
                    return t0.d.b(Math.max(v12.f16512a, i14.f16512a), 0, Math.max(v12.f16514c, i14.f16514c), Math.max(v12.f16515d, i14.f16515d));
                } else {
                    t0.d k12 = k();
                    WindowInsetsCompat windowInsetsCompat2 = this.f8518f;
                    if (windowInsetsCompat2 != null) {
                        dVar = windowInsetsCompat2.h();
                    }
                    int i15 = k12.f16515d;
                    if (dVar != null) {
                        i15 = Math.min(i15, dVar.f16515d);
                    }
                    return t0.d.b(k12.f16512a, 0, k12.f16514c, i15);
                }
            } else if (z11) {
                return t0.d.b(0, Math.max(v().f16513b, k().f16513b), 0, 0);
            } else {
                return t0.d.b(0, k().f16513b, 0, 0);
            }
        }

        public f(WindowInsetsCompat windowInsetsCompat, f fVar) {
            this(windowInsetsCompat, new WindowInsets(fVar.f8515c));
        }
    }

    public static class i extends h {

        /* renamed from: n  reason: collision with root package name */
        public t0.d f8521n = null;

        /* renamed from: o  reason: collision with root package name */
        public t0.d f8522o = null;

        /* renamed from: p  reason: collision with root package name */
        public t0.d f8523p = null;

        public i(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public t0.d h() {
            if (this.f8522o == null) {
                this.f8522o = t0.d.d(this.f8515c.getMandatorySystemGestureInsets());
            }
            return this.f8522o;
        }

        public t0.d j() {
            if (this.f8521n == null) {
                this.f8521n = t0.d.d(this.f8515c.getSystemGestureInsets());
            }
            return this.f8521n;
        }

        public t0.d l() {
            if (this.f8523p == null) {
                this.f8523p = t0.d.d(this.f8515c.getTappableElementInsets());
            }
            return this.f8523p;
        }

        public WindowInsetsCompat m(int i11, int i12, int i13, int i14) {
            return WindowInsetsCompat.x(this.f8515c.inset(i11, i12, i13, i14));
        }

        public void s(t0.d dVar) {
        }

        public i(WindowInsetsCompat windowInsetsCompat, i iVar) {
            super(windowInsetsCompat, (h) iVar);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final e f8496a;

        public Builder() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.f8496a = new d();
            } else if (i11 >= 29) {
                this.f8496a = new c();
            } else if (i11 >= 20) {
                this.f8496a = new b();
            } else {
                this.f8496a = new e();
            }
        }

        public WindowInsetsCompat a() {
            return this.f8496a.b();
        }

        @Deprecated
        public Builder b(t0.d dVar) {
            this.f8496a.d(dVar);
            return this;
        }

        @Deprecated
        public Builder c(t0.d dVar) {
            this.f8496a.f(dVar);
            return this;
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                this.f8496a = new d(windowInsetsCompat);
            } else if (i11 >= 29) {
                this.f8496a = new c(windowInsetsCompat);
            } else if (i11 >= 20) {
                this.f8496a = new b(windowInsetsCompat);
            } else {
                this.f8496a = new e(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            k kVar = windowInsetsCompat.f8495a;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30 && (kVar instanceof j)) {
                this.f8495a = new j(this, (j) kVar);
            } else if (i11 >= 29 && (kVar instanceof i)) {
                this.f8495a = new i(this, (i) kVar);
            } else if (i11 >= 28 && (kVar instanceof h)) {
                this.f8495a = new h(this, (h) kVar);
            } else if (i11 >= 21 && (kVar instanceof g)) {
                this.f8495a = new g(this, (g) kVar);
            } else if (i11 < 20 || !(kVar instanceof f)) {
                this.f8495a = new k(this);
            } else {
                this.f8495a = new f(this, (f) kVar);
            }
            kVar.e(this);
            return;
        }
        this.f8495a = new k(this);
    }
}
