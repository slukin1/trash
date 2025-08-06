package com.hbg.lib.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

public final class p {
    public static String a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (language.endsWith("vi")) {
            return "vi-vi";
        }
        if (language.endsWith("ru")) {
            return "ru-ru";
        }
        if (language.endsWith("tr")) {
            return "tr-tr";
        }
        if (language.endsWith("fr")) {
            return "fr-fr";
        }
        if (language.endsWith("it")) {
            return "it-it";
        }
        if (!TextUtils.isEmpty(country) && !TextUtils.isEmpty(language)) {
            if (language.endsWith("zh")) {
                return language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country;
            } else if (language.endsWith(TUIThemeManager.LANGUAGE_EN)) {
                return language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country;
            } else if (language.endsWith("es")) {
                return language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country;
            }
        }
        return "en-us";
    }

    public static String b() {
        Locale locale = BaseApplication.b().getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            country = "us";
        }
        return language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country;
    }

    public static boolean c(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("ru");
    }

    public static boolean d() {
        return Resources.getSystem().getConfiguration().locale.getLanguage().endsWith("ko");
    }

    public static boolean e() {
        return Resources.getSystem().getConfiguration().locale.getLanguage().endsWith("tr");
    }

    public static boolean f(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("tr");
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("vi");
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static boolean i(Context context) {
        return h(context) && !a(context).toLowerCase(Locale.ROOT).endsWith("cn");
    }
}
