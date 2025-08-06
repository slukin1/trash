package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import java.util.Locale;

public final class ZhCnLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static ZhCnLang f68434a = new ZhCnLang();
    }

    public static ZhCnLang getInstance() {
        return b.f68434a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "SimplifiedChinese";
    }

    private ZhCnLang() {
        this.locale = Locale.SIMPLIFIED_CHINESE;
        this.str = BaseApplication.b().getString(R$string.setting_chinese);
        this.header = "zh-CN";
        this.url = "/zh-cn/";
        this.zendeskLocaleStr = "zh-cn";
    }
}
