package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class ZhHkLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static ZhHkLang f68435a = new ZhHkLang();
    }

    public static ZhHkLang getInstance() {
        return b.f68435a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "TraditionalChinese";
    }

    private ZhHkLang() {
        this.locale = AppLanguageHelper.TRADITIONAL_CHINESE_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_chinese_tw);
        this.header = "zh-HK";
        this.url = "/zh-hk/";
        this.zendeskLocaleStr = "zh-hk";
    }
}
