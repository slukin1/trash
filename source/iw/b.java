package iw;

import com.jumio.core.cdn.CDNCache;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CDNCache f55850b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55851c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f55852d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CDNCache.a f55853e;

    public /* synthetic */ b(CDNCache cDNCache, String str, String str2, CDNCache.a aVar) {
        this.f55850b = cDNCache;
        this.f55851c = str;
        this.f55852d = str2;
        this.f55853e = aVar;
    }

    public final void run() {
        CDNCache.a(this.f55850b, this.f55851c, this.f55852d, this.f55853e);
    }
}
