package gs;

import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.x;
import com.hbg.lib.core.util.m0;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sumsub.sentry.q;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tg.r;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<String> f84191a = new ArrayList<>();

    public static void a(String str, String str2, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("business_category", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap2.put("type", str2);
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        i("appexposure_contracts", hashMap2);
    }

    public static void b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("tradepair_name", str);
        hashMap.put("handicap_type", str2);
        i("bb_coindetail_view", hashMap);
    }

    public static HashMap<String, Object> c() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Constants.EXTRA_KEY_APP_VERSION, String.valueOf(105400));
        hashMap.put(TPDownloadProxyEnum.USER_OS_VERSION, Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("is_login", Boolean.valueOf(r.x().F0()));
        hashMap.put(q.f30469g, n0.f32119g);
        hashMap.put("uid", r.x().J());
        hashMap.put("deviceid", m0.a());
        return hashMap;
    }

    public static String d() {
        return SPUtil.j() ? "usdt_multiple" : "usdt_single";
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (f84191a.isEmpty()) {
            f84191a.add("Kline");
            f84191a.add("menu");
            f84191a.add("contracts_set");
            f84191a.add("order_navigation");
            f84191a.add("rate");
            f84191a.add("market_information");
            f84191a.add("trade_limit");
            f84191a.add("sub_account_management");
            f84191a.add("about_contracts");
            f84191a.add("add_optional");
            f84191a.add("new_guide");
            f84191a.add("single_double");
            f84191a.add("onebyone_all");
            f84191a.add("single");
            f84191a.add("double");
            f84191a.add("transfer");
            f84191a.add("entrust_model_explanation");
            f84191a.add("entrust_model");
            f84191a.add("limited_price_entrust");
            f84191a.add("market_price_entrust");
            f84191a.add("stop_surplus_loss");
            f84191a.add("plan_entrust");
            f84191a.add("tracking_entrust");
            f84191a.add("period_entrust");
            f84191a.add("lever_adjust");
            f84191a.add("buy_open");
            f84191a.add("sell_open");
            f84191a.add("buy_flat");
            f84191a.add("sell_flat");
            f84191a.add("all_repeal");
            f84191a.add("repeal");
            f84191a.add("hold_share");
            f84191a.add("flat");
            f84191a.add("market_price_flat");
            f84191a.add("key_backhand");
            f84191a.add(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER);
        }
        return f84191a.contains(str);
    }

    public static void f(String str) {
        g(str, (HashMap) null);
    }

    public static void g(String str, HashMap hashMap) {
        String str2;
        try {
            HashMap<String, Object> c11 = c();
            c11.put("event", str);
            c11.put("event_data", hashMap);
            String jSONObject = new JSONObject(c11).toString();
            if (d.k()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                sb2.append(str);
                sb2.append("]");
                if (hashMap == null) {
                    str2 = "";
                } else {
                    str2 = hashMap.toString();
                }
                sb2.append(str2);
                sb2.append("commonData = ");
                sb2.append(jSONObject);
                d.j("SensorsDataHelper", sb2.toString());
            }
            i(str, hashMap);
        } catch (Exception unused) {
        }
    }

    public static void h(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("mode", z11 ? "multiple" : "single");
        i("linear_swap_switch_asset_mode", hashMap);
    }

    public static void i(String str, HashMap hashMap) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("]");
        if (hashMap == null) {
            str2 = "";
        } else {
            str2 = hashMap.toString();
        }
        sb2.append(str2);
        d.j("SensorsDataHelper", sb2.toString());
        if (hashMap == null) {
            try {
                SensorsDataAPI.sharedInstance().track(str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            try {
                SensorsDataAPI.sharedInstance().track(str, new JSONObject(hashMap));
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public static void j(String str, String str2, String str3, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("business_category", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap2.put("type", str2);
        }
        hashMap2.put("button_name", str3);
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        if (e(str3) && !str.equals("coin_contract")) {
            hashMap2.put("margin_type", d());
        }
        i("appclick_contracts", hashMap2);
    }

    public static void k(int i11, String str) {
        HashMap hashMap;
        try {
            String optString = new JSONObject(str).optString(com.sumsub.sentry.n0.f30437i);
            if (!x.d(optString)) {
                Map<String, Object> d11 = rd.d.f23353a.d(optString);
                hashMap = new HashMap();
                hashMap.putAll(d11);
            } else {
                hashMap = null;
            }
            i(i11 == 1 ? "push_view" : "push_click", hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static void l(boolean z11, String str, String str2, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("tradepair_name", str);
        hashMap.put("handicap_type", str2);
        hashMap.put("bb_trademode", i11 == 0 ? "LimitOrder" : i11 == 1 ? "MarketOrder" : i11 == 2 ? "StopLimit" : i11 == 3 ? "TriggerOrder" : "");
        i(z11 ? "bb_sub_buyinfo" : "bb_sub_sellinfo", hashMap);
    }

    public static void m(String str, JSONObject jSONObject) {
        d.j("SensorsDataHelper", "[" + str + "]" + jSONObject);
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    SensorsDataAPI.sharedInstance().track(str, jSONObject);
                    return;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        SensorsDataAPI.sharedInstance().track(str);
    }
}
