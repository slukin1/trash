package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class RuRuLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static RuRuLang f68430a = new RuRuLang();
    }

    public static RuRuLang getInstance() {
        return b.f68430a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Russian";
    }

    private RuRuLang() {
        this.locale = AppLanguageHelper.RUSSIAN_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_russian);
        this.header = "ru-RU";
        this.url = "/ru-ru/";
        this.zendeskLocaleStr = "ru-ru";
    }
}
