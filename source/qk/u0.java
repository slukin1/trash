package qk;

import com.hbg.lib.core.util.ConfigPreferences;

public final class u0 {
    public static boolean a() {
        return 1 == ConfigPreferences.g("spot_config", "config_app_spot_limit_confirm_key", 1);
    }

    public static boolean b() {
        return 1 == ConfigPreferences.g("spot_config", "config_app_spot_market_confirm_key", 1);
    }

    public static boolean c() {
        return 1 == ConfigPreferences.g("spot_config", "config_app_spot_plan_confirm_key", 1);
    }

    public static boolean d() {
        return 1 == ConfigPreferences.g("spot_config", "config_app_spot_tp_sl_confirm_key", 1);
    }

    public static boolean e(String str) {
        return 1 == ConfigPreferences.g("spot_config", str, 1);
    }

    public static void f(String str, boolean z11) {
        ConfigPreferences.k("spot_config", str, z11 ? 1 : 0);
    }
}
