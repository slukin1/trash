package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class FrLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static FrLang f68420a = new FrLang();
    }

    public static FrLang getInstance() {
        return b.f68420a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "French";
    }

    private FrLang() {
        this.locale = AppLanguageHelper.FRENCH_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_french);
        this.header = "fr-FR";
        this.url = "/fr-fr/";
        this.zendeskLocaleStr = "fr-fr";
    }
}
