package androidx.camera.camera2.internal;

import androidx.camera.core.FocusMeteringAction;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class w2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x2 f5398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FocusMeteringAction f5400d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f5401e;

    public /* synthetic */ w2(x2 x2Var, CallbackToFutureAdapter.a aVar, FocusMeteringAction focusMeteringAction, long j11) {
        this.f5398b = x2Var;
        this.f5399c = aVar;
        this.f5400d = focusMeteringAction;
        this.f5401e = j11;
    }

    public final void run() {
        this.f5398b.M(this.f5399c, this.f5400d, this.f5401e);
    }
}
