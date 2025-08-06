package sa;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import ra.c;
import va.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale f84857a = new Locale("vi", "VN");

    /* renamed from: b  reason: collision with root package name */
    public static final Locale f84858b = new Locale("zh", "HK");

    /* renamed from: c  reason: collision with root package name */
    public static final Locale f84859c = new Locale("ms", "MY");

    /* renamed from: d  reason: collision with root package name */
    public static String f84860d;

    public static OtcConfigBean a() {
        try {
            return (OtcConfigBean) new Gson().fromJson(FileUtil.k(c.c().s().getResources().getAssets().open("otc_dynamic.json")), OtcConfigBean.class);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        List<OtcConfigItem.CountryBean> countryBeans;
        OtcConfigBean r11 = b.o().r();
        if (r11 == null) {
            r11 = a();
            b.o().D(r11);
        }
        if (!(r11 == null || (countryBeans = r11.getCountryBeans()) == null)) {
            for (OtcConfigItem.CountryBean next : countryBeans) {
                if (TextUtils.equals(str, next.getAppShort()) && g(next.getCurrencyId())) {
                    return next.getCurrencyId();
                }
            }
        }
        return "";
    }

    public static String c() {
        String e11 = ConfigPreferences.e("otc_config", "sp_key_pricing_method_type", "");
        if (!TextUtils.isEmpty(e11)) {
            f84860d = e11;
            return e11;
        }
        String i11 = i();
        if (!TextUtils.isEmpty(i11)) {
            f84860d = i11;
            return i11;
        }
        String country = Locale.getDefault().getCountry();
        if (!TextUtils.isEmpty(country)) {
            if (country.equals(Locale.SIMPLIFIED_CHINESE.getCountry())) {
                i11 = b(Locale.SIMPLIFIED_CHINESE.getCountry());
            } else {
                Locale locale = f84858b;
                if (country.equals(locale.getCountry())) {
                    i11 = b(locale.getCountry());
                } else {
                    Locale locale2 = f84859c;
                    if (country.equals(locale2.getCountry())) {
                        i11 = b(locale2.getCountry());
                    } else {
                        Locale locale3 = f84857a;
                        if (country.equals(locale3.getCountry())) {
                            i11 = b(locale3.getCountry());
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(i11)) {
            f84860d = "1";
        } else {
            f84860d = i11;
        }
        return f84860d;
    }

    public static String d() {
        if (h()) {
            return "vnd";
        }
        if (e()) {
            return "hkd";
        }
        return f() ? "myr" : "cny";
    }

    public static boolean e() {
        return TextUtils.equals(c(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
    }

    public static boolean f() {
        return TextUtils.equals(c(), "22");
    }

    public static boolean g(String str) {
        List<OtcConfigItem.CurrencyBean> currencyBeans;
        if (!(b.o().r() == null || (currencyBeans = b.o().r().getCurrencyBeans()) == null)) {
            for (OtcConfigItem.CurrencyBean currencyId : currencyBeans) {
                if (TextUtils.equals(str, currencyId.getCurrencyId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h() {
        return TextUtils.equals(c(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
    }

    public static String i() {
        List<OtcConfigItem.CountryBean> countryBeans;
        OtcConfigBean r11 = b.o().r();
        if (r11 == null) {
            r11 = a();
            b.o().D(r11);
        }
        String str = "";
        if (!(r11 == null || (countryBeans = r11.getCountryBeans()) == null)) {
            List<Integer> d11 = c.c().d();
            if (!CollectionsUtils.b(d11)) {
                for (OtcConfigItem.CountryBean next : countryBeans) {
                    if (TextUtils.equals(String.valueOf(d11.get(0).intValue()), next.getCountryId()) && g(next.getCurrencyId())) {
                        str = next.getCurrencyName();
                    }
                }
            }
        }
        return str;
    }

    public static void j(String str) {
        f84860d = str;
        ConfigPreferences.m("otc_config", "sp_key_pricing_method_type", str);
    }
}
