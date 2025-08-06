package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f5516b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f5517c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Executor f5518d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5519e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f5520f;

    public /* synthetic */ i(CameraX cameraX, Context context, Executor executor, CallbackToFutureAdapter.a aVar, long j11) {
        this.f5516b = cameraX;
        this.f5517c = context;
        this.f5518d = executor;
        this.f5519e = aVar;
        this.f5520f = j11;
    }

    public final void run() {
        this.f5516b.lambda$initAndRetryRecursively$2(this.f5517c, this.f5518d, this.f5519e, this.f5520f);
    }
}
