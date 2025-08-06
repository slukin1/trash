package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class EsLaLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static EsLaLang f68419a = new EsLaLang();
    }

    public static EsLaLang getInstance() {
        return b.f68419a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Spanish-Latin America";
    }

    private EsLaLang() {
        this.locale = AppLanguageHelper.SPAIN_US_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_spanish_us);
        this.header = "es-LA";
        this.url = "/es-la/";
        this.zendeskLocaleStr = "es-la";
    }
}
