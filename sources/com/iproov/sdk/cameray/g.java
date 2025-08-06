package com.iproov.sdk.cameray;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cif f38744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f38745c;

    public /* synthetic */ g(Cif ifVar, SurfaceTexture surfaceTexture) {
        this.f38744b = ifVar;
        this.f38745c = surfaceTexture;
    }

    public final void run() {
        this.f38744b.m157for(this.f38745c);
    }
}
