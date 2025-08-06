package com.google.android.exoplayer2.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class o implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Handler f65847b;

    public /* synthetic */ o(Handler handler) {
        this.f65847b = handler;
    }

    public final void execute(Runnable runnable) {
        this.f65847b.post(runnable);
    }
}
