package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraStateRegistry;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraStateRegistry.OnOpenAvailableListener f5575b;

    public /* synthetic */ n(CameraStateRegistry.OnOpenAvailableListener onOpenAvailableListener) {
        this.f5575b = onOpenAvailableListener;
    }

    public final void run() {
        this.f5575b.onOpenAvailable();
    }
}
