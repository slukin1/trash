package com.huobi.litere.helper;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.ConfigPreferences;

public class LiteReHelper {

    /* renamed from: b  reason: collision with root package name */
    public static LiteReHelper f75418b = new LiteReHelper();

    /* renamed from: a  reason: collision with root package name */
    public boolean f75419a = ConfigPreferences.c("lite_re_config", "lite_area_config", false);

    public static LiteReHelper a() {
        return f75418b;
    }

    public boolean b() {
        return this.f75419a;
    }

    public void c(boolean z11) {
        this.f75419a = z11;
        ConfigPreferences.n("lite_re_config", "lite_area_config", z11);
        if (z11) {
            SP.y("SP_KEY_HAS_SHOW_LITE", true);
        }
    }
}
