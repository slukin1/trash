package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class NlNlLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static NlNlLang f68427a = new NlNlLang();
    }

    public static NlNlLang getInstance() {
        return b.f68427a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Dutch";
    }

    private NlNlLang() {
        this.locale = AppLanguageHelper.DUTCH_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_netherlands);
        this.header = "nl-NL";
        this.url = "/nl-nl/";
        this.zendeskLocaleStr = "nl-nl";
    }
}
