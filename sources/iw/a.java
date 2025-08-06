package iw;

import com.jumio.core.cdn.CDNCache;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CDNCache f55848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55849c;

    public /* synthetic */ a(CDNCache cDNCache, String str) {
        this.f55848b = cDNCache;
        this.f55849c = str;
    }

    public final void run() {
        CDNCache.a(this.f55848b, this.f55849c);
    }
}
