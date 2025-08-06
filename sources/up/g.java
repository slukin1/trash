package up;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.enums.TradeBusinessEnum;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jp.c1;
import ra.c;
import va.b;

public final class g {
    public static OtcConfigBean a() {
        try {
            return (OtcConfigBean) new Gson().fromJson(FileUtil.k(c.c().s().getResources().getAssets().open("otc_dynamic.json")), OtcConfigBean.class);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String b() {
        String d11 = ConfigPreferences.d("otc_config", "otc_select_trade_coin");
        return TextUtils.isEmpty(d11) ? "USDT" : d11;
    }

    public static String c(String str) {
        String uid = OtcModuleConfig.a().getUid();
        if (!TextUtils.isEmpty(uid)) {
            String d11 = ConfigPreferences.d("otc_config", str + uid);
            if (!TextUtils.isEmpty(d11) && c1.h().b(TradeBusinessEnum.ALL, d11)) {
                return d11;
            }
        }
        String d12 = ConfigPreferences.d("otc_config", str);
        if (!TextUtils.isEmpty(d12) && c1.h().b(TradeBusinessEnum.ALL, d12)) {
            return d12;
        }
        Locale systemLocale = AppLanguageHelper.getInstance().getSystemLocale();
        String d13 = d();
        if (!TextUtils.isEmpty(d13) && c1.h().b(TradeBusinessEnum.ALL, d13)) {
            return d13;
        }
        if (systemLocale != null && !TextUtils.isEmpty(systemLocale.getCountry())) {
            String country = systemLocale.getCountry();
            if (b.o().r() != null && b.o().r().getCountryBeans() != null) {
                Iterator<OtcConfigItem.CountryBean> it2 = b.o().r().getCountryBeans().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    OtcConfigItem.CountryBean next = it2.next();
                    if (country.equalsIgnoreCase(next.getAppShort()) && b.h(next.getCurrencyId()) != null) {
                        d13 = next.getCurrencyName();
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(d13) || !c1.h().b(TradeBusinessEnum.ALL, d13)) {
            return (b.o().r() == null || CollectionsUtils.b(b.o().r().getCurrencyBeans())) ? "USD" : b.o().r().getCurrencyBeans().get(0).getNameShort();
        }
        return d13;
    }

    public static String d() {
        List<OtcConfigItem.CountryBean> countryBeans;
        OtcConfigBean r11 = b.o().r();
        if (r11 == null) {
            r11 = a();
            b.o().D(r11);
        }
        if (!(r11 == null || (countryBeans = r11.getCountryBeans()) == null)) {
            List<Integer> d11 = OtcModuleConfig.a().d();
            if (!CollectionsUtils.b(d11)) {
                for (OtcConfigItem.CountryBean next : countryBeans) {
                    if (TextUtils.equals(String.valueOf(d11.get(0).intValue()), next.getCountryId()) && b.h(next.getCurrencyId()) != null) {
                        return next.getCurrencyName();
                    }
                }
            }
        }
        return "";
    }

    public static void e(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.toUpperCase();
        }
        String uid = OtcModuleConfig.a().getUid();
        if (!TextUtils.isEmpty(uid)) {
            ConfigPreferences.m("otc_config", str + uid, str2);
        }
    }
}
