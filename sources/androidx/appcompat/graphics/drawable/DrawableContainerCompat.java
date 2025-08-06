package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    public d f3966b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f3967c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f3968d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f3969e;

    /* renamed from: f  reason: collision with root package name */
    public int f3970f = 255;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3971g;

    /* renamed from: h  reason: collision with root package name */
    public int f3972h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3973i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f3974j;

    /* renamed from: k  reason: collision with root package name */
    public long f3975k;

    /* renamed from: l  reason: collision with root package name */
    public long f3976l;

    /* renamed from: m  reason: collision with root package name */
    public c f3977m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            DrawableContainerCompat.this.a(true);
            DrawableContainerCompat.this.invalidateSelf();
        }
    }

    public static class b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    public static class c implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        public Drawable.Callback f3979b;

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f3979b;
            this.f3979b = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f3979b = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            Drawable.Callback callback = this.f3979b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j11);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f3979b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class d extends Drawable.ConstantState {
        public int A = 0;
        public int B = 0;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a  reason: collision with root package name */
        public final DrawableContainerCompat f3980a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f3981b;

        /* renamed from: c  reason: collision with root package name */
        public int f3982c;

        /* renamed from: d  reason: collision with root package name */
        public int f3983d;

        /* renamed from: e  reason: collision with root package name */
        public int f3984e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f3985f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable[] f3986g;

        /* renamed from: h  reason: collision with root package name */
        public int f3987h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f3988i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f3989j;

        /* renamed from: k  reason: collision with root package name */
        public Rect f3990k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f3991l = false;

        /* renamed from: m  reason: collision with root package name */
        public boolean f3992m;

        /* renamed from: n  reason: collision with root package name */
        public int f3993n;

        /* renamed from: o  reason: collision with root package name */
        public int f3994o;

        /* renamed from: p  reason: collision with root package name */
        public int f3995p;

        /* renamed from: q  reason: collision with root package name */
        public int f3996q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f3997r;

        /* renamed from: s  reason: collision with root package name */
        public int f3998s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f3999t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f4000u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f4001v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f4002w;

        /* renamed from: x  reason: collision with root package name */
        public boolean f4003x = true;

        /* renamed from: y  reason: collision with root package name */
        public boolean f4004y;

        /* renamed from: z  reason: collision with root package name */
        public int f4005z;

        public d(d dVar, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            this.f3980a = drawableContainerCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = dVar != null ? dVar.f3981b : null;
            }
            this.f3981b = resources2;
            int f11 = DrawableContainerCompat.f(resources, dVar != null ? dVar.f3982c : 0);
            this.f3982c = f11;
            if (dVar != null) {
                this.f3983d = dVar.f3983d;
                this.f3984e = dVar.f3984e;
                this.f4001v = true;
                this.f4002w = true;
                this.f3988i = dVar.f3988i;
                this.f3991l = dVar.f3991l;
                this.f4003x = dVar.f4003x;
                this.f4004y = dVar.f4004y;
                this.f4005z = dVar.f4005z;
                this.A = dVar.A;
                this.B = dVar.B;
                this.C = dVar.C;
                this.D = dVar.D;
                this.E = dVar.E;
                this.F = dVar.F;
                this.G = dVar.G;
                this.H = dVar.H;
                this.I = dVar.I;
                if (dVar.f3982c == f11) {
                    if (dVar.f3989j) {
                        this.f3990k = dVar.f3990k != null ? new Rect(dVar.f3990k) : rect;
                        this.f3989j = true;
                    }
                    if (dVar.f3992m) {
                        this.f3993n = dVar.f3993n;
                        this.f3994o = dVar.f3994o;
                        this.f3995p = dVar.f3995p;
                        this.f3996q = dVar.f3996q;
                        this.f3992m = true;
                    }
                }
                if (dVar.f3997r) {
                    this.f3998s = dVar.f3998s;
                    this.f3997r = true;
                }
                if (dVar.f3999t) {
                    this.f4000u = dVar.f4000u;
                    this.f3999t = true;
                }
                Drawable[] drawableArr = dVar.f3986g;
                this.f3986g = new Drawable[drawableArr.length];
                this.f3987h = dVar.f3987h;
                SparseArray<Drawable.ConstantState> sparseArray = dVar.f3985f;
                if (sparseArray != null) {
                    this.f3985f = sparseArray.clone();
                } else {
                    this.f3985f = new SparseArray<>(this.f3987h);
                }
                int i11 = this.f3987h;
                for (int i12 = 0; i12 < i11; i12++) {
                    if (drawableArr[i12] != null) {
                        Drawable.ConstantState constantState = drawableArr[i12].getConstantState();
                        if (constantState != null) {
                            this.f3985f.put(i12, constantState);
                        } else {
                            this.f3986g[i12] = drawableArr[i12];
                        }
                    }
                }
                return;
            }
            this.f3986g = new Drawable[10];
            this.f3987h = 0;
        }

        public final int a(Drawable drawable) {
            int i11 = this.f3987h;
            if (i11 >= this.f3986g.length) {
                o(i11, i11 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f3980a);
            this.f3986g[i11] = drawable;
            this.f3987h++;
            this.f3984e = drawable.getChangingConfigurations() | this.f3984e;
            p();
            this.f3990k = null;
            this.f3989j = false;
            this.f3992m = false;
            this.f4001v = false;
            return i11;
        }

        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i11 = this.f3987h;
                Drawable[] drawableArr = this.f3986g;
                for (int i12 = 0; i12 < i11; i12++) {
                    if (drawableArr[i12] != null && u0.a.b(drawableArr[i12])) {
                        u0.a.a(drawableArr[i12], theme);
                        this.f3984e |= drawableArr[i12].getChangingConfigurations();
                    }
                }
                z(b.c(theme));
            }
        }

        public boolean c() {
            if (this.f4001v) {
                return this.f4002w;
            }
            e();
            this.f4001v = true;
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getConstantState() == null) {
                    this.f4002w = false;
                    return false;
                }
            }
            this.f4002w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f3985f.get(i12);
                    if (constantState != null && b.a(constantState)) {
                        return true;
                    }
                } else if (u0.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public void d() {
            this.f3992m = true;
            e();
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            this.f3994o = -1;
            this.f3993n = -1;
            this.f3996q = 0;
            this.f3995p = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f3993n) {
                    this.f3993n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f3994o) {
                    this.f3994o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f3995p) {
                    this.f3995p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f3996q) {
                    this.f3996q = minimumHeight;
                }
            }
        }

        public final void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f3985f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    this.f3986g[this.f3985f.keyAt(i11)] = t(this.f3985f.valueAt(i11).newDrawable(this.f3981b));
                }
                this.f3985f = null;
            }
        }

        public final int f() {
            return this.f3986g.length;
        }

        public final Drawable g(int i11) {
            int indexOfKey;
            Drawable drawable = this.f3986g[i11];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f3985f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i11)) < 0) {
                return null;
            }
            Drawable t11 = t(this.f3985f.valueAt(indexOfKey).newDrawable(this.f3981b));
            this.f3986g[i11] = t11;
            this.f3985f.removeAt(indexOfKey);
            if (this.f3985f.size() == 0) {
                this.f3985f = null;
            }
            return t11;
        }

        public int getChangingConfigurations() {
            return this.f3983d | this.f3984e;
        }

        public final int h() {
            return this.f3987h;
        }

        public final int i() {
            if (!this.f3992m) {
                d();
            }
            return this.f3994o;
        }

        public final int j() {
            if (!this.f3992m) {
                d();
            }
            return this.f3996q;
        }

        public final int k() {
            if (!this.f3992m) {
                d();
            }
            return this.f3995p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f3988i) {
                return null;
            }
            Rect rect2 = this.f3990k;
            if (rect2 != null || this.f3989j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i13 = rect3.left;
                    if (i13 > rect.left) {
                        rect.left = i13;
                    }
                    int i14 = rect3.top;
                    if (i14 > rect.top) {
                        rect.top = i14;
                    }
                    int i15 = rect3.right;
                    if (i15 > rect.right) {
                        rect.right = i15;
                    }
                    int i16 = rect3.bottom;
                    if (i16 > rect.bottom) {
                        rect.bottom = i16;
                    }
                }
            }
            this.f3989j = true;
            this.f3990k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f3992m) {
                d();
            }
            return this.f3993n;
        }

        public final int n() {
            if (this.f3997r) {
                return this.f3998s;
            }
            e();
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            int opacity = i11 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i12 = 1; i12 < i11; i12++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i12].getOpacity());
            }
            this.f3998s = opacity;
            this.f3997r = true;
            return opacity;
        }

        public void o(int i11, int i12) {
            Drawable[] drawableArr = new Drawable[i12];
            Drawable[] drawableArr2 = this.f3986g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i11);
            }
            this.f3986g = drawableArr;
        }

        public void p() {
            this.f3997r = false;
            this.f3999t = false;
        }

        public final boolean q() {
            return this.f3991l;
        }

        public final boolean r() {
            if (this.f3999t) {
                return this.f4000u;
            }
            e();
            int i11 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            boolean z11 = false;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                } else if (drawableArr[i12].isStateful()) {
                    z11 = true;
                    break;
                } else {
                    i12++;
                }
            }
            this.f4000u = z11;
            this.f3999t = true;
            return z11;
        }

        public abstract void s();

        public final Drawable t(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                u0.a.m(drawable, this.f4005z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f3980a);
            return mutate;
        }

        public final void u(boolean z11) {
            this.f3991l = z11;
        }

        public final void v(int i11) {
            this.A = i11;
        }

        public final void w(int i11) {
            this.B = i11;
        }

        public final boolean x(int i11, int i12) {
            int i13 = this.f3987h;
            Drawable[] drawableArr = this.f3986g;
            boolean z11 = false;
            for (int i14 = 0; i14 < i13; i14++) {
                if (drawableArr[i14] != null) {
                    boolean m11 = Build.VERSION.SDK_INT >= 23 ? u0.a.m(drawableArr[i14], i11) : false;
                    if (i14 == i12) {
                        z11 = m11;
                    }
                }
            }
            this.f4005z = i11;
            return z11;
        }

        public final void y(boolean z11) {
            this.f3988i = z11;
        }

        public final void z(Resources resources) {
            if (resources != null) {
                this.f3981b = resources;
                int f11 = DrawableContainerCompat.f(resources, this.f3982c);
                int i11 = this.f3982c;
                this.f3982c = f11;
                if (i11 != f11) {
                    this.f3992m = false;
                    this.f3989j = false;
                }
            }
        }
    }

    public static int f(Resources resources, int i11) {
        if (resources != null) {
            i11 = resources.getDisplayMetrics().densityDpi;
        }
        if (i11 == 0) {
            return 160;
        }
        return i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f3971g = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f3968d
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0036
            long r9 = r13.f3975k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f3970f
            r3.setAlpha(r9)
            r13.f3975k = r7
            goto L_0x0038
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r10 = r13.f3966b
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f3970f
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L_0x0039
        L_0x0036:
            r13.f3975k = r7
        L_0x0038:
            r3 = r6
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.f3969e
            if (r9 == 0) goto L_0x0061
            long r10 = r13.f3976l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f3969e = r0
            r13.f3976l = r7
            goto L_0x0063
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r4 = r13.f3966b
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f3970f
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0061:
            r13.f3976l = r7
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r14 = r13.f3974j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f3966b.b(theme);
    }

    public d b() {
        return this.f3966b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f3972h;
    }

    public boolean canApplyTheme() {
        return this.f3966b.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        if (this.f3977m == null) {
            this.f3977m = new c();
        }
        drawable.setCallback(this.f3977m.b(drawable.getCallback()));
        try {
            if (this.f3966b.A <= 0 && this.f3971g) {
                drawable.setAlpha(this.f3970f);
            }
            d dVar = this.f3966b;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    u0.a.o(drawable, dVar.F);
                }
                d dVar2 = this.f3966b;
                if (dVar2.I) {
                    u0.a.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f3966b.f4003x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                u0.a.m(drawable, u0.a.f(this));
            }
            if (i11 >= 19) {
                u0.a.j(drawable, this.f3966b.C);
            }
            Rect rect = this.f3967c;
            if (i11 >= 21 && rect != null) {
                u0.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f3977m.a());
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f3969e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final boolean e() {
        if (!isAutoMirrored() || u0.a.f(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f3972h
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.f3966b
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f3969e
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f3968d
            if (r0 == 0) goto L_0x0029
            r9.f3969e = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.f3966b
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f3976l = r0
            goto L_0x0035
        L_0x0029:
            r9.f3969e = r4
            r9.f3976l = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f3968d
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r0 = r9.f3966b
            int r1 = r0.f3987h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f3968d = r0
            r9.f3972h = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$d r10 = r9.f3966b
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f3975k = r2
        L_0x0051:
            r9.d(r0)
            goto L_0x005a
        L_0x0055:
            r9.f3968d = r4
            r10 = -1
            r9.f3972h = r10
        L_0x005a:
            long r0 = r9.f3975k
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L_0x0067
            long r1 = r9.f3976l
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r10 = r9.f3974j
            if (r10 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$a r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$a
            r10.<init>()
            r9.f3974j = r10
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r10)
        L_0x0076:
            r9.a(r0)
        L_0x0079:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.g(int):boolean");
    }

    public int getAlpha() {
        return this.f3970f;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f3966b.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f3966b.c()) {
            return null;
        }
        this.f3966b.f3983d = getChangingConfigurations();
        return this.f3966b;
    }

    public Drawable getCurrent() {
        return this.f3968d;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f3967c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f3966b.q()) {
            return this.f3966b.i();
        }
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f3966b.q()) {
            return this.f3966b.m();
        }
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f3966b.q()) {
            return this.f3966b.j();
        }
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f3966b.q()) {
            return this.f3966b.k();
        }
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f3968d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f3966b.n();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            b.b(drawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z11;
        Rect l11 = this.f3966b.l();
        if (l11 != null) {
            rect.set(l11);
            z11 = (l11.right | ((l11.left | l11.top) | l11.bottom)) != 0;
        } else {
            Drawable drawable = this.f3968d;
            if (drawable != null) {
                z11 = drawable.getPadding(rect);
            } else {
                z11 = super.getPadding(rect);
            }
        }
        if (e()) {
            int i11 = rect.left;
            rect.left = rect.right;
            rect.right = i11;
        }
        return z11;
    }

    public void h(d dVar) {
        this.f3966b = dVar;
        int i11 = this.f3972h;
        if (i11 >= 0) {
            Drawable g11 = dVar.g(i11);
            this.f3968d = g11;
            if (g11 != null) {
                d(g11);
            }
        }
        this.f3969e = null;
    }

    public final void i(Resources resources) {
        this.f3966b.z(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f3966b;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable == this.f3968d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f3966b.C;
    }

    public boolean isStateful() {
        return this.f3966b.r();
    }

    public void jumpToCurrentState() {
        boolean z11;
        Drawable drawable = this.f3969e;
        boolean z12 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f3969e = null;
            z11 = true;
        } else {
            z11 = false;
        }
        Drawable drawable2 = this.f3968d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f3971g) {
                this.f3968d.setAlpha(this.f3970f);
            }
        }
        if (this.f3976l != 0) {
            this.f3976l = 0;
            z11 = true;
        }
        if (this.f3975k != 0) {
            this.f3975k = 0;
        } else {
            z12 = z11;
        }
        if (z12) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f3973i && super.mutate() == this) {
            d b11 = b();
            b11.s();
            h(b11);
            this.f3973i = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3969e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f3968d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i11) {
        return this.f3966b.x(i11, c());
    }

    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f3969e;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        Drawable drawable2 = this.f3968d;
        if (drawable2 != null) {
            return drawable2.setLevel(i11);
        }
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3969e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f3968d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        if (drawable == this.f3968d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        if (!this.f3971g || this.f3970f != i11) {
            this.f3971g = true;
            this.f3970f = i11;
            Drawable drawable = this.f3968d;
            if (drawable == null) {
                return;
            }
            if (this.f3975k == 0) {
                drawable.setAlpha(i11);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z11) {
        d dVar = this.f3966b;
        if (dVar.C != z11) {
            dVar.C = z11;
            Drawable drawable = this.f3968d;
            if (drawable != null) {
                u0.a.j(drawable, z11);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f3966b;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f3968d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z11) {
        d dVar = this.f3966b;
        if (dVar.f4003x != z11) {
            dVar.f4003x = z11;
            Drawable drawable = this.f3968d;
            if (drawable != null) {
                drawable.setDither(z11);
            }
        }
    }

    public void setHotspot(float f11, float f12) {
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            u0.a.k(drawable, f11, f12);
        }
    }

    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        Rect rect = this.f3967c;
        if (rect == null) {
            this.f3967c = new Rect(i11, i12, i13, i14);
        } else {
            rect.set(i11, i12, i13, i14);
        }
        Drawable drawable = this.f3968d;
        if (drawable != null) {
            u0.a.l(drawable, i11, i12, i13, i14);
        }
    }

    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f3966b;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            u0.a.o(this.f3968d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f3966b;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            u0.a.p(this.f3968d, mode);
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        Drawable drawable = this.f3969e;
        if (drawable != null) {
            drawable.setVisible(z11, z12);
        }
        Drawable drawable2 = this.f3968d;
        if (drawable2 != null) {
            drawable2.setVisible(z11, z12);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f3968d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
