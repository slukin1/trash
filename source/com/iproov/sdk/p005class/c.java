package com.iproov.sdk.p005class;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.iproov.sdk.class.c  reason: invalid package */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cdo f38755b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f38756c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f38757d;

    public /* synthetic */ c(Cdo doVar, Handler handler, HandlerThread handlerThread) {
        this.f38755b = doVar;
        this.f38756c = handler;
        this.f38757d = handlerThread;
    }

    public final void run() {
        this.f38755b.m252do(this.f38756c, this.f38757d);
    }
}
