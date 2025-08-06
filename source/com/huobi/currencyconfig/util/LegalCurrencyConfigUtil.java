package com.huobi.currencyconfig.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.HbgDataModuleConfig;
import com.hbg.lib.data.R$string;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.currencyconfig.helper.LegalCurrencyConfigImpl;
import com.huobi.utils.GsonHelper;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import e6.h;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import u6.g;

public class LegalCurrencyConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43757a = "LegalCurrencyConfigUtil";

    /* renamed from: b  reason: collision with root package name */
    public static List<PricingMethodBean> f43758b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, PricingMethodBean> f43759c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static jj.a f43760d = new LegalCurrencyConfigImpl();

    public class a extends TypeToken<List<PricingMethodBean>> {
    }

    public class b extends TypeToken<List<PricingMethodBean>> {
    }

    public class c extends EasySubscriber<List<PricingMethodBean>> {
        public void onError2(Throwable th2) {
            super.onError2(th2);
            String str = LegalCurrencyConfigUtil.f43757a;
            Log.d(str, "requestValuationWayList---onError2: " + th2.getMessage());
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            String str = LegalCurrencyConfigUtil.f43757a;
            Log.d(str, "requestValuationWayList---onFailed: " + aPIStatusErrorException.getErrMsg());
        }

        public void onNext(List<PricingMethodBean> list) {
            super.onNext(list);
            if (list != null && list.size() > 0) {
                LegalCurrencyConfigUtil.f43758b = list;
                HashMap<String, PricingMethodBean> hashMap = new HashMap<>();
                for (PricingMethodBean next : LegalCurrencyConfigUtil.f43758b) {
                    hashMap.put(next.getAbbr(), next);
                }
                LegalCurrencyConfigUtil.f43759c = hashMap;
                String json = new Gson().toJson((Object) list);
                SP.w("user_config", "sp_key_valuation_way_list", json);
                if (LegalCurrencyConfigUtil.W()) {
                    String a11 = LegalCurrencyConfigUtil.p();
                    if (!TextUtils.isEmpty(a11)) {
                        LegalCurrencyConfigUtil.c0(a11);
                    }
                }
                String str = LegalCurrencyConfigUtil.f43757a;
                Log.d(str, "requestValuationWayList---onRequestSuccess: " + json);
            }
        }
    }

    static {
        a0();
    }

    public static String A(String str, String str2, TradeType tradeType) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String U = U(str, true, str2, tradeType);
        if (!TextUtils.isEmpty(U)) {
            return B(U);
        }
        return "";
    }

    public static String B(String str) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String v11 = v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        try {
            return L(new BigDecimal(str).multiply(bigDecimal));
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String C(String str, String str2) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str2)) {
            return B(str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String d11 = f43760d.d(StringUtils.g(str2));
        if (TextUtils.isEmpty(d11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(d11);
        }
        try {
            return M(new BigDecimal(str).multiply(bigDecimal), str2);
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String D(String str, String str2, TradeType tradeType) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String U = U(str, false, str2, tradeType);
        if (!TextUtils.isEmpty(U)) {
            return B(U);
        }
        return "";
    }

    public static String E(String str, String str2) {
        return f43760d.p(str, str2);
    }

    public static String F(String str, String str2, String str3) {
        return f43760d.c(str, str2, str3);
    }

    public static String G(String str, String str2, TradeType tradeType) {
        BigDecimal bigDecimal;
        String g11 = StringUtils.g(str2);
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        if ("usdt".equals(g11)) {
            str3 = B(str);
        } else {
            Map<String, SymbolPrice> P = P(tradeType);
            if (!(P == null || P.size() <= 0 || (bigDecimal = HbgDataModuleConfig.a().a("usdt", P).get(g11)) == null)) {
                str3 = B(new BigDecimal(str).multiply(bigDecimal).toPlainString());
            }
        }
        return TextUtils.isEmpty(str3) ? L(BigDecimal.ZERO) : str3;
    }

    public static BigDecimal H(String str) {
        return f43760d.g(str);
    }

    public static Map<String, String> I(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    hashMap.put((String) next.getKey(), B((String) next.getValue()));
                }
            }
        }
        return hashMap;
    }

    public static String J(Context context, String str) {
        String str2;
        if (m.a(str).compareTo(BigDecimal.ZERO) < 0) {
            str2 = context.getResources().getString(R$string.balance_total_cny_with_space);
        } else {
            str2 = context.getResources().getString(R$string.balance_total_cny);
        }
        return String.format(str2, new Object[]{str}) + y().toUpperCase(Locale.US);
    }

    public static String K(String str, int i11) {
        if (!str.contains(InstructionFileId.DOT)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split("\\.");
        if (split.length < 1) {
            return str;
        }
        int i12 = 0;
        stringBuffer.append(split[0]);
        stringBuffer.append(InstructionFileId.DOT);
        String str2 = split[1];
        boolean z11 = false;
        int i13 = 0;
        while (i12 < str2.length()) {
            try {
                int parseInt = Integer.parseInt(String.valueOf(str2.charAt(i12)));
                stringBuffer.append(String.valueOf(parseInt));
                if (z11 || parseInt > 0) {
                    i13++;
                    if (i13 >= i11) {
                        break;
                    }
                    z11 = true;
                    i12++;
                } else {
                    i12++;
                }
            } catch (Exception unused) {
            }
        }
        return stringBuffer.toString();
    }

    public static String L(BigDecimal bigDecimal) {
        if (bigDecimal == null || Double.valueOf(m.h0(bigDecimal.toPlainString())).doubleValue() == 0.0d) {
            return "0.00";
        }
        return N(bigDecimal);
    }

    public static String M(BigDecimal bigDecimal, String str) {
        if (bigDecimal == null || TextUtils.isEmpty(str) || Double.valueOf(m.h0(bigDecimal.toPlainString())).doubleValue() == 0.0d) {
            return "0.00";
        }
        return N(bigDecimal);
    }

    public static String N(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "0.00";
        }
        String plainString = bigDecimal.toPlainString();
        double abs = Math.abs(m.h0(plainString));
        if (Double.compare(abs, 0.0d) == 0) {
            return "0.00";
        }
        if (Double.compare(abs, 0.1d) >= 0) {
            return bigDecimal.setScale(2, 1).toPlainString();
        }
        if (Double.compare(abs, 0.01d) >= 0) {
            return bigDecimal.setScale(4, 1).toPlainString();
        }
        return K(plainString, 3);
    }

    public static String O(String str) {
        PricingMethodBean pricingMethodBean = f43759c.get(str);
        String abbr = pricingMethodBean != null ? pricingMethodBean.getAbbr() : "";
        if (!TextUtils.isEmpty(abbr)) {
            return abbr;
        }
        str.hashCode();
        if (str.equals("btc")) {
            return "btc";
        }
        if (!str.equals("usdt")) {
            return "usd";
        }
        return "usdt";
    }

    public static Map<String, SymbolPrice> P(TradeType tradeType) {
        return f43760d.e(tradeType);
    }

    public static String Q(String str, String str2) {
        return f43760d.m(str, str2);
    }

    public static String R(String str, BigDecimal bigDecimal, String str2, int i11) {
        return f43760d.b(str, bigDecimal, str2, i11);
    }

    public static Observable<Map<String, SymbolPrice>> S(TradeType tradeType, boolean z11) {
        return f43760d.k(z11);
    }

    public static Map<String, SymbolPrice> T() {
        return f43760d.f();
    }

    public static String U(String str, boolean z11, String str2, TradeType tradeType) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, SymbolPrice> P = P(tradeType);
        String E = a1.v().E(str2, tradeType);
        String o11 = a1.v().o(str2, tradeType);
        if (P == null || P.isEmpty()) {
            return "";
        }
        Map<String, BigDecimal> a11 = HbgDataModuleConfig.a().a("usdt", P);
        boolean equals = "usdt".equals(a1.v().E(str2, tradeType));
        SymbolPrice symbolPrice = P.get(str2);
        if (equals) {
            if (symbolPrice == null || symbolPrice.getClose() == null) {
                bigDecimal = new BigDecimal(0);
            } else {
                bigDecimal = new BigDecimal(symbolPrice.getClose().doubleValue());
            }
        } else if (z11) {
            bigDecimal = a11.get(E);
        } else {
            bigDecimal = a11.get(o11);
        }
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(str).multiply(bigDecimal).toPlainString();
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String V(String str, String str2, TradeType tradeType) {
        BigDecimal bigDecimal;
        String g11 = StringUtils.g(str2);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("usdt".equals(g11)) {
            return str;
        }
        Map<String, SymbolPrice> P = P(tradeType);
        if (P == null || P.size() <= 0 || (bigDecimal = HbgDataModuleConfig.a().a("usdt", P).get(g11)) == null) {
            return "";
        }
        return new BigDecimal(str).multiply(bigDecimal).toPlainString();
    }

    public static boolean W() {
        return ConfigPreferences.c("user_config", "sp_key_update_pricing_method", false);
    }

    public static Observable<List<LegalRateBean>> X(boolean z11) {
        return f43760d.n(z11);
    }

    public static String Y(String str, String str2) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String d11 = f43760d.d(StringUtils.g(str2));
        if (TextUtils.isEmpty(d11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(d11);
        }
        try {
            return M(new BigDecimal(str).divide(bigDecimal, 8, 4), str2);
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean Z(String str) {
        return f43760d.j(str);
    }

    public static void a0() {
        String j11 = SP.j("user_config", "sp_key_valuation_way_list", "");
        String str = f43757a;
        Log.d(str, "initValuationWayList---SP: " + j11);
        if (!TextUtils.isEmpty(j11)) {
            Log.d(str, "static initializer: start--");
            try {
                List<PricingMethodBean> list = (List) GsonHelper.a().fromJson(j11, new a().getType());
                f43758b = list;
                for (PricingMethodBean next : list) {
                    f43759c.put(next.getAbbr(), next);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                f43758b = new ArrayList();
                f43759c = new HashMap<>();
                String str2 = f43757a;
                Log.d(str2, "static initializer: Exception--" + e11.getMessage());
            }
            Log.d(f43757a, "static initializer: end--");
            return;
        }
        Log.d(str, "initValuationWayList: start--");
        String s11 = h.r().s("HBPricingMethod");
        List<PricingMethodBean> list2 = (List) GsonHelper.a().fromJson(s11, new b().getType());
        f43758b = list2;
        for (PricingMethodBean next2 : list2) {
            f43759c.put(next2.getAbbr(), next2);
        }
        SP.w("user_config", "sp_key_valuation_way_list", s11);
        Log.d(f43757a, "initValuationWayList: end --");
    }

    public static String b(String str, int i11) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String v11 = v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        try {
            return new BigDecimal(str).multiply(bigDecimal).setScale(i11, RoundingMode.DOWN).toPlainString();
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static void b0() {
        v7.b.a().getValuationWayList().b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }

    public static String c(String str, String str2, int i11) {
        return f43760d.l(str, str2, i11);
    }

    public static void c0(String str) {
        ConfigPreferences.m("user_config", "sp_key_pricing_method", str);
        d0("");
    }

    public static String d() {
        String d11 = ConfigPreferences.d("user_config", "sp_key_symbol_pricing_method");
        return TextUtils.isEmpty(d11) ? y() : d11;
    }

    public static void d0(String str) {
        ConfigPreferences.m("user_config", "sp_key_symbol_pricing_method", str);
    }

    public static Observable<Map<String, SymbolPrice>> e() {
        return f43760d.h();
    }

    public static void e0(Map<String, SymbolPrice> map) {
        f43760d.i(map);
    }

    public static Observable<Map<String, SymbolPrice>> f(boolean z11) {
        return f43760d.k(z11);
    }

    public static void f0(boolean z11) {
        ConfigPreferences.n("user_config", "sp_key_update_pricing_method", z11);
    }

    public static String g(String str) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String v11 = v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        try {
            return k(new BigDecimal(str).multiply(bigDecimal));
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String h(String str, String str2) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str2)) {
            return B(str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String d11 = f43760d.d(StringUtils.g(str2));
        if (TextUtils.isEmpty(d11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(d11);
        }
        try {
            return l(new BigDecimal(str).multiply(bigDecimal), str2);
        } catch (NumberFormatException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String i(String str, String str2) {
        return f43760d.o(str, str2);
    }

    public static String j(String str, String str2, String str3) {
        return f43760d.a(str, str2, str3);
    }

    public static String k(BigDecimal bigDecimal) {
        if (bigDecimal == null || Double.valueOf(m.h0(bigDecimal.toPlainString())).doubleValue() == 0.0d) {
            return "0.00";
        }
        return m(bigDecimal);
    }

    public static String l(BigDecimal bigDecimal, String str) {
        if (bigDecimal == null || TextUtils.isEmpty(str) || Double.valueOf(m.h0(bigDecimal.toPlainString())).doubleValue() == 0.0d) {
            return "0.00";
        }
        return m(bigDecimal);
    }

    public static String m(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "0.00";
        }
        String plainString = bigDecimal.toPlainString();
        double abs = Math.abs(m.h0(plainString));
        if (Double.compare(abs, 0.0d) == 0) {
            return "0.00";
        }
        if (Double.compare(abs, 0.1d) >= 0) {
            return bigDecimal.setScale(2, 1).toPlainString();
        }
        if (Double.compare(abs, 0.01d) >= 0) {
            return bigDecimal.setScale(4, 1).toPlainString();
        }
        return K(plainString, 3);
    }

    public static String n(String str, TradeType tradeType) {
        BigDecimal bigDecimal;
        Map<String, SymbolPrice> T = T();
        BigDecimal bigDecimal2 = null;
        if (T != null) {
            String E = a1.v().E(str, tradeType);
            String o11 = a1.v().o(str, tradeType);
            SymbolPrice symbolPrice = T.get(str);
            boolean equals = "usdt".equals(E);
            Double close = symbolPrice != null ? symbolPrice.getClose() : null;
            if ("usdt".equals(o11)) {
                bigDecimal2 = BigDecimal.ONE;
            } else if (close != null) {
                if (equals) {
                    bigDecimal2 = new BigDecimal(close.toString());
                } else {
                    SymbolPrice symbolPrice2 = T.get(E + "usdt");
                    Double close2 = symbolPrice2 != null ? symbolPrice2.getClose() : null;
                    if (close2 != null) {
                        bigDecimal2 = new BigDecimal(close2.toString()).multiply(new BigDecimal(close.toString()));
                    }
                }
            }
            if (bigDecimal2 == null && close != null && !T.isEmpty()) {
                BigDecimal bigDecimal3 = HbgDataModuleConfig.a().a("usdt", T).get(E);
                if (bigDecimal3 == null) {
                    bigDecimal3 = BigDecimal.ZERO;
                }
                bigDecimal2 = bigDecimal3.multiply(new BigDecimal(close.toString()));
            }
        }
        if (bigDecimal2 == null) {
            bigDecimal2 = BigDecimal.ZERO;
        }
        String v11 = v();
        if (TextUtils.isEmpty(v11)) {
            bigDecimal = BigDecimal.ONE;
        } else {
            bigDecimal = new BigDecimal(v11);
        }
        return L(bigDecimal2.multiply(bigDecimal));
    }

    public static String o(String str, String str2, String str3, TradeType tradeType) {
        BigDecimal bigDecimal;
        Map<String, SymbolPrice> P = P(tradeType);
        if (P == null || P.size() <= 0 || (bigDecimal = HbgDataModuleConfig.a().a(str3, P).get(str)) == null) {
            return m.m("0", PrecisionUtil.a(tradeType, str3));
        }
        return m.m(new BigDecimal(str2).multiply(bigDecimal).toPlainString(), PrecisionUtil.a(tradeType, str3));
    }

    public static String p() {
        Locale systemLocale = AppLanguageHelper.getInstance().getSystemLocale();
        String str = systemLocale.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + systemLocale.getCountry();
        String str2 = "";
        for (PricingMethodBean next : f43758b) {
            String deviceLanguage = next.getDeviceLanguage();
            if (!TextUtils.isEmpty(deviceLanguage)) {
                String[] split = deviceLanguage.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int length = split.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (TextUtils.equals(split[i11], str)) {
                        str2 = next.getAbbr();
                        f0(false);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        return str2;
    }

    public static Object q(Context context, String str) {
        PricingMethodBean pricingMethodBean = f43759c.get(str);
        if (pricingMethodBean == null || TextUtils.isEmpty(pricingMethodBean.getImageUrl())) {
            return -1;
        }
        if (pricingMethodBean.getImageUrl().contains("/")) {
            return pricingMethodBean.getImageUrl();
        }
        return Integer.valueOf(context.getResources().getIdentifier(pricingMethodBean.getImageUrl(), "drawable", context.getPackageName()));
    }

    public static String r(String str, boolean z11) {
        if (z11) {
            str = str + O(str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.toUpperCase(Locale.US);
    }

    public static String s(String str) {
        return f43760d.d(str);
    }

    public static String t(Context context, String str) {
        if (context == null) {
            return null;
        }
        PricingMethodBean pricingMethodBean = f43759c.get(str);
        String symbol = pricingMethodBean != null ? pricingMethodBean.getSymbol() : "";
        return TextUtils.isEmpty(symbol) ? context.getString(R$string.usd_label) : symbol;
    }

    public static String u(Context context, String str) {
        String string = context.getResources().getString(R$string.balance_total_cny_with_space);
        return String.format(string, new Object[]{str}) + d().toUpperCase(Locale.US);
    }

    public static String v() {
        return f43760d.d(y());
    }

    public static String w() {
        Context h11 = SPUtil.h();
        if (h11 == null) {
            return null;
        }
        PricingMethodBean pricingMethodBean = f43759c.get(y());
        String symbol = pricingMethodBean != null ? pricingMethodBean.getSymbol() : "";
        return TextUtils.isEmpty(symbol) ? h11.getString(R$string.usd_label) : symbol;
    }

    public static String x() {
        Context h11 = SPUtil.h();
        String d11 = d();
        if ("btc".equals(d11)) {
            return h11.getResources().getString(R$string.b_label);
        }
        if ("usdt".equals(d11)) {
            return h11.getResources().getString(R$string.usdt_label);
        }
        return w();
    }

    public static String y() {
        String d11 = ConfigPreferences.d("user_config", "sp_key_pricing_method");
        if (!TextUtils.isEmpty(d11) && f43759c.containsKey(d11)) {
            return d11;
        }
        String z11 = z(AppLanguageHelper.getInstance().getSystemLocale());
        c0(z11);
        return z11;
    }

    public static String z(Locale locale) {
        String str = "";
        if (locale == null) {
            Iterator<PricingMethodBean> it2 = f43758b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PricingMethodBean next = it2.next();
                if (next.getDefaultCurrency() == 1) {
                    str = next.getAbbr();
                    break;
                }
            }
            return TextUtils.isEmpty(str) ? f43758b.get(0).getAbbr() : str;
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String str2 = language + Constants.ACCEPT_TIME_SEPARATOR_SERVER + country;
        Log.d(f43757a, "lang:" + language + ",country = " + country);
        String str3 = str;
        for (PricingMethodBean next2 : f43758b) {
            String deviceLanguage = next2.getDeviceLanguage();
            if (!TextUtils.isEmpty(deviceLanguage)) {
                String[] split = deviceLanguage.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                int length = split.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (TextUtils.equals(split[i11], str2)) {
                        str = next2.getAbbr();
                        break;
                    } else {
                        i11++;
                    }
                }
                if (next2.getDefaultCurrency() == 1) {
                    str3 = next2.getAbbr();
                }
            }
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            f0(true);
            str = str3;
        }
        if (!TextUtils.isEmpty(str) || f43758b.size() <= 0) {
            return str;
        }
        String abbr = f43758b.get(0).getAbbr();
        f0(true);
        return abbr;
    }
}
