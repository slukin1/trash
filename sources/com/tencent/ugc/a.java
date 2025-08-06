package com.tencent.ugc;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GlobalContextManager f50118a;

    private a(GlobalContextManager globalContextManager) {
        this.f50118a = globalContextManager;
    }

    public static Runnable a(GlobalContextManager globalContextManager) {
        return new a(globalContextManager);
    }

    public final void run() {
        this.f50118a.initGlobalContext();
    }
}
