package com.tencent.liteav.sdkcommon;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21637a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21638b;

    private c(DashboardManager dashboardManager, String str) {
        this.f21637a = dashboardManager;
        this.f21638b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new c(dashboardManager, str);
    }

    public final void run() {
        this.f21637a.removeDashboardInternal(this.f21638b);
    }
}
