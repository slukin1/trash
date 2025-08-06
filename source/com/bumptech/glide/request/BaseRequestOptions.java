package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import e4.c;
import f4.h;
import f4.i;
import java.util.Map;
import n3.b;
import n3.g;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    public boolean A;

    /* renamed from: b  reason: collision with root package name */
    public int f64184b;

    /* renamed from: c  reason: collision with root package name */
    public float f64185c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public DiskCacheStrategy f64186d = DiskCacheStrategy.f63713e;

    /* renamed from: e  reason: collision with root package name */
    public Priority f64187e = Priority.NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f64188f;

    /* renamed from: g  reason: collision with root package name */
    public int f64189g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f64190h;

    /* renamed from: i  reason: collision with root package name */
    public int f64191i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f64192j = true;

    /* renamed from: k  reason: collision with root package name */
    public int f64193k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f64194l = -1;

    /* renamed from: m  reason: collision with root package name */
    public b f64195m = c.a();

    /* renamed from: n  reason: collision with root package name */
    public boolean f64196n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f64197o = true;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f64198p;

    /* renamed from: q  reason: collision with root package name */
    public int f64199q;

    /* renamed from: r  reason: collision with root package name */
    public Options f64200r = new Options();

    /* renamed from: s  reason: collision with root package name */
    public Map<Class<?>, g<?>> f64201s = new CachedHashCodeArrayMap();

    /* renamed from: t  reason: collision with root package name */
    public Class<?> f64202t = Object.class;

    /* renamed from: u  reason: collision with root package name */
    public boolean f64203u;

    /* renamed from: v  reason: collision with root package name */
    public Resources.Theme f64204v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f64205w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f64206x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f64207y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f64208z = true;

    public static boolean N(int i11, int i12) {
        return (i11 & i12) != 0;
    }

    public final int A() {
        return this.f64191i;
    }

    public final Priority B() {
        return this.f64187e;
    }

    public final Class<?> C() {
        return this.f64202t;
    }

    public final b D() {
        return this.f64195m;
    }

    public final float E() {
        return this.f64185c;
    }

    public final Resources.Theme F() {
        return this.f64204v;
    }

    public final Map<Class<?>, g<?>> G() {
        return this.f64201s;
    }

    public final boolean H() {
        return this.A;
    }

    public final boolean I() {
        return this.f64206x;
    }

    public final boolean J() {
        return this.f64192j;
    }

    public final boolean K() {
        return M(8);
    }

    public boolean L() {
        return this.f64208z;
    }

    public final boolean M(int i11) {
        return N(this.f64184b, i11);
    }

    public final boolean O() {
        return this.f64197o;
    }

    public final boolean P() {
        return this.f64196n;
    }

    public final boolean Q() {
        return M(2048);
    }

    public final boolean R() {
        return i.t(this.f64194l, this.f64193k);
    }

    public T S() {
        this.f64203u = true;
        return f0();
    }

    public T T() {
        return X(DownsampleStrategy.f64057e, new CenterCrop());
    }

    public T U() {
        return W(DownsampleStrategy.f64056d, new CenterInside());
    }

    public T V() {
        return W(DownsampleStrategy.f64055c, new FitCenter());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T W(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, n3.g<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.e0(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.W(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, n3.g):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T X(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, n3.g<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f64205w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.X(r2, r3)
            return r2
        L_0x000d:
            r1.k(r2)
            r2 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.o0(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.X(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, n3.g):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T Y(int i11) {
        return Z(i11, i11);
    }

    public T Z(int i11, int i12) {
        if (this.f64205w) {
            return clone().Z(i11, i12);
        }
        this.f64194l = i11;
        this.f64193k = i12;
        this.f64184b |= 512;
        return g0();
    }

    public T a0(int i11) {
        if (this.f64205w) {
            return clone().a0(i11);
        }
        this.f64191i = i11;
        int i12 = this.f64184b | 128;
        this.f64184b = i12;
        this.f64190h = null;
        this.f64184b = i12 & -65;
        return g0();
    }

    public T b(BaseRequestOptions<?> baseRequestOptions) {
        if (this.f64205w) {
            return clone().b(baseRequestOptions);
        }
        if (N(baseRequestOptions.f64184b, 2)) {
            this.f64185c = baseRequestOptions.f64185c;
        }
        if (N(baseRequestOptions.f64184b, 262144)) {
            this.f64206x = baseRequestOptions.f64206x;
        }
        if (N(baseRequestOptions.f64184b, 1048576)) {
            this.A = baseRequestOptions.A;
        }
        if (N(baseRequestOptions.f64184b, 4)) {
            this.f64186d = baseRequestOptions.f64186d;
        }
        if (N(baseRequestOptions.f64184b, 8)) {
            this.f64187e = baseRequestOptions.f64187e;
        }
        if (N(baseRequestOptions.f64184b, 16)) {
            this.f64188f = baseRequestOptions.f64188f;
            this.f64189g = 0;
            this.f64184b &= -33;
        }
        if (N(baseRequestOptions.f64184b, 32)) {
            this.f64189g = baseRequestOptions.f64189g;
            this.f64188f = null;
            this.f64184b &= -17;
        }
        if (N(baseRequestOptions.f64184b, 64)) {
            this.f64190h = baseRequestOptions.f64190h;
            this.f64191i = 0;
            this.f64184b &= -129;
        }
        if (N(baseRequestOptions.f64184b, 128)) {
            this.f64191i = baseRequestOptions.f64191i;
            this.f64190h = null;
            this.f64184b &= -65;
        }
        if (N(baseRequestOptions.f64184b, 256)) {
            this.f64192j = baseRequestOptions.f64192j;
        }
        if (N(baseRequestOptions.f64184b, 512)) {
            this.f64194l = baseRequestOptions.f64194l;
            this.f64193k = baseRequestOptions.f64193k;
        }
        if (N(baseRequestOptions.f64184b, 1024)) {
            this.f64195m = baseRequestOptions.f64195m;
        }
        if (N(baseRequestOptions.f64184b, 4096)) {
            this.f64202t = baseRequestOptions.f64202t;
        }
        if (N(baseRequestOptions.f64184b, 8192)) {
            this.f64198p = baseRequestOptions.f64198p;
            this.f64199q = 0;
            this.f64184b &= -16385;
        }
        if (N(baseRequestOptions.f64184b, 16384)) {
            this.f64199q = baseRequestOptions.f64199q;
            this.f64198p = null;
            this.f64184b &= -8193;
        }
        if (N(baseRequestOptions.f64184b, 32768)) {
            this.f64204v = baseRequestOptions.f64204v;
        }
        if (N(baseRequestOptions.f64184b, 65536)) {
            this.f64197o = baseRequestOptions.f64197o;
        }
        if (N(baseRequestOptions.f64184b, 131072)) {
            this.f64196n = baseRequestOptions.f64196n;
        }
        if (N(baseRequestOptions.f64184b, 2048)) {
            this.f64201s.putAll(baseRequestOptions.f64201s);
            this.f64208z = baseRequestOptions.f64208z;
        }
        if (N(baseRequestOptions.f64184b, 524288)) {
            this.f64207y = baseRequestOptions.f64207y;
        }
        if (!this.f64197o) {
            this.f64201s.clear();
            int i11 = this.f64184b & -2049;
            this.f64184b = i11;
            this.f64196n = false;
            this.f64184b = i11 & -131073;
            this.f64208z = true;
        }
        this.f64184b |= baseRequestOptions.f64184b;
        this.f64200r.b(baseRequestOptions.f64200r);
        return g0();
    }

    public T b0(Drawable drawable) {
        if (this.f64205w) {
            return clone().b0(drawable);
        }
        this.f64190h = drawable;
        int i11 = this.f64184b | 64;
        this.f64184b = i11;
        this.f64191i = 0;
        this.f64184b = i11 & -129;
        return g0();
    }

    public T c() {
        if (!this.f64203u || this.f64205w) {
            this.f64205w = true;
            return S();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public T c0(Priority priority) {
        if (this.f64205w) {
            return clone().c0(priority);
        }
        this.f64187e = (Priority) h.d(priority);
        this.f64184b |= 8;
        return g0();
    }

    public T d() {
        return l0(DownsampleStrategy.f64057e, new CenterCrop());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T d0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, n3.g<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.e0(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.d0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, n3.g):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T e() {
        return d0(DownsampleStrategy.f64056d, new CenterInside());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T e0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, n3.g<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.l0(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.X(r1, r2)
        L_0x000b:
            r2 = 1
            r1.f64208z = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.e0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, n3.g, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f64185c, this.f64185c) == 0 && this.f64189g == baseRequestOptions.f64189g && i.d(this.f64188f, baseRequestOptions.f64188f) && this.f64191i == baseRequestOptions.f64191i && i.d(this.f64190h, baseRequestOptions.f64190h) && this.f64199q == baseRequestOptions.f64199q && i.d(this.f64198p, baseRequestOptions.f64198p) && this.f64192j == baseRequestOptions.f64192j && this.f64193k == baseRequestOptions.f64193k && this.f64194l == baseRequestOptions.f64194l && this.f64196n == baseRequestOptions.f64196n && this.f64197o == baseRequestOptions.f64197o && this.f64206x == baseRequestOptions.f64206x && this.f64207y == baseRequestOptions.f64207y && this.f64186d.equals(baseRequestOptions.f64186d) && this.f64187e == baseRequestOptions.f64187e && this.f64200r.equals(baseRequestOptions.f64200r) && this.f64201s.equals(baseRequestOptions.f64201s) && this.f64202t.equals(baseRequestOptions.f64202t) && i.d(this.f64195m, baseRequestOptions.f64195m) && i.d(this.f64204v, baseRequestOptions.f64204v)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public T clone() {
        try {
            T t11 = (BaseRequestOptions) super.clone();
            Options options = new Options();
            t11.f64200r = options;
            options.b(this.f64200r);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t11.f64201s = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f64201s);
            t11.f64203u = false;
            t11.f64205w = false;
            return t11;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final T f0() {
        return this;
    }

    public T g(Class<?> cls) {
        if (this.f64205w) {
            return clone().g(cls);
        }
        this.f64202t = (Class) h.d(cls);
        this.f64184b |= 4096;
        return g0();
    }

    public final T g0() {
        if (!this.f64203u) {
            return f0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public T h(DiskCacheStrategy diskCacheStrategy) {
        if (this.f64205w) {
            return clone().h(diskCacheStrategy);
        }
        this.f64186d = (DiskCacheStrategy) h.d(diskCacheStrategy);
        this.f64184b |= 4;
        return g0();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [n3.d<Y>, n3.d, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T h0(n3.d<Y> r2, Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.f64205w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.h0(r2, r3)
            return r2
        L_0x000d:
            f4.h.d(r2)
            f4.h.d(r3)
            com.bumptech.glide.load.Options r0 = r1.f64200r
            r0.c(r2, r3)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.g0()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.h0(n3.d, java.lang.Object):com.bumptech.glide.request.BaseRequestOptions");
    }

    public int hashCode() {
        return i.o(this.f64204v, i.o(this.f64195m, i.o(this.f64202t, i.o(this.f64201s, i.o(this.f64200r, i.o(this.f64187e, i.o(this.f64186d, i.p(this.f64207y, i.p(this.f64206x, i.p(this.f64197o, i.p(this.f64196n, i.n(this.f64194l, i.n(this.f64193k, i.p(this.f64192j, i.o(this.f64198p, i.n(this.f64199q, i.o(this.f64190h, i.n(this.f64191i, i.o(this.f64188f, i.n(this.f64189g, i.k(this.f64185c)))))))))))))))))))));
    }

    public T i() {
        return h0(y3.h.f66714b, Boolean.TRUE);
    }

    public T i0(b bVar) {
        if (this.f64205w) {
            return clone().i0(bVar);
        }
        this.f64195m = (b) h.d(bVar);
        this.f64184b |= 1024;
        return g0();
    }

    public T j() {
        if (this.f64205w) {
            return clone().j();
        }
        this.f64201s.clear();
        int i11 = this.f64184b & -2049;
        this.f64184b = i11;
        this.f64196n = false;
        int i12 = i11 & -131073;
        this.f64184b = i12;
        this.f64197o = false;
        this.f64184b = i12 | 65536;
        this.f64208z = true;
        return g0();
    }

    public T j0(float f11) {
        if (this.f64205w) {
            return clone().j0(f11);
        }
        if (f11 < 0.0f || f11 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f64185c = f11;
        this.f64184b |= 2;
        return g0();
    }

    public T k(DownsampleStrategy downsampleStrategy) {
        return h0(DownsampleStrategy.f64060h, h.d(downsampleStrategy));
    }

    public T k0(boolean z11) {
        if (this.f64205w) {
            return clone().k0(true);
        }
        this.f64192j = !z11;
        this.f64184b |= 256;
        return g0();
    }

    public T l(int i11) {
        if (this.f64205w) {
            return clone().l(i11);
        }
        this.f64189g = i11;
        int i12 = this.f64184b | 32;
        this.f64184b = i12;
        this.f64188f = null;
        this.f64184b = i12 & -17;
        return g0();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T l0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, n3.g<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.f64205w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.l0(r2, r3)
            return r2
        L_0x000d:
            r1.k(r2)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.n0(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.l0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, n3.g):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T m(Drawable drawable) {
        if (this.f64205w) {
            return clone().m(drawable);
        }
        this.f64188f = drawable;
        int i11 = this.f64184b | 16;
        this.f64184b = i11;
        this.f64189g = 0;
        this.f64184b = i11 & -33;
        return g0();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<Y>, java.lang.Object, n3.g] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T m0(java.lang.Class<Y> r2, n3.g<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.f64205w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.m0(r2, r3, r4)
            return r2
        L_0x000d:
            f4.h.d(r2)
            f4.h.d(r3)
            java.util.Map<java.lang.Class<?>, n3.g<?>> r0 = r1.f64201s
            r0.put(r2, r3)
            int r2 = r1.f64184b
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r1.f64184b = r2
            r3 = 1
            r1.f64197o = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f64184b = r2
            r0 = 0
            r1.f64208z = r0
            if (r4 == 0) goto L_0x0032
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f64184b = r2
            r1.f64196n = r3
        L_0x0032:
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.g0()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.m0(java.lang.Class, n3.g, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T n(int i11) {
        if (this.f64205w) {
            return clone().n(i11);
        }
        this.f64199q = i11;
        int i12 = this.f64184b | 16384;
        this.f64184b = i12;
        this.f64198p = null;
        this.f64184b = i12 & -8193;
        return g0();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T n0(n3.g<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.o0(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.n0(n3.g):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T o() {
        return d0(DownsampleStrategy.f64055c, new FitCenter());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T o0(n3.g<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.f64205w
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r2.clone()
            com.bumptech.glide.request.BaseRequestOptions r3 = r0.o0(r3, r4)
            return r3
        L_0x000d:
            com.bumptech.glide.load.resource.bitmap.g r0 = new com.bumptech.glide.load.resource.bitmap.g
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.m0(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.m0(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            n3.g r0 = r0.a()
            r2.m0(r1, r0, r4)
            java.lang.Class<y3.c> r0 = y3.c.class
            y3.e r1 = new y3.e
            r1.<init>(r3)
            r2.m0(r0, r1, r4)
            com.bumptech.glide.request.BaseRequestOptions r3 = r2.g0()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.o0(n3.g, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    public T p(long j11) {
        return h0(p.f64125d, Long.valueOf(j11));
    }

    public T p0(g<Bitmap>... gVarArr) {
        if (gVarArr.length > 1) {
            return o0(new n3.c((g<T>[]) gVarArr), true);
        }
        if (gVarArr.length == 1) {
            return n0(gVarArr[0]);
        }
        return g0();
    }

    public final DiskCacheStrategy q() {
        return this.f64186d;
    }

    public T q0(boolean z11) {
        if (this.f64205w) {
            return clone().q0(z11);
        }
        this.A = z11;
        this.f64184b |= 1048576;
        return g0();
    }

    public final int r() {
        return this.f64189g;
    }

    public final Drawable s() {
        return this.f64188f;
    }

    public final Drawable t() {
        return this.f64198p;
    }

    public final int u() {
        return this.f64199q;
    }

    public final boolean v() {
        return this.f64207y;
    }

    public final Options w() {
        return this.f64200r;
    }

    public final int x() {
        return this.f64193k;
    }

    public final int y() {
        return this.f64194l;
    }

    public final Drawable z() {
        return this.f64190h;
    }
}
