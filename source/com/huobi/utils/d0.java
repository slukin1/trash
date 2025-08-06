package com.huobi.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

public class d0 {
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

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static boolean c(Context context) {
        return b(context) && !a(context).toLowerCase(Locale.ROOT).endsWith("cn");
    }
}
