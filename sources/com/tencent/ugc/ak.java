package com.tencent.ugc;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ak implements TXVideoEditer.TXThumbnailListener {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50143a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCThumbnailGenerator f50144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50145c;

    private ak(TXVideoEditer tXVideoEditer, UGCThumbnailGenerator uGCThumbnailGenerator, boolean z11) {
        this.f50143a = tXVideoEditer;
        this.f50144b = uGCThumbnailGenerator;
        this.f50145c = z11;
    }

    public static TXVideoEditer.TXThumbnailListener a(TXVideoEditer tXVideoEditer, UGCThumbnailGenerator uGCThumbnailGenerator, boolean z11) {
        return new ak(tXVideoEditer, uGCThumbnailGenerator, z11);
    }

    public final void onThumbnail(int i11, long j11, Bitmap bitmap) {
        this.f50143a.mSequenceTaskRunner.a(bu.a(this.f50143a, this.f50144b, this.f50145c, i11, j11, bitmap));
    }
}
