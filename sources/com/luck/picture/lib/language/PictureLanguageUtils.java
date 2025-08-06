package com.luck.picture.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.luck.picture.lib.utils.SpUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

public class PictureLanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private PictureLanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void applyLanguage(Context context, Locale locale) {
        applyLanguage(context, locale, false);
    }

    private static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public static void setAppLanguage(Context context, int i11, int i12) {
        WeakReference weakReference = new WeakReference(context);
        if (i11 >= 0) {
            applyLanguage((Context) weakReference.get(), LocaleTransform.getLanguage(i11));
        } else if (i12 >= 0) {
            applyLanguage((Context) weakReference.get(), LocaleTransform.getLanguage(i12));
        } else {
            setDefaultLanguage((Context) weakReference.get());
        }
    }

    private static void setDefaultLanguage(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void updateLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (!equals(locale2.getLanguage(), locale.getLanguage()) || !equals(locale2.getCountry(), locale.getCountry())) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            context.createConfigurationContext(configuration);
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    private static void applyLanguage(Context context, Locale locale, boolean z11) {
        if (z11) {
            SpUtils.putString(context, KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
        } else {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            SpUtils.putString(context, KEY_LOCALE, language + "$" + country);
        }
        updateLanguage(context, locale);
    }
}
