package bj;

import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.ConfigPreferences;

public final class p0 {
    public static boolean a() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_lightning_confirm", 1);
    }

    public static boolean b() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_limit_confirm", 1);
    }

    public static boolean c() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_plan_confirm", 1);
    }

    public static boolean d() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_time_confirm", 1);
    }

    public static boolean e() {
        return ConfigPreferences.c("contract_config", "config_app_contract_price_protection" + BaseModuleConfig.a().getUid(), true);
    }

    public static boolean f() {
        return ConfigPreferences.c("contract_config", "config_app_contract_reverse_confirm", true);
    }

    public static boolean g() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_linear_swap_style", 1);
    }

    public static boolean h() {
        return 1 == ConfigPreferences.g("contract_config", "config_app_contract_style", 1);
    }

    public static void i(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_lightning_confirm", i11);
    }

    public static void j(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_limit_confirm", i11);
    }

    public static void k(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_linear_swap_style", i11);
    }

    public static void l(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_plan_confirm", i11);
    }

    public static void m(boolean z11) {
        ConfigPreferences.n("contract_config", "config_app_contract_price_protection" + BaseModuleConfig.a().getUid(), z11);
    }

    public static void n(boolean z11) {
        ConfigPreferences.n("contract_config", "config_app_contract_reverse_confirm", z11);
    }

    public static void o(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_style", i11);
    }

    public static void p(int i11) {
        ConfigPreferences.k("contract_config", "config_app_contract_time_confirm", i11);
    }
}
