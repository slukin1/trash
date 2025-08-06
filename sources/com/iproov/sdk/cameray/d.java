package com.iproov.sdk.cameray;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Cdo f38738b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f38739c;

    public /* synthetic */ d(Cdo doVar, SurfaceTexture surfaceTexture) {
        this.f38738b = doVar;
        this.f38739c = surfaceTexture;
    }

    public final void run() {
        this.f38738b.m107if(this.f38739c);
    }
}
