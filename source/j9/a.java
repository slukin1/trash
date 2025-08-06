package j9;

import com.hbg.lib.network.retrofit.websocketnew.b;
import java.lang.ref.SoftReference;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SoftReference f55893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f55894c;

    public /* synthetic */ a(SoftReference softReference, Throwable th2) {
        this.f55893b = softReference;
        this.f55894c = th2;
    }

    public final void run() {
        b.a.b(this.f55893b, this.f55894c);
    }
}
