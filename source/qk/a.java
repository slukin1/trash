package qk;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeSharingGlobalConfig;
import pk.e;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f47756d;

    /* renamed from: a  reason: collision with root package name */
    public LinearSwapTimeSharingGlobalConfig f47757a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47758b;

    /* renamed from: c  reason: collision with root package name */
    public int f47759c;

    public static a b() {
        if (f47756d == null) {
            synchronized (e.class) {
                if (f47756d == null) {
                    f47756d = new a();
                }
            }
        }
        return f47756d;
    }

    public LinearSwapTimeSharingGlobalConfig a() {
        return this.f47757a;
    }

    public int c() {
        LinearSwapTimeSharingGlobalConfig linearSwapTimeSharingGlobalConfig = this.f47757a;
        if (linearSwapTimeSharingGlobalConfig != null) {
            return linearSwapTimeSharingGlobalConfig.getTwTradeAmountLimit();
        }
        return 0;
    }

    public boolean d() {
        if (!e()) {
            return false;
        }
        int g11 = ConfigPreferences.g("user_config", "config_contract_market_tw_trade", 1);
        this.f47759c = g11;
        if (g11 == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f47758b;
    }

    public void g(boolean z11) {
        if (z11 != this.f47759c) {
            this.f47759c = z11 ? 1 : 0;
            ConfigPreferences.k("user_config", "config_contract_market_tw_trade", z11);
        }
    }

    public void h(LinearSwapTimeSharingGlobalConfig linearSwapTimeSharingGlobalConfig) {
        this.f47757a = linearSwapTimeSharingGlobalConfig;
    }

    public void i(boolean z11) {
        LinearSwapTimeSharingGlobalConfig linearSwapTimeSharingGlobalConfig = this.f47757a;
        if (linearSwapTimeSharingGlobalConfig == null || linearSwapTimeSharingGlobalConfig.getTwState() != 1) {
            this.f47758b = false;
        } else {
            this.f47758b = z11;
        }
    }

    public int j(boolean z11, boolean z12) {
        return (!z11 || !e() || !d() || !z12) ? 0 : 1;
    }
}
