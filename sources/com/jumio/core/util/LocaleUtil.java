package com.jumio.core.util;

import android.content.Context;
import android.os.Build;
import java.util.Locale;

public final class LocaleUtil {
    public static final LocaleUtil INSTANCE = new LocaleUtil();

    public final Locale getLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getApplicationContext().getResources().getConfiguration().getLocales().get(0);
        }
        return context.getApplicationContext().getResources().getConfiguration().locale;
    }
}
