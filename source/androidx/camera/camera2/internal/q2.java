package androidx.camera.camera2.internal;

import androidx.camera.core.FocusMeteringAction;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x2 f5279a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FocusMeteringAction f5280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5281c;

    public /* synthetic */ q2(x2 x2Var, FocusMeteringAction focusMeteringAction, long j11) {
        this.f5279a = x2Var;
        this.f5280b = focusMeteringAction;
        this.f5281c = j11;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5279a.N(this.f5280b, this.f5281c, aVar);
    }
}
