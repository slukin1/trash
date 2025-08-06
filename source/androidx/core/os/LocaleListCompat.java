package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

public final class LocaleListCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final LocaleListCompat f8390b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    public final j f8391a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Locale[] f8392a = {new Locale(TUIThemeManager.LANGUAGE_EN, "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale equals : f8392a) {
                if (equals.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String c11 = z0.b.c(locale);
            if (!c11.isEmpty()) {
                return c11.equals(z0.b.c(locale2));
            }
            String country = locale.getCountry();
            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                return true;
            }
            return false;
        }
    }

    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public LocaleListCompat(j jVar) {
        this.f8391a = jVar;
    }

    public static LocaleListCompat a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return j(b.a(localeArr));
        }
        return new LocaleListCompat(new i(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER, -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static LocaleListCompat c(String str) {
        Locale locale;
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP, -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i11 = 0; i11 < length; i11++) {
            if (Build.VERSION.SDK_INT >= 21) {
                locale = a.a(split[i11]);
            } else {
                locale = b(split[i11]);
            }
            localeArr[i11] = locale;
        }
        return a(localeArr);
    }

    public static LocaleListCompat e() {
        return f8390b;
    }

    public static LocaleListCompat j(LocaleList localeList) {
        return new LocaleListCompat(new k(localeList));
    }

    public Locale d(int i11) {
        return this.f8391a.get(i11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.f8391a.equals(((LocaleListCompat) obj).f8391a);
    }

    public boolean f() {
        return this.f8391a.isEmpty();
    }

    public int g() {
        return this.f8391a.size();
    }

    public String h() {
        return this.f8391a.a();
    }

    public int hashCode() {
        return this.f8391a.hashCode();
    }

    public Object i() {
        return this.f8391a.b();
    }

    public String toString() {
        return this.f8391a.toString();
    }
}
