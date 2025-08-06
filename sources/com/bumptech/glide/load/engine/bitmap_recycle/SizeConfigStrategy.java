package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import f4.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy implements h {

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f63747d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f63748e;

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.Config[] f63749f = {Bitmap.Config.RGB_565};

    /* renamed from: g  reason: collision with root package name */
    public static final Bitmap.Config[] f63750g = {Bitmap.Config.ARGB_4444};

    /* renamed from: h  reason: collision with root package name */
    public static final Bitmap.Config[] f63751h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    public final c f63752a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final f<b, Bitmap> f63753b = new f<>();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f63754c = new HashMap();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f63755a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f63755a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f63755a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f63755a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f63755a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.a.<clinit>():void");
        }
    }

    public static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public final c f63756a;

        /* renamed from: b  reason: collision with root package name */
        public int f63757b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f63758c;

        public b(c cVar) {
            this.f63756a = cVar;
        }

        public void a() {
            this.f63756a.c(this);
        }

        public void b(int i11, Bitmap.Config config) {
            this.f63757b = i11;
            this.f63758c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f63757b != bVar.f63757b || !i.d(this.f63758c, bVar.f63758c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11 = this.f63757b * 31;
            Bitmap.Config config = this.f63758c;
            return i11 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.h(this.f63757b, this.f63758c);
        }
    }

    public static class c extends d<b> {
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i11, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i11, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f63747d = configArr;
        f63748e = configArr;
    }

    public static String h(int i11, Bitmap.Config config) {
        return "[" + i11 + "](" + config + ")";
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f63748e;
        }
        int i11 = a.f63755a[config.ordinal()];
        if (i11 == 1) {
            return f63747d;
        }
        if (i11 == 2) {
            return f63749f;
        }
        if (i11 == 3) {
            return f63750g;
        }
        if (i11 == 4) {
            return f63751h;
        }
        return new Bitmap.Config[]{config};
    }

    public String a(int i11, int i12, Bitmap.Config config) {
        return h(i.g(i11, i12, config), config);
    }

    public int b(Bitmap bitmap) {
        return i.h(bitmap);
    }

    public void c(Bitmap bitmap) {
        b e11 = this.f63752a.e(i.h(bitmap), bitmap.getConfig());
        this.f63753b.d(e11, bitmap);
        NavigableMap<Integer, Integer> j11 = j(bitmap.getConfig());
        Integer num = (Integer) j11.get(Integer.valueOf(e11.f63757b));
        Integer valueOf = Integer.valueOf(e11.f63757b);
        int i11 = 1;
        if (num != null) {
            i11 = 1 + num.intValue();
        }
        j11.put(valueOf, Integer.valueOf(i11));
    }

    public Bitmap d(int i11, int i12, Bitmap.Config config) {
        b g11 = g(i.g(i11, i12, config), config);
        Bitmap a11 = this.f63753b.a(g11);
        if (a11 != null) {
            f(Integer.valueOf(g11.f63757b), a11);
            a11.reconfigure(i11, i12, config);
        }
        return a11;
    }

    public String e(Bitmap bitmap) {
        return h(i.h(bitmap), bitmap.getConfig());
    }

    public final void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j11 = j(bitmap.getConfig());
        Integer num2 = (Integer) j11.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            j11.remove(num);
        } else {
            j11.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public final b g(int i11, Bitmap.Config config) {
        b e11 = this.f63752a.e(i11, config);
        Bitmap.Config[] i12 = i(config);
        int length = i12.length;
        int i13 = 0;
        while (i13 < length) {
            Bitmap.Config config2 = i12[i13];
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i11));
            if (ceilingKey == null || ceilingKey.intValue() > i11 * 8) {
                i13++;
            } else {
                if (ceilingKey.intValue() == i11) {
                    if (config2 == null) {
                        if (config == null) {
                            return e11;
                        }
                    } else if (config2.equals(config)) {
                        return e11;
                    }
                }
                this.f63752a.c(e11);
                return this.f63752a.e(ceilingKey.intValue(), config2);
            }
        }
        return e11;
    }

    public final NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f63754c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f63754c.put(config, treeMap);
        return treeMap;
    }

    public Bitmap removeLast() {
        Bitmap f11 = this.f63753b.f();
        if (f11 != null) {
            f(Integer.valueOf(i.h(f11)), f11);
        }
        return f11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f63753b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry next : this.f63754c.entrySet()) {
            sb2.append(next.getKey());
            sb2.append('[');
            sb2.append(next.getValue());
            sb2.append("], ");
        }
        if (!this.f63754c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }
}
