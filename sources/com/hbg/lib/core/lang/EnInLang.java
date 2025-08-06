package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class EnInLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static EnInLang f68416a = new EnInLang();
    }

    public static EnInLang getInstance() {
        return b.f68416a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "English (India)";
    }

    private EnInLang() {
        this.locale = AppLanguageHelper.EN_IN_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_english_in);
        this.header = "en-IN";
        this.url = "/en-in/";
        this.zendeskLocaleStr = "en-in";
    }
}
