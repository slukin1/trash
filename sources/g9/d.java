package g9;

import java.lang.ref.SoftReference;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SoftReference f54798b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f54799c;

    public /* synthetic */ d(SoftReference softReference, Throwable th2) {
        this.f54798b = softReference;
        this.f54799c = th2;
    }

    public final void run() {
        e.h(this.f54798b, this.f54799c);
    }
}
