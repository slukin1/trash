package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import java.util.Locale;

public final class KoKrLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static KoKrLang f68425a = new KoKrLang();
    }

    public static KoKrLang getInstance() {
        return b.f68425a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "Korean";
    }

    private KoKrLang() {
        this.locale = Locale.KOREA;
        this.str = BaseApplication.b().getString(R$string.setting_korean);
        this.header = "ko-KR";
        this.url = "/ko-kr/";
        this.zendeskLocaleStr = "ko-kr";
    }
}
