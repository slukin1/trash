package com.huobi.trade.helper;

import com.hbg.lib.core.util.ConfigPreferences;

public final class z {
    public static boolean a() {
        return ConfigPreferences.c("user_config", "config_spot_margin_trade_only_show_current_symbol", false);
    }

    public static void b(boolean z11) {
        ConfigPreferences.n("user_config", "config_spot_margin_trade_only_show_current_symbol", z11);
    }
}
