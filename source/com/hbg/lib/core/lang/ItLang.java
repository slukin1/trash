package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import java.util.Locale;

public final class ItLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static ItLang f68423a = new ItLang();
    }

    public static ItLang getInstance() {
        return b.f68423a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Italian";
    }

    private ItLang() {
        this.locale = Locale.ITALIAN;
        this.str = BaseApplication.b().getString(R$string.setting_italian);
        this.header = "it-IT";
        this.url = "/it-it/";
        this.zendeskLocaleStr = "it-it";
    }
}
