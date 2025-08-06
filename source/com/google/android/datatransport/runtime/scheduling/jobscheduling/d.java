package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uploader f65599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f65600c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f65601d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Runnable f65602e;

    public /* synthetic */ d(Uploader uploader, TransportContext transportContext, int i11, Runnable runnable) {
        this.f65599b = uploader;
        this.f65600c = transportContext;
        this.f65601d = i11;
        this.f65602e = runnable;
    }

    public final void run() {
        this.f65599b.lambda$upload$1(this.f65600c, this.f65601d, this.f65602e);
    }
}
