package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import s0.g;
import s0.h;

public final class ResourcesCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f8340a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<e, SparseArray<d>> f8341b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8342c = new Object();

    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(int i11, Handler handler) {
            getHandler(handler).post(new g(this, i11));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new h(this, typeface));
        }

        /* renamed from: onFontRetrievalFailed */
        public abstract void lambda$callbackFailAsync$1(int i11);

        /* renamed from: onFontRetrieved */
        public abstract void lambda$callbackSuccessAsync$0(Typeface typeface);
    }

    public static class a {
        public static Drawable a(Resources resources, int i11, int i12) {
            return resources.getDrawableForDensity(i11, i12);
        }
    }

    public static class b {
        public static Drawable a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getDrawable(i11, theme);
        }

        public static Drawable b(Resources resources, int i11, int i12, Resources.Theme theme) {
            return resources.getDrawableForDensity(i11, i12, theme);
        }
    }

    public static class c {
        public static int a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getColor(i11, theme);
        }

        public static ColorStateList b(Resources resources, int i11, Resources.Theme theme) {
            return resources.getColorStateList(i11, theme);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f8343a;

        /* renamed from: b  reason: collision with root package name */
        public final Configuration f8344b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8345c;

        public d(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int i11;
            this.f8343a = colorStateList;
            this.f8344b = configuration;
            if (theme == null) {
                i11 = 0;
            } else {
                i11 = theme.hashCode();
            }
            this.f8345c = i11;
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f8346a;

        /* renamed from: b  reason: collision with root package name */
        public final Resources.Theme f8347b;

        public e(Resources resources, Resources.Theme theme) {
            this.f8346a = resources;
            this.f8347b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (!this.f8346a.equals(eVar.f8346a) || !androidx.core.util.b.a(this.f8347b, eVar.f8347b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return androidx.core.util.b.b(this.f8346a, this.f8347b);
        }
    }

    public static final class f {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final Object f8348a = new Object();

            /* renamed from: b  reason: collision with root package name */
            public static Method f8349b;

            /* renamed from: c  reason: collision with root package name */
            public static boolean f8350c;

            @SuppressLint({"BanUncheckedReflection"})
            public static void a(Resources.Theme theme) {
                synchronized (f8348a) {
                    if (!f8350c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f8349b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e11) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e11);
                        }
                        f8350c = true;
                    }
                    Method method = f8349b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e12) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e12);
                            f8349b = null;
                        }
                    }
                }
            }
        }

        public static class b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 29) {
                b.a(theme);
            } else if (i11 >= 23) {
                a.a(theme);
            }
        }
    }

    public static void a(e eVar, int i11, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f8342c) {
            WeakHashMap<e, SparseArray<d>> weakHashMap = f8341b;
            SparseArray sparseArray = weakHashMap.get(eVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(eVar, sparseArray);
            }
            sparseArray.append(i11, new d(colorStateList, eVar.f8346a.getConfiguration(), theme));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList b(androidx.core.content.res.ResourcesCompat.e r5, int r6) {
        /*
            java.lang.Object r0 = f8342c
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$e, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$d>> r1 = f8341b     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0042
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0045 }
            androidx.core.content.res.ResourcesCompat$d r2 = (androidx.core.content.res.ResourcesCompat.d) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0042
            android.content.res.Configuration r3 = r2.f8344b     // Catch:{ all -> 0x0045 }
            android.content.res.Resources r4 = r5.f8346a     // Catch:{ all -> 0x0045 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003f
            android.content.res.Resources$Theme r5 = r5.f8347b     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x0031
            int r3 = r2.f8345c     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003b
        L_0x0031:
            if (r5 == 0) goto L_0x003f
            int r3 = r2.f8345c     // Catch:{ all -> 0x0045 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0045 }
            if (r3 != r5) goto L_0x003f
        L_0x003b:
            android.content.res.ColorStateList r5 = r2.f8343a     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r5
        L_0x003f:
            r1.remove(r6)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r5 = 0
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.b(androidx.core.content.res.ResourcesCompat$e, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i11, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, true);
    }

    public static int d(Resources resources, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return c.a(resources, i11, theme);
        }
        return resources.getColor(i11);
    }

    public static ColorStateList e(Resources resources, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        e eVar = new e(resources, theme);
        ColorStateList b11 = b(eVar, i11);
        if (b11 != null) {
            return b11;
        }
        ColorStateList l11 = l(resources, i11, theme);
        if (l11 != null) {
            a(eVar, i11, l11, theme);
            return l11;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return c.b(resources, i11, theme);
        } else {
            return resources.getColorStateList(i11);
        }
    }

    public static Drawable f(Resources resources, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a(resources, i11, theme);
        }
        return resources.getDrawable(i11);
    }

    public static Drawable g(Resources resources, int i11, int i12, Resources.Theme theme) throws Resources.NotFoundException {
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 21) {
            return b.b(resources, i11, i12, theme);
        }
        if (i13 >= 15) {
            return a.a(resources, i11, i12);
        }
        return resources.getDrawable(i11);
    }

    public static Typeface h(Context context, int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i11, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    public static Typeface i(Context context, int i11, TypedValue typedValue, int i12, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i11, typedValue, i12, fontCallback, (Handler) null, true, false);
    }

    public static void j(Context context, int i11, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        androidx.core.util.h.g(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        n(context, i11, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    public static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f8340a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList l(Resources resources, int i11, Resources.Theme theme) {
        if (m(resources, i11)) {
            return null;
        }
        try {
            return s0.c.a(resources, resources.getXml(i11), theme);
        } catch (Exception e11) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e11);
            return null;
        }
    }

    public static boolean m(Resources resources, int i11) {
        TypedValue k11 = k();
        resources.getValue(i11, k11, true);
        int i12 = k11.type;
        if (i12 < 28 || i12 > 31) {
            return false;
        }
        return true;
    }

    public static Typeface n(Context context, int i11, TypedValue typedValue, int i12, FontCallback fontCallback, Handler handler, boolean z11, boolean z12) {
        Resources resources = context.getResources();
        int i13 = i11;
        resources.getValue(i11, typedValue, true);
        Typeface o11 = o(context, resources, typedValue, i11, i12, fontCallback, handler, z11, z12);
        if (o11 != null || fontCallback != null || z12) {
            return o11;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i11) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface o(android.content.Context r17, android.content.res.Resources r18, android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.ResourcesCompat.FontCallback r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00bb
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L_0x0025
            if (r11 == 0) goto L_0x0024
            r11.callbackFailAsync(r15, r12)
        L_0x0024:
            return r16
        L_0x0025:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = t0.g.f(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0035
            if (r11 == 0) goto L_0x0034
            r11.callbackSuccessAsync(r2, r12)
        L_0x0034:
            return r2
        L_0x0035:
            if (r25 == 0) goto L_0x0038
            return r16
        L_0x0038:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 == 0) goto L_0x006f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            androidx.core.content.res.a$b r2 = androidx.core.content.res.a.b(r2, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 != 0) goto L_0x0059
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0058
            r11.callbackFailAsync(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0058:
            return r16
        L_0x0059:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = t0.g.c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            return r0
        L_0x006f:
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = t0.g.d(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0086
            r11.callbackSuccessAsync(r0, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            goto L_0x0089
        L_0x0086:
            r11.callbackFailAsync(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto L_0x00b5
        L_0x00a0:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        L_0x00b5:
            if (r11 == 0) goto L_0x00ba
            r11.callbackFailAsync(r15, r12)
        L_0x00ba:
            return r16
        L_0x00bb:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
