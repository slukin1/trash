package uh;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.asset.AssetModuleConfig;

public final class f {

    /* renamed from: b  reason: collision with root package name */
    public static final f f47922b = new f();

    /* renamed from: a  reason: collision with root package name */
    public boolean f47923a;

    public f() {
        c(ConfigPreferences.c("user_config", "CONFIG_HIDE_ZERO_SUMMARY_BALANCE_" + AssetModuleConfig.a().getUid(), false));
    }

    public static f a() {
        return f47922b;
    }

    public boolean b() {
        return this.f47923a;
    }

    public void c(boolean z11) {
        if (this.f47923a != z11) {
            this.f47923a = z11;
            ConfigPreferences.n("user_config", "CONFIG_HIDE_ZERO_SUMMARY_BALANCE_" + AssetModuleConfig.a().getUid(), z11);
        }
    }
}
