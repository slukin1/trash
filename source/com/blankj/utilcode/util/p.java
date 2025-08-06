package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class p {
    public static void a(Activity activity) {
        Locale locale;
        String c11 = a0.q().c("KEY_LOCALE");
        if (!TextUtils.isEmpty(c11)) {
            if ("VALUE_FOLLOW_SYSTEM".equals(c11)) {
                locale = b(Resources.getSystem().getConfiguration());
            } else {
                locale = e(c11);
            }
            if (locale != null) {
                g(activity, locale);
                g(Utils.a(), locale);
            }
        }
    }

    public static Locale b(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().get(0);
        }
        return configuration.locale;
    }

    public static boolean c(String str) {
        int i11 = 0;
        for (char c11 : str.toCharArray()) {
            if (c11 == '$') {
                if (i11 >= 1) {
                    return false;
                }
                i11++;
            }
        }
        return i11 == 1;
    }

    public static void d(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }

    public static Locale e(String str) {
        Locale f11 = f(str);
        if (f11 == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            a0.q().i("KEY_LOCALE");
        }
        return f11;
    }

    public static Locale f(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("$");
            return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void g(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        d(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
