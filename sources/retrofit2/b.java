package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f25638b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f25639c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Response f25640d;

    public /* synthetic */ b(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Response response) {
        this.f25638b = r12;
        this.f25639c = callback;
        this.f25640d = response;
    }

    public final void run() {
        this.f25638b.lambda$onResponse$0(this.f25639c, this.f25640d);
    }
}
