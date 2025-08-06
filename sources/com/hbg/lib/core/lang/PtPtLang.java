package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class PtPtLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static PtPtLang f68429a = new PtPtLang();
    }

    public static PtPtLang getInstance() {
        return b.f68429a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Portuguese-PT";
    }

    private PtPtLang() {
        this.locale = AppLanguageHelper.PORTUGAL_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_portugal);
        this.header = "pt-PT";
        this.url = "/pt-pt/";
        this.zendeskLocaleStr = "pt-pt";
    }
}
