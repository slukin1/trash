package qt;

import com.hbg.lib.core.util.ConfigPreferences;

public final class y {
    public static boolean a() {
        return b();
    }

    public static boolean b() {
        return ConfigPreferences.c("user_config", "config_spot_margin_trade_only_show_current_symbol", false);
    }

    public static void c(boolean z11) {
        ConfigPreferences.n("user_config", "config_spot_margin_trade_only_show_current_symbol", z11);
    }
}
