package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class IdLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static IdLang f68422a = new IdLang();
    }

    public static IdLang getInstance() {
        return b.f68422a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Bahasa Indonesia";
    }

    private IdLang() {
        this.locale = AppLanguageHelper.INDONESIA_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_indonesian);
        this.header = "id-ID";
        this.url = "/id-id/";
        this.zendeskLocaleStr = "id-id";
    }
}
