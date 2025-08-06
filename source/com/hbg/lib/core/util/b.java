package com.hbg.lib.core.util;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f68692a = new b();

    public static b c() {
        return f68692a;
    }

    public int a() {
        return ConfigPreferences.g("user_config", "config_app_margin_select", 1);
    }

    public boolean b(String str) {
        return ConfigPreferences.c("user_config", str + "_" + "config_app_asset_show", true);
    }

    public boolean d() {
        return ConfigPreferences.c("user_config", "config_app_usdt_exchange_tips_show", true);
    }

    public void e() {
        if (!(ConfigPreferences.g("user_config", "config_app_spot_handicap_style", -1) == -1)) {
            return;
        }
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            j(1);
            i(1);
            return;
        }
        j(0);
        i(0);
    }

    public boolean f() {
        return true;
    }

    public void g(int i11) {
        ConfigPreferences.k("user_config", "config_app_margin_select", i11);
    }

    public void h(boolean z11, String str) {
        ConfigPreferences.n("user_config", str + "_" + "config_app_asset_show", z11);
    }

    public void i(int i11) {
        ConfigPreferences.k("user_config", "config_app_margin_handicap_style", i11);
    }

    public void j(int i11) {
        ConfigPreferences.k("user_config", "config_app_spot_handicap_style", i11);
    }
}
