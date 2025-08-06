package com.adjust.sdk;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActivityHandler f13952b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f13953c;

    public /* synthetic */ b(ActivityHandler activityHandler, boolean z11) {
        this.f13952b = activityHandler;
        this.f13953c = z11;
    }

    public final void run() {
        this.f13952b.lambda$onActivityLifecycle$0(this.f13953c);
    }
}
