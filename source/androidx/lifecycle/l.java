package androidx.lifecycle;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f10023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f10024c;

    public /* synthetic */ l(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f10023b = dispatchQueue;
        this.f10024c = runnable;
    }

    public final void run() {
        DispatchQueue.d(this.f10023b, this.f10024c);
    }
}
