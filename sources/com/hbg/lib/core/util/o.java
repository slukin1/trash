package com.hbg.lib.core.util;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.config.AliyunConfig;
import com.hbg.lib.core.config.OtherConfig;
import i6.d;
import java.util.Map;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static OtherConfig f68741a;

    /* renamed from: b  reason: collision with root package name */
    public static AliyunConfig f68742b;

    /* renamed from: c  reason: collision with root package name */
    public static String f68743c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, String> f68744d;

    public static String a() {
        OtherConfig otherConfig = f68741a;
        return (otherConfig == null || TextUtils.isEmpty(otherConfig.getGooglePlayPackage())) ? "com.android.vending" : f68741a.getGooglePlayPackage();
    }

    public static String b() {
        OtherConfig otherConfig = f68741a;
        return (otherConfig == null || TextUtils.isEmpty(otherConfig.getGooglePlayUrl())) ? "https://play.google.com/store/apps/details" : f68741a.getGooglePlayUrl();
    }

    public static int c() {
        OtherConfig otherConfig = f68741a;
        return Math.min(Math.max((otherConfig == null || otherConfig.getKlineDeepNum() == 0) ? 20 : f68741a.getKlineDeepNum(), 5), 20);
    }

    public static int d(boolean z11) {
        OtherConfig otherConfig;
        int i11 = z11 ? 300 : 200;
        if (!(z11 || (otherConfig = f68741a) == null || otherConfig.getKlineNum() == 0)) {
            i11 = f68741a.getKlineNum();
        }
        return Math.min(Math.max(i11, 100), 300);
    }

    public static String e() {
        if (TextUtils.isEmpty(f68743c)) {
            f68743c = BaseApplication.b().getResources().getString(R$string.otc_url);
        }
        d.b("FeatureConfigHelper-->getOtcAuthHost-->" + f68743c);
        return f68743c;
    }

    public static String f() {
        String str;
        Map<String, String> map = f68744d;
        if (map == null || !map.containsKey(AppLanguageHelper.getInstance().getCurAppLocale().toString())) {
            str = "";
        } else {
            str = f68744d.get(AppLanguageHelper.getInstance().getCurAppLocale().toString());
            SP.s("CACHE_WEB_HOST", str);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String i11 = SP.i("CACHE_WEB_HOST", "");
        if (!TextUtils.isEmpty(i11)) {
            return i11;
        }
        if (f68741a == null) {
            return "";
        }
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return f68741a.getWebHostCn();
        }
        if (AppLanguageHelper.getInstance().isEnglishLanguage()) {
            return f68741a.getWebHostEn();
        }
        if (AppLanguageHelper.getInstance().isKoreaLanguage()) {
            return f68741a.getWebHostKr();
        }
        if (AppLanguageHelper.getInstance().isTurkeyLanguage()) {
            return f68741a.getWebHostTr();
        }
        if (AppLanguageHelper.getInstance().isVietnamLanguage()) {
            return f68741a.getWebHostVi();
        }
        return AppLanguageHelper.getInstance().isRussianLanguage() ? f68741a.getWebHostRu() : str;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static void i(AliyunConfig aliyunConfig) {
        f68742b = aliyunConfig;
    }

    public static void j(OtherConfig otherConfig) {
        f68741a = otherConfig;
    }

    public static void k(String str) {
        d.b("FeatureConfigHelper-->setOtcAuthHost-->" + str);
        f68743c = str;
    }

    public static void l(Map<String, String> map) {
        f68744d = map;
    }
}
