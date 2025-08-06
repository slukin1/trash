package com.tencent.liteav.sdkcommon;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21639a;

    private d(DashboardManager dashboardManager) {
        this.f21639a = dashboardManager;
    }

    public static Runnable a(DashboardManager dashboardManager) {
        return new d(dashboardManager);
    }

    public final void run() {
        this.f21639a.removeAllDashboardInternal();
    }
}
