package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditer;
import java.util.List;

final /* synthetic */ class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass5 f50272a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f50273b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50274c;

    /* renamed from: d  reason: collision with root package name */
    private final long f50275d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f50276e;

    /* renamed from: f  reason: collision with root package name */
    private final List f50277f;

    /* renamed from: g  reason: collision with root package name */
    private final UGCThumbnailGenerator f50278g;

    private cf(TXVideoEditer.AnonymousClass5 r12, TXVideoEditer.TXThumbnailListener tXThumbnailListener, int i11, long j11, Bitmap bitmap, List list, UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f50272a = r12;
        this.f50273b = tXThumbnailListener;
        this.f50274c = i11;
        this.f50275d = j11;
        this.f50276e = bitmap;
        this.f50277f = list;
        this.f50278g = uGCThumbnailGenerator;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass5 r102, TXVideoEditer.TXThumbnailListener tXThumbnailListener, int i11, long j11, Bitmap bitmap, List list, UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new cf(r102, tXThumbnailListener, i11, j11, bitmap, list, uGCThumbnailGenerator);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass5.a(this.f50272a, this.f50273b, this.f50274c, this.f50275d, this.f50276e, this.f50277f, this.f50278g);
    }
}
