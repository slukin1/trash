package com.huobi.otc.utils;

import android.text.TextUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.helper.OtcCountryConfigImpl;
import java.util.List;
import java.util.Locale;
import lp.c;
import va.b;

public class OtcCountryConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static c f79633a = new OtcCountryConfigImpl();

    public static String a() {
        List<Integer> d11 = OtcModuleConfig.a().d();
        if (!CollectionsUtils.b(d11)) {
            return String.valueOf(d11.get(0));
        }
        Locale systemLocale = AppLanguageHelper.getInstance().getSystemLocale();
        if (systemLocale == null || TextUtils.isEmpty(systemLocale.getCountry())) {
            return "";
        }
        String country = systemLocale.getCountry();
        if (b.o().r() == null || b.o().r().getCountryBeans() == null) {
            return "";
        }
        for (OtcConfigItem.CountryBean next : b.o().r().getCountryBeans()) {
            if (country.equalsIgnoreCase(next.getAppShort())) {
                return next.getCountryId();
            }
        }
        return "";
    }

    public static String b() {
        return AppLanguageHelper.getInstance().getCurLanguageHeader();
    }
}
