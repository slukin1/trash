package com.tencent.liteav.sdkcommon;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21635a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21636b;

    private b(DashboardManager dashboardManager, String str) {
        this.f21635a = dashboardManager;
        this.f21636b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new b(dashboardManager, str);
    }

    public final void run() {
        this.f21635a.addDashboardInternal(this.f21636b);
    }
}
