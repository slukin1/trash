package com.tencent.liteav.sdkcommon;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21633a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21634b;

    private a(DashboardManager dashboardManager, boolean z11) {
        this.f21633a = dashboardManager;
        this.f21634b = z11;
    }

    public static Runnable a(DashboardManager dashboardManager, boolean z11) {
        return new a(dashboardManager, z11);
    }

    public final void run() {
        this.f21633a.showDashboardInternal(this.f21634b);
    }
}
