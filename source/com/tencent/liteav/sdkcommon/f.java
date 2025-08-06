package com.tencent.liteav.sdkcommon;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21643a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21644b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21645c;

    private f(DashboardManager dashboardManager, String str, String str2) {
        this.f21643a = dashboardManager;
        this.f21644b = str;
        this.f21645c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new f(dashboardManager, str, str2);
    }

    public final void run() {
        this.f21643a.appendLogInternal(this.f21644b, this.f21645c);
    }
}
