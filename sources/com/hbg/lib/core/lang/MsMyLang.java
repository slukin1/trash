package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class MsMyLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static MsMyLang f68426a = new MsMyLang();
    }

    public static MsMyLang getInstance() {
        return b.f68426a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Indonesian";
    }

    private MsMyLang() {
        this.locale = AppLanguageHelper.MS_MY_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_malaysia);
        this.header = "ms-MY";
        this.url = "/ms-my/";
        this.zendeskLocaleStr = "ms-my";
    }
}
