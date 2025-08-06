package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class h implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f5512a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f5513b;

    public /* synthetic */ h(CameraX cameraX, Context context) {
        this.f5512a = cameraX;
        this.f5513b = context;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5512a.lambda$initInternal$0(this.f5513b, aVar);
    }
}
