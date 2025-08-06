package com.tencent.liteav.base.util;

import android.os.MessageQueue;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final CustomHandler f21534a;

    /* renamed from: b  reason: collision with root package name */
    private final MessageQueue.IdleHandler f21535b;

    private e(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        this.f21534a = customHandler;
        this.f21535b = idleHandler;
    }

    public static Runnable a(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        return new e(customHandler, idleHandler);
    }

    public final void run() {
        CustomHandler.lambda$quitLooper$3(this.f21534a, this.f21535b);
    }
}
