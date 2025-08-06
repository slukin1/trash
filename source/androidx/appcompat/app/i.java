package androidx.appcompat.app;

import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class i {
    public static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i11 = 0; i11 < localeListCompat.g() + localeListCompat2.g(); i11++) {
            if (i11 < localeListCompat.g()) {
                locale = localeListCompat.d(i11);
            } else {
                locale = localeListCompat2.d(i11 - localeListCompat.g());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.f()) {
            return LocaleListCompat.e();
        }
        return a(localeListCompat, localeListCompat2);
    }
}
