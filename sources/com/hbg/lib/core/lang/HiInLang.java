package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;

public final class HiInLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static HiInLang f68421a = new HiInLang();
    }

    public static HiInLang getInstance() {
        return b.f68421a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Hindi";
    }

    private HiInLang() {
        this.locale = AppLanguageHelper.HI_IN_LOCALE;
        this.str = BaseApplication.b().getString(R$string.setting_hi_in);
        this.header = "hi-IN";
        this.url = "/hi-in/";
        this.zendeskLocaleStr = "hi-in";
    }
}
