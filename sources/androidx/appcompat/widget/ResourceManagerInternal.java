package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class ResourceManagerInternal {

    /* renamed from: h  reason: collision with root package name */
    public static final PorterDuff.Mode f4460h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public static ResourceManagerInternal f4461i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f4462j = new c(6);

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f4463a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleArrayMap<String, e> f4464b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArrayCompat<String> f4465c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f4466d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f4467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4468f;

    /* renamed from: g  reason: collision with root package name */
    public f f4469g;

    public static class a implements e {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e11);
                return null;
            }
        }
    }

    public static class b implements e {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.b.c(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                return null;
            }
        }
    }

    public static class c extends i0.b<Integer, PorterDuffColorFilter> {
        public c(int i11) {
            super(i11);
        }

        public static int a(int i11, PorterDuff.Mode mode) {
            return ((i11 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter b(int i11, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(a(i11, mode)));
        }

        public PorterDuffColorFilter c(int i11, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(a(i11, mode)), porterDuffColorFilter);
        }
    }

    public static class d implements e {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        e.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e11) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e11);
                }
            }
            return null;
        }
    }

    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i11);

        ColorStateList b(Context context, int i11);

        PorterDuff.Mode c(int i11);

        boolean d(Context context, int i11, Drawable drawable);

        boolean e(Context context, int i11, Drawable drawable);
    }

    public static class g implements e {
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e11);
                return null;
            }
        }
    }

    public static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal h() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (f4461i == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                f4461i = resourceManagerInternal2;
                p(resourceManagerInternal2);
            }
            resourceManagerInternal = f4461i;
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter l(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter b11;
        synchronized (ResourceManagerInternal.class) {
            c cVar = f4462j;
            b11 = cVar.b(i11, mode);
            if (b11 == null) {
                b11 = new PorterDuffColorFilter(i11, mode);
                cVar.c(i11, mode, b11);
            }
        }
        return b11;
    }

    public static void p(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new g());
            resourceManagerInternal.a("animated-vector", new b());
            resourceManagerInternal.a("animated-selector", new a());
            resourceManagerInternal.a("drawable", new d());
        }
    }

    public static boolean q(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void w(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (r.a(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z11 = tintInfo.f4523d;
        if (z11 || tintInfo.f4522c) {
            drawable.setColorFilter(g(z11 ? tintInfo.f4520a : null, tintInfo.f4522c ? tintInfo.f4521b : f4460h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(String str, e eVar) {
        if (this.f4464b == null) {
            this.f4464b = new SimpleArrayMap<>();
        }
        this.f4464b.put(str, eVar);
    }

    public final synchronized boolean b(Context context, long j11, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.f4466d.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray();
            this.f4466d.put(context, longSparseArray);
        }
        longSparseArray.l(j11, new WeakReference(constantState));
        return true;
    }

    public final void c(Context context, int i11, ColorStateList colorStateList) {
        if (this.f4463a == null) {
            this.f4463a = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.f4463a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f4463a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.b(i11, colorStateList);
    }

    public final void d(Context context) {
        if (!this.f4468f) {
            this.f4468f = true;
            Drawable j11 = j(context, R$drawable.abc_vector_test);
            if (j11 == null || !q(j11)) {
                this.f4468f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public final Drawable f(Context context, int i11) {
        Drawable drawable;
        if (this.f4467e == null) {
            this.f4467e = new TypedValue();
        }
        TypedValue typedValue = this.f4467e;
        context.getResources().getValue(i11, typedValue, true);
        long e11 = e(typedValue);
        Drawable i12 = i(context, e11);
        if (i12 != null) {
            return i12;
        }
        f fVar = this.f4469g;
        if (fVar == null) {
            drawable = null;
        } else {
            drawable = fVar.a(this, context, i11);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e11, drawable);
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable i(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f4466d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.g(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.m(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.i(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public synchronized Drawable j(Context context, int i11) {
        return k(context, i11, false);
    }

    public synchronized Drawable k(Context context, int i11, boolean z11) {
        Drawable r11;
        d(context);
        r11 = r(context, i11);
        if (r11 == null) {
            r11 = f(context, i11);
        }
        if (r11 == null) {
            r11 = ContextCompat.getDrawable(context, i11);
        }
        if (r11 != null) {
            r11 = v(context, i11, z11, r11);
        }
        if (r11 != null) {
            r.b(r11);
        }
        return r11;
    }

    public synchronized ColorStateList m(Context context, int i11) {
        ColorStateList n11;
        n11 = n(context, i11);
        if (n11 == null) {
            f fVar = this.f4469g;
            n11 = fVar == null ? null : fVar.b(context, i11);
            if (n11 != null) {
                c(context, i11, n11);
            }
        }
        return n11;
    }

    public final ColorStateList n(Context context, int i11) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f4463a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.g(i11);
    }

    public PorterDuff.Mode o(int i11) {
        f fVar = this.f4469g;
        if (fVar == null) {
            return null;
        }
        return fVar.c(i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable r(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r0 = r10.f4464b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.f4465c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.g(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r3 = r10.f4464b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.f4465c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f4467e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f4467e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f4467e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = e(r0)
            android.graphics.drawable.Drawable r6 = r10.i(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.f4465c     // Catch:{ Exception -> 0x00a2 }
            r8.b(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$e> r8 = r10.f4464b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.ResourceManagerInternal$e r3 = (androidx.appcompat.widget.ResourceManagerInternal.e) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.f4465c
            r11.b(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public synchronized void s(Context context) {
        LongSparseArray longSparseArray = this.f4466d.get(context);
        if (longSparseArray != null) {
            longSparseArray.c();
        }
    }

    public synchronized Drawable t(Context context, n0 n0Var, int i11) {
        Drawable r11 = r(context, i11);
        if (r11 == null) {
            r11 = n0Var.a(i11);
        }
        if (r11 == null) {
            return null;
        }
        return v(context, i11, false, r11);
    }

    public synchronized void u(f fVar) {
        this.f4469g = fVar;
    }

    public final Drawable v(Context context, int i11, boolean z11, Drawable drawable) {
        ColorStateList m11 = m(context, i11);
        if (m11 != null) {
            if (r.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r11 = u0.a.r(drawable);
            u0.a.o(r11, m11);
            PorterDuff.Mode o11 = o(i11);
            if (o11 == null) {
                return r11;
            }
            u0.a.p(r11, o11);
            return r11;
        }
        f fVar = this.f4469g;
        if ((fVar == null || !fVar.d(context, i11, drawable)) && !x(context, i11, drawable) && z11) {
            return null;
        }
        return drawable;
    }

    public boolean x(Context context, int i11, Drawable drawable) {
        f fVar = this.f4469g;
        return fVar != null && fVar.e(context, i11, drawable);
    }
}
