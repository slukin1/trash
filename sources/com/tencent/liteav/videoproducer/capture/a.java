package com.tencent.liteav.videoproducer.capture;

import android.os.Handler;
import com.tencent.liteav.base.util.v;

final /* synthetic */ class a implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f22542a;

    public a(Handler handler) {
        this.f22542a = handler;
    }

    public final void a(Runnable runnable) {
        this.f22542a.post(runnable);
    }
}
