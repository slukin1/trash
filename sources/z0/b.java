package z0;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Method f16883a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f16884b;

    public static class a {
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* renamed from: z0.b$b  reason: collision with other inner class name */
    public static class C0116b {
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        Class<String> cls = String.class;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21) {
            try {
                Class<?> cls2 = Class.forName("libcore.icu.ICU");
                f16883a = cls2.getMethod("getScript", new Class[]{cls});
                f16884b = cls2.getMethod("addLikelySubtags", new Class[]{cls});
            } catch (Exception e11) {
                f16883a = null;
                f16884b = null;
                Log.w("ICUCompat", e11);
            }
        } else if (i11 < 24) {
            try {
                f16884b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e12) {
                throw new IllegalStateException(e12);
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f16884b;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e11) {
            Log.w("ICUCompat", e11);
        } catch (InvocationTargetException e12) {
            Log.w("ICUCompat", e12);
        }
        return locale2;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static String b(String str) {
        try {
            Method method = f16883a;
            if (method != null) {
                return (String) method.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException e11) {
            Log.w("ICUCompat", e11);
        } catch (InvocationTargetException e12) {
            Log.w("ICUCompat", e12);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return C0116b.c(C0116b.a(C0116b.b(locale)));
        }
        if (i11 >= 21) {
            try {
                return a.a((Locale) f16884b.invoke((Object) null, new Object[]{locale}));
            } catch (InvocationTargetException e11) {
                Log.w("ICUCompat", e11);
                return a.a(locale);
            } catch (IllegalAccessException e12) {
                Log.w("ICUCompat", e12);
                return a.a(locale);
            }
        } else {
            String a11 = a(locale);
            if (a11 != null) {
                return b(a11);
            }
            return null;
        }
    }
}
