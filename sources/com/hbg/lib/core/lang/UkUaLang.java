package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class UkUaLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static UkUaLang f68432a = new UkUaLang();
    }

    public static UkUaLang getInstance() {
        return b.f68432a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "English";
    }

    private UkUaLang() {
        this.locale = AppLanguageHelper.UK_UA_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_uk_ua);
        this.header = "uk-UA";
        this.url = "/uk-ua/";
        this.zendeskLocaleStr = "uk-ua";
    }
}
