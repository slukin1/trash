package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class ViLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static ViLang f68433a = new ViLang();
    }

    public static ViLang getInstance() {
        return b.f68433a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Vietnamese";
    }

    private ViLang() {
        this.locale = AppLanguageHelper.VIETNAM_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_vietnam);
        this.header = "vi-VI";
        this.url = "/vi-vi/";
        this.zendeskLocaleStr = "vi-vi";
    }
}
