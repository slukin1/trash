package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import java.util.List;

final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50123a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50124b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50125c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50126d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f50127e;

    /* renamed from: f  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f50128f;

    private ad(TXVideoEditer tXVideoEditer, List list, int i11, int i12, boolean z11, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f50123a = tXVideoEditer;
        this.f50124b = list;
        this.f50125c = i11;
        this.f50126d = i12;
        this.f50127e = z11;
        this.f50128f = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list, int i11, int i12, boolean z11, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ad(tXVideoEditer, list, i11, i12, z11, tXThumbnailListener);
    }

    public final void run() {
        this.f50123a.doGetThumbnail(this.f50124b, this.f50125c, this.f50126d, this.f50127e, this.f50128f);
    }
}
