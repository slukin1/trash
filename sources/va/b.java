package va;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ra.c;
import rx.Observable;

public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f84992d;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f84993a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f84994b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public OtcConfigBean f84995c;

    public class a extends TypeToken<HashMap<String, Map<String, String>>> {
    }

    public b() {
        C();
    }

    public static String c(String str) {
        try {
            Map map = (Map) ((HashMap) new Gson().fromJson(FileUtil.k(c.c().s().getResources().getAssets().open("otc_card_trade_json.json")), new a().getType())).get(str);
            if (map == null) {
                return "";
            }
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                return (String) map.get("zh-cn");
            }
            return (String) map.get("default");
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String d(int i11) {
        OtcConfigBean r11 = o().r();
        if (r11 != null && !CollectionsUtils.b(r11.getCoinInfoList())) {
            for (OtcMarketCoinInfo.CoinInfo next : r11.getCoinInfoList()) {
                if (next.getCoinId() == i11) {
                    return next.getCoinCode();
                }
            }
        }
        switch (i11) {
            case 1:
                return "BTC";
            case 2:
                return "USDT";
            case 3:
                return DefiChainInfo.CHAIN_ETH;
            case 4:
                return "HT";
            case 5:
                return "EOS";
            case 6:
                return "HUSD";
            case 7:
                return "XRP";
            case 8:
                return "LTC";
            case 10:
                return "BCH";
            case 11:
                return "ETC";
            case 12:
                return "BSV";
            case 13:
                return "DASH";
            case 14:
                return "HPT";
            case 15:
                return "USD01";
            default:
                return "";
        }
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        OtcConfigBean r11 = o().r();
        if (r11 != null && !CollectionsUtils.b(r11.getCoinInfoList())) {
            for (OtcMarketCoinInfo.CoinInfo next : r11.getCoinInfoList()) {
                if (str.equalsIgnoreCase(next.getShortName())) {
                    return next.getCoinId();
                }
            }
        }
        if ("BTC".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("USDT".equalsIgnoreCase(str)) {
            return 2;
        }
        if (DefiChainInfo.CHAIN_ETH.equalsIgnoreCase(str)) {
            return 3;
        }
        if ("HT".equalsIgnoreCase(str)) {
            return 4;
        }
        if ("EOS".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("HUSD".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("XRP".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("LTC".equalsIgnoreCase(str)) {
            return 8;
        }
        return 0;
    }

    public static String g(int i11) {
        OtcConfigBean r11 = o().r();
        if (r11 == null || CollectionsUtils.b(r11.getCoinInfoList())) {
            return "";
        }
        for (OtcMarketCoinInfo.CoinInfo next : r11.getCoinInfoList()) {
            if (next.getCoinId() == i11) {
                return next.getShortName();
            }
        }
        return "";
    }

    public static OtcConfigItem.CurrencyBean h(String str) {
        OtcConfigBean r11 = o().r();
        if (TextUtils.isEmpty(str) || r11 == null || CollectionsUtils.b(r11.getCurrencyBeans())) {
            return null;
        }
        for (OtcConfigItem.CurrencyBean next : r11.getCurrencyBeans()) {
            if (str.equalsIgnoreCase(next.getCurrencyId())) {
                return next;
            }
        }
        return null;
    }

    public static OtcConfigItem.CurrencyBean i(String str) {
        OtcConfigBean r11 = o().r();
        if (TextUtils.isEmpty(str) || r11 == null || CollectionsUtils.b(r11.getCurrencyBeans())) {
            return null;
        }
        for (OtcConfigItem.CurrencyBean next : r11.getCurrencyBeans()) {
            if (str.equalsIgnoreCase(next.getNameShort())) {
                return next;
            }
        }
        return null;
    }

    public static String j(String str) {
        OtcConfigBean r11 = o().r();
        if (r11 != null && !CollectionsUtils.b(r11.getCurrencyBeans())) {
            for (OtcConfigItem.CurrencyBean next : r11.getCurrencyBeans()) {
                if (str.equalsIgnoreCase(next.getNameShort())) {
                    return next.getCurrencyId();
                }
            }
        }
        return "";
    }

    public static String k(int i11) {
        return l(String.valueOf(i11));
    }

    public static String l(String str) {
        OtcConfigBean r11 = o().r();
        if (r11 == null || CollectionsUtils.b(r11.getCurrencyBeans())) {
            return "USD";
        }
        for (OtcConfigItem.CurrencyBean next : r11.getCurrencyBeans()) {
            if (TextUtils.equals(next.getCurrencyId(), str)) {
                return next.getNameShort();
            }
        }
        return "USD";
    }

    public static String m(int i11) {
        return n(String.valueOf(i11));
    }

    public static String n(String str) {
        OtcConfigBean r11 = o().r();
        if (r11 == null || CollectionsUtils.b(r11.getCurrencyBeans())) {
            return "";
        }
        for (OtcConfigItem.CurrencyBean next : r11.getCurrencyBeans()) {
            if (TextUtils.equals(next.getCurrencyId(), str)) {
                return next.getSymbol();
            }
        }
        return "";
    }

    public static b o() {
        if (f84992d == null) {
            synchronized (b.class) {
                if (f84992d == null) {
                    f84992d = new b();
                }
            }
        }
        return f84992d;
    }

    public static int q(String str) {
        OtcConfigItem.CurrencyBean i11;
        if (TextUtils.isEmpty(str) || (i11 = i(str)) == null) {
            return 1;
        }
        if (i11.getEntrance() == 1) {
            return 2;
        }
        if (i11.getEntrance() == 2) {
            return 1;
        }
        return 3;
    }

    public static OtcMarketCoinInfo.CoinInfo s(int i11) {
        List<OtcMarketCoinInfo.CoinInfo> coinInfoList;
        OtcConfigBean r11 = o().r();
        if (r11 != null && !CollectionsUtils.b(r11.getCoinInfoList()) && (coinInfoList = r11.getCoinInfoList()) != null && !coinInfoList.isEmpty()) {
            for (OtcMarketCoinInfo.CoinInfo next : coinInfoList) {
                if (next != null && next.getCoinId() == i11) {
                    return next;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ OtcConfigBean y(OtcConfigBean otcConfigBean) {
        otcConfigBean.setVersion(System.currentTimeMillis());
        D(otcConfigBean);
        return otcConfigBean;
    }

    public final void A() {
        if (this.f84995c != null) {
            ConfigPreferences.m("otc_config", "otc_dynamic_key", new Gson().toJson((Object) this.f84995c));
        }
    }

    public Observable<OtcConfigBean> B() {
        return s8.a.a().d().b().map(new a(this));
    }

    public final void C() {
        String d11 = ConfigPreferences.d("otc_config", "otc_dynamic_key");
        if (!TextUtils.isEmpty(d11)) {
            try {
                OtcConfigBean otcConfigBean = (OtcConfigBean) new Gson().fromJson(d11, OtcConfigBean.class);
                this.f84995c = otcConfigBean;
                if (otcConfigBean != null) {
                    return;
                }
            } catch (Throwable th2) {
                if (this.f84995c == null) {
                    z();
                }
                throw th2;
            }
            z();
            return;
        }
        z();
    }

    public void D(OtcConfigBean otcConfigBean) {
        this.f84995c = otcConfigBean;
        A();
    }

    public void E(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f84995c = (OtcConfigBean) new Gson().fromJson(str, OtcConfigBean.class);
                A();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void b() {
        OtcConfigBean otcConfigBean = this.f84995c;
        if (otcConfigBean != null) {
            otcConfigBean.setVersion(0);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        List<String> u11 = u();
        List<String> u12 = bVar.u();
        if (u11 != null ? !u11.equals(u12) : u12 != null) {
            return false;
        }
        List<String> t11 = t();
        List<String> t12 = bVar.t();
        if (t11 != null ? !t11.equals(t12) : t12 != null) {
            return false;
        }
        OtcConfigBean r11 = r();
        OtcConfigBean r12 = bVar.r();
        return r11 != null ? r11.equals(r12) : r12 == null;
    }

    public String f(String str) {
        OtcConfigBean otcConfigBean = this.f84995c;
        if (otcConfigBean != null && !CollectionsUtils.b(otcConfigBean.getCurrencyBeans())) {
            for (OtcMarketCoinInfo.CoinInfo next : this.f84995c.getCoinInfoList()) {
                if (str.equalsIgnoreCase(next.getShortName())) {
                    return String.valueOf(next.getCoinId());
                }
            }
        }
        return "";
    }

    public int hashCode() {
        List<String> u11 = u();
        int i11 = 43;
        int hashCode = u11 == null ? 43 : u11.hashCode();
        List<String> t11 = t();
        int hashCode2 = ((hashCode + 59) * 59) + (t11 == null ? 43 : t11.hashCode());
        OtcConfigBean r11 = r();
        int i12 = hashCode2 * 59;
        if (r11 != null) {
            i11 = r11.hashCode();
        }
        return i12 + i11;
    }

    public List<OtcMarketCoinInfo.CoinInfo> p() {
        ArrayList arrayList = new ArrayList();
        OtcConfigBean otcConfigBean = this.f84995c;
        return (otcConfigBean == null || CollectionsUtils.b(otcConfigBean.getCoinInfoList())) ? arrayList : this.f84995c.getCoinInfoList();
    }

    public OtcConfigBean r() {
        return this.f84995c;
    }

    public synchronized List<String> t() {
        if (CollectionsUtils.b(this.f84993a)) {
            this.f84994b.add("BE");
            this.f84994b.add("FI");
            this.f84994b.add("FR");
            this.f84994b.add("HU");
            this.f84994b.add("IE");
            this.f84994b.add("IT");
            this.f84994b.add("NL");
            this.f84994b.add("NO");
            this.f84994b.add("ES");
            this.f84994b.add("SE");
            this.f84994b.add("CH");
            this.f84994b.add("GB");
            this.f84994b.add("RU");
            this.f84994b.add("GI");
            this.f84994b.add("UA");
            this.f84994b.add("KZ");
        }
        return this.f84994b;
    }

    public String toString() {
        return "OtcConfigModel(supportFastUserIdList=" + u() + ", supportFastCountryCodeList=" + t() + ", otcConfigBean=" + r() + ")";
    }

    public synchronized List<String> u() {
        if (CollectionsUtils.b(this.f84993a)) {
            this.f84993a.add("19");
            this.f84993a.add("54");
            this.f84993a.add("55");
            this.f84993a.add("72");
            this.f84993a.add("78");
            this.f84993a.add("80");
            this.f84993a.add("121");
            this.f84993a.add("127");
            this.f84993a.add("159");
            this.f84993a.add("166");
            this.f84993a.add("167");
            this.f84993a.add("182");
            this.f84993a.add("142");
            this.f84993a.add("62");
            this.f84993a.add("180");
            this.f84993a.add("86");
        }
        return this.f84993a;
    }

    public boolean v(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (OtcConfigItem.CurrencyBean next : this.f84995c.getCurrencyBeans()) {
            if (TextUtils.equals(next.getNameShort().toUpperCase(), str.toUpperCase())) {
                if (next.getWhetherGib() == 2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("USD".equalsIgnoreCase(str) || "USD01".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public boolean x() {
        OtcConfigBean otcConfigBean = this.f84995c;
        return otcConfigBean != null && !CollectionsUtils.b(otcConfigBean.getCurrencyBeans()) && !CollectionsUtils.b(this.f84995c.getCountryBeans()) && !CollectionsUtils.b(this.f84995c.getCoinInfoList()) && System.currentTimeMillis() - this.f84995c.getVersion() < Period.MIN60_MILLS;
    }

    public final void z() {
        try {
            this.f84995c = (OtcConfigBean) new Gson().fromJson(FileUtil.k(c.c().s().getResources().getAssets().open("otc_dynamic.json")), OtcConfigBean.class);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
