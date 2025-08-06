package com.iproov.sdk.p005class;

import android.os.HandlerThread;

/* renamed from: com.iproov.sdk.class.d  reason: invalid package */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cdo f38758b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f38759c;

    public /* synthetic */ d(Cdo doVar, HandlerThread handlerThread) {
        this.f38758b = doVar;
        this.f38759c = handlerThread;
    }

    public final void run() {
        this.f38758b.m253do(this.f38759c);
    }
}
