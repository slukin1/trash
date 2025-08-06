package com.huobi.utils;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.huobi.domain.DomainSwitcher;
import com.huochat.community.network.domain.DomainTool;
import i6.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import m6.a;
import sn.f;
import wi.b;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f83715a = new HashMap(1);

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (f83715a.get(str.toLowerCase()) != null) {
                f83715a.remove(str.toLowerCase());
            }
            f83715a.put(str.toLowerCase(), str2);
        }
    }

    public static String b() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + a.h() + "tradingbot/h5/futures";
    }

    public static String c() {
        String d11 = !TextUtils.isEmpty(o7.b.d()) ? o7.b.d() : "%scollection/custom/?formCode=9f420242c36b4ee88f766d12d05c714a&formVersion=14";
        Locale locale = Locale.US;
        return String.format(locale, j() + d11, new Object[]{f.s()});
    }

    public static String d() {
        String d11 = !TextUtils.isEmpty(o7.b.d()) ? o7.b.d() : "%scollection/custom/?formCode=9f420242c36b4ee88f766d12d05c714a&formVersion=14";
        Locale locale = Locale.US;
        return String.format(locale, j() + d11, new Object[]{f.s()});
    }

    public static String e() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + a.h() + "financial/earn/h5/orderDetail";
    }

    public static String f(String str) {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%s" + str, new Object[]{f.s()});
    }

    public static String g() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%sfiat/h5/deposit-order-detail/", new Object[]{f.s()});
    }

    public static String h() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%sfiat/h5/sepa-transfer/", new Object[]{f.s()});
    }

    public static String i() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%sfinancial/earn/h5", new Object[]{f.s()});
    }

    public static String j() {
        return !SystemUtils.c() ? b.f48038b : DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
    }

    public static String k(String str) {
        Locale locale = Locale.US;
        String format = String.format(locale, j() + "%s" + str, new Object[]{f.s()});
        StringBuilder sb2 = new StringBuilder();
        sb2.append("全域弹层最终URL：");
        sb2.append(format);
        d.c("HBgDialog", sb2.toString());
        return format;
    }

    public static String l(String str) {
        return DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + "/support/" + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/list/" + str;
    }

    public static String m() {
        return !SystemUtils.c() ? b.f48061y : DomainTool.DOMAIN_PREFIX + DomainSwitcher.G();
    }

    public static String n() {
        String b11 = !TextUtils.isEmpty(o7.b.b()) ? o7.b.b() : "%scollection/custom/?formCode=e3440bf69acf4f7ab3b5ecce84ce40a5&formVersion=10";
        Locale locale = Locale.US;
        return String.format(locale, j() + b11, new Object[]{f.s()});
    }

    public static String o() {
        String c11 = !TextUtils.isEmpty(o7.b.c()) ? o7.b.c() : "%scollection/custom/?formCode=30b625d14b034e9995ea97d1bd515672&formVersion=23";
        Locale locale = Locale.US;
        return String.format(locale, j() + c11, new Object[]{f.s()});
    }

    public static String p() {
        return String.format(j() + "%sobservation/h5/?hideNav=1", new Object[]{f.s()});
    }

    public static String q(Context context) {
        String lowerCase = p.a(context).toLowerCase();
        if (!TextUtils.isEmpty(lowerCase) && f83715a.get(lowerCase) != null) {
            return f83715a.get(lowerCase);
        }
        if (p.h(context)) {
            return p.i(context) ? "https://www.wjx.cn/vm/O70hYiA.aspx" : "https://www.wjx.cn/vm/QdvJJAF.aspx";
        }
        return "https://www.wjx.cn/vm/tUeOH9l.aspx";
    }

    public static String r() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%strade-rules/exchange/h5/", new Object[]{f.s()});
    }

    public static String s() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + a.h() + "tradingbot/h5/my-strategies";
    }

    public static String t() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + a.h() + "tradingbot/h5";
    }

    public static String u(String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(a.h());
        if (TextUtils.isEmpty(str)) {
            sb2.append("tradingbot/h5/create");
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public static String v() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%saccount/security-reset-h5/", new Object[]{f.s()});
    }

    public static String w() {
        Locale locale = Locale.US;
        return String.format(locale, j() + "%saccount/security-reset-h5/", new Object[]{f.s()});
    }
}
