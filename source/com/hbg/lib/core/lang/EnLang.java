package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import java.util.Locale;

public final class EnLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static EnLang f68417a = new EnLang();
    }

    public static EnLang getInstance() {
        return b.f68417a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "English";
    }

    private EnLang() {
        this.locale = Locale.ENGLISH;
        this.str = BaseApplication.b().getString(R$string.setting_english);
        this.header = "en-US";
        this.url = "/en-us/";
        this.zendeskLocaleStr = "en-us";
    }
}
