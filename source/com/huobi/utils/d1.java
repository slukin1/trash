package com.huobi.utils;

import com.hbg.lib.core.lang.EnLang;
import com.hbg.lib.core.lang.ZhCnLang;
import com.hbg.lib.core.lang.ZhHkLang;
import com.hbg.lib.core.util.AppLanguageHelper;
import java.util.Locale;
import m6.a;

public final class d1 {
    public static String a() {
        return String.format(Locale.US, c1.m(), new Object[]{h()});
    }

    public static String b() {
        return String.format(Locale.US, c1.n(), new Object[]{h()});
    }

    public static String c() {
        return String.format(Locale.US, c1.o(), new Object[]{h()});
    }

    public static String d() {
        return String.format(Locale.US, c1.q(), new Object[]{h()});
    }

    public static String e() {
        return String.format(Locale.US, c1.p(), new Object[]{h()});
    }

    public static String f() {
        return String.format(Locale.US, c1.b(), new Object[]{h()});
    }

    public static String g() {
        return String.format(Locale.US, c1.c(), new Object[]{h()});
    }

    public static String h() {
        return a.j();
    }

    public static String i() {
        Locale locale = Locale.US;
        return String.format(locale, a0.j() + "%sglobal-licensed-businesses", new Object[]{a.h()});
    }

    public static String j() {
        return String.format(Locale.US, c1.r(), new Object[]{h()});
    }

    public static String k() {
        return String.format(Locale.US, c1.f(), new Object[]{h()});
    }

    public static String l() {
        return String.format(Locale.US, c1.i(), new Object[]{h()});
    }

    public static String m() {
        return String.format(Locale.US, c1.t(), new Object[]{h()});
    }

    public static String n() {
        return String.format(Locale.US, c1.s(), new Object[]{h()});
    }

    public static String o() {
        if (AppLanguageHelper.getInstance().isTurkeyLanguage()) {
            return String.format(Locale.US, c1.u(), new Object[]{h()});
        }
        Locale locale = Locale.US;
        return String.format(locale, c1.u(), new Object[]{"en-US".toLowerCase(locale)});
    }

    public static String p() {
        if (AppLanguageHelper.getInstance().isTurkeyLanguage()) {
            return String.format(Locale.US, c1.v(), new Object[]{h()});
        }
        Locale locale = Locale.US;
        return String.format(locale, c1.v(), new Object[]{"en-US".toLowerCase(locale)});
    }

    public static String q() {
        String str;
        String f11 = a.f();
        if (ZhCnLang.getInstance().getLanguageHeader().equals(f11)) {
            str = ZhCnLang.getInstance().getLanguageHeader().toLowerCase(Locale.US);
        } else if (ZhHkLang.getInstance().getLanguageHeader().equals(f11)) {
            str = ZhHkLang.getInstance().getLanguageHeader().toLowerCase(Locale.US);
        } else {
            str = EnLang.getInstance().getLanguageHeader().toLowerCase(Locale.US);
        }
        return String.format(Locale.US, c1.k(), new Object[]{str});
    }

    public static String r() {
        return String.format(Locale.US, c1.w(), new Object[]{h()});
    }

    public static String s() {
        return String.format(Locale.US, c1.x(), new Object[]{h()});
    }

    public static String t() {
        return String.format(Locale.US, c1.f83722b, new Object[]{h()});
    }
}
