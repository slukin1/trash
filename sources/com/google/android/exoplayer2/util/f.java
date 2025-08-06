package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class f implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f66091b;

    public /* synthetic */ f(String str) {
        this.f66091b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.lambda$newSingleThreadExecutor$0(this.f66091b, runnable);
    }
}
