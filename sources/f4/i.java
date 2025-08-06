package f4;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import s3.c;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f66261a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f66262b = new char[64];

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66263a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f66263a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f66263a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f66263a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f66263a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGBA_F16     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f66263a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f4.i.a.<clinit>():void");
        }
    }

    public static void a() {
        if (!q()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!r()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof c) {
            return ((c) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static String e(byte[] bArr, char[] cArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11] & 255;
            int i12 = i11 * 2;
            char[] cArr2 = f66261a;
            cArr[i12] = cArr2[b11 >>> 4];
            cArr[i12 + 1] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> f(int i11) {
        return new ArrayDeque(i11);
    }

    public static int g(int i11, int i12, Bitmap.Config config) {
        return i11 * i12 * i(config);
    }

    @TargetApi(19)
    public static int h(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i11 = a.f66263a[config.ordinal()];
        if (i11 == 1) {
            return 1;
        }
        if (i11 == 2 || i11 == 3) {
            return 2;
        }
        return i11 != 4 ? 4 : 8;
    }

    public static <T> List<T> j(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static int k(float f11) {
        return l(f11, 17);
    }

    public static int l(float f11, int i11) {
        return n(Float.floatToIntBits(f11), i11);
    }

    public static int m(int i11) {
        return n(i11, 17);
    }

    public static int n(int i11, int i12) {
        return (i12 * 31) + i11;
    }

    public static int o(Object obj, int i11) {
        return n(obj == null ? 0 : obj.hashCode(), i11);
    }

    public static int p(boolean z11, int i11) {
        return n(z11 ? 1 : 0, i11);
    }

    public static boolean q() {
        return !r();
    }

    public static boolean r() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean s(int i11) {
        return i11 > 0 || i11 == Integer.MIN_VALUE;
    }

    public static boolean t(int i11, int i12) {
        return s(i11) && s(i12);
    }

    public static String u(byte[] bArr) {
        String e11;
        char[] cArr = f66262b;
        synchronized (cArr) {
            e11 = e(bArr, cArr);
        }
        return e11;
    }
}
