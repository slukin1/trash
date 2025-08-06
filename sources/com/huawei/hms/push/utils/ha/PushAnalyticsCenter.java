package com.huawei.hms.push.utils.ha;

public class PushAnalyticsCenter {

    /* renamed from: a  reason: collision with root package name */
    private PushBaseAnalytics f38453a;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static PushAnalyticsCenter f38454a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f38454a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f38453a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f38453a = pushBaseAnalytics;
    }
}
