package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class PtBrLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static PtBrLang f68428a = new PtBrLang();
    }

    public static PtBrLang getInstance() {
        return b.f68428a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Portuguese-BR";
    }

    private PtBrLang() {
        this.locale = AppLanguageHelper.BRAZIL_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_brazil);
        this.header = "pt-BR";
        this.url = "/pt-br/";
        this.zendeskLocaleStr = "pt-br";
    }
}
