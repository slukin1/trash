package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f25635b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f25636c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f25637d;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Throwable th2) {
        this.f25635b = r12;
        this.f25636c = callback;
        this.f25637d = th2;
    }

    public final void run() {
        this.f25635b.lambda$onFailure$1(this.f25636c, this.f25637d);
    }
}
