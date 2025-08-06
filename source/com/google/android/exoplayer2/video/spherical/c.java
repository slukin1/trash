package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f66123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f66124c;

    public /* synthetic */ c(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.f66123b = sphericalGLSurfaceView;
        this.f66124c = surfaceTexture;
    }

    public final void run() {
        this.f66123b.lambda$onSurfaceTextureAvailable$1(this.f66124c);
    }
}
