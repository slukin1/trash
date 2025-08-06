package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.ErrorListener f5105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f5106c;

    public /* synthetic */ f0(SessionConfig.ErrorListener errorListener, SessionConfig sessionConfig) {
        this.f5105b = errorListener;
        this.f5106c = sessionConfig;
    }

    public final void run() {
        this.f5105b.onError(this.f5106c, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }
}
