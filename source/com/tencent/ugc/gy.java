package com.tencent.ugc;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class gy implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50586a;

    private gy(UGCVideoProcessor uGCVideoProcessor) {
        this.f50586a = uGCVideoProcessor;
    }

    public static Handler.Callback a(UGCVideoProcessor uGCVideoProcessor) {
        return new gy(uGCVideoProcessor);
    }

    public final boolean handleMessage(Message message) {
        return this.f50586a.handleMessage(message);
    }
}
