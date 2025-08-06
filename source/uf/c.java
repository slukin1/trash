package uf;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.utils.OtcCountryConfigUtil;
import java.util.HashMap;
import jp.m;
import oa.a;
import up.g;
import va.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f37360a;

    public c() {
        c();
    }

    public static c b() {
        if (f37360a == null) {
            synchronized (m.class) {
                if (f37360a == null) {
                    f37360a = new c();
                }
            }
        }
        return f37360a;
    }

    public HashMap a(HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Activity f11 = a.g().f(OtcTradeActivity.class);
        if (f11 != null && (f11 instanceof OtcTradeActivity)) {
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) f11;
            if (!hashMap.containsKey("coin_name")) {
                Fragment m02 = otcTradeActivity.getSupportFragmentManager().m0(OtcModuleConfig.a().o().getName());
                if (m02 != null) {
                    hashMap.put("coin_name", ((d) m02).Pg());
                }
                if (!hashMap.containsKey("coin_name")) {
                    OtcTradeAreaEnum Ed = otcTradeActivity.Ed();
                    int Jh = otcTradeActivity.Jh();
                    int fd2 = otcTradeActivity.fd();
                    if (Ed == OtcTradeAreaEnum.FAST_AREA) {
                        hashMap.put("coin_name", b.g(Jh));
                    } else if (Ed == OtcTradeAreaEnum.FREE_AREA) {
                        hashMap.put("coin_name", b.g(fd2));
                    }
                }
            }
            hashMap.put("fiat_name", g.c("otc_select_trade_currency_quote_asset"));
            String a11 = OtcCountryConfigUtil.a();
            if (!TextUtils.isEmpty(a11)) {
                hashMap.put("country_id", a11);
            }
            if (!hashMap.containsKey("side")) {
                OtcTradeAreaEnum Ed2 = otcTradeActivity.Ed();
                int Kh = otcTradeActivity.Kh();
                int Mh = otcTradeActivity.Mh();
                String str = "buy";
                if (Ed2 == OtcTradeAreaEnum.FAST_AREA) {
                    if (Kh != -1) {
                        if (Kh != 0) {
                            str = "sell";
                        }
                        hashMap.put("side", str);
                    }
                } else if (Ed2 == OtcTradeAreaEnum.FREE_AREA && Mh != -1) {
                    if (Mh != 0) {
                        str = "sell";
                    }
                    hashMap.put("side", str);
                }
            }
        }
        return hashMap;
    }

    public final void c() {
    }

    public HashMap d(HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put("amount", op.a.r(0).a());
        return hashMap;
    }

    public HashMap e(HashMap hashMap) {
        d dVar;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        try {
            Activity f11 = a.g().f(OtcTradeActivity.class);
            if (f11 != null && (f11 instanceof OtcTradeActivity)) {
                OtcTradeActivity otcTradeActivity = (OtcTradeActivity) f11;
                if (!hashMap.containsKey("coin_name") && (dVar = (d) otcTradeActivity.getSupportFragmentManager().m0(OtcModuleConfig.a().o().getName())) != null && !hashMap.containsKey("side")) {
                    hashMap.put("side", dVar.w2() ? "buy" : "sell");
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public HashMap f(String str, String str2, HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        hashMap.put("otc_step", str);
        hashMap.put("spm", str2);
        return hashMap;
    }

    public HashMap g(HashMap hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        String n11 = op.a.r(0).n();
        if (!"0".equals(n11)) {
            hashMap.put("payment", n11);
        }
        return hashMap;
    }

    public void h(String str, HashMap hashMap) {
        try {
            OtcModuleConfig.a().track(str, a(hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void i(String str, HashMap hashMap) {
        h("otc_faq", f(str, "", hashMap));
    }

    public void j(String str, HashMap hashMap) {
        h("hbg_fiat_deposit", f(str, "", hashMap));
    }

    public void k(String str, HashMap hashMap) {
        h("hbg_fiat_withdraw", f(str, "", hashMap));
    }

    public void l(String str, HashMap hashMap) {
        h("otc_new_user_guide", f(str, "", hashMap));
    }

    public void m(String str, String str2, HashMap hashMap) {
        h("base_config_failed", e(f(str, str2, hashMap)));
    }

    public void n(String str, String str2, HashMap hashMap) {
        h("otc_fast_landing", e(f(str, str2, hashMap)));
    }

    public void o(String str, String str2, HashMap hashMap) {
        h("otc_fast_order", e(f(str, str2, hashMap)));
    }

    public void p(String str, String str2, HashMap hashMap) {
        h("otc_fast_quote", e(f(str, str2, hashMap)));
    }

    public void q(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("otc_step", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("page_type", str2);
        }
        h("otc_main_landing", hashMap);
    }

    public void r(String str, String str2, HashMap hashMap) {
        h("otc_p2p_adlist", d(g(f(str, str2, hashMap))));
    }

    public void s(String str, String str2, HashMap hashMap) {
        h("otc_p2p_order", g(f(str, str2, hashMap)));
    }
}
