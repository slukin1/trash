package jp;

import android.text.TextUtils;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.OtcAppIdConfigInfo;
import i6.d;
import java.util.HashMap;
import java.util.Map;

public final class m {

    /* renamed from: e  reason: collision with root package name */
    public static volatile m f84360e;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f84361a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f84362b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f84363c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Object> f84364d = new HashMap();

    public static m a() {
        if (f84360e == null) {
            synchronized (m.class) {
                if (f84360e == null) {
                    f84360e = new m();
                }
            }
        }
        return f84360e;
    }

    public String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        d.e("getKycAppId--->", str2);
        if (TextUtils.equals(str, "bind_card_auth_type") || TextUtils.equals(str, "t2_before_jumio_card")) {
            return "b3Rj5Z";
        }
        BaseSettingBean g11 = qu.d.i().g();
        OtcAppIdConfigInfo otcAppIdConfigInfo = null;
        if (!(g11 == null || g11.getBalanceTradeConfigObj() == null || g11.getBalanceTradeConfigObj().getBalanceAppId() == null)) {
            otcAppIdConfigInfo = g11.getBalanceTradeConfigObj().getBalanceAppId();
        }
        str2.hashCode();
        if (!str2.equals("EUR")) {
            if (!str2.equals("GBP")) {
                return "52d6d3";
            }
            if (otcAppIdConfigInfo == null || TextUtils.isEmpty(otcAppIdConfigInfo.getGBP())) {
                return "b3Rj5Z";
            }
            return otcAppIdConfigInfo.getGBP();
        } else if (otcAppIdConfigInfo == null || TextUtils.isEmpty(otcAppIdConfigInfo.getEUR())) {
            return "b3Rj5Z";
        } else {
            return otcAppIdConfigInfo.getEUR();
        }
    }
}
