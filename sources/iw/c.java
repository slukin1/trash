package iw;

import com.jumio.core.cdn.CDNCache;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CDNCache f55854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f55855c;

    public /* synthetic */ c(CDNCache cDNCache, ExecutorService executorService) {
        this.f55854b = cDNCache;
        this.f55855c = executorService;
    }

    public final void run() {
        CDNCache.a(this.f55854b, this.f55855c);
    }
}
