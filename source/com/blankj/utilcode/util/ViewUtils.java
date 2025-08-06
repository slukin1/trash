package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Locale;

public class ViewUtils {
    public static boolean a() {
        Locale locale;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 17) {
            return false;
        }
        if (i11 >= 24) {
            locale = Utils.a().getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = Utils.a().getResources().getConfiguration().locale;
        }
        if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    public static View b(int i11) {
        return ((LayoutInflater) Utils.a().getSystemService("layout_inflater")).inflate(i11, (ViewGroup) null);
    }
}
