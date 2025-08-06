package com.huobi.trade.helper;

import com.hbg.lib.core.util.ConfigPreferences;

public final class y {
    public static boolean a() {
        return ConfigPreferences.c("user_config", "config_trade_only_show_current_symbol_in_dialog", true);
    }
}
