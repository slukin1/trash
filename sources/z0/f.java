package z0;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale f16910a = new Locale("", "");

    public static class a {
        public static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    public static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return a.a(locale);
        }
        if (locale == null || locale.equals(f16910a)) {
            return 0;
        }
        String c11 = b.c(locale);
        if (c11 == null) {
            return a(locale);
        }
        return (c11.equalsIgnoreCase("Arab") || c11.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
