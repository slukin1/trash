package p0;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;

public final class h {

    public static class a {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static LocaleListCompat a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.c(e.a(context));
        }
        Object b11 = b(context);
        if (b11 != null) {
            return LocaleListCompat.j(a.a(b11));
        }
        return LocaleListCompat.e();
    }

    public static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
