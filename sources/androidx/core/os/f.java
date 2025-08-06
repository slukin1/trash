package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

public final class f {

    public static class a {
        public static void a(Configuration configuration, LocaleListCompat localeListCompat) {
            if (!localeListCompat.f()) {
                configuration.setLocale(localeListCompat.d(0));
            }
        }
    }

    public static class b {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales((LocaleList) localeListCompat.i());
        }
    }

    public static LocaleListCompat a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.j(b.a(configuration));
        }
        return LocaleListCompat.a(configuration.locale);
    }

    public static void b(Configuration configuration, LocaleListCompat localeListCompat) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            b.b(configuration, localeListCompat);
        } else if (i11 >= 17) {
            a.a(configuration, localeListCompat);
        }
    }
}
