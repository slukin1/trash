package dt;

import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;
import d7.a1;
import java.util.HashMap;
import java.util.Map;

public class i2 {

    /* renamed from: b  reason: collision with root package name */
    public static i2 f84088b = new i2();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f84089a = new HashMap();

    public i2() {
        e();
    }

    public static i2 a() {
        return f84088b;
    }

    public int b(TradeType tradeType, int i11) {
        if (tradeType == TradeType.PRO) {
            return ConfigPreferences.g("user_config", "config_exchange_last_order_index", i11);
        }
        if (tradeType == TradeType.MARGIN) {
            return ConfigPreferences.g("user_config", "config_margin_last_order_index", i11);
        }
        return tradeType == TradeType.SUPERMARGIN ? ConfigPreferences.g("user_config", "config_super_margin_last_order_index", i11) : i11;
    }

    public TradeType c() {
        String d11 = ConfigPreferences.d("user_config", "config_exchange_last_trade_type");
        if (TextUtils.isEmpty(d11) || TextUtils.equals(TradeType.PRO.name(), d11)) {
            return TradeType.PRO;
        }
        TradeType tradeType = TradeType.MARGIN;
        if (TextUtils.equals(tradeType.name(), d11)) {
            return tradeType;
        }
        return TradeType.SUPERMARGIN;
    }

    public String d(TradeType tradeType) {
        if (this.f84089a.get(tradeType.name()) != null && a1.v().H(tradeType).contains(this.f84089a.get(tradeType.name()))) {
            return this.f84089a.get(tradeType.name());
        }
        return "";
    }

    public final void e() {
        Map<String, String> map = this.f84089a;
        TradeType tradeType = TradeType.MARGIN;
        String name = tradeType.name();
        map.put(name, ConfigPreferences.d("user_config", tradeType.name() + "config_symbolid"));
        Map<String, String> map2 = this.f84089a;
        TradeType tradeType2 = TradeType.SUPERMARGIN;
        String name2 = tradeType2.name();
        map2.put(name2, ConfigPreferences.d("user_config", tradeType2.name() + "config_symbolid"));
        Map<String, String> map3 = this.f84089a;
        TradeType tradeType3 = TradeType.PRO;
        String name3 = tradeType3.name();
        map3.put(name3, ConfigPreferences.d("user_config", tradeType3.name() + "config_symbolid"));
        Map<String, String> map4 = this.f84089a;
        TradeType tradeType4 = TradeType.C2C;
        String name4 = tradeType4.name();
        map4.put(name4, ConfigPreferences.d("user_config", tradeType4.name() + "config_symbolid"));
    }

    public void f(TradeType tradeType, int i11) {
        if (tradeType == TradeType.PRO) {
            ConfigPreferences.k("user_config", "config_exchange_last_order_index", i11);
        } else if (tradeType == TradeType.MARGIN) {
            ConfigPreferences.k("user_config", "config_margin_last_order_index", i11);
        } else if (tradeType == TradeType.SUPERMARGIN) {
            ConfigPreferences.k("user_config", "config_super_margin_last_order_index", i11);
        }
    }

    public final void g(String str) {
        StringBuilder sb2 = new StringBuilder();
        TradeType tradeType = TradeType.MARGIN;
        sb2.append(tradeType.name());
        sb2.append("config_symbolid");
        ConfigPreferences.m("user_config", sb2.toString(), this.f84089a.get(tradeType.name()));
        StringBuilder sb3 = new StringBuilder();
        TradeType tradeType2 = TradeType.SUPERMARGIN;
        sb3.append(tradeType2.name());
        sb3.append("config_symbolid");
        ConfigPreferences.m("user_config", sb3.toString(), this.f84089a.get(tradeType2.name()));
        StringBuilder sb4 = new StringBuilder();
        TradeType tradeType3 = TradeType.PRO;
        sb4.append(tradeType3.name());
        sb4.append("config_symbolid");
        ConfigPreferences.m("user_config", sb4.toString(), this.f84089a.get(tradeType3.name()));
        StringBuilder sb5 = new StringBuilder();
        TradeType tradeType4 = TradeType.C2C;
        sb5.append(tradeType4.name());
        sb5.append("config_symbolid");
        ConfigPreferences.m("user_config", sb5.toString(), this.f84089a.get(tradeType4.name()));
        ConfigPreferences.m("user_config", "config_exchange_last_trade_type", str);
    }

    public void h(TradeType tradeType, String str) {
        this.f84089a.put(tradeType.name(), str);
        g(tradeType.name());
    }
}
