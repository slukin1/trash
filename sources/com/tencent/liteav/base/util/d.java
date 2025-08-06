package com.tencent.liteav.base.util;

import android.os.MessageQueue;

final /* synthetic */ class d implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    private final CustomHandler f21533a;

    private d(CustomHandler customHandler) {
        this.f21533a = customHandler;
    }

    public static MessageQueue.IdleHandler a(CustomHandler customHandler) {
        return new d(customHandler);
    }

    public final boolean queueIdle() {
        return CustomHandler.lambda$quitLooper$2(this.f21533a);
    }
}
