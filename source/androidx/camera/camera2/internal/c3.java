package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class c3 implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e3 f5040a;

    public /* synthetic */ c3(e3 e3Var) {
        this.f5040a = e3Var;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5040a.i(sessionConfig, sessionError);
    }
}
