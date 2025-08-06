package com.tencent.liteav.sdkcommon;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardManager f21640a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21641b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21642c;

    private e(DashboardManager dashboardManager, String str, String str2) {
        this.f21640a = dashboardManager;
        this.f21641b = str;
        this.f21642c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new e(dashboardManager, str, str2);
    }

    public final void run() {
        this.f21640a.setStatusInternal(this.f21641b, this.f21642c);
    }
}
