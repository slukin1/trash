package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8393a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final int f8394b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f8395c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8396d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f8397e;

    /* renamed from: androidx.core.os.a$a  reason: collision with other inner class name */
    public static final class C0023a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0023a f8398a = new C0023a();

        public final int a(int i11) {
            return SdkExtensions.getExtensionVersion(i11);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        int i12 = 0;
        f8394b = i11 >= 30 ? C0023a.f8398a.a(30) : 0;
        f8395c = i11 >= 30 ? C0023a.f8398a.a(31) : 0;
        f8396d = i11 >= 30 ? C0023a.f8398a.a(33) : 0;
        if (i11 >= 30) {
            i12 = C0023a.f8398a.a(1000000);
        }
        f8397e = i12;
    }

    public static final boolean a(String str, String str2) {
        if (x.b("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0) {
            return true;
        }
        return false;
    }

    public static final boolean b() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 33 || (i11 >= 32 && a("Tiramisu", Build.VERSION.CODENAME));
    }

    public static final boolean c() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 34 || (i11 >= 33 && a("UpsideDownCake", Build.VERSION.CODENAME));
    }

    public static final boolean d() {
        return Build.VERSION.SDK_INT >= 34 && a("VanillaIceCream", Build.VERSION.CODENAME);
    }
}
