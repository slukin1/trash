package qk;

import com.hbg.lib.network.pro.core.bean.SpotTimeSharingGlobalConfig;

public final class v0 {

    /* renamed from: c  reason: collision with root package name */
    public static volatile v0 f47762c;

    /* renamed from: a  reason: collision with root package name */
    public SpotTimeSharingGlobalConfig f47763a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47764b;

    public static v0 b() {
        if (f47762c == null) {
            synchronized (v0.class) {
                if (f47762c == null) {
                    f47762c = new v0();
                }
            }
        }
        return f47762c;
    }

    public SpotTimeSharingGlobalConfig a() {
        return this.f47763a;
    }

    public boolean c(boolean z11) {
        return this.f47764b && z11;
    }

    public void d(SpotTimeSharingGlobalConfig spotTimeSharingGlobalConfig) {
        this.f47763a = spotTimeSharingGlobalConfig;
    }

    public void e(boolean z11) {
        SpotTimeSharingGlobalConfig spotTimeSharingGlobalConfig = this.f47763a;
        if (spotTimeSharingGlobalConfig == null || !spotTimeSharingGlobalConfig.isAvailable()) {
            this.f47764b = false;
        } else {
            this.f47764b = z11;
        }
    }
}
