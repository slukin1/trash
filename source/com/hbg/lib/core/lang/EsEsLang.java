package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class EsEsLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static EsEsLang f68418a = new EsEsLang();
    }

    public static EsEsLang getInstance() {
        return b.f68418a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Spanish";
    }

    private EsEsLang() {
        this.locale = AppLanguageHelper.SPANISH_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_spanish);
        this.header = "es-ES";
        this.url = "/es-es/";
        this.zendeskLocaleStr = "es-es";
    }
}
