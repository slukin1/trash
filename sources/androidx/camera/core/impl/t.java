package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class t implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f5582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f5583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f5584c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5585d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f5586e;

    public /* synthetic */ t(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j11, boolean z11) {
        this.f5582a = list;
        this.f5583b = scheduledExecutorService;
        this.f5584c = executor;
        this.f5585d = j11;
        this.f5586e = z11;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return DeferrableSurfaces.lambda$surfaceListWithTimeout$3(this.f5582a, this.f5583b, this.f5584c, this.f5585d, this.f5586e, aVar);
    }
}
