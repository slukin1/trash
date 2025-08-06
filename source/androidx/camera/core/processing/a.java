package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5638a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5639b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5640c;

    public /* synthetic */ a(DefaultSurfaceProcessor defaultSurfaceProcessor, int i11, int i12) {
        this.f5638a = defaultSurfaceProcessor;
        this.f5639b = i11;
        this.f5640c = i12;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5638a.lambda$snapshot$7(this.f5639b, this.f5640c, aVar);
    }
}
