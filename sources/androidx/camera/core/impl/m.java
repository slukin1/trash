package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraStateRegistry;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraStateRegistry.OnConfigureAvailableListener f5573b;

    public /* synthetic */ m(CameraStateRegistry.OnConfigureAvailableListener onConfigureAvailableListener) {
        this.f5573b = onConfigureAvailableListener;
    }

    public final void run() {
        this.f5573b.onConfigureAvailable();
    }
}
