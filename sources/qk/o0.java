package qk;

import com.hbg.lib.core.util.ConfigPreferences;

public final class o0 {
    public static boolean a() {
        return ConfigPreferences.c("user_config", "config_only_show_current_symbol", true);
    }

    public static boolean b() {
        return ConfigPreferences.c("user_config", "config_only_show_entrust_current_symbol", true);
    }

    public static void c(boolean z11) {
        ConfigPreferences.n("user_config", "config_only_show_current_symbol", z11);
    }

    public static void d(boolean z11) {
        ConfigPreferences.n("user_config", "config_only_show_entrust_current_symbol", z11);
    }
}
