package qk;

import com.hbg.lib.core.util.ConfigPreferences;

public final class n0 {
    public static int a() {
        return ConfigPreferences.g("user_config", "config_app_future_trade_type", 1);
    }

    public static void b(int i11) {
        ConfigPreferences.k("user_config", "config_app_future_trade_type", i11);
    }
}
