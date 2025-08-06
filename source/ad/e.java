package ad;

import com.hbg.lib.core.util.ConfigPreferences;

public final class e {
    public static boolean a() {
        return ConfigPreferences.c("user_config", "config_grid_current_symbol", false);
    }

    public static void b(boolean z11) {
        ConfigPreferences.n("user_config", "config_grid_current_symbol", z11);
    }
}
