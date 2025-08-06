package uh;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.asset.AssetModuleConfig;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f47920b = new e();

    /* renamed from: a  reason: collision with root package name */
    public boolean f47921a;

    public e() {
        c(ConfigPreferences.c("user_config", "CONFIG_HIDE_ZERO_POS_BALANCE_" + AssetModuleConfig.a().getUid(), false));
    }

    public static e a() {
        return f47920b;
    }

    public boolean b() {
        return this.f47921a;
    }

    public void c(boolean z11) {
        if (this.f47921a != z11) {
            this.f47921a = z11;
            ConfigPreferences.n("user_config", "CONFIG_HIDE_ZERO_POS_BALANCE_" + AssetModuleConfig.a().getUid(), z11);
        }
    }

    public boolean d() {
        c(!this.f47921a);
        return this.f47921a;
    }
}
