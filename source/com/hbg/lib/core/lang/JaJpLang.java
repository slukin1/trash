package com.hbg.lib.core.lang;

import android.annotation.SuppressLint;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.R$string;
import java.util.Locale;

public final class JaJpLang extends BaseLang {

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static JaJpLang f68424a = new JaJpLang();
    }

    public static JaJpLang getInstance() {
        return b.f68424a;
    }

    public static String getLanguage() {
        return getInstance().getLocale().getLanguage();
    }

    public String getSensorsLanguage() {
        return "日本語";
    }

    private JaJpLang() {
        this.locale = Locale.JAPAN;
        this.str = BaseApplication.b().getString(R$string.setting_japanese);
        this.header = "ja-JP";
        this.url = "/ja-jp/";
        this.zendeskLocaleStr = "ja-jp";
    }
}
