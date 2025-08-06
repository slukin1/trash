package rl;

import com.hbg.module.market.MarketModuleConfig;

public final class a {
    public static int a(String str) {
        if (MarketModuleConfig.a().v().equals(MarketModuleConfig.a().e0(str))) {
            return 40;
        }
        if (MarketModuleConfig.a().z().equals(MarketModuleConfig.a().e0(str))) {
            return 50;
        }
        if (str.contains("NQ")) {
            return 31;
        }
        if (str.contains("CQ")) {
            return 30;
        }
        if (str.contains("NW")) {
            return 20;
        }
        str.contains("CW");
        return 10;
    }
}
