package q3;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f66564a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66565b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f66566c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66567d;

    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        public static final int f66568i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        public final Context f66569a;

        /* renamed from: b  reason: collision with root package name */
        public ActivityManager f66570b;

        /* renamed from: c  reason: collision with root package name */
        public c f66571c;

        /* renamed from: d  reason: collision with root package name */
        public float f66572d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f66573e = ((float) f66568i);

        /* renamed from: f  reason: collision with root package name */
        public float f66574f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        public float f66575g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        public int f66576h = 4194304;

        public a(Context context) {
            this.f66569a = context;
            this.f66570b = (ActivityManager) context.getSystemService("activity");
            this.f66571c = new C0724b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && b.e(this.f66570b)) {
                this.f66573e = 0.0f;
            }
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: q3.b$b  reason: collision with other inner class name */
    public static final class C0724b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final DisplayMetrics f66577a;

        public C0724b(DisplayMetrics displayMetrics) {
            this.f66577a = displayMetrics;
        }

        public int a() {
            return this.f66577a.heightPixels;
        }

        public int b() {
            return this.f66577a.widthPixels;
        }
    }

    public interface c {
        int a();

        int b();
    }

    public b(a aVar) {
        int i11;
        this.f66566c = aVar.f66569a;
        if (e(aVar.f66570b)) {
            i11 = aVar.f66576h / 2;
        } else {
            i11 = aVar.f66576h;
        }
        this.f66567d = i11;
        int c11 = c(aVar.f66570b, aVar.f66574f, aVar.f66575g);
        float b11 = (float) (aVar.f66571c.b() * aVar.f66571c.a() * 4);
        int round = Math.round(aVar.f66573e * b11);
        int round2 = Math.round(b11 * aVar.f66572d);
        int i12 = c11 - i11;
        int i13 = round2 + round;
        if (i13 <= i12) {
            this.f66565b = round2;
            this.f66564a = round;
        } else {
            float f11 = (float) i12;
            float f12 = aVar.f66573e;
            float f13 = aVar.f66572d;
            float f14 = f11 / (f12 + f13);
            this.f66565b = Math.round(f13 * f14);
            this.f66564a = Math.round(f14 * aVar.f66573e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f66565b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f66564a));
            sb2.append(", byte array size: ");
            sb2.append(f(i11));
            sb2.append(", memory class limited? ");
            sb2.append(i13 > c11);
            sb2.append(", max size: ");
            sb2.append(f(c11));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f66570b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f66570b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    public static int c(ActivityManager activityManager, float f11, float f12) {
        boolean e11 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e11) {
            f11 = f12;
        }
        return Math.round(memoryClass * f11);
    }

    @TargetApi(19)
    public static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f66567d;
    }

    public int b() {
        return this.f66564a;
    }

    public int d() {
        return this.f66565b;
    }

    public final String f(int i11) {
        return Formatter.formatFileSize(this.f66566c, (long) i11);
    }
}
