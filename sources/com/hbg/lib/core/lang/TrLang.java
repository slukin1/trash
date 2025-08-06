package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class TrLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static TrLang f68431a = new TrLang();
    }

    public static TrLang getInstance() {
        return b.f68431a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Turkish";
    }

    private TrLang() {
        this.locale = AppLanguageHelper.TURKEY_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_turkey);
        this.header = "tr-TR";
        this.url = "/tr-tr/";
        this.zendeskLocaleStr = "tr-tr";
    }
}
