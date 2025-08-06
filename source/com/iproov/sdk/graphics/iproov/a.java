package com.iproov.sdk.graphics.iproov;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OpenGLRenderer f38849b;

    public /* synthetic */ a(OpenGLRenderer openGLRenderer) {
        this.f38849b = openGLRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f38849b.m696do(surfaceTexture);
    }
}
